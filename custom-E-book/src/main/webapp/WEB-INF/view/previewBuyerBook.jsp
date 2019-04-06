<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.example.demo.ebook.model.book.Book"
	import="com.example.demo.ebook.model.chapter.Chapter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="searchResult" method="post">
			<input type="number" name="id" value="${book.id}" readonly/>
			<input type="text" name="isbn" value="${book.isbn}"/>
			<input type="text" name="bookName" value="${book.bookName}"/>
			<input type="number" name="noOfChapters" value="${book.noOfChapters}"/>
			<input type="number" name="totalNoOfPages" value="${book.totalNoOfPages}"/>
			<input type="number" name="price" value="${book.price}"/>
			<input type="text" name="bookLoc" value="${book.bookLoc}"/>
			<input type="text" name="keywords" value="${book.keywords}"/>
			<input type="submit" value="back"/>
	</form>
<!-- 	<object data="/MT2018016.pdf" type="application/pdf" width="300" height="200"> -->
<!-- <a href="/MT2018016.pdf">test.pdf</a> -->
<!-- </object> -->
	<nav class="navbar navbar-expand-sm bg-light">
		<ul class="navbar-nav">
			<c:forEach items="${chapters}" var="chapter">
				<li class="nav-item"><a class="nav-link"
					href="previewBuyerChapter?id=${chapter.id}">${chapter.name}</a></li>
			</c:forEach>
		</ul>
	</nav>
</body>
</html>