<%-- 
    Document   : resumenVenta
    Created on : 01-12-2015, 18:31:45
    Author     : Jordan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resumen Venta</title>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
    </head>
    <body class="lime lighten-1">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    <center><%@include file="opciones.jsp" %></center>
    <center>__________________________________________________________________________________________________</center>
    <center>
        <h1>Resumen de Venta</h1>
        </br>
        <h2>Cliente: <c:out value="${clientelisto.nombre}" /></h2>
        </br>
        <h3>Articulo: <c:out value="${Productolisto.nombre}" /> | Cantidad: <c:out value="${ventalista.cantProducto}" /></h3>
        </br>
        <h2>Valor Unitario: $ <c:out value="${Productolisto.valorNeto}" /> | Valor Total: $ <c:out value="${ventalista.valorNetoTotal}" /></h2>
        </br>
        <h2>Codigo de Venta: <c:out value="${ventalista.codVenta}" /></h2>
    </center>
    </body>
</html>
