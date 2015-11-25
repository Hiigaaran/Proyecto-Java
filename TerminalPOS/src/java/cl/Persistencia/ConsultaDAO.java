/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.Persistencia;

import cl.dominio.Producto;
import cl.dominio.Venta;
import cl.dto.ClienteProductoVentaDTO;
import cl.dto.ProductoVentaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class ConsultaDAO {
    private Connection cnx;

    public ConsultaDAO(Connection cnx) {
        this.cnx = cnx;
    }
    
    public List<ProductoVentaDTO> buscarAllProductoVenta(){
        List<ProductoVentaDTO> lista = new ArrayList<>();
        String sql = "select * from producto pro, venta ven on(pro.cod_producto=ven.cod_producto)";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                Venta venta = new Venta();
                venta.setCantProducto(rs.getInt("ven.cant_prod"));
                venta.setCodProducto(rs.getInt("ven.cod_producto"));
                venta.setFecha(rs.getTimestamp("ven.fecha"));
                venta.setRutCliente(rs.getInt("ven.rut_cliente"));
                venta.setValorNetoTotal(rs.getInt("valor_neto_total"));
                
                Producto producto = new Producto();
                producto.setClase(rs.getString("pro.clase"));
                producto.setDescripcion(rs.getString("pro.descripcion"));
                producto.setNombre(rs.getString("pro.nombre"));
                producto.setStock(rs.getInt("pro.stock"));
                producto.setValorNeto(rs.getInt("pro.valor_neto"));
                
                lista.add(new ProductoVentaDTO(producto, venta));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar el Venta vs Producto!!");
        }
        return lista;
    }
    
    public List<ClienteProductoVentaDTO> buscarAllClienteProductoVenta(){
        List<ClienteProductoVentaDTO> lista = new ArrayList<>();
        String sql = "select * from producto pro, ";
    }
}
