<%-- 
    Document   : home
    Created on : 15/07/2017, 19:34:23
    Author     : Joseph Sousa
--%>
<%@page import="com.texugos.caronas.classes.Carona"%>
<%@page import="java.util.List"%>
<%@page import="com.texugos.caronas.interfaces.CaronaDaoIf"%>
<%@page import="com.texugos.caronas.factory.DaoFactoryBD"%>
<%@page import="com.texugos.caronas.factory.DaoFactoryIf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href='http://fonts.googleapis.com/css?family=Englebert|Open+Sans:400,600,700' rel='stylesheet' type='text/css' />
        <link href="default.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="AdminLTE-2.3.6//bootstrap/css/bootstrap.min.css"/>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css"/>
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css"/>
        <!-- Theme style -->
        <link rel="stylesheet" href="AdminLTE-2.3.6/dist/css/AdminLTE.min.css"/>
        <!-- iCheck -->
        <link rel="stylesheet" href="AdminLTE-2.3.6/plugins/iCheck/square/blue.css"/>
        <script type="text/javascript" src='jquery.min.js'></script>
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
        <div id="wrapper" class="container"/>
        <div id="page">
            <form action="FrontController?action=BuscaCaronas" method="post">
                <div class="input-group">
                    <input type="text" name="pesquisa-origem" class="form-control" placeholder="De onde ?" required/>
                    <input type="text" name="pesquisa-destino" class="form-control" placeholder="para onde ?" required/>
                    <br/>
                    <span class="input-group-btn">
                        <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                        </button>
                    </span>
                </div>
            </form>
            <br/>
            <table id="tabela-caronas" class="table table-bordered table-striped table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Origem</th>
                        <th>Destino</th>
                        <th>Parada</th>
                        <th>Hora de partida</th>
                        <th>Data</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${caronas}" var="carona">  
                        <tr>
                            <td class="id">${carona.id}</td>
                            <td>${carona.origem}</td>  
                            <td>${carona.destino}</td>   
                            <td>${carona.wayPoint}</td>   
                            <td>${carona.dataPartida}</td>  
                            <td>${carona.horaPartida}</td>    
                        </tr>  
                    </c:forEach>
                </tbody>
            </table>
            <form action="FrontController?action=ExibeCarona" method="post">
                <input name="id-carona" type="text" style="display: none" />
                <ul style="list-style: none; padding: 0px;">
                    <li style="float: left; margin-right: 10px;">
                        <button type='submit' class='submit-button success'>
                            <i class="fa fa-plus" aria-hidden="true"></i> visualizar 
                        </button>
                    </li>
                    <li>
                        <button type="button" class='submit-button danger'>
                            <i class="fa fa-times" aria-hidden="true"></i> Cancelar 
                        </button>
                    </li>
                </ul>
            </form>
            <script>
                $('#tabela-caronas tbody tr').click(function () {
                    $(this).addClass('selected').siblings().removeClass('selected');
                    $('table tr').each(function () {
                        var id = $(this).find('.id').html();
                        $('input[name="id-carona"').val(id);
                    });
                });
            </script>    
        </div>
        <div id="footer">
            <p>&copy; Texugos sistemas</p>
        </div>
    </body>
</html>

