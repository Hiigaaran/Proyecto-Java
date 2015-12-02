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
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Jordan
 */
@WebServlet(name = "ControllerEstadisticasVentas", urlPatterns = {"/ControllerEstadisticasVentas"})
public class ControllerEstadisticasVentas extends HttpServlet {
    
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
           
            //request.setAttribute("venta", venta);
            //request.setAttribute("producto", producto);
            //request.setAttribute("cliente", cliente);
            request.setAttribute("lsProducto", service.buscarTodosLosProductos());
            request.setAttribute("lstCliente", service.buscarTodosCliente());
            request.setAttribute("lstVentas", service.buscarTodasVentas());
           
            
            request.getRequestDispatcher("/estadisticasventas.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
        
        
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection cnx = ds.getConnection()){
            TerminalPosService service = new TerminalPosService(cnx);
            
            
            String rut = request.getParameter("codigoClienteDEL");
            if (rut != null) {
                int rutN = Integer.parseInt(rut);
                service.eliminarCliente(rutN);
            }
            
            String cod = request.getParameter("codigoVentaDEL");
            if (cod != null) {
                int codN = Integer.parseInt(cod);
                service.eliminarVenta(codN);
            }
        
            //Luego se repite el doGet
            //request.setAttribute("venta", venta);
            //request.setAttribute("producto", producto);
            //request.setAttribute("cliente", cliente);
            request.setAttribute("lsProducto", service.buscarTodosLosProductos());
            request.setAttribute("lstCliente", service.buscarTodosCliente());
            request.setAttribute("lstVentas", service.buscarTodasVentas());
           
            
            request.getRequestDispatcher("/estadisticasventas.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
