<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	id of the publisher is <%=session.getAttribute("id") %> <br/><br>
	Hello,${buyer.name}<br>
	<a href="logoutBuyer">logout</a>
</body>
</html>