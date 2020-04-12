<%--
  Created by IntelliJ IDEA.
  User: Nano
  Date: 06/04/2020
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<html>
<body>

<form action="Form2Viaje">
    <input type="text" name="origen" placeholder="Origen">
    <input type="text" name="destino" placeholder="Destino">
    <button type="submit">Calcular</button>
</form>

<div id="googleMap" style="width:100%;height:300px;"></div>

<script>
    function myMap() {
        var myLatlng = new google.maps.LatLng(40.416775, -3.703790);
        var mapProp= {
            center:myLatlng,
            zoom:10,
        };

        var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

        var marker = new google.maps.Marker({
            position:myLatlng,
            map: map,
            title: 'Hello World!'
        });

        marker.setMap(map);
    }
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB3mRMEq45bXCYnUyK90ZI1BEe2k20zYpc&callback=myMap"></script>

</body>
</html>
