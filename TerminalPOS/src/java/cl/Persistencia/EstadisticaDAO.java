/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.Persistencia;

import cl.dominio.Cliente;
import cl.dominio.Estadistica;
import cl.dominio.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jordan
 */
public class EstadisticaDAO {
     private Connection cnx;

    public EstadisticaDAO(Connection cnx) {
        this.cnx = cnx;
    }
    
    
    
    public void create()
    {
        int totalSemana= obtenerSemanal();
        int totalMes=obtenerMensual();
        int totalAnio=obtenerAnual();
        
        java.util.Date date = new java.util.Date();
        Timestamp ts_now = new Timestamp(date.getTime());
        
        //Ingreso de la estadistica con todos los valores recuperados anteriormente
         String sql = "insert into estadistica (fecha_estadistica,total_semanal,total_mensual,total_anual)values(?,?,?,?)";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setTimestamp(1, ts_now);
            stmt.setInt(2, totalSemana);
            stmt.setInt(3, totalMes);
            stmt.setInt(4, totalAnio);
            
            stmt.executeUpdate();
        }catch (SQLException ex) {
            throw new RuntimeException("Error al Ingresar la Estadistica", ex);
        }
    }
    
    public int obtenerSemanal()
    {
        int totalSemana=0;
        //obtiene total de ventas de la  semana actual     
        
         String semana = "SELECT sum(valor_neto_total) FROM venta WHERE WEEKOFYEAR(fecha) = WEEKOFYEAR(NOW())";
        try (PreparedStatement stmt = cnx.prepareStatement(semana)) {
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                   totalSemana=rs.getInt("sum(valor_neto_total)");
                }
            }             
           
        }catch (SQLException ex) {
            throw new RuntimeException("Error al obtener total semanal", ex);
        }
        return totalSemana;
    }
    
    public int obtenerMensual()
    {
        int totalMes=0; 
        //SELECT sum(valor_neto_total) from venta where EXTRACT(MONTH FROM fecha) = EXTRACT(MONTH FROM now())
        //obtiene total de ventas del  mes actual
        String mes = "SELECT sum(valor_neto_total) FROM venta  WHERE YEAR(fecha) = YEAR(NOW()) AND MONTH(fecha)=MONTH(NOW())";
        try (PreparedStatement stmt = cnx.prepareStatement(mes)) {
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                   totalMes=rs.getInt("sum(valor_neto_total)");
                }
            }             
           
        }catch (SQLException ex) {
            throw new RuntimeException("Error al obtener total Mensual", ex);
        }
        return totalMes;
    }
    
    public int obtenerAnual()
    {
        int totalAnio=0;
        //obtiene toal de ventas del año actual
         String anio = "SELECT sum(valor_neto_total) FROM venta  WHERE YEAR(fecha) = YEAR(NOW());";
        try (PreparedStatement stmt = cnx.prepareStatement(anio)) {
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                   totalAnio=rs.getInt("sum(valor_neto_total)");
                }
            }             
           
        }catch (SQLException ex) {
            throw new RuntimeException("Error al obtener total Anual", ex);
        }
        return totalAnio;
    }
    
    
    public int obtenerDiario()
    {
        int totalDiario=0;
        //obtiene toal de ventas del año actual
         String dia = "SELECT sum(valor_neto_total) total FROM venta WHERE YEAR(fecha) = YEAR(NOW()) AND MONTH(fecha) = MONTH(NOW()) AND DAY(fecha) = DAY(NOW())";
        try (PreparedStatement stmt = cnx.prepareStatement(dia)) {
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                   totalDiario=rs.getInt("total");
                }
            }             
           
        }catch (SQLException ex) {
            throw new RuntimeException("Error al obtener total del Dia", ex);
        }
        
        return totalDiario;
    }
    
    
    
    public List<Estadistica> buscarTodoEstadisticas()
    {
       
          List<Estadistica> lista = new ArrayList<>();
            String sql = "select * from estadistica order by cod_estadistica";
          try (PreparedStatement stmt = cnx.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Estadistica estad= new Estadistica();
                estad.setCod_estadistica(rs.getInt("cod_estadistica"));
                estad.setFecha_estadistica(rs.getTimestamp("fecha_estadistica"));
                estad.setTotal_semanal(rs.getInt("total_semanal"));
                estad.setTotal_mensual(rs.getInt("total_mensual"));
                estad.setTotal_anual(rs.getInt("total_anual"));             
                  
                lista.add(estad);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al Buscar Todas las Estadisticas", ex);
        }
        return lista;
        
        
        
    }
    
    
    
    
    public double obtenerPromedioDiario()
    {
        double promedioDiario=0;
        //obtiene toal de ventas del año actual
         String average = "SELECT avg(valor_neto_total) FROM venta WHERE YEAR(fecha) = YEAR(NOW()) AND MONTH(fecha) = MONTH(NOW()) AND DAY(fecha) = DAY(NOW())";
        try (PreparedStatement stmt = cnx.prepareStatement(average)) {
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                   promedioDiario=rs.getDouble("avg(valor_neto_total)");
                }
            }             
           
        }catch (SQLException ex) {
            throw new RuntimeException("Error al promedio  del Dia", ex);
        }
        
        return promedioDiario;
    }
    
    
        public double obtenerPromedioAnual()
    {
        double promedioAnual=0;
        //obtiene toal de ventas del año actual
         String average = "SELECT avg(valor_neto_total) FROM venta  WHERE YEAR(fecha) = YEAR(NOW())";
        try (PreparedStatement stmt = cnx.prepareStatement(average)) {
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                   promedioAnual=rs.getDouble("avg(valor_neto_total)");
                }
            }             
           
        }catch (SQLException ex) {
            throw new RuntimeException("Error al obtener promedio Anual", ex);
        }
        return promedioAnual;
    }
    
        
         public double obtenerPromedioMensual()
    {
        double promedioMes=0; 
        //SELECT sum(valor_neto_total) from venta where EXTRACT(MONTH FROM fecha) = EXTRACT(MONTH FROM now())
        //obtiene total de ventas del  mes actual
        String average = "SELECT avg(valor_neto_total) FROM venta  WHERE YEAR(fecha) = YEAR(NOW()) AND MONTH(fecha)=MONTH(NOW())";
        try (PreparedStatement stmt = cnx.prepareStatement(average)) {
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                   promedioMes=rs.getDouble("avg(valor_neto_total)");
                }
            }             
           
        }catch (SQLException ex) {
            throw new RuntimeException("Error al obtener promedio Mensual", ex);
        }
        return promedioMes;
    }
         
          
    public double obtenerPromedioSemanal()
    {
        double promedioSemana=0;
        //obtiene total de ventas de la  semana actual     
        
         String average = "SELECT avg(valor_neto_total) FROM venta WHERE WEEKOFYEAR(fecha) = WEEKOFYEAR(NOW())";
        try (PreparedStatement stmt = cnx.prepareStatement(average)) {
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                   promedioSemana=rs.getDouble("avg(valor_neto_total)");
                }
            }             
           
        }catch (SQLException ex) {
            throw new RuntimeException("Error al obtener promedio semanal", ex);
        }
        return promedioSemana;
    }
    
    
    
    
    
    
}
