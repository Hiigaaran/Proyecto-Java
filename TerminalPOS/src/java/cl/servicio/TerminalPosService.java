/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.servicio;

import cl.Persistencia.ClienteDAO;
import cl.Persistencia.ProductoDAO;
import cl.dominio.Cliente;
import java.sql.Connection;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Simon
 */
public class TerminalPosService {
    private ClienteDAO clienteDAO;
    private ProductoDAO productoDAO;

    public TerminalPosService(Connection cnx) {
        clienteDAO = new ClienteDAO(cnx);
        productoDAO = new ProductoDAO(cnx);
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
    
}
