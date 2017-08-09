<%-- 
    Document   : login
    Created on : 15/07/2017, 19:45:51
    Author     : Joseph Sousa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href='http://fonts.googleapis.com/css?family=Englebert|Open+Sans:400,600,700' rel='stylesheet' type='text/css' />
        <link rel="stylesheet" href="AdminLTE-2.3.6/bootstrap/css/bootstrap.min.css"/>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css"/>
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css"/>
        <!-- Theme style -->
        <link rel="stylesheet" href="AdminLTE-2.3.6/dist/css/AdminLTE.min.css"/>
        <!-- iCheck -->
        <link rel="stylesheet" href="AdminLTE-2.3.6/plugins/iCheck/square/blue.css"/>
        <link href="default.css" rel="stylesheet" type="text/css" media="all" />
        <!--[if IE 6]>
        <link href="default_ie6.css" rel="stylesheet" type="text/css" />
        <![endif]-->
    </head>
    <body>
        <div id="wrapper" class="container1">
            <div id="page">
                <div class="login-box">
                    <div class="login-logo">
                        <a href="login.jsp"><b>Caro</b>neiro</a>
                    </div>
                    <!-- /.login-logo -->
                    <div class="login-box-body">
                        <p class="login-box-msg">Faça o login para prosseguir</p>

                        <form action="FrontController?action=Login" method="post">
                            <div class="form-group has-feedback">
                                <input type="email" id="email" name="email" class="form-control" placeholder="Email"/>
                                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <input type="password" name="senha" id="senha" class="form-control" placeholder="Password"/>
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                            <div class="row">
                                <!-- /.col -->
                                <div class="col-xs-4">
                                    <button type="submit" class="btn btn-primary btn-block btn-flat">Entrar</button>
                                </div>
                                <!-- /.col -->
                            </div>
                        </form>
                        <c:if test="${requestScope.sucesso == false}">
                            <div id="errorMsg" class="alert alert-danger" style="margin: 10px 10px 5px 10px;">
                                <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Erro!</strong> ${requestScope.errorMsg}
                            </div>
                        </c:if>
                        <a href="register.jsp" class="text-center">Novo por aqui? Cadastre se</a>
                    </div>
                    <!-- /.login-box-body -->
                </div>
            </div>
        </div>
        <div id="footer">
            <p>&copy; Texugos Sistemas.</p>
        </div>
    </body>
</html>

