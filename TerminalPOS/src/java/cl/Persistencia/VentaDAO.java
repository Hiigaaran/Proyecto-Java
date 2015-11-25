/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.Persistencia;

import cl.dominio.Producto;
import cl.dominio.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class VentaDAO {
    private Connection cnx;

    public VentaDAO(Connection cnx) {
        this.cnx = cnx;
    }
    
    public void ingresarVenta(Venta v, Producto p){
        //Primero va la validación.
        String sql = "update producto set stock=? where cod_producto= ?";
        
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setInt(1, p.getStock() - v.getCantProducto());
            stmt.setInt(2, v.getCodProducto());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al ingresar la venta, stock insuficiente!!");
        }
        
        //Si pasa la validacion se continua con la venta del producto.
        sql = "insert into venta (fecha, rut_cliente, cant_prod, valor_neto_total)";
        
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setTimestamp(1, v.getFecha());
            stmt.setInt(2, v.getRutCliente());
            stmt.setInt(3, v.getCantProducto());
            stmt.setInt(4, v.getValorNetoTotal());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al ingresar la venta, error inesperado!!");
        }
        
    }
    
    public List<Venta> buscarVentas(){
        List<Venta> ventas = new ArrayList<>();
        String sql = "select * from venta order by cod_venta";
        
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setCodVenta(rs.getInt("cod_venta"));
                venta.setCodProducto(rs.getInt("cod_producto"));
                venta.setCantProducto(rs.getInt("cant_prod"));
                venta.setFecha(rs.getTimestamp("fecha"));
                venta.setRutCliente(rs.getInt("rut_cliente"));
                venta.setValorNetoTotal(rs.getInt("valor_neto_total"));
                ventas.add(venta);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar todos los registros de Ventas");
        }
        return ventas;
    }
}
