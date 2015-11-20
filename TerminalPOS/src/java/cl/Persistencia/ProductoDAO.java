/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.Persistencia;

import cl.dominio.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jordan
 */
public class ProductoDAO {
    
    private Connection cnx;
    
    public ProductoDAO (Connection cnx)
    {
        this.cnx=cnx;
    }
    
    
    public void agregar(Producto p)
    {
      String sql = "insert into producto"
              + "(cod_producto,nombre,clase,descripcion,stock,valor_neto)"
              + "values(?,?,?,?,?,?)"  ;
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
              
            stmt.setInt(1, p.getCodProducto());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getClase());
            stmt.setString(4,p.getDescripcion());
            stmt.setInt(5, p.getStock());
            stmt.setInt(6, p.getValorNeto());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error ingresar el Producto", ex);
        }
        
    }
    
    
    
    public void actualizar()
    {
        
    }
    
    
    
}
