<%--
  Created by IntelliJ IDEA.
  User: Nano
  Date: 01/05/2020
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title> Usuario </title>
</head>
<body>
<h1> ${usuario.name} </h1>

<h2>Viajes favoritos</h2>
<table border="1">
    <c:if test="${fn:length(favourites) != 0}">
        <th>Nombre</th><th>¿Quieres eliminarlo?</th>
        <c:forEach items="${favourites}" var="favi">
            <tr>
                <td>${favi.name}</td>
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
    <input type="text" name="name" placeholder="Nombre del favorito">
    <input type="text" name="origen" placeholder="Origen">
    <input type="text" name="destino" placeholder="Destino">
    <button type="submit">Añadir</button>
</form>

<h2>Historial de viajes realizados</h2>
<table border="1">
    <c:if test="${fn:length(historial) != 0}">
        <th>Id</th><th>Fecha</th><th>Origen</th><th>Destino</th><th>Precio</th>
        <c:forEach items="${historial}" var="histi">
            <tr>
                <td>${histi.id}</td>
                <td>${histi.date}</td>
                <td>${histi.origen}</td>
                <td>${histi.destino}</td>
                <td>${histi.cost} $</td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${fn:length(historial) == 0}">
        <tr>
            <td>Aún no ha realizado ningún viaje.</td>
        </tr>
    </c:if>
</table>
<h1>Añade un nuevo viaje al historial</h1>
<form action="Form4Historial">
    <input type="text" name="origen" placeholder="Origen">
    <input type="text" name="destino" placeholder="Destino">
    <input type="number" step="0.01" name="cost" placeholder="Precio">
    <button type="submit">Aúadir</button>
</form>
</body>
</html>
