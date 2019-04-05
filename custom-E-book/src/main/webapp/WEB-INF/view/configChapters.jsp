<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		$(":button").click(function() {
			var id = $(this).attr('id');
			var startPage = $("#start_page_"+id).val();
			var endPage = $("#end_page_"+id).val();
			var totalPages = $("#totalNoOfPages").val();
			var sourceLoc = $("#bookLoc").val();
			$.ajax({
				url:'preview',
				data: {id : id, startPage : startPage, endPage : endPage, totalPages : totalPages, source : sourceLoc}
//  				success: function(responseText) {
//  					//$("#start_img_"+id).show();
// 					//$("#end_img_"+id).show();
//  					if(responseText != "") {
//  						alert(responseText);
//  					}
//  				}
			});
			
			var delayInMilliseconds = 7000; //1 second

			setTimeout(function() {
				$("#start_img_"+id).attr('src', "/images/temp/start_preview_"+id+".jpg")
				$("#end_img_"+id).attr('src', "/images/temp/end_preview_"+id+".jpg")
				$("#start_img_"+id).load(location.href + " #start_img_"+id);
				$("#start_img_"+id).show();
				$("#end_img_"+id).load(location.href + " #end_img_"+id);
				$("#end_img_"+id).show();
			}, delayInMilliseconds);
			
			
// 			alert("id = "+id + " start page = "+startPage+" endPage = "+endPage);
		});
	});
</script>
</head>
<body>
	<form action="saveChapters" method="post">
			<input type="number" name="bookId" value="${book.id}" />
			<input type="text" name="isbn" value="${book.isbn}"/>
			<input type="text" name="bookName" value="${book.bookName}"/>
			<input type="number" name="noOfChapters" value="${book.noOfChapters}"/>
			<input type="number" id="totalNoOfPages" name="totalNoOfPages" value="${book.totalNoOfPages}"/>
			<input type="number" name="price" value="${book.price}"/>
			<input type="text" id="bookLoc" name="bookLoc" value="${book.bookLoc}"/>
			<input type="text" name="keywords" value="${book.keywords}"/>
		<c:forEach var="i" begin="1" end="${book.noOfChapters}">
			Chapter ${i}  
			<br><label for="name_${i}"> Name of the chapter</label><input type="text" name="name_${i}">
			<br><label for="price_${i}"> Price</label><input type="number" name="price_${i}" min="0">
			<br><label for="description_${i}"> Description of the chapter</label> <br><textarea rows="4" cols="50" name="description_${i}"></textarea>
			<br><label for="keywords_${i}"> Keywords (space separated)</label> <input type="text" name="keywords_${i}">
			<label for="start_page_${i}">Start page</label>
			<input type="number" min="1" max="${book.totalNoOfPages}"
				name="start_page_${i}" id="start_page_${i}">
			
			<label for="end_page_${i}">End page</label>
			<input type="number" min="1" max="${book.totalNoOfPages}"
				name="end_page_${i}" id="end_page_${i}">
			<br> <button type="button" id="${i}">preview</button> <br>
			<img src="" hidden="true" id="start_img_${i}" height="200" width="150">
			<img src="" hidden="true" id="end_img_${i}" height="200" width="150">
			<br>
			<br>
		</c:forEach>
		<input type="submit" value="configure chapters">
	</form>
</body>
</html>