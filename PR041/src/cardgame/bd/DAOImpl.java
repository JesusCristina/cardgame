package cardgame.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Implementación de la interfaz DAO.
 * @author Jesús Rivero Muñiz
 */
public class DAOImpl implements DAO {
    
    /**
     * Contiene el nombre de la clase Driver.
     */
    private String driver = "com.mysql.jdbc.Driver";

    /**
     * URL base para el acceso a la base de datos.
     */
    private String urlBase = "jdbc:mysql://localhost:3306/";

    /**
     * Nombre de la base datos.
     */
    private String baseDatos = null;

    /**
     * Nombre del usuario con el que se accederá a la base de datos.
     */
    private String usuario = null;

    /**
     * Clave de usuario.
     */
    private String clave = null;

    /**
     * Representa una conexi�n a la base de datos.
     */
    private Connection conexion = null;
    
    /**
     * Construye un bean de DAO a partir de driver, url base, 
     * base de datos, nombre de usuario y clave.
     */
    public DAOImpl(String driver, String urlBase, String baseDatos, String usuario, String clave) {
            this.driver = driver;
            this.urlBase = urlBase;
            this.baseDatos = baseDatos;
            this.usuario = usuario;
            this.clave = clave;
    }
    
    /**
     * Construye un bean de DAO a partir de url base, 
     * base de datos, nombre de usuario y clave.
     */
    public DAOImpl(String urlBase, String baseDatos, String usuario, String clave){
            this.urlBase = urlBase;
            this.baseDatos = baseDatos;
            this.usuario = usuario;
            this.clave = clave;
    }
                            
    /**
     * Construye un bean de DAO a partir de  
     * base de datos, nombre de usuario y clave.
     */
    public DAOImpl(String baseDatos, String usuario, String clave){
            this.baseDatos = baseDatos;
            this.usuario = usuario;
            this.clave = clave;
    }
    
    /**
     * Abre una conexión con la base de datos.
     * @return Devuelve la conexión.
     * @throws SQLException
     */
    public Connection getConexion() throws SQLException {
        if (conexion == null)
            conexion = DriverManager.getConnection(urlBase + baseDatos, usuario, clave);
        return conexion;
    }

    /**
     * Cierra la conexión con la base de datos.
     * @throws SQLException
     */
    public void closeConexion() throws SQLException {
        if (conexion != null) {
            conexion.close();
            conexion = null;
        }
    }
}
