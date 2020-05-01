<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista del usuario</title>
<link rel="stylesheet" type="text/css" href="main.css" />
</head>
<body>
<div class="container-fluid p-0" style="display: flex ; flex-direction: column">
	<div>
		<h1>Hola ${usuario.name}!</h1>
		<h2>Donde quieres ir hoy?</h2>
	</div>
	<div>
		<a href="UserView.jsp">User</a>
	</div>
</div>

<%@ include file = "MapView.jsp" %>
</body>
</html>