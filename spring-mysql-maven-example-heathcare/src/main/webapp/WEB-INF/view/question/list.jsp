<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
	<head>
	</head>
	<body>
	<p><a href="${pageContext.servletContext.contextPath}/patient">Patient</a></p>
	<p><a href="${pageContext.servletContext.contextPath}/question/add">Add Question</a></p>
	<table style="width:100%" border="1">
            <tr>
                <td>Question</td>
                <td>Option</td>
            </tr>
        <c:forEach items="${questions}" var="question">
            <tr>
                <td>${question.question}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/question/edit/${question.id}">Edit</a>
                    <a href="${pageContext.servletContext.contextPath}/question/delete/${question.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
	</body>
</html>