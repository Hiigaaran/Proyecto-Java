
package cl.Persistencia;

import cl.dominio.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {

    private Connection cnx;

    public VendedorDAO(Connection cnx) {
        this.cnx = cnx;
    }

    
}

