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
    <body class="lime lighten-1">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <center><%@include file="opciones.jsp" %></center>
        <form action="<c:url value="/ControllerEstadisticasVentas" />" method="GET">
            <center><h1>Sitio de Estadisticas de POS</h1></center>
        
    <center><h3>Lista de Cliente Registrados</h3></center>
    <center>
        <table class="centered highlight container">
            <tr>
                <th><center>Rut Cliente</center></th>
                <th><center>Nombre Cliente</center></th>
                <th><center>Acción</center></th>
            </tr>
            <c:forEach var="c" items="${lstCliente}">

                <tr>
                    <td><c:out value="${c.rutCliente}" /></td>
                    <td><c:out value="${c.nombre}" /></td>
                    <td>
                        <c:url var="urlEliminar" value="/ControllerEstadisticasVentas">
                            <c:param name="codigoCliente" value="${param.rutCliente}" />
                        </c:url>
                        <form action="${urlEliminar}" method="post">
                            <input type="hidden" name="codigoClienteDEL" value="${c.rutCliente}" />
                            <input class="waves-effect waves-light btn" type="submit" value="Eliminar" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <center><c:out value="${mensaje1}" /></center>
    </center>
    
    <center><h3>Lista de Ventas Registradas</h3></center>
    <center>
        <table class="centered highlight container">
        <tr>
            <th><center>Codigo Venta</center></th>
            <th><center>Fecha Venta</center></th>
            <th><center>Cliente</center></th>
            <th><center>Codigo Producto</center></th>
            <th><center>Cantidad Producto</center></th>
            <th><center>Valor Neto Total Venta</center></th>
            <th><center>Acción</center></th>
        </tr>
        <c:forEach var="v" items="${lstVentas}" >
            <tr>
                <td><c:out value="${v.codVenta}" /></td>
                <td><c:out value="${v.fecha}" /></td>
                <td><c:out value="${v.rutCliente}" /></td>
                <td><c:out value="${v.codProducto}" /></td>
                <td><c:out value="${v.cantProducto}" /></td>
                <td><c:out value="${v.valorNetoTotal}" /></td>
                <td>
                    <c:url var="urlEliminar2" value="/ControllerEstadisticasVentas">
                            <c:param name="codigoVenta" value="${param.codVenta}" />
                        </c:url>
                        <form action="${urlEliminar2}" method="post">
                            <input type="hidden" name="codigoVentaDEL" value="${v.codVenta}" />
                            <input class="waves-effect waves-light btn" type="submit" value="Eliminar" />
                        </form>
                </td>
            </tr>
        </c:forEach>
    </table>
        <center><c:out value="${mensaje2}" /></center>
    </center>
    </body>
        </form>
            </br>
                        </br>

                                    </br>

            
</html>
