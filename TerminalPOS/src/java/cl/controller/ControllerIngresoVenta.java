/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;

import cl.dominio.Cliente;
import cl.dominio.Producto;
import cl.dominio.Venta;
import cl.servicio.ServicioException;
import cl.servicio.TerminalPosService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jordan
 */
@WebServlet(name = "ControllerIngresoVenta", urlPatterns = {"/ControllerIngresoVenta"})
public class ControllerIngresoVenta extends HttpServlet {

    @Resource(mappedName = "jdbc/puntoventa")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection cnx = ds.getConnection()) {
            TerminalPosService service = new TerminalPosService(cnx);

            Cliente cliente = new Cliente();
            Producto producto = new Producto();
            Venta venta = new Venta();

            request.setAttribute("cliente", cliente);
            request.setAttribute("lsProducto", service.buscarTodosLosProductos());
            request.setAttribute("venta", venta);

            request.getRequestDispatcher("/ingresoVentas.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try (Connection cnx = ds.getConnection()) {
            TerminalPosService service = new TerminalPosService(cnx);
            Cliente cliente = new Cliente();
            Venta venta = new Venta();
            Producto producto = null;
            int rut = 0;
            Map<String, String> mapMensajes = new HashMap<>();
            String mensaje;
            try {
                rut = Integer.parseInt(request.getParameter("rut_cli"));
                //Supongo que aqui podriamos colocar un metodo para validar Ruts.
                if (rut <= 0) {
                    mapMensajes.put("rut_cli", "Tiene que ingresar un Rut ");
                } else {
                    if (validarRut(request.getParameter("rut_cli"))) {
                        cliente.setRutCliente(rut);
                    } else {
                        mapMensajes.put("rut_cli", "Tiene que ingresar un Rut Válido");
                    }

                }
            } catch (NumberFormatException e) {
                mapMensajes.put("rut_cli", "El Rut no es valido: " + request.getParameter("rut_cli"));
            }

            String nombreCli = request.getParameter("nom_cli");
            if (nombreCli.isEmpty()) {
                mapMensajes.put("nom_cli", "Tiene que ingresar nombre de cliente");
            } else {
                cliente.setNombre(nombreCli);
            }

            String strCodProducto = request.getParameter("lsProducto");
            if (strCodProducto.isEmpty()) {
                mapMensajes.put("lsProducto", "Tiene que seleccionar un producto para vender!!");
            } else {
                venta.setCodProducto(Integer.parseInt(strCodProducto));
            }

            int cantidad = Integer.parseInt(request.getParameter("cant_prod"));
            if (cantidad <= 0) {
                mapMensajes.put("cant_prod", "Tiene que ingresar una cantidad valida!!");
            } else {
                venta.setCantProducto(cantidad);
            }

            // Si no encuentra errores registrados trae al producto seleccionado y recoge todos los valores
            // para enviarlos para ingreso a 
            if (mapMensajes.isEmpty()) {
                try {

                    producto = service.buscarProducto(Integer.parseInt(strCodProducto));

                    cliente.setNombre(nombreCli);
                    cliente.setRutCliente(rut);
                    service.agregarCliente(cliente);
                    venta.setRutCliente(cliente.getRutCliente());
                    venta.setCodProducto(producto.getCodProducto());
                    venta.setCantProducto(cantidad);
                    venta.setValorNetoTotal(cantidad * producto.getValorNeto());

                    java.util.Date date = new java.util.Date();
                    Timestamp ts_now = new Timestamp(date.getTime());
                    venta.setFecha(ts_now);

                    //service.agregarCliente(cliente);
                    service.agregarVenta(venta, producto);
                    request.setAttribute("strCodProducto", strCodProducto);
                    request.setAttribute("venta", venta);
                    request.getRequestDispatcher("/ControllerResumenVenta").forward(request, response);
                } catch (ServicioException ex) {
                    mensaje = ex.getMessage();
                }
            }else
            {
              request.setAttribute("mapMensajes", mapMensajes);
              request.setAttribute("lsProducto", service.buscarTodosLosProductos());
              request.setAttribute("cliente", cliente);
              request.setAttribute("venta", venta);
              request.getRequestDispatcher("/ingresoVentas.jsp").forward(request, response);   
            }
             

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

}
