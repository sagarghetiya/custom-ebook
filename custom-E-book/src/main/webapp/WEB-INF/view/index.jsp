<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom Ebook</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
 body{

   background-size:cover;
   background-repeat:no-repeat;
}
  </style>
</head>
<body background="/images/book_index.jpg">
<div id="navigation" style="padding-bottom:-15px;">
<!-- navbar area -->

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><b>Custom EBooks</b></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/regBuyerPublisher"><span class="glyphicon glyphicon-user"></span>Register </a></li>
       <li><a href="/loginBuyerPublisher"><span class="glyphicon glyphicon-user"></span> Login</a></li> 
        <!--  <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
    </ul>
    </div>
   
</nav>
</div>
<!-- navbar area -->

<!-- main body area -->
<!-- <div id="image" style="background-image:url(/images/book_index.jpg);object-fit:cover;padding-top:-21px;margin-top:-21px;"> -->

<!--   </div> -->
  
<!-- main body area -->

<!-- 
<div id="middle" style="background-color:#A0522D; height:400px;">
</div>middle text -->
<!-- <!-- footer area -->
<!-- <div style=" background-color:#000000;padding: 10px; text-align: center;color: red; height:120px;"> -->
		
<!-- </div> -->
<!-- footer area -->
<!-- <a href="/regBuyer">register Buyer</a> <br/> -->
<!-- <a href="/regPublisher">register Publisher</a> <br/> -->

</body>
</html>