<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}">Index</a>
	<p>add doctor</p>
	</head> 
	<body>
	<table>
	<form:form method="post" commandName="doctor" action="${pageContext.servletContext.contextPath}/doctor/add">
		<tr>
			<td>First Name</td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><form:input path="lastName"/></td>
		</tr>
		<tr>
			<td>Emplyee Id</td>
			<td><form:input path="employeeId"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</form:form> 
	</table>
	</body>
</html>
