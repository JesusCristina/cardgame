package cardgame.bd;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz DAO.
 * @author Jesús Rivero Muñiz
 */
public interface DAO {
    /**
     * Conecta con la base de datos.
     * @return Devuelve la conexión.
     * @throws SQLException
     */
    public Connection getConexion() throws SQLException;

    /**
     * Cierra la conexión con la base de datos.
     * @throws SQLException
     */
    public void closeConexion() throws SQLException;
}
