<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="pay" method="post">
		<table>
			<c:forEach items="${booksId}" var="id">
				<tr>
					<td>${id}</td>
<%-- 					<td>${book.isbn}</td> --%>
				</tr>
			</c:forEach>
		</table>
		<table>
			<c:forEach items="${chaptersId}" var="id">
				<tr>
					<td>${id}</td>
<%-- 					<td>${book.isbn}</td> --%>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>