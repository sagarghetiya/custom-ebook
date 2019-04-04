<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="registerBook" method="post" enctype="multipart/form-data">
		<pre>
				ISBN No.     : <input type="text" name="isbn" />
				name     : <input type="text" name="bookName" />
				No of chapters : <input type="number" name="noOfChapters" />
				Price : <input type="number" name="price">
				keywords   : <input type="text" name="keywords" />
				<label>upload your book : </label><input type="file" name="file" />
			<input type="submit" name="register">
		</pre>
	</form>
</body>
</html>