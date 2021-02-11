
package modeloCONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel y Linda
 */
public class Conexion {
    public static Conexion instance;
    private Connection conexion;    // conectar a la base de datos
    //String url="jdbc:postgresql://localhost:5432/proyecto";
    String url="jdbc:postgresql://localhost:5432/svch_data";
    String user="postgres";
    //String pass="admin";
    String pass="123456";
    //String pass="1234567890";
    String driverClass="org.postgresql.Driver";

    private Conexion()throws Exception {
        try{
            Class.forName(this.driverClass);
            conexion = DriverManager.getConnection(this.url,this.user,this.pass);
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.print("error x = "+e.getMessage());
        }
    }
    public synchronized static Conexion saberEstado(){
        if(instance == null){
            try {
                instance = new Conexion();
            } catch (Exception ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }
    public void cerrarConexion()throws Exception{
        instance = null;
    }

    public Connection getConexion() {
        return conexion;
    }
}
