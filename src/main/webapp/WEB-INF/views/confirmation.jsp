<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
First Name :${student.firstName}
<br><br>
Last Name :${student.lastName}
<br><br>
Country :${student.country}
<br><br>
Gender :${student.gender}
<br><br>
<ul>
<c:forEach var="fav" items="${student.favlang}">
	<li>${fav}</li>
</c:forEach>
</ul>
Favorite Language :${student.gender}
<h1>Thank you for registration.</h1>
</body>
</html>