<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h2>Hola ${usuario.nombre}</h2>

<%@ include file = "MapView.jsp" %>

<h2>Viajes favoritos</h2>
<c:if test="${fn:length(usuario.viajes_fav) != 0}">
<c:forEach items="${usuario.viajes_fav}" var="favi">
<tr>
<td>${favi.id}</td>
</tr>
</c:forEach>
</c:if>
<c:if test="${fn:length(usuario.viajes_fav) == 0}">
<tr>
<td>No has añadido viajes favoritos aún.</td>
</tr>
</c:if>



<h2>Añade un nuevo viaje favorito</h2>
<form action="Form3ViajeFav">
    <input type="text" name="id" placeholder="Identificador del viaje">
	<input type="text" name="origen" placeholder="Origen">
	<input type="text" name="destino" placeholder="Destino">
	<button type="submit">Añadir</button>
</form>

</body>
</html>