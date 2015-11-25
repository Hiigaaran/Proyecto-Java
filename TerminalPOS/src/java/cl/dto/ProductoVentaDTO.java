/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dto;

import cl.dominio.Producto;
import cl.dominio.Venta;
import java.io.Serializable;

/**
 *
 * @author Simon
 */
public class ProductoVentaDTO implements Serializable{
    private Producto producto;
    private Venta venta;

    public ProductoVentaDTO() {
    }

    public ProductoVentaDTO(Producto producto, Venta venta) {
        this.producto = producto;
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
}
