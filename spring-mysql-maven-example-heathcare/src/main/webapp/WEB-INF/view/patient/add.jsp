<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/patient-panel-35123.png"></img></a>
	</head> 
	<body>
	<table>
	<form:form method="post" commandName="patient" action="${pageContext.servletContext.contextPath}/patient/add">
		<tr>
			<td>Patient Name</td>
			<td><form:input path="patientName"/></td>
		</tr>
		<tr>
			<td>Patient Id</td>
			<td><form:input path="patientId"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td> <form:input path="age"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</form:form> 
	</table>
	</body>
</html>
