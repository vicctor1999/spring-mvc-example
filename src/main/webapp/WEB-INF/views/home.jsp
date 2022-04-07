<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="https://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</p>
	<form action="user" method="post">
		<h3>Nombre</h3>
		<input type="text" name="userName"><br>
		<h3>Apellidos</h3>
		<input type="text" name="userSurname"><br>
		<h3>Dias hasta cumpleaños</h3>  
		<input type="text" name="number"><br> 
		<input type="submit" value="Login">
	</form>
</body>
</html>
