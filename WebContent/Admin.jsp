<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista de usuarios</title>
<link rel="stylesheet" type="text/css" href="main.css" />
</head>
<body>
<h2>Admin</h2>
<p><b>Número de usuarios activos: </b>${fn:length(usuarios)}</p>
<h2>Usuarios</h2>
<table border="1">
<c:forEach items="${usuarios}" var="usuarioi">
<tr>
<td>${usuarioi.email}</td>
<td>${usuarioi.name}</td>
<td>${usuarioi.last_name}</td>
</tr>
</c:forEach>
</table>
</body>
</html>