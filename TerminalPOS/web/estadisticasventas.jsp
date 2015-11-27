<%-- 
    Document   : estadisticasventas
    Created on : 27-nov-2015, 2:11:46
    Author     : kades
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
     <table>
            <tr>
                <th>Nombre</th>
                <th>Raza</th>
                <th>ID Reg.</th>
                <th>Fecha Registro</th>
                <th>Acción</th>
            </tr>
            <c:forEach var="p" items="${lstParticipantes}">

                <tr>
                    <td><c:out value="${p.participante.nombre}" /> </td>
                    <td><c:out value="${p.raza.nombre}" /> </td>
                    <td><c:out value="${p.participante.idRegistro}" /></td>
                    <td><fmt:formatDate value="${p.participante.fechaRegistro}" pattern="dd/MM/yyyy HH:mm" /> </td>
                    <td>
                        <c:url var="urlEliminar" value="/ListarParticipanteController">
                            <c:param name="idRaza" value="${param.idRaza}" />
                        </c:url>
                        <form action="${urlEliminar}" method="post">
                            <input type="hidden" name="idParticipante" value="${p.participante.id}" />
                            <input type="submit" value="Eliminar" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
