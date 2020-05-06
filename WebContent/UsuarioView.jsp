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
<body style="margin:15px">
<div class="container-fluid p-0">
		<h3>Donde quieres ir hoy?</h3>
</div>
<%@ include file = "MapView.jsp" %>

<h2>Viajes favoritos</h2>
<table border="1">
	<c:if test="${fn:length(favourites) != 0}">
		<th>Nombre</th><th>¿Quieres eliminarlo?</th>
		<c:forEach items="${favourites}" var="favi">
			<tr>
				<td>${favi.id}</td>
				<td>
					<form action="FormDeleteFavourite">
						<input type="hidden" name="favid" value="${favi.id}" />
						<button type="submit">Eliminar</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${fn:length(favourites) == 0}">
		<tr>
		<td>No has añadido viajes favoritos aún.</td>
		</tr>
	</c:if>
</table>

<h2>Añade un nuevo viaje favorito</h2>
<form action="Form3ViajeFav">
    <input type="text" name="id" placeholder="Identificador del viaje">
	<input type="text" name="origen" placeholder="Origen">
	<input type="text" name="destino" placeholder="Destino">
	<button type="submit">Añadir</button>
</form>

</body>
</html>