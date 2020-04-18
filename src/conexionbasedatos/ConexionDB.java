package conexionbasedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    private final String user = "root";
    private final String pass = "saladino";
    private final String server = "jdbc:mysql://localhost:3306/inventario?serverTimezone=UTC";
    private final String provinciasTab = "jdbc:mysql://localhost:3306/espania?serverTimezone=UTC";
    private Connection conexion;
    
    public Connection establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(server, user, pass);
            System.out.println("Conexion OK!!!");
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR, no se puede conectar a la Data Base.\n" + ex.toString());
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    public Connection establecerConexionProvincias() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(provinciasTab, user, pass);
            System.out.println("Conexion OK España!!!");
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR, no se puede conectar a la Data Base.\n" + ex.toString());
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    public void desconectarConexion(){
        try {
            conexion.close();
            System.out.println("Desconectado DB, OK!!");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
