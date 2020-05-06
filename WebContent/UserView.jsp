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

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB3mRMEq45bXCYnUyK90ZI1BEe2k20zYpc&libraries=places"></script>
<html>
<head>
    <title> Usuario </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="d-flex">
    <h1 style="flex-direction: row"> ${usuario.name} </h1>
    <div class="ml-auto">
        <span style="font-size: 50px">
            <a style="text-decoration: none; flex-direction: row" href="MainView.jsp" class="fas fa-arrow-circle-left icon-5x"></a>
        </span>
    </div>

</div>


<h2>Viajes favoritos</h2>
<table class="table table-hover">
    <c:if test="${fn:length(favourites) != 0}">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>¿Quieres eliminarlo?</th>
            </tr>
        </thead>
        <c:forEach items="${favourites}" var="favi">
        <tbody>
            <tr>
                <td>${favi.name}</td>
                <td>
                    <form action="FormDeleteFavourite">
                        <input type="hidden" name="favid" value="${favi.id}" />
                        <button type="submit" class="btn btn-danger">Eliminar</button>
                    </form>
                </td>
            </tr>
        </tbody>
        </c:forEach>
    </c:if>
    <c:if test="${fn:length(favourites) == 0}">
    <tbody>
        <tr>
            <td>No has añadido viajes favoritos aún.</td>
        </tr>
    </tbody>
    </c:if>
</table>

<h2>Añade un nuevo viaje favorito</h2>
<form action="Form3ViajeFav" class="form-inline">
    <input style="width: 200px" type="text" class="form-control mb-2 mr-sm-2"  name="id" placeholder="Identificador del viaje" required>
    <input style="width: 200px" type="text" class="form-control mb-2 mr-sm-2" id="autocomplete1"  placeholder="Origen" required>
    <input style="width: 200px" type="text" class="form-control mb-2 mr-sm-2" id="autocomplete2"  placeholder="Destino" required>
    <input type="hidden" id="origin_lat" name="origin_lat" >
    <input type="hidden" id="destiny_lat" name="destiny_lat" >
    <input type="hidden" id="origin_long" name="origin_long">
    <input type="hidden" id="destiny_long" name="destiny_long">
    <button type="submit" class="btn btn-light">Añadir</button>
</form>
<script>
    autocomplete1 = new google.maps.places.Autocomplete(
        document.getElementById('autocomplete1'))
    autocomplete2 = new google.maps.places.Autocomplete(
        document.getElementById('autocomplete2'))
    place1 = autocomplete1.getPlace();
    let origin_lat= place1.geometry.location.lat()
    document.getElementById("origin_lat").value = origin_lat;
    let origin_long= place1.geometry.location.lng()
    document.getElementById("destiny_lat").value = origin_long;
    place2 = autocomplete2.getPlace();
    let destiny_lat= place2.geometry.location.lat()
    document.getElementById("origin_long").value = destiny_lat;
    let destiny_long= place2.geometry.location.lng()
    document.getElementById("destiny_long").value = destiny_long;


</script>

<h2>Historial de viajes realizados</h2>
<table class="table table-hover">
    <c:if test="${fn:length(historial) != 0}">
        <thead>
            <tr>
                <th>Id</th>
                <th>Fecha</th>
                <th>Origen</th>
                <th>Destino</th>
                <th>Precio</th>
            </tr>
        </thead>
        <c:forEach items="${historial}" var="histi">
            <tbody>
                <tr>
                    <td>${histi.id}</td>
                    <td>${histi.date}</td>
                    <td>${histi.origen}</td>
                    <td>${histi.destino}</td>
                    <td>${histi.cost} €</td>
                </tr>
                </tbody>
        </c:forEach>
    </c:if>
    <c:if test="${fn:length(historial) == 0}">
    <tbody>
        <tr>
            <td>Aún no ha realizado ningún viaje.</td>
        </tr>
    </tbody>
    </c:if>
</table>
<h1>Añade un nuevo viaje al historial</h1>
<form action="Form4Historial" >
    <input type="text" class="form-control" name="origen" placeholder="Origen">
    <input type="text" class="form-control" name="destino" placeholder="Destino">
    <input type="number" class="form-control" step="0.1" name="cost" placeholder="Precio">
    <button type="submit" class="btn btn-light">Añadir</button>
</form>
</body>
</html>
