<<<<<<< HEAD
package cl.Persistencia;

import cl.dominio.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {

    private Connection cnx;

    public VendedorDAO(Connection cnx) {
        this.cnx = cnx;
    }

    public void agregar(Vendedor v) {
        String sql = "insert into vendedor "
                + "(rutVendedor,nombre,apellido)"
                + "values (?,?,?)";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){

            stmt.setString(1,v.getRutVendedor());
            stmt.setString(2,v.getNombre());
            stmt.setString(3,v.getApellido());
            
        } catch (SQLException ex) {
        throw new RuntimeException("Error al agregar Vendedor");
        }
    }
    
    public Vendedor buscarPorRutVendedor(String rutVendedor){
        String sql = "select * from Vendedor where rutVendedor";
        Vendedor v = null;
        
        try(PreparedStatement stmt = cnx.prepareStatement(sql)) {
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                  v.setRutVendedor(rs.getString("rut_Vendedor"));
                  v.setNombre(rs.getString("nombre"));
                  v.setApellido(rs.getString("apellido"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al Buscar Peticion");
        }
        return v;
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.Persistencia;

/**
 *
 * @author Sergio
 */
public class VendedorDAO {
    
    
   
}
>>>>>>> e86a8e7f5a8c94d69487bcfb41a03a25079c1666
