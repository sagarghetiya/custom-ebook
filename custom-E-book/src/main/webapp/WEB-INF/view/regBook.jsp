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
				Total No. of pages : <input type="number" name="totalNoOfPages" />
				Price : <input type="number" name="price">
				keywords   : <input type="text" name="keywords" />
				<label>upload your book : </label><input type="file" name="file" />
				description   : <input type="text" name="description" />
			<input type="submit" name="register">
		</pre>
	</form>
</body>
</html>