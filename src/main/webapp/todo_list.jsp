<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ToDo管理システム</title>
<style>
body {
	font-family: sans-serif;
	margin: 20px;
	color: #333;
}

h2 {
	font-size: 1.2rem;
	margin-bottom: 5px;
}

.container {
	max-width: 600px;
	border: 1px solid #ccc;
	padding: 20px;
	margin-bottom: 20px;
	background-color: #fff;
}

.search-box, .form-group {
	margin-bottom: 15px;
}

label {
	display: inline-block;
	width: 90px;
}

input[type="text"], input[type="date"], select {
	padding: 4px;
	border: 1px solid #999;
	border-radius: 3px;
	box-sizing: border-box;
}

.input-keyword {
	width: 150px;
}

.input-title {
	width: 200px;
}

.input-detail {
	width: 200px;
}

.input-date {
	width: 150px;
}

button {
	padding: 4px 10px;
	cursor: pointer;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 15px;
	margin-bottom: 15px;
}

th, td {
	text-align: left;
	padding: 6px 4px;
}

th {
	border-bottom: 1px solid #333;
}

.btn-right {
	text-align: right;
	margin-bottom: 15px;
}
</style>
</head>
<body>

	<!-- 【一覧画面】 -->
	<div class="container">
		<h2>【一覧画面】</h2>
		<div class="search-box">
			<div class="col-md-5">
				<form method="get" action="TodoList">
					<label for="keyword" class="form-label fw-semibold">キーワード</label> <input
						type="text" name="keyword" class="input-keyword"
						placeholder="タイトル・詳細で検索"
						value="<c:out value="${ param['keyword'] }" />">
			</div>
			ステータス: <select 　name="status">
				<option value="all">すべて</option>
				<option value="未着手">未着手</option>
				<option value="進行中">進行中</option>
				<option value="完了">完了</option>
			</select>
			<button type="submit"
				class="btn btn-primary w-100 py2 rounded-3 fw-semibold">検索</button>
		</div>
		</form>

		<table>
			<thead>
				<tr>
					<th style="width: 10%;">#</th>
					<th style="width: 40%;">タイトル</th>
					<th style="width: 25%;">ステータス</th>
					<th style="width: 25%;">期限日</th>
				</tr>
				<!-- ここの部分にデータを渡したい -->
			</thead>
			<tbody>
				<c:forEach var="todo" items="${ todos }">
					<tr>
						<th scope="row"><c:out value="${todo.todo_id}" /></th>
						<td><c:out value="${todo.title}" /></td>
						<td><c:out value="${todo.status}" /></td>
						<td><c:out value="${todo.due_date}" /></td>
					</tr>
				</c:forEach>
				<!--  
                <tr>
                    <td>1</td>
                    <td>ドキュメント作成</td>
                    <td>未着手</td>
                    <td>2026-06-10</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>コードレビュー</td>
                    <td>進行中</td>
                    <td>2026-06-05</td>
                   -->
				</tr>
			</tbody>
		</table>

		<div class="btn-right">
			<a href="TodoCreate" <button>[新規追加]</button></a>
		</div>
	</div>



</body>
</html>