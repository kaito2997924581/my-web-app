package controller;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import service.TodoService;

/**
 * Servlet implementation class TodoCreate
 */
@WebServlet("/TodoCreate")
public class TodoCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodoCreate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/todo_create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		String status = request.getParameter("status");
		String dueTimeStr = request.getParameter("due_time");
		LocalDate due_time = LocalDate.parse(dueTimeStr);

		TodoService ts = new TodoService();
		ts.createTodo(title, detail, status, due_time);

		response.sendRedirect("TodoList");//ここの引数にはサーブレット名を指定する
	}
}