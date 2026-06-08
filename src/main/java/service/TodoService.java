package service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.TodoDao;
import entity.Todo;

public class TodoService {
	public ArrayList<Todo> getTodos(String keyword, String status) {
		ArrayList<Todo> result = null;
		TodoDao td = new TodoDao();
		try {
			result = (keyword == null) ? td.findAll() : td.findByKeyword(keyword);
			//nullだったらこれまで通り全件取得、あったら検索
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return result;
	}

	public int createTodo(String title, String detail, String status, LocalDate due_date) {
		int result = 0;
		TodoDao td = new TodoDao();
		try {
			Todo t = new Todo(title, detail, status, due_date);
			result = td.create(t);
		} catch (SQLException se) {
			System.out.println("作成失敗");
			se.printStackTrace();
		}
		return result;
	}
}
