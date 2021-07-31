<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome<%=request.getParameter("username")%></title>
<style>
body {
	background-color: Maroon;
}

#body {
	padding: 10px;
	width: 500px;
	height: 200px;
	margin-left: 380px;
	background-color: Chocolate;
	text-align: center;
	color: white;
	border-radius: 10px;
}

#ip {
	background-color: red;
	margin-left: 20px;
	color: white;
	float:right;
}
h1{

color:lime;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<form action="logout" method="post">
	<h1>LogIn Successfully</h1>
		<div id="body">
			user name =<%=request.getParameter("username")%><br> <br>
			age =<%=session.getAttribute("age")%><br> <br> place =
			<%=session.getAttribute("place")%>
		</div>
		<br> <br> <br> <input id="ip" type="submit"
			value="logout">
	</form>
</body>
</html>