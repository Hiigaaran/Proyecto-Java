<%-- 
    Document   : estadisticas
    Created on : 01-12-2015, 18:16:43
    Author     : Jordan
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
    <center><h3>Estadisticas Venta</h3></center>
    <center><%@include file="opciones.jsp" %></center>
    <center>
        <h2><center>Resumen Acotado</center></h2>
        <table class="centered highlight container">
            <tr>
                <th><center>Codigo Registro</center></th>
                <th><center>Fecha Ejecutada</center></th>
                <th><center>Total Semanal</center></th>
                <th><center>Total Mensual</center></th>
                <th><center>Total Anual</center></th>
            </tr>
            <c:forEach var="v" items="${lstEstadisticas}">
                  <tr>
                      <td><c:out value="${v.cod_estadistica}"/></td>
                      <td><c:out value="${v.fecha_estadistica}"/></td>
                      <td>$ <c:out value="${v.total_semanal}"/></td>
                      <td>$ <c:out value="${v.total_mensual}"/></td>
                      <td>$ <c:out value="${v.total_anual}"/></td>     
                  </tr>
              </c:forEach>
        </table>
        </br>
        <div>
            <table class="container highlight centered">
                <tr><td><h1>Ganancia Promedio del Dia : $ <c:out value="${promediodia}" /></h1></td></tr></table>
                </br>
            <table class="container highlight centered">
                <tr><td><h1>Ganancia Promedio del Mes : $ <c:out value="${promediomes}" /></h1></td></tr></table>
                </br>
            <table class="container highlight centered">
                <tr><td><h1>Ganancia Promedio del Año : $ <c:out value="${promedioanio}" /></h1></td></tr></table>
        </div>
    </center>
</body>
</html>
