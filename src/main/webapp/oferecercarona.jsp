<%-- 
    Document   : home
    Created on : 15/07/2017, 19:34:23
    Author     : Joseph Sousa
--%>
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Prospect 
Description: A two-column, fixed-width design with dark color scheme.
<a href="home.jsp"></a>
Version    : 1.0
Released   : 20130902

-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
        <meta charset="utf-8"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href='http://fonts.googleapis.com/css?family=Englebert|Open+Sans:400,600,700' rel='stylesheet' type='text/css' />
        <link href="default.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="AdminLTE-2.3.6//bootstrap/css/bootstrap.min.css">
            <!-- Font Awesome -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css"/>
            <!-- Ionicons -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css"/>
            <!-- Theme style -->
            <link rel="stylesheet" href="AdminLTE-2.3.6/dist/css/AdminLTE.css"/>
            <!-- iCheck -->
            <link rel="stylesheet" href="AdminLTE-2.3.6/plugins/iCheck/square/blue.css"/>
            <!--[if IE 6]>
            <link href="default_ie6.css" rel="stylesheet" type="text/css" />
            <![endif]-->
    </head>
    <body>
        <div id="header" class="container">
            <div id="logo">
                <h1><a href="home.jsp">Caroneiro</a></h1>
            </div>
            <div id="menu">
                <ul>
                    <li><a href="home.jsp" accesskey="1" title="">Inicio</a></li>
                    <li><a href="oferecercarona.jsp" accesskey="2" title="">Oferecer carona</a></li>
                    <li><a href="pedircarona.jsp" accesskey="3" title="">Pedir carona</a></li>
                </ul>
            </div>
        </div>
        <div id="wrapper" class="container">
            <div id="page">
                <div id="map"></div>
                <div id="content">                   
                    <form action="FrontController?action=CadastroCarona" id="carona" method="post">
                        <div class="form-group has-feedback">
                            <input type="text" class="form-control" id="start" name="partida" placeholder="Partida"/>
                            <span class="glyphicon glyphicon-arrow-up form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="text" id="end" class="form-control" name="destino" placeholder="Destino"/>
                            <span class="glyphicon glyphicon-arrow-down form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="text" id="waypoint" class="form-control" name="waypoint" placeholder="Parada"/>
                            <span class="glyphicon glyphicon-exclamation-sign form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="tel" class="form-control" name="telefone" placeholder="Telefone">
                                <span class="glyphicon glyphicon glyphicon-phone-alt form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="date" class="form-control" name="data-partida" placeholder="Data de partida"/>
                            <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="datetime" class="form-control" name="hora-partida" placeholder="Horário de partida"/>
                            <span class="glyphicon glyphicon-time form-control-feedback"></span>
                        </div>
                        <div class="col-xs-4">
                            <button type="button" id="rota" class="btn btn-primary btn-block btn-flat">Mostrar rota</button>
                        </div>
                        <div class="row">
                            <!-- /.col -->
                            <div class="col-xs-4">
                                <button type="submit" class="btn btn-primary btn-block btn-flat">Cadastrar carona</button>
                            </div>
                            <!-- /.col -->
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div id="footer">
            <p>&copy; Texugos sistemas</p>
        </div>
        <script>
            function initMap() {
                var directionsService = new google.maps.DirectionsService;
                var directionsDisplay = new google.maps.DirectionsRenderer;
                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 6,
                    center: {lat: -6.834571, lng: -38.549354}
                });
                directionsDisplay.setMap(map);

                document.getElementById('rota').addEventListener('click', function () {
                    calculateAndDisplayRoute(directionsService, directionsDisplay);
                });
            }
            function calculateAndDisplayRoute(directionsService, directionsDisplay) {
                var waypts = [];
                var checkboxArray = document.getElementById("waypoint").value;
                if (checkboxArray !== null && checkboxArray !== "") {
                    waypts.push({
                        location: checkboxArray,
                        stopover: true
                    });
                }
                directionsService.route({
                    origin: document.getElementById('start').value,
                    destination: document.getElementById('end').value,
                    waypoints: waypts,
                    optimizeWaypoints: true,
                    travelMode: 'DRIVING'
                }, function (response, status) {
                    if (status === 'OK') {
                        directionsDisplay.setDirections(response);
                    } else {
                        window.alert('Directions request failed due to ' + status);
                    }
                });
            }
        </script>
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBBRngUbErxBeoBn7kBAqjrj28akhK6q94&callback=initMap">
        </script>
    </body>
</html>

