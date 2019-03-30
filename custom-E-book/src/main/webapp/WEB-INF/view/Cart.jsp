<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buyer's Cart</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style >
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 16px;
  text-align: center;
  background-color: #f1f1f1;
}
</style>
</head>
<body>
${error}
<form action="/saveEbookContent" method="post">
<article>
<div class="container">
<table class="table table-striped">
<caption><h3>Ebook Content</h3></caption>
<thead>
<tr class="tr tr-success">
<td>Chapter/Book Name</td>
<td>Price</td>
<td>Serial Number</td>
<td>Remove</td>
</tr>
</thead>
<tbody>
	
<c:forEach items="${ebooks}" var="ebook">
	<tr>
	<td><div class="card">${ebook.chapter.name}</div><input type="hidden" name="ebookid" value="${ebook.id}"/></td>
	<td><div class="card">${ebook.price}</div></td>
	<td>
			 <select  name="sequence">
			 <option selected>Choose Sequence</option>
            <c:forEach begin="1" end="${size}" var="val">
                <option  value="${val}">${val}</option>
            </c:forEach>
        </select>
		
	</td>
	<td><div class="card"><a href="/deletechapter">Delete</a></div></td>
	
	</tr>
</c:forEach>
</tbody>
</table>
</div>
</article>
<button type="submit">Save</button>
</form>
</body>
</html>