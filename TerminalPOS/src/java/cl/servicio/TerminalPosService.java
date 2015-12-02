/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.servicio;



import java.sql.Connection;
import java.util.List;
import cl.Persistencia.*;
import cl.dominio.Cliente;
import cl.dominio.Producto;
import cl.dominio.Venta;
import cl.dto.ClienteProductoVentaDTO;
import cl.dto.ProductoVentaDTO;

/**
 *
 * @author Simon
 */
public class TerminalPosService {
    
    private ClienteDAO clienteDAO;
    private ProductoDAO productoDAO;
    private VentaDAO ventaDAO;
    private ConsultaDAO consultaDAO;

    public TerminalPosService(Connection cnx) {
        clienteDAO =new ClienteDAO(cnx);
        productoDAO=new ProductoDAO(cnx);
        ventaDAO= new VentaDAO(cnx);
        consultaDAO = new ConsultaDAO(cnx);
    }

    public void agregarCliente(Cliente cli)throws ServicioException
    {
        Cliente bd = clienteDAO.buscar(cli.getRutCliente());
        if (bd==null) {
            //throw new ServicioException("Ya existe Cliente  con el Rut indicado: " + cli.getRutCliente());
            clienteDAO.agregar(cli);
        }
        
    }
    
    public void agregarProducto(Producto prod)throws ServicioException
    {
        productoDAO.agregar(prod);
    }
   
    public void agregarVenta(Venta v,Producto p)
    {
            ventaDAO.ingresarVenta(v, p);
    }
    
    public List<Producto> buscarTodosLosProductos()
    {
        return productoDAO.buscarTodos();
    }
    
    public List<ClienteProductoVentaDTO> buscarTodoClienteProductoVenta()
    {
        return consultaDAO.buscarAllClienteProductoVenta();
    }
    
    
    public List<ProductoVentaDTO> buscarTodoProductoVenta()
    {
        return consultaDAO.buscarAllProductoVenta();
    }
    
    
    public Producto buscarProducto(int cod_producto)
    {
       return  productoDAO.buscar(cod_producto);
        
    }
    
    public List<Cliente> buscarTodosCliente()
    {               
        return clienteDAO.buscarTodos();
    }
    
    public List<Venta> buscarTodasVentas()
    {
        return ventaDAO.buscarVentas();
    }
    public Venta buscarUltimaVenta()
    {
        return ventaDAO.buscarUltima();
    }
}
