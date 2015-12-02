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
          <table>
                <th>Fecha Estadistica</th>
                
                    <c:forEach var="v" items="lstEstadisticas">     
                    <td><c:out value="${v.fecha_estadisticas}"/></td> 
                </c:forEach>
                
            </table>
            
            <table> 
                <br/>
                <th>Estadistica Semanal</th>
                
                    <c:forEach var="c" items="lstEstadisticas">
                    <td><c:out value="${v.total_semanal}"/></td>
                </c:forEach>
               
            </table>

            <table>
                <br/>
                <th>Estadistica Mensual</th>
               
                    <c:forEach var="n" items="lstEstadisticas">
                    <td><c:out value="${n.total_mensual}"/></td>
                </c:forEach>
                

            </table>
            <table>
                <br/>
                <th>Estadistica Anual</th>
                 
                <c:forEach var="m" items="lstEstadisticas">
                <td><c:out value="${m.total_anual}"/></td>
                </c:forEach>
                
            </table>            
            <%---  
              <c:forEach var="v" items="${lstEstaditicas}">
                  <tr>
                      <td><c:out value="${v.cod_estadisticas}"/></td>
                      <td><c:out value="${v.fecha_estadisticas}"/></td>
                      <td><c:out value="${v.total_semanal}"/></td>
                      <td><c:out value="${v.total_mensual}"/></td>
                      <td><c:out value="${v.total_anual}"/></td>     
                  </tr>
              </c:forEach>
            --%>
        
    </center>
</body>
</html>
