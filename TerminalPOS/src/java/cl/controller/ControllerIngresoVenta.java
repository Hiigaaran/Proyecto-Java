/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;

import cl.dominio.Cliente;
import cl.dominio.Producto;
import cl.dominio.Venta;
import cl.servicio.TerminalPosService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jordan
 */
@WebServlet(name = "ControllerIngresoVenta", urlPatterns = {"/ControllerIngresoVenta"})
public class ControllerIngresoVenta extends HttpServlet {

    @Resource(mappedName = "jdbc/puntoventa")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection cnx = ds.getConnection()){
            TerminalPosService service = new TerminalPosService(cnx);
            
            Cliente cliente = new Cliente();
            Producto producto = new Producto();
            Venta venta = new Venta();
            
            request.setAttribute("cliente", cliente);
            request.setAttribute("lsProducto", service.buscarTodosLosProductos());
            request.setAttribute("venta", venta);
            
            request.getRequestDispatcher("/ingresoVentas.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try (Connection cnx = ds.getConnection()){
            TerminalPosService service = new TerminalPosService(cnx);
            Cliente cliente = new Cliente();
            Venta venta = new Venta();
            Producto producto = new Producto();
            
            Map<String,String> mapMensajes = new HashMap<>();
            String mensaje;
            try {
                int rut = Integer.parseInt(request.getParameter("rut_cli"));
                //Supongo que aqui podriamos colocar un metodo para validar Ruts.
                if (rut <= 0) {
                    mapMensajes.put("rut_cli", "Tiene que ingresar un Rut Válido");
                }else{
                    cliente.setRutCliente(rut);
                }
            } catch (NumberFormatException e) {
                mapMensajes.put("rut_cli", "El Rut no es valido: " + request.getParameter("rut_cli"));
            }
            
            String nombreCli = request.getParameter("nom_cli");
            if (nombreCli.isEmpty()) {
                mapMensajes.put("nom_cli", "Tiene que ingresar nombre de cliente");
            }else{
                cliente.setNombre(nombreCli);
            }
            
            String strCodProducto = request.getParameter("lsProducto");
            if (strCodProducto.isEmpty()) {
                mapMensajes.put("lsProducto", "Tiene que seleccionar un producto para vender!!");
            }else{
                venta.setCodProducto(Integer.parseInt(strCodProducto));
            }
            
            int cantidad = Integer.parseInt(request.getParameter("cant_prod"));
            if (cantidad <= 0) {
                    mapMensajes.put("cant_prod", "Tiene que ingresar una cantidad valida!!");
                }else{
                    venta.setCantProducto(cantidad);
                }
            
            
            
        } catch (Exception e) {
        }
    }

    

}
