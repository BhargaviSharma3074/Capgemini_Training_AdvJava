<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Register Employee</h2>

<form:form action="save" modelAttribute="employee">

ID: <form:input path="id"/> <br><br>
Name: <form:input path="name"/> <br><br>
Phone: <form:input path="phone"/> <br><br>
Email: <form:input path="email"/> <br><br>

<input type="submit" value="Register">

</form:form>

</body>
</html>