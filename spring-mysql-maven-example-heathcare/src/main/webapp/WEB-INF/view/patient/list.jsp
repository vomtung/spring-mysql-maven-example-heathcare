<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
	<head>
	</head>
	<body>
	<p><a href="${pageContext.servletContext.contextPath}/patient/add">add patient</a></p>
	<p><a href="${pageContext.servletContext.contextPath}/patient/list_json">json</a></p>
	<p><a href="${pageContext.servletContext.contextPath}/question">Question</a></p>
	<table style="width:100%" border="1">
            <tr>
                <td>Patient Id</td>
                <td>Patient Name</td>
                <td>Age</td>
                <td>Configuration</td>
            </tr>
        <c:forEach items="${patients}" var="patient">
            <tr>
                <td>${patient.patientId}</td>
                <td>${patient.patientName}</td>
                <td>${patient.age}</td>
                <td>
                    <a href="#">Edit</a>
                    <a href="${pageContext.servletContext.contextPath}/patient/answer/${patient.id}">Answer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
	</body>
</html>