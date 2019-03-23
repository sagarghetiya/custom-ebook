<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("error") %>
	<form action="validatePublisherLogin" method="post">
		<pre>
			<label>login ID :</label> <input type="text" name="loginId" />
			<label>password :</label> <input type="password" name="password">
			<input type="submit" name="Login">
		</pre>
	</form>

</body>
</html>