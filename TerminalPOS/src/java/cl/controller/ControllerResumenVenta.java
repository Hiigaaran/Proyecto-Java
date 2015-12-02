
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
@WebServlet(name = "ControllerResumenVenta", urlPatterns = {"/ControllerResumenVenta"})
public class ControllerResumenVenta extends HttpServlet {

   
    @Resource(mappedName = "jdbc/puntoventa")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String strCodProducto =(String)request.getAttribute("CodProducto");
        
        try (Connection cnx = ds.getConnection()) {
            TerminalPosService service = new TerminalPosService(cnx);
            Producto prod=service.buscarProducto(Integer.parseInt(strCodProducto));
            
             
        //seteo de atributos usados por producto
        request.setAttribute("neto", prod.getValorNeto());
        request.setAttribute("nombre", prod.getNombre());
        request.setAttribute("clase",prod.getClase());
        request.setAttribute("cod_producto", prod.getCodProducto());
        request.setAttribute("descripcion", prod.getDescripcion());
        request.setAttribute("stock", prod.getStock());
             
             
        
       
        Venta ven=(Venta) request.getAttribute("ventalista");
        
        
        //seteo de atributos usados por Venta
        request.setAttribute("cod_venta", ven.getCodVenta());
        request.setAttribute("fecha", ven.getFecha());
        request.setAttribute("cantidad_producto", ven.getCantProducto());
        request.setAttribute("neto_total", ven.getValorNetoTotal());
             
             
             
            request.getRequestDispatcher("/resumenVenta.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
}
