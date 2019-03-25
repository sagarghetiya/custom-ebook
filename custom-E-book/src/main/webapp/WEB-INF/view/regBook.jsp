<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="registerBook" method="post">
		<pre>
				ISBN No.     : <input type="text" name="isbn" />
				name     : <input type="text" name="bookName" />
				No of chapters : <input type="number" name="noOfChapter" />
				Total No. of pages : <input type="number" name="totalNoOfPages" />
				Price : <input type="decimal" name="price">
				Loc   : <input type="text" name="bookLoc" />
				keywords   : <input type="text" name="keywords" />
				description   : <input type="text" name="description" />
			<input type="submit" name="register">
		</pre>
	</form>
</body>
</html>