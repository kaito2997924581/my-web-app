package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import service.TodoService;

/**
 * Servlet implementation class TodoList
 */
@WebServlet("/TodoList")
public class TodoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodoList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletRe-sponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");//jspファイルにキーワードとして受け取るデータをリクエスト
		String status = request.getParameter("status");
		
		TodoService ts = new TodoService();
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//TodoService ts = new TodoService(); //Todoサービスを呼び出す準備
		request.setAttribute("todos", ts.getTodos(keyword,status)); //todoの表から取得した表をセット
		request.getRequestDispatcher("/todo_list.jsp").forward(request, response);//セットしたものをtodo_list.jspに送る
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
