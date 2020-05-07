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
<body style="margin:15px">
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
                <th>Origen</th>
                <th>Destino</th>
                <th>¿Quieres eliminarlo?</th>
            </tr>
        </thead>
        <c:forEach items="${favourites}" var="favi">
        <tbody>
            <tr>
                <td>${favi.name}</td>
                <td>${favi.origin}</td>
                <td>${favi.destiny}</td>
                <td>
                    <button onClick="deleteFavourite(${favi.id})" class="btn btn-danger">Eliminar</button>
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
<form action="Form3ViajeFav" id="form-fav" class="form-inline">
    <input style="width: 200px" type="text" class="form-control mb-2 mr-sm-2"  name="id" id="fav-name" placeholder="Identificador del viaje" required>
    <input style="width: 200px" type="text" class="form-control mb-2 mr-sm-2" id="autocomplete1"  placeholder="Origen" required>
    <input style="width: 200px" type="text" class="form-control mb-2 mr-sm-2" id="autocomplete2"  placeholder="Destino" required>
    <button type="submit" class="btn btn-light">Añadir</button>
</form>
<script>
    autocomplete1 = new google.maps.places.Autocomplete(
        document.getElementById('autocomplete1'))
    autocomplete2 = new google.maps.places.Autocomplete(
        document.getElementById('autocomplete2'))

    function deleteFavourite(id){
        $.ajax({
            type: "POST",
            url: "FormDeleteFavourite",
            data: {
                favid:id

            },
            dataType: "text",
            success: function(){
                location.reload();
            }
        });
    }

    $("#form-fav").submit(function (e) {
        e.preventDefault();
        var origin = autocomplete1.getPlace();
        var destiny = autocomplete2.getPlace();
        var name=$("#fav-name").val();
        $.ajax({
            type: "POST",
            url: "Form3ViajeFav",
            data: {
                name: name,
                origin_lat:origin.geometry.location.lat(),
                origin_long:origin.geometry.location.lng(),
                destiny_lat:destiny.geometry.location.lat(),
                destiny_long:origin.geometry.location.lng(),
                origin: origin.formatted_address,
                destiny:destiny.formatted_address

            },
            dataType: "text",
            success: function(){
                location.reload();
            }
        });
    })

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
                    <td>${histi.origin}</td>
                    <td>${histi.destiny}</td>
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

</body>
</html>
