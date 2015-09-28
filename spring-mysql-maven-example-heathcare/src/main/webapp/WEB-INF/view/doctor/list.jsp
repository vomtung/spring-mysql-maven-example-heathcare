<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}">Index</a>
	</head>
	<body>
	<p><a href="${pageContext.servletContext.contextPath}/doctor/add">Add Doctor</a></p>
	<table style="width:100%" border="1">
            <tr>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Employee Id</td>
                <td>Option</td>
            </tr>
        <c:forEach items="${doctors}" var="doctor">
            <tr>
                <td>${doctor.firstName}</td>
                <td>${doctor.lastName}</td>
                <td>${doctor.employeeId}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/doctor/edit/${doctor.id}">Edit</a>
                    <a href="${pageContext.servletContext.contextPath}/doctor/delete/${doctor.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
	</body>
</html>