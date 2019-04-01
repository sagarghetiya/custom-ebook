<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.example.demo.ebook.model.book.Book"
	import="com.example.demo.ebook.model.chapter.Chapter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addToCart" method="post">
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
					<td>${book.bookName}</td>
					<td>${book.isbn}</td>
				</tr>
			</c:forEach>
		</table>
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
					<td>${chapter.name}</td>
					<td>${chapter.description}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
<%-- ${Books_id}<br> --%>
</body>
</html>