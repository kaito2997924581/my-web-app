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


	<!-- 【新規登録画面】 -->
	<div class="container">
		<h2>【新規登録画面】</h2>

		<form action="TodoCreate" method="post">

			<div class="form-group">
				<label>タイトル ：</label> <input type="text" name="title"
					class="input-title">
			</div>
			<div class="form-group">
				<label>詳細 ：</label> <input type="text" name="detail"
					class="input-detail">
			</div>
			<div class="form-group">
				<label>ステータス：</label> <select name="status">
					<option value="未着手">未着手</option>
					<option value="進行中">進行中</option>
					<option value="完了">完了</option>
				</select>
			</div>
			<div class="form-group">
				<label>期限日 ：</label> <input type="date" name="due_time"
					class="input-date" value="2026-06-05">
			</div>
			<div style="padding-left: 90px;">
				<button type="submit">[登録]</button>

			</div>
		</form>
	</div>

</body>
</html>