<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}">Index</a>
	</head>
	<body>
	<p><a href="${pageContext.servletContext.contextPath}/prescription/add">add patient</a></p>
	<table style="width:100%" border="1">
            <tr>
                <td>Prescription Id</td>
                <td>Prescription Id</td>
            </tr>
        <c:forEach items="${prescriptions}" var="prescription">
            <tr>
                <td>${prescription.id}</td>
                <td>${prescription.patient.patientId}</td>
                <td>
                    <a href="#">Edit</a>
                    <a href="${pageContext.servletContext.contextPath}/patient/answer/${patient.id}">Answer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
	</body>
</html>