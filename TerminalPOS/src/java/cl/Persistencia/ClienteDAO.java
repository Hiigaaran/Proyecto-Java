package cl.Persistencia;

import cl.dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection cnx;

    public ClienteDAO(Connection cnx) {

        this.cnx = cnx;

    }

    public void agregar(Cliente c) {

        String sql = "insert into cliente "
                + "(rut_cliente,nombre,apellido,direccion,correo)"
                + "values (?,?,?,?,?)";

        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setString(1, c.getRutCliente());
            stmt.setString(2, c.getNombre());
            stmt.setString(3, c.getApellido());
            stmt.setString(4, c.getDireccion());
            stmt.setString(5, c.getCorreo());

        } catch (SQLException ex) {
            throw new RuntimeException("Error al Agregar Cliente");
        }
    }

    public Cliente buscarPorRutCliente(String rutCliente) {

        String sql = "select * from Cliente where rut_cliente = ?";
        Cliente c = null;

        try (PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setString(1, rutCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    c.setRutCliente(rs.getString("rut_cliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellido(rs.getString("apellido"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setCorreo(rs.getString("correo"));
                }

            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al Buscar Peticion");
        }
        return c;
    }

}
