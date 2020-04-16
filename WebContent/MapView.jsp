<%--
  Created by IntelliJ IDEA.
  User: Nano
  Date: 06/04/2020
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>


<div class="container-fluid p-0">
    <form class="justify-content-center">
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Origen">
                    </div>

                </div>
                <div class="col">
                    <div class="form-group">
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Destino">
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Calcular</button>
                    </div>
                </div>
            </div>
    </form>
    <div id="googleMap" style="width:100%;height:500px;"></div>
</div>

<script>
    function myMap() {
        navigator.geolocation.getCurrentPosition(function(position) {
            var lat = position.coords.latitude;
            var long = position.coords.longitude;
            var myLatlng = new google.maps.LatLng(lat, long);
            var mapProp= {
                center:myLatlng,
                zoom:15,
            };
            var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

            var marker = new google.maps.Marker({
                position:myLatlng,
                map: map,
                title: 'Hello World!'
            });

            marker.setMap(map);
        });

    }

    /*window.eqfeed_callback = function(results) {
        for (var i = 0; i < results.features.length; i++) {
            var coords = results.features[i].geometry.coordinates;
            var latLng = new google.maps.LatLng(coords[1],coords[0]);
            var marker = new google.maps.Marker({
                position: latLng,
                map: map
            });
        }
    }*/


</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB3mRMEq45bXCYnUyK90ZI1BEe2k20zYpc&callback=myMap"></script>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
