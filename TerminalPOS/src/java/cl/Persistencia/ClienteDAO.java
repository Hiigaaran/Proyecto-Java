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
     public void agregar()
     {
         
     }
    
    
}
