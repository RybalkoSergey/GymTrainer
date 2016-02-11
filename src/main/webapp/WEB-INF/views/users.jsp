<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gym trainer</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>

<body>
	<h2>List of Employees</h2>	
	<table>
		<tr>
			<td>Login</td><td>First name</td><td>Last name</td><td>SSN</td><td></td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
			<td>${user.login}</td>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			<td><a href="<c:url value='/edit-${user.login}-employee' />">${user.login}</a></td>
			<td><a href="<c:url value='/delete-${user.login}-employee' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New User</a>
</body>
</html>