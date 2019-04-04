<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buyer's Cart</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> 
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Buyer Home</title>
<style>
body{
  /* background-image:url("mybackground.jpg")*/
   background-size:cover;
   background-repeat:no-repeat;
}
.button {
	  background-color: #FF6347; /* Green */
	 border-radius: 8px;
	  color: white;
	  padding: 15px 32px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 15px;
	  margin: 4px 2px;
	  cursor: pointer;
	  -webkit-transition-duration: 0.4s; /* Safari */
	  transition-duration: 0.4s;
	  
	}
	.button2:hover {

	  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
	}
</style>
</head>
<body background="/images/book2.jpeg">
	<!-- Navigation bar -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Buyer Home</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Main Home Page</a></li>
				
				<li><a href="#">About</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logoutBuyer"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a></li>
			</ul>
		</div>
	</nav>
	<!---------- end ----------------->
${result}
	<h3>Hello,${buyer.name}</h3><br>
	<button class="button button2" style="background-color: #CD853F;" onclick="location.href='/showEbookContent'">Go to Cart</button>
</body>
</html>