<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.example.demo.ebook.model.publisher.Publisher"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:out value="${id}" />
	<br />
	<br>
	<a href="logoutPublisher">logout</a>
	<a href="regBook">registerBook</a>
	<br>
	<br>
	<table border="2">
		<tr>
			<th>ISBN</th>
			<th>book name</th>
			<th>book price</th>
			<th>Chapters Configured</th>
		</tr>
		<c:forEach items="${publisherBooks}" var="book">

			<tr>
				<td>${book.isbn}</td>
				<td><a
					href=<c:choose>
							<c:when test="${book.chaptersAdded==true}">
						        "reConfChapters?id=${book.id}"
							</c:when>
							<c:otherwise>
						        "confChapters?id=${book.id}"
							</c:otherwise>
						</c:choose>>${book.bookName}</a></td>
				<td>${book.price}</td>
				<td><c:choose>
						<c:when test="${book.chaptersAdded==true}">
						        Yes
							</c:when>
						<c:otherwise>
						        No*
							</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>

	*Note - if you haven't configured your chapters, the book will only be
	available as a whole for sale

</body>
</html>