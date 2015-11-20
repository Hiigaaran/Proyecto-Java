/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dto;

import cl.dominio.Cliente;
import cl.dominio.DetalleVenta;
import cl.dominio.Producto;
import cl.dominio.Vendedor;
import cl.dominio.Venta;

/**
 *
 * @author Jordan
 */
public class VentaVendedorClienteDetalleVentaProducto {
    
    private Venta venta;
    private Vendedor vendedor;
    private Cliente cliente;
    private DetalleVenta detalleVenta;
    private Producto producto;

    public VentaVendedorClienteDetalleVentaProducto() {
    }

    public VentaVendedorClienteDetalleVentaProducto(Venta venta, Vendedor vendedor, Cliente cliente, DetalleVenta detalleVenta, Producto producto) {
        this.venta = venta;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.detalleVenta = detalleVenta;
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
  
    
    
}
