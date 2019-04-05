<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.example.demo.ebook.model.publisher.Publisher"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Publisher Home</title>
<style>
</style>
</head>
<body>
<!---------------------NavBar opening -------------------------->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Publisher Home</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="/regBook">Register Book</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logoutPublisher"><span class="glyphicon glyphicon-log-in"></span>
						Logout</a></li>
			</ul>
		</div>
	</nav>
	<!---------------------NavBar ending -------------------------->

	<c:out value="${id}" />
	<br />
	
	<br>
	<table border="1">
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