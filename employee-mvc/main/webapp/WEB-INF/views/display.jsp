<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Employee List</title>

</head>

<body>
<h2 align="center">Employee Details</h2>

<table border="1" align="center">

<tr>
<th>ID</th>
<th>Name</th>
<th>Phone</th>
<th>Email</th>
<th>Update</th>
<th>Delete</th>
</tr>

<c:choose>

<c:when test="${not empty list}">
<c:forEach var="e" items="${list}">
<tr>
<td>${e.id}</td>
<td>${e.name}</td>
<td>${e.phone}</td>
<td>${e.email}</td>
<td><a href="update?id=${e.id}">Update</a></td>
<td><a href="delete?id=${e.id}">Delete</a></td>
</tr>
</c:forEach>
</c:when>

<c:otherwise>
<tr>
<td colspan="4">No Records Found</td>
</tr>
</c:otherwise>

</c:choose>

</table>
</body>
</html>