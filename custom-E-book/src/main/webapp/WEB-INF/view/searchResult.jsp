<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.example.demo.ebook.model.book.Book"
	import="com.example.demo.ebook.model.chapter.Chapter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
body {
	font-family: Arial;
}

* {
	box-sizing: border-box;
}

form.example input[type=text] {
	padding: 10px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	width: 80%;
	background: #f1f1f1;
}

form.example button {
	float: left;
	width: 20%;
	padding: 10px;
	background: #2196F3;
	color: white;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

form.example button:hover {
	background: #0b7dda;
}

form.example::after {
	content: "";
	clear: both;
	display: table;
}
</style>
</head>
<body>
	<form class="example" action="searchResult"
		style="margin: auto; max-width: 50%">
		<input type="text" placeholder="Search.." name="keywords"
			value="${keywords}">
		<button type="submit">
			<i class="fa fa-search"></i>
		</button>
	</form>
	<br/>
	<br/>
	<form action="addToCart" method="post">
		<div class="container">
			<button type="button" class="btn btn-info" data-toggle="collapse"
				data-target="#book_collapse" style="min-width: 30%">Books</button>
			<div id="book_collapse" class="collapse in">
				<c:choose>
					<c:when test="${not empty books}">
						<table>
							<tr>
								<th>checkbox</th>
								<th>book name</th>
								<th>book isbn</th>
							</tr>
							<c:forEach items="${books}" var="book">
								<tr>
									<td><input type="checkbox" name="bookIdList"
										value="${book.id}"></td>
									<td><a href="previewBuyerBook?id=${book.id}">${book.bookName}</a></td>
									<td>${book.isbn}</td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
		No book found<br />
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<br/>
		<br/>
		<div class="container">
			<button type="button" class="btn btn-info" data-toggle="collapse"
				data-target="#chapter_collapse" style="min-width: 30%">Chapter</button>
			<div id="chapter_collapse" class="collapse in">
				<c:choose>
					<c:when test="${not empty chapters}">
						<table>
							<tr>
								<th>checkbox</th>
								<th>chapter name</th>
								<th>chapter description</th>
							</tr>
							<c:forEach items="${chapters}" var="chapter">
								<tr>
									<td><input type="checkbox" name="chapterIdList"
										value="${chapter.id}"></td>
									<td><a href="previewBuyerChapter?id=${chapter.id}">${chapter.name}</a></td>
									<td>${chapter.description}</td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<br />
						<br />
						No chapter found
						<br />
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<c:if test="${(not empty books) || (not empty chapters)}">
			<input type="submit" value="Submit" style="margin-left: 20%" />
		</c:if>
	</form>
</body>
</html>