<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}">Index</a>
	</head>
	<body>
	<p><a href="${pageContext.servletContext.contextPath}/patient">Patient</a></p>
	<p><a href="${pageContext.servletContext.contextPath}/question/add">Add Question</a></p>
	<table style="width:100%" border="1">
            <tr>
                <td>Question</td>
                <td>Answer</td>
                <td>Option</td>
            </tr>
        <c:forEach items="${answers}" var="answer">
            <tr>
                <td>${answer.question.question}</td>
                <td>${answer.answer}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/answer/update/${answer.id}">Answer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
	</body>
</html>