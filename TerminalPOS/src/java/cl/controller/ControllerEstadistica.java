/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;


import cl.dominio.Estadistica;
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
 * @author ELver 
 */
@WebServlet(name = "ControllerEstadistica", urlPatterns = {"/ControllerEstadistica"})
public class ControllerEstadistica extends HttpServlet {

    @Resource(mappedName ="jdbc/puntoventa")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try(Connection cnx =ds.getConnection()){
            
           TerminalPosService service = new TerminalPosService(cnx);
            
           request.setAttribute("totaldia", service.buscarTotalDia());
           request.setAttribute("totalsemana", service.buscarTotalSemana());
           request.setAttribute("totalmes", service.buscarTotalMes());
           request.setAttribute("totalanio", service.buscarTotalAnio());
           request.setAttribute("promediodia", service.buscarPromedioDiario());
           request.setAttribute("promediosemana", service.buscarPromedioSemana());
           request.setAttribute("promediomes", service.buscarPromedioMensual());
           request.setAttribute("promedioanio", service.buscarPromedioAnual());
           request.setAttribute("lstEstadisticas", service.buscarTodasEstadisticas());
             
             
          
          request.getRequestDispatcher("/estadisticas.jsp").forward(request, response);   
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
         request.setCharacterEncoding("UTF-8");
        try (Connection cnx = ds.getConnection()) {
            TerminalPosService service = new TerminalPosService(cnx);
        
            
            service.crearEstadistica();
            
            request.setAttribute("totaldia", service.buscarTotalDia());
           request.setAttribute("totalsemana", service.buscarTotalSemana());
           request.setAttribute("totalmes", service.buscarTotalMes());
           request.setAttribute("totalanio", service.buscarTotalAnio());
           request.setAttribute("promediodia", service.buscarPromedioDiario());
           request.setAttribute("promediosemana", service.buscarPromedioSemana());
           request.setAttribute("promediomes", service.buscarPromedioMensual());
           request.setAttribute("promedioanio", service.buscarPromedioAnual());
           request.setAttribute("lstEstadisticas", service.buscarTodasEstadisticas());
            
            request.getRequestDispatcher("/estadisticas.jsp").forward(request, response); 
        
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }

   

}
