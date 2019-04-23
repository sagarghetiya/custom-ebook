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
	<form action="reSaveChapters" method="post">
			<input type="number" name="bookId" value="${book.id}" />
			
			<input type="text" name="isbn" value="${book.isbn}"/>
			<input type="text" name="bookName" value="${book.bookName}"/>
			<input type="number" name="noOfChapters" value="${book.noOfChapters}"/>
			<input type="number" id="totalNoOfPages" name="totalNoOfPages" value="${book.totalNoOfPages}"/>
			<input type="number" name="price" value="${book.price}"/>
			<input type="text" id="bookLoc" name="bookLoc" value="${book.bookLoc}"/>
			<input type="text" name="keywords" value="${book.keywords}"/>
		<c:forEach items="${listOfChapters}" var="chapter">
			<br>
			<br>
			<br><label for="name_${chapter.id}"> Name of the chapter</label><input type="text" name="name_${chapter.id}" value="${chapter.name}">
			<br><label for="price_${chapter.id}"> Price</label><input type="number" step="any" name="price_${chapter.id}" min="0" value="${chapter.price}">
			<br><label for="description_${chapter.id}"> Description of the chapter</label> <br><textarea rows="4" cols="50" name="description_${chapter.id}" >${chapter.description}</textarea>
			<br><label for="keywords_${chapter.id}"> Keywords (space separated)</label> <input type="text" name="keywords_${chapter.id}" value="${chapter.keywords}">
			<br>
			<br>
		</c:forEach>
		<input type="submit" value="configure chapters">
	</form>

</body>
</html>