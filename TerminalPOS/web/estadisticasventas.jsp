<%-- 
    Document   : estadisticasventas
    Created on : 27-nov-2015, 2:11:46
    Author     : kades
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <title>Estadisticas POS</title>
        <style>
            table {
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                padding: 5px;
            }
        </style>
    </head>
    <body class="teal">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <form action="<c:url value="/ControllerEstadisticasVentas" />" method="GET">
            <center><h1>Sitio de Estadisticas de POS</h1></center>
            <%@include file="opciones.jsp" %>
        
    <center><h3>Lista de Cliente Registrados</h3></center>
    <center>
        <table>
            <tr>
                <th>Rut Cliente</th>
                <th>Nombre Cliente</th>
            </tr>
            <c:forEach var="c" items="${lstCliente}">

                <tr>
                    <td><c:out value="${c.rutCliente}" /> </td>
                    <td><c:out value="${c.nombre}" /> </td>
                </tr>
            </c:forEach>
        </table>
    </center>
    
    <center><h3>Lista de Ventas Registradas</h3></center>
    <center>
        <table>
        <tr>
            <th>Codigo Venta</th>
            <th>Fecha Venta</th>
            <th>Cliente</th>
            <th>Codigo Producto</th>
            <th>Cantidad Producto</th>
            <th>Valor Neto Total Venta</th>
        </tr>
        <c:forEach var="v" items="${lstVentas}" >
            <tr>
                <td><c:out value="${v.codVenta}" /></td>
                <td><c:out value="${v.fecha}" /></td>
                <td><c:out value="${v.rutCliente}" /></td>
                <td><c:out value="${v.codProducto}" /></td>
                <td><c:out value="${v.cantProducto}" /></td>
                <td><c:out value="${v.valorNetoTotal}" /></td>
            </tr>
        </c:forEach>
    </table>
    </center>
    </body>
        </form>
</html>
