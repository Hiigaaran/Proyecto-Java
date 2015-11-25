/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.Persistencia;


import cl.dominio.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    
    public void agregar (Producto p)
    {
        String sql = "insert into producto (nombre,clase,descripcion,stock, valor_neto)values(?,?,?,?,?)";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            
            stmt.setString(1,p.getNombre());
            stmt.setString(2, p.getClase());
            stmt.setString(3, p.getDescripcion());
            stmt.setInt(4, p.getStock());
            stmt.setInt(5, p.getValorNeto());
            
            int filasAfectadas = stmt.executeUpdate();
        }catch (SQLException ex) {
            throw new RuntimeException("Error al Agregar Producto", ex);
        }
        }
    
    public void eliminar(Producto p) {
        String sql = "delete from producto where cod_producto = ?";
        
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setInt(1, p.getCodProducto());

            int filasAfectas = stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error al Eliminar el Producto", ex);
        }

    }
    
    public Producto buscar(int cod_producto)
    {
        Producto prod = null;
        String sql = "select * from producto where cod_producto  = ?";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setInt(1, cod_producto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    prod= new Producto();
                    prod.setCodProducto(rs.getInt("cod_prodducto"));
                    prod.setNombre(rs.getString("nombre"));
                    prod.setClase(rs.getString("clase"));
                    prod.setDescripcion(rs.getString("descripcion"));
                    prod.setStock(rs.getInt("stock"));
                    prod.setValorNeto(rs.getInt("valor_neto"));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al Buscar el Producto", ex);
        }
        return prod;
        
    }
    
    
    
    
    public List<Producto> buscarTodos()
    {
        List<Producto> lista = new ArrayList();
        String sql = "select * from producto order by cod_producto";
          try (PreparedStatement stmt = cnx.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setCodProducto(rs.getInt("cod_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setClase(rs.getString("clase"));
                prod.setDescripcion(rs.getString("descrpcion"));
                prod.setStock(rs.getInt("stock"));
                prod.setValorNeto(rs.getInt("valor_neto"));
                
                lista.add(prod);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al Buscar Todos los Productos", ex);
        }
        return lista;
    }
    
    }

