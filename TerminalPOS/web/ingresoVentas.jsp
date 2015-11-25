<%-- 
    Document   : ingresoVentas
    Created on : 15-11-2015, 19:12:18
    Author     : Jordan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venta</title>
    </head>
    <body>
    <center> 
         
        <%@include file="opciones.jsp" %>
       <br/>
    </center>   
        <form action="<c:url value="/ControllerIngresoVenta"/>" method="post">
            <table border="0">           
            <tbody>
                <tr>Ingresa Datos Cliente</tr>
                <tr>
                    <td>Rut:</td>
                    <td><input type="text" name="rut_cli" value="<c:out value="${cliente.rutCliente}"/>"/></td>
                    <td>Nombre:</td>
                    <td><input type="text" name="nom_cli" value="<c:out value="${cliente.nombre}"/>"/></td>
                </tr>
            </tbody>
        </table>
______________________________________________________________________________________________________
       <br/>
       <br/>
       <table border="0">
           <tbody>
               <tr>Ingrese Datos de la Venta</tr>
               <tr>
                    <td>Producto:</td>
                            <td><select name="lsProducto" >
                                    <option value="">(Seleccione)</option>
                                    <c:forEach var="p" items="${lsProducto}">
                                        <option value="${p.codProducto}" ${p.codProducto == venta.codProducto ? 'Selected' : ''}>
                                            <c:out value="${p.nombre}"/>
                                        </option>
                                    </c:forEach>
                        </select></td>
                    <td>Cantidad:</td>
                    <td><input type="text" name="cant_prod" value="<c:out value="${venta.cantProducto}"/>"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Valor Unitario:</td>
                    <td><input type="text" name="val_neto" value="<c:out value="${producto.valorNeto}"/>"></td>
                    <td>Valor Total:</td>
                    <td><input type="text" name="val_total" value="<c:out value="${venta.valorNetoTotal}"/>"/></td>  
                </tr>  
                <tr>
                    <td><input type="submit" alt="Ingresar Venta"/></td>
                </tr>
           </tbody>
       </table> 
        </form>
    </body>
</html>
