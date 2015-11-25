package cl.Persistencia;

import cl.dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection cnx;

    public ClienteDAO(Connection cnx) {

        this.cnx = cnx;

    }
    
    
    
    
     public void agregar(Cliente cli)
     {
         String sql = "insert into cliente (rut_cliente,nombre)values(?,?)";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setInt(1, cli.getRutCliente());
            stmt.setString(2, cli.getNombre());
            
            int filasAfectadas = stmt.executeUpdate();
        }catch (SQLException ex) {
            throw new RuntimeException("Error al Agregar Cliente", ex);
        }
     }
    
    public Cliente buscar(int rutCli)
    {
        Cliente cli=null;
        String sql = "select * from cliente where rut_cliente  = ?";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setInt(1, rutCli);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cli= new Cliente();
                    cli.setRutCliente(rs.getInt("rut_cliente"));
                    cli.setNombre(rs.getString("nombre"));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al Buscar el Cliente", ex);
        }
        return cli;
        
    }
     
    
    public List<Cliente> buscarTodos()
    {
        List<Cliente> lista =new ArrayList();
        String sql="select * from cliente order by nombre";
        try (PreparedStatement stmt = cnx.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setRutCliente(rs.getInt("rut_cliente"));
                cli.setNombre(rs.getString("nombre"));
                
                
                lista.add(cli);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al Buscar Todos los Clientes", ex);
        }
        return lista;
    }
     
}
