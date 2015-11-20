/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dto;

import cl.dominio.DetalleVenta;
import cl.dominio.Producto;

/**
 *
 * @author Jordan
 */
public class ProductoDetalleVenta {
    
    private Producto producto;
    private DetalleVenta detalleVenta;

    public ProductoDetalleVenta() {
    }

    public ProductoDetalleVenta(Producto producto, DetalleVenta detalleVenta) {
        this.producto = producto;
        this.detalleVenta = detalleVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
    
    
    
}
