<%-- 
    Document   : opciones
    Created on : 15-11-2015, 19:06:32
    Author     : Jordan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1> Terminal Punto de Ventas </h1>
<p>
    Opciones: 
    <a href="<c:url value="/ControllerIngresoVenta" />">Agregar Nueva Venta</a>
    |
    <a href="<c:url value="/ControllerEstadisticasVentas" />">Registro de Ventas</a>
    |
    <a href="<c:out value="/ControllerEstadisticas"/>">Estadisticas</a>

</p>
<hr />
