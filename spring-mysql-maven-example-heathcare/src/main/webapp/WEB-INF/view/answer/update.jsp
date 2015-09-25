<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}">Index</a>
	</head> 
	<body>
	<table>
	<form:form method="post" commandName="answer" action="${pageContext.servletContext.contextPath}/answer/update">
		<form:hidden path="id"/>
		<tr>
			<td>Question</td>
			<td>${answer.question.question }</td>
		</tr>
		<tr>
			<td>Answer</td>
			<td><form:textarea path="answer"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</form:form>
	</table>
	</body>
</html>
