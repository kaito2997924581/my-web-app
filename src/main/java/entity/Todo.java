package entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Todo {
	private int todo_id;
	private String title;
	private String detail;
	private String status;
	private LocalDate due_date;//local date

	public Todo(String t, String d, String s, LocalDate dd) {
		this.title = t;
		this.detail = d;
		this.status = s;
		this.due_date = dd;
	}
}
