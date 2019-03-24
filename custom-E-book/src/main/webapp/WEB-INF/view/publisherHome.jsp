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

	<c:out value="${id}"/>
	<br/>
	<br>
	<a href="logoutPublisher">logout</a>
	<a href="regBook">registerBook</a>
</body>
</html>