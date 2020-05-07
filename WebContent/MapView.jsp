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



<div class="container-fluid p-0" >
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
    <div class="row"  id="mapRoute">
        <div class="col">
            <div id="googleMap" style="width:100%;height:35em;"></div>
        </div>
    </div>
    <div class="row" style="margin:15px 0px" id="cards">
    </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>

<script>

    var map;

    var directionsService

    var placeSearch, autocomplete;

    var directionsRenderer

    var place1,place2;

    var lat1,long1, startMarker;

    var lat2,long2, endMarker;

    var bikes;

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
            console.log(position)
            lat1 = position.coords.latitude;
            long1 = position.coords.longitude;
            var position1 = new google.maps.LatLng(lat1, long1);
            var mapProp= {
                center:position1,
                zoom:15,
            };
            map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

            directionsService = new google.maps.DirectionsService;

            var rendererOptions = {
                preserveViewport: true,
                suppressMarkers:true,
            };

            directionsRenderer = new google.maps.DirectionsRenderer(rendererOptions);
            directionsRenderer.setMap(map);

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
            document.getElementById('autocomplete2'), {types: ['geocode'], origin: new google.maps.LatLng(lat1, long1)});

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

                bikes=data.bike
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

    var options={
        mobike:{
            name:"Mobike",
            travelMode:"BICYCLING",
            startPrice:0,
            priceMin:0.20,
            imageUrl:"data:image/jpeg;base64,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",
            transitOptions:{}
        },
        walking:{
            name:"Andando",
            travelMode:"WALKING",
            startPrice:0,
            priceMin:0,
            imageUrl:"https://static.ellahoy.es/r/845X0/www.ellahoy.es/img/quemar-calorias-andando.jpg",
            transitOptions:{}
        },
        bus:{
            name:"Bus",
            travelMode:"TRANSIT",
            startPrice:1.50,
            priceMin:0,
            imageUrl:"https://www.esmadrid.com/sites/default/files/styles/content_type_full/public/editorial/buscomomoversepormadrid_1405591788.285.jpg?itok=ORj8ZXY6",
            transitOptions:{
                modes: "BUS",
            }
        },
        subway:{
            name:"Metro",
            travelMode:"TRANSIT",
            startPrice:1.50,
            priceMin:0,
            imageUrl:"https://www.soy-de.com/images/thumbs/Metro-de-Madrid-renueva-los-planos-de-su-red-de-es-0042224.jpeg",
            transitOptions:{
                modes: "SUBWAY",
            }
        }
    }

    function setRoute(serviceName){
        directionsRenderer.setDirections(options[serviceName].response);
    }

    function addHistorial(price){
        $.ajax({
            type: "POST",
            url: "Form4Historial",
            data: {
                origin_lat:lat1,
                origin_long:long1,
                destiny_lat:lat2,
                destiny_long:long2,
                origin: place1.formatted_address,
                destiny:place2.formatted_address,
                cost: price,

            },
            dataType: "text",
        });


    }

    function addCard(serviceName,waypoints, paint){
        var time;
        var travelMode= options[serviceName].travelMode;
        var startPrice= options[serviceName].startPrice;
        var priceMin= options[serviceName].priceMin;
        var imageUrl= options[serviceName].imageUrl;
        var name= options[serviceName].name;

        return directionsService.route({
            origin: new google.maps.LatLng(lat1,long1),
            destination: new google.maps.LatLng(lat2,long2),
            waypoints: waypoints ,
            optimizeWaypoints: true,
            travelMode: travelMode
        }, function(response, status) {
            if (status === 'OK') {

                time= response.routes[0].legs.reduce((acc,currentValue)=>acc+currentValue.duration.value,0);
                time=Math.ceil(time/60);
                var price=(startPrice+priceMin*time).toFixed(2)
                $('#cards').append('<div class="card" style="width: 20rem;margin-right: 8px">\n' +
                    '  <img class="card-img-top" style="height: 180px;" src='+imageUrl+' alt="Card image cap">\n' +
                    '  <div class="card-body">\n' +
                    '    <h5 class="card-title">'+name+'</h5>\n' +
                    '    <p class="card-text">Time: '+time+ ' minutos</p>\n' +
                    '    <p class="card-text">Price: '+price+' &euro;</p>\n' +
                    '    <div style="display: flex; justify-content: space-around">' +
                    '      <a href="#" style="flex-direction: column" onclick="setRoute(&quot;'+serviceName+'&quot;)" class="btn btn-primary">Calcular ruta</a>\n' +
                    '      <a href="#" style="flex-direction: column" onclick="addHistorial('+price+')" class="btn btn-primary">Viaje realizado </a>\n' +
                    '    </div>' +
                    '  </div>\n' +
                    '</div>')

                options[serviceName].response=response;
                if(paint){
                    place1= {
                        formatted_address:response.routes[0].legs[0].start_address};
                    directionsRenderer.setDirections(response);
                }

            } else {
                window.alert('Directions request failed due to ' + status);
            }
        });
    }


    $(document).ready(function() {

        //option A
        $("form").submit(function(e){
            e.preventDefault();
            if(lat1 && long1 && lat2 && long2){
                if(!document.getElementById("directionsPanel")){
                    var c= document.createElement("div")
                    c.id="col"

                    c.style.width = "35%";
                    c.style.overflow = "scroll";
                    c.style.maxHeight = "35em";

                    var dir= document.createElement("div")
                    dir.id="directionsPanel"
                    c.appendChild(dir)
                    document.getElementById("mapRoute").appendChild(c)
                }
                var waypoints;
                directionsRenderer.setPanel(document.getElementById('directionsPanel'));
                if(bikes.length>0){
                    var bike=bikes[0];
                    waypoints= [{location:new google.maps.LatLng(bike.distY, bike.distX),stopover:true}];
                }

                $('#cards').empty();

                addCard("mobike",waypoints,false);

                addCard("walking",[],false);

                //addCard("bus",[],false);

                addCard("subway",[],true);





                /*directionsService.route({
                    origin: new google.maps.LatLng(lat1,long1),
                    destination: new google.maps.LatLng(lat2,long2),
                    travelMode: 'TRANSIT',
                    transitOptions: {
                        modes: ["BUS", "RAIL"]
                    }
                }, function(response, status) {
                    console.log(response)
                    if (status === 'OK') {
                        directionsRenderer.setDirections(response);
                    } else {
                        window.alert('Directions request failed due to ' + status);
                    }
                });*/

            }

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
