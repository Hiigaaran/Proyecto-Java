/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.servicio;

import cl.Persistencia.ClienteDAO;
import cl.Persistencia.ProductoDAO;
import cl.Persistencia.VendedorDAO;
import cl.Persistencia.VentaDAO;
import cl.dominio.Cliente;
import cl.dominio.Producto;
import cl.dominio.Vendedor;
import java.sql.Connection;

/**
 *
 * @author Simon
 */
public class TerminalPosService {
    private ClienteDAO clienteDAO;
    private ProductoDAO productoDAO;
    private VendedorDAO vendedorDAO;
    private VentaDAO ventaDAO;

    public TerminalPosService(Connection cnx) {
        clienteDAO = new ClienteDAO(cnx);
        productoDAO = new ProductoDAO(cnx);
        vendedorDAO = new VendedorDAO(cnx);
        
    }
    
    //Seccion de Metodos para Cliente
    public void agregarCliente(Cliente c) throws ServicioException {
        
        Cliente bd = clienteDAO.buscarPorRutCliente(c.getRutCliente());
        if (bd != null) {
            throw new ServicioException("Ya existe un Cliente en la base de datos con el siguiente RUT: " + c.getRutCliente());
        }
        clienteDAO.agregar(c);
    }
    
    //Seccion de Metodos para Producto
    public void agregarProducto(Producto p) throws ServicioException {
        if(productoDAO.verificarCodproducto(p.getCodProducto())){
            throw new ServicioException("El producto con el siguiente nombre: " + p.getNombre()+" ya existe!!");
        }
        productoDAO.agregar(p);
    }
    
    //Seccion de Metodos para Vendedor
    public void agregarVendedor(Vendedor v) throws ServicioException {
        Vendedor bd = vendedorDAO.buscarPorRutVendedor(v.getRutVendedor());
        if (bd != null) {
            throw new ServicioException("Ya hay un vendedor registrado con el siguiente RUT: "+v.getRutVendedor());
        }
        vendedorDAO.agregar(v);
    }
}
