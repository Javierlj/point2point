<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista del usuario</title>
	<link rel="stylesheet" type="text/css" href="main.css" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
</head>
<body style="margin:15px">
<div class="d-flex" >
	<div>
		<h2>Donde quieres ir hoy?</h2>
	</div>
	<div class="ml-auto">
		<span style="font-size: 50px">
			<a href="UserView.jsp" class="fas fa-user icon-5x"style=" flex-direction: column"></a>
		</span>
	</div>
</div>

<%@ include file = "MapView.jsp" %>
</body>
</html>