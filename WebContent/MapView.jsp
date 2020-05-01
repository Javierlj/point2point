<%--
  Created by IntelliJ IDEA.
  User: Nano
  Date: 06/04/2020
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>



<div class="container-fluid p-0">
    <form class="justify-content-center">
            <div class="row">
                <div class="col">
                    <div id="locationField1">
                        <input id="autocomplete1"
                               placeholder="Enter your address"
                               class="form-control"
                               onFocus="geolocate()"
                               type="text"/>
                    </div>

                </div>
                <div class="col">
                    <div class="form-group">
                        <div id="locationField2">
                            <input id="autocomplete2"
                                   placeholder="Enter your address"
                                   class="form-control"
                                   onFocus="geolocate()"
                                   type="text"/>
                        </div>
                    </div>

                </div>
                <div class="col">
                    <div class="form-group">
                        <button class="btn btn-primary">Calcular</button>
                    </div>
                </div>
            </div>
    </form>
    <div id="googleMap" style="width:100%;height:500px;"></div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>

<script>

    var map;

    var placeSearch, autocomplete;

    var place1,place2;

    var lat1,long1, startMarker;

    var lat2,long2, endMarker;

    var componentForm = {
        street_number: 'short_name',
        route: 'long_name',
        locality: 'long_name',
        administrative_area_level_1: 'short_name',
        country: 'long_name',
        postal_code: 'short_name'
    };

    var iconBase =
        'http://maps.google.com/mapfiles/ms/icons/';

    var icons = {
        Mobike: {
            icon: iconBase + 'cycling.png'
        },
        Blue: {
            icon: iconBase + 'blue.png'
        },
    }


    var bounds;

    function myMap() {
        bounds = new google.maps.LatLngBounds()
        navigator.geolocation.getCurrentPosition(function(position) {
            lat1 = position.coords.latitude;
            long1 = position.coords.longitude;
            var position1 = new google.maps.LatLng(lat1, long1);
            var mapProp= {
                center:position1,
                zoom:15,
            };
            map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

            google.maps.event.addListener(map, 'zoom_changed', function() {
                zoomChangeBoundsListener =
                    google.maps.event.addListener(map, 'bounds_changed', function(event) {
                        if (this.getZoom() > 15 && this.initialZoom == true) {
                            // Change max/min zoom here
                            this.setZoom(15);
                            this.initialZoom = false;
                        }
                        google.maps.event.removeListener(zoomChangeBoundsListener);
                    });
            });

            startMarker= new google.maps.Marker({
                position:position1,
                map: map,
                title: 'Inicio'
            });

            map.initialZoom = true;
            bounds.extend(place1)
            map.fitBounds(bounds);



        });

        // Create the autocomplete object, restricting the search predictions to
        // geographical location types.
        autocomplete1 = new google.maps.places.Autocomplete(
            document.getElementById('autocomplete1'), {types: ['geocode']});

        // Avoid paying for data that you don't need by restricting the set of
        // place fields that are returned to just the address components.
        //autocomplete.setFields(['address_component']);

        // When the user selects an address from the drop-down, populate the
        // address fields in the form.
        autocomplete1.addListener('place_changed', fillInAddress1);

        // Create the autocomplete object, restricting the search predictions to
        // geographical location types.
        autocomplete2 = new google.maps.places.Autocomplete(
            document.getElementById('autocomplete2'), {types: ['geocode']});

        // Avoid paying for data that you don't need by restricting the set of
        // place fields that are returned to just the address components.
        //autocomplete.setFields(['address_component']);

        // When the user selects an address from the drop-down, populate the
        // address fields in the form.
        autocomplete2.addListener('place_changed', fillInAddress2);

    }

    navigator.geolocation.getCurrentPosition(function(position) {
        lat = position.coords.latitude;
        long = position.coords.longitude;

        getData()
    })

    function getData() {
        if(lat1 && long1){
            var latitude=lat1
            var longitude=long1
        }else{
            var latitude=lat
            var longitude=long
        }
        $.get("FormPetitionServlet",
            {
                latitude: latitude,
                longitude: longitude,
                radio: "10000"
            },
            function(data, status){
                var bikes=data.bike
                for(i in bikes){
                    var bike=bikes[i]
                    new google.maps.Marker({
                        position:new google.maps.LatLng(bike.distY, bike.distX),
                        icon: icons["Mobike"].icon,
                        map: map,
                        title: 'Mobike'
                    });
                }
            });
    }



    $(document).ready(function() {

        //option A
        $("form").submit(function(e){
            e.preventDefault();
        });


    });



    // This sample uses the Autocomplete widget to help the user select a
    // place, then it retrieves the address components associated with that
    // place, and then it populates the form fields with those details.
    // This sample requires the Places library. Include the libraries=places
    // parameter when you first load the API. For example:
    // <script
    // src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">


    function fillInAddress1() {
        // Get the place details from the autocomplete object.
        place1 = autocomplete1.getPlace();
        lat1= place1.geometry.location.lat()
        long1= place1.geometry.location.lng()
        getData()
        if(startMarker){
            startMarker.setMap(null)
        }

        var position1= new google.maps.LatLng(lat1, long1)
        startMarker=new google.maps.Marker({
            position:position1,
            map: map,
            title: 'Destino'
        });
        bounds = new google.maps.LatLngBounds()
        if(lat2 && long2){
            var position2= new google.maps.LatLng(lat2, long2)
            bounds.extend(position2)
        }
        bounds.extend(position1)
        map.fitBounds(bounds);

    }

    function fillInAddress2() {
        // Get the place details from the autocomplete object.
        place2 = autocomplete2.getPlace();
        lat2= place2.geometry.location.lat()
        long2= place2.geometry.location.lng()
        if(endMarker){
            endMarker.setMap(null)
        }
        console.log(lat1,long1)

        var position1= new google.maps.LatLng(lat1, long1)
        var position2= new google.maps.LatLng(lat2, long2)

        endMarker=new google.maps.Marker({
            position:position2,
            map: map,
            title: 'Destino'
        });
        bounds = new google.maps.LatLngBounds()
        bounds.extend(position1)
        bounds.extend(position2)
        map.fitBounds(bounds);

    }
    // Bias the autocomplete object to the user's geographical location,
    // as supplied by the browser's 'navigator.geolocation' object.
    function geolocate() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                var geolocation = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
                var circle = new google.maps.Circle(
                    {center: geolocation, radius: position.coords.accuracy});
                autocomplete1.setBounds(circle.getBounds());
                autocomplete2.setBounds(circle.getBounds());

            });
        }
    }
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB3mRMEq45bXCYnUyK90ZI1BEe2k20zYpc&libraries=places&callback=myMap&&initAutocomplete"></script>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>
