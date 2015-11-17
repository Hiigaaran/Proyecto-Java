<%-- 
    Document   : ingresoVentas
    Created on : 15-11-2015, 19:12:18
    Author     : Jordan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center> 
         <h3> Sistema Punto de Ventas</h3>
        <%@include file="opciones.jsp" %>
        _______________________________________________________________
    </center>   
        <table border="0">           
            <tbody>
                <tr>Ingresa Datos Cliente</tr>
                <tr>
                    <td>Rut:</td>
                    <td><input type="text" name="rut_cli"/></td>
                    <td>Nombre:</td>
                    <td><input type="text" name="nom_cli"/></td>
                    <td>Apellido:</td>
                    <td><input type="text" name="apell_cli"/></td>
                </tr>
                <tr>
                    <td>Direccion:</td>
                    <td><input type="text" name="direc_cli"/></td>
                    <td>Correo:</td>
                    <td><input type="text" name="correo_cli"/></td>
                    <td>      </td>
                    <td><input type="submit" alt="Ingresar Cliente"</td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

        
        
    </body>
</html>
