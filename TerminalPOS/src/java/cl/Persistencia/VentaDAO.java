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
            
            if (p.getStock()>v.getCantProducto()) {
                 stmt.setInt(1, p.getStock() - v.getCantProducto());
                stmt.setInt(2, v.getCodProducto()); 
            
            stmt.executeUpdate(); 
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Error al ingresar la venta, stock insuficiente!!");
        }
        
        //Si pasa la validacion se continua con la venta del producto.
        sql = "insert into venta (fecha, rut_cliente, cant_prod, valor_neto_total,cod_producto) values (?,?,?,?,?)";
        
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setTimestamp(1, v.getFecha());
            stmt.setInt(2, v.getRutCliente());
            stmt.setInt(3, v.getCantProducto());
            stmt.setInt(4, v.getValorNetoTotal());
            stmt.setInt(5, v.getCodProducto());
            
            stmt.executeUpdate();
            
            
        } catch (SQLException e) {
            
            throw new RuntimeException("Error al ingresar la venta, error inesperado!!");
        }
        
    }
    
    public Venta buscarUltima()
    {
        int max=0;
        String sql = "select max(cod_venta) from venta";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                     max=rs.getInt("max(cod_venta)");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al Buscar el maximo codigo de venta", ex);
        }
        
        
       Venta ven =new Venta();
        String sql2 = "select * from venta where cod_venta  = ?";
        try (PreparedStatement stmt = cnx.prepareStatement(sql2)) {
            stmt.setInt(1, max);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                ven.setCodVenta(rs.getInt("cod_venta"));
                ven.setCodProducto(rs.getInt("cod_producto"));
                ven.setCantProducto(rs.getInt("cant_prod"));
                ven.setFecha(rs.getTimestamp("fecha"));
                ven.setRutCliente(rs.getInt("rut_cliente"));
                ven.setValorNetoTotal(rs.getInt("valor_neto_total"));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al Buscar  la ultima venta", ex);
        }
        return ven;
        
       
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
    
    public void eliminar(int cod){
        int codigoProducto = 0;
        int cantidadProducto = 0;
        int stock = 0;
        String sql = "select cod_producto, cant_prod from venta where cod_venta = ?";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setInt(1, cod);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                codigoProducto = rs.getInt("cod_producto");
                cantidadProducto = rs.getInt("cant_prod");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al encontrar datos del producto en la venta");
        }
        
        sql = "select stock from producto where cod_producto = ?";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setInt(1, codigoProducto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                stock = rs.getInt("stock");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar producto de la venta en eliminacion");
        }
        
        sql = "update producto set stock = ? where cod_producto = ?";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setInt(1, stock + cantidadProducto);
            stmt.setInt(2, codigoProducto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el stock del producto de la venta a eliminar");
        }
        
        sql = "delete from venta where cod_venta= ?";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setInt(1, cod);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar las ventas del cliente");
        }
    }
    
    
   
}
