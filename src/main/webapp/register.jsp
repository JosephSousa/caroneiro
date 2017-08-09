<%-- 
    Document   : register
    Created on : 15/07/2017, 20:40:18
    Author     : Joseph Sousa
--%>
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Prospect 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20130902

-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href='http://fonts.googleapis.com/css?family=Englebert|Open+Sans:400,600,700' rel='stylesheet' type='text/css' />
        <link href="default.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="AdminLTE-2.3.6//bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="AdminLTE-2.3.6/dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="AdminLTE-2.3.6/plugins/iCheck/square/blue.css">
        <!--[if IE 6]>
        <link href="default_ie6.css" rel="stylesheet" type="text/css" />
        <![endif]-->
    </head>
    <body>
        <div id="wrapper" class="container1">
            <div id="page">
                <div class="register-box">
                    <div class="register-logo">
                        <a href="login.jsp"><b>Caro</b>neiro</a>
                    </div>

                    <div class="register-box-body">
                        <p class="login-box-msg">Registro de usuários</p>

                        <form action="FrontController?action=CadastroUsuarios" method="post">
                            <div class="form-group has-feedback">
                                <input type="text" class="form-control" name="nome" placeholder="Nome">
                                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <input type="email" class="form-control" name="email" placeholder="Email">
                                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <input type="tel" class="form-control" name="telefone" placeholder="Telefone">
                                    <span class="glyphicon glyphicon glyphicon-phone-alt form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <input type="password" class="form-control" name="senha" placeholder="Senha">
                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <input type="password" class="form-control" name="senha2" placeholder="Repita a senha">
                                    <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                            </div>
                            <div class="row">
                                <!-- /.col -->
                                <div class="col-xs-4">
                                    <button type="submit" class="btn btn-primary btn-block btn-flat">Cadastrar</button>
                                </div>
                                <!-- /.col -->
                            </div>
                        </form>
                        <c:if test="${requestScope.sucessoUser == false}">
                            <div id="errorMsg" class="alert alert-danger" style="margin: 10px 10px 5px 10px;">
                                <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Erro!</strong> ${requestScope.errorMsg}
                            </div>
                        </c:if>
                        <a href="login.jsp" class="text-center">Já sou membro</a>
                    </div>
                    <!-- /.form-box -->
                </div>
            </div>
        </div>
        <div id="footer">
            <p>&copy; Texugos sistemas</p>
        </div>
    </body>
</html>

