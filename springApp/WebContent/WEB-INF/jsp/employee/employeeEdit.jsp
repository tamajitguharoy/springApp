<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Update</title>
</head>
<body>
${request.getContextPath()}
<form:form action="/springApp/employee/edit.htm" commandName="emp" method="post">
<table>
<tr><td>ID</td><td><form:input path="eid"/></td></tr>
<tr><td>Name</td><td><form:input path="ename"/></td></tr>
<tr><td></td><td><input type="submit"/></td></tr>
</table>
</form:form>
</body>
</html>