package conexionbasedatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodosDB {

    private final ConexionDB con = new ConexionDB();
    
    public ResultSet consultarTablas(String query) {
        ResultSet datos = null ;
        try {
            Statement sc = con.establecerConexion().createStatement();
            datos= sc.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public ResultSet consultarTablaEspania(String query) {
        ResultSet datos = null ;
        try {
            Statement sc = con.establecerConexionProvincias().createStatement();
            datos= sc.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
   
}
