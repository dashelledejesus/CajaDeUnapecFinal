<%-- 
    Document   : login
    Created on : 09/11/2021, 09:01:47 PM
    Author     : Arisleyni Casilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>BIENVENIDO AL SISTEMA DE CAJA DE UNAPEC</h1>
        <p>Usuario: <%= request.getParameter ("txt_user")%></p>
        <p>Contraseña: <%= request.getParameter ("txt_pass")%></p>
        <a href="http://localhost:8080/CapturaCliente/">Caja Unapec</a>
    </body>
</html>
