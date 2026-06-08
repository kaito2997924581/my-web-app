package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Todo;
import utils.DbUtil;

public class TodoDao {
	public ArrayList<Todo> findAll() throws SQLException {
		String sql = "select * from todos order by todo_id;";

		ArrayList<Todo> result = new ArrayList<Todo>();

		try (Connection conn = DbUtil.open();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {//get「DB内カラムのデータ型」
				Todo t = new Todo(rs.getInt("todo_id"), rs.getString("title"), rs.getString("detail"),
						rs.getString("status"), rs.getDate("due_date").toLocalDate());//sqlのDate→LocalDate 
				result.add(t);//getInt(String)の中にはカラム名を入れる
			}
		}
		return result;
	}

	public ArrayList<Todo> findByKeyword(String keyword) throws SQLException {
		String sql = "SELECT * from todos  where title like ? or detail like ?";  //これから実行するsql

		ArrayList<Todo> result = new ArrayList<Todo>();

		try (Connection conn = DbUtil.open();//接続
				PreparedStatement stmt = conn.prepareStatement(sql);) {//stmtによって?の値をこれから変更
			stmt.setString(1, "%" + keyword + "%");//第一引数の設定(titlelに対応)
			stmt.setString(2, "%" + keyword + "%");//第二引数の設定(detailに対応)
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Todo a = new Todo(rs.getInt("todo_id"), rs.getString("title"), rs.getString("detail"),
							rs.getString("status"), rs.getDate("due_date").toLocalDate());

					result.add(a);
				}
			}
		}
		return result;
	}

	public int create(Todo t) throws SQLException {
		String sql = "insert into todos (title, detail, status, due_date) value(?,?,?,?);";

		int id = 0;

		try (Connection conn = DbUtil.open();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			pstmt.setString(1, t.getTitle());
			pstmt.setString(2, t.getDetail());
			pstmt.setString(3, t.getStatus());
			pstmt.setDate(4, java.sql.Date.valueOf(t.getDue_date()));
			int affectedRows = pstmt.executeUpdate();
			//Local Date → sqlのDate
			if (affectedRows > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getInt(1);
					}
				}
			}
		}
		return id;
	}
}
