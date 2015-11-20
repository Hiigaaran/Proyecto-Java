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
        <title>Venta</title>
    </head>
    <body>
    <center> 
         
        <%@include file="opciones.jsp" %>
       <br/>
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
                    <td><input type="submit" alt="Ingresar Cliente" </td>
                    <td></td>
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
                    <td><input type="text" name="nom_prod"/></td>
                    <td>Codigo Producto:</td>
                    <td><input type="text" name="cod_prod"/></td>
                    <td>Cantidad:</td>
                    <td><input type="text" name="cant_prod"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Codigo Venta:</td>
                    <td><input type="text" name="cod_ven"/></td>
                    <td>Valor:</td>
                    <td><input type="text" name="val_neto"></td>
                    <td>Valor Total:</td>
                    <td><input type="text" name="val_total" /></td>  
                </tr>  
                <tr>
                    <td><input type="submit" alt="Ingresar Venta"/></td>
                </tr>
           </tbody>
       </table> 
    </body>
</html>
