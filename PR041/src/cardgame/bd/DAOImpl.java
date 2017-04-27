package cardgame.bd;

import cardgame.juego.Carta;
import cardgame.juego.Jugador;
import cardgame.juego.ListaJugadores;
import cardgame.juego.ListaManos;
import cardgame.juego.ListaPartidas;
import cardgame.juego.Mano;
import cardgame.juego.Mazo;
import cardgame.juego.Partida;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    
    /**
     * Recupera todas las cartas de la base de datos y crea un mazo con ellas.
     * @return Devuelve el mazo con las cartas.
     * @throws SQLException
     */
    public Mazo recuperarMazo() throws SQLException {
        Mazo mazo = new Mazo();
        try {
            getConexion();
            String consulta = "SELECT valor, palo FROM CARTAS";
            Statement statement = conexion.createStatement();
            ResultSet registros = statement.executeQuery(consulta);
            while (registros.next()) {
                String palo = registros.getString("palo");
                String valor = registros.getString("valor");
                Carta carta = new Carta(palo, valor);
                mazo.agregarCarta(carta);
            }
        } finally {
            closeConexion();
        }
        return mazo;
    }

    /**
     * Recupera todos los jugadores que hay registrados en la base de datos.
     * @return Devuelve un contenedor con los jugadores registrados.
     * @throws SQLException
     */
    public ListaJugadores recuperarJugadores() throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return null;
    }

    /**
     * Recupera un jugador de la base de datos.
     * @param nombre Nombre del jugador.
     * @return Devuelve un objeto jugador con los datos recuperados.
     * @throws SQLException
     */
    public Jugador recuperarJugador(String nombre) throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return null;
    }

    /**
     * Consulta todas las partidas almacenadas en la base de datos.
     * @return Devuelve un contenedor con las partidas.
     * @throws SQLException
     */
    public ListaPartidas consultarPartidas() throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return null;
    }

    /**
     * Recupera una partida de la base de datos.
     * @param numPartida Número de partida.
     * @return Devuelve un objeto partida con los datos almacenados.
     * @throws SQLException
     */
    public Partida recuperarPartida(int numPartida) throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return null;
    }

    /**
     * Inserta una lista de partidas en la base de datos.
     * @param listaPartidas Contenedor con las partidas.
     * @return Devuelve el número de registros insertados.
     * @throws SQLException
     */
    public int insertarPartidas(ListaPartidas listaPartidas) throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return 0;
    }

    /**
     * Inserta una partida en la base de datos.
     * @param partida Partida a almacenar.
     * @return Devuelve 1 si se ha insertado, 0 si no se ha podido insertar.
     * @throws SQLException
     */
    public int insertarPartidas(Partida partida) throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return 0;
    }

    /**
     * Inserta una lista de jugadores en la base de datos.
     * @param listaJugadores Contenedor con los jugadores.
     * @return Devuelve el número de registros insertados.
     * @throws SQLException
     */
    public int insertarJugadores(ListaJugadores listaJugadores) throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return 0;
    }

    /**
     * Inserta un jugador en la base de datos.
     * @param jugador Jugador a insertar.
     * @return Devuelve 1 si se ha insertado, 0 si no se ha podido insertar.
     * @throws SQLException
     */
    public int insertarJugadores(Jugador jugador) throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return 0;
    }

    /**
     * Inserta una lista de manos en la base de datos.
     * @param listaManos Contenedor con las manos.
     * @return Devuelve el número de registros insertados.
     * @throws SQLException
     * @throws ErrorSQL
     */
    public int insertarManos(ListaManos listaManos) throws SQLException, ErrorSQL {
        int manosInsertadas = 0;
        try {
            getConexion();
            String insert = "INSERT INTO MANO VALUES (?,?)";
            PreparedStatement statement = conexion.prepareStatement(insert);
            while(listaManos.getManos().hasNext()) {
                Mano mano = listaManos.getManos().next();
                statement.setInt(1, ultimaMano() + 1);
                while(mano.getCartas().hasNext()) {
                    Carta carta = mano.getCartas().next();
                    statement.setInt(2, averiguarIdCarta(carta));
                    manosInsertadas += statement.executeUpdate();
                }
                manosInsertadas++;
            }
        } finally {
            closeConexion();
        }
        return manosInsertadas;
    }
    
    /**
     * Devuelve el número de la última mano registrada en la
     * base de datos.
     * @return Numero de la última mano.
     * @throws ErrorSQL Informa de que no se han devuelto datos.
     * @throws SQLException
     */
    private int ultimaMano() throws ErrorSQL, SQLException {
        int ultimaMano = 0;
        String consulta = "SELECT MAX(id_mano) FROM MANOS";
        Statement statement = conexion.createStatement();
        ResultSet registros = statement.executeQuery(consulta);
        if (registros.next())
            ultimaMano = registros.getInt("id_mano");
        else
            throw new ErrorSQL(ErrorSQL.NO_DATA_ERR, "No se han devuelto datos.");
        return ultimaMano;
    }
    
    /**
     * Devuelve el ID en base de datos de una carta a través
     * de su palo y su valor.
     * @param carta Carta proporcionada.
     * @return Devuelve el ID de la carta.
     * @throws ErrorSQL
     * @throws SQLException
     */
    private int averiguarIdCarta(Carta carta) throws ErrorSQL, SQLException {
        int idCarta = 0;
        String palo = carta.getPalo();
        String valor = carta.getValor();
        String consulta = "SELECT id_carta FROM CARTAS" +
            "WHERE palo LIKE " + palo + " AND valor LIKE " + valor;
        Statement statement = conexion.createStatement();
        ResultSet registros = statement.executeQuery(consulta);
        if (registros.next())
            idCarta = registros.getInt("id_carta");
        else
            throw new ErrorSQL(ErrorSQL.NO_DATA_ERR, "No se han devuelto datos.");
        return idCarta;
    }
    
    /**
     * Inserta una mano en la base de datos.
     * @param mano Mano a insertar.
     * @return Devuelve 1 si se ha insertado, 0 si no se ha podido insertar.
     * @throws SQLException
     */
    public int insertarManos(Mano mano) throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return 0;
    }

    /**
     * Elimina un jugador de la base de datos.
     * @param nombre Nombre del jugador.
     * @return Devuelve 1 si se ha eliminado, 0 si no se ha podido eliminar.
     * @throws SQLException
     */
    public int eliminarJugador(String nombre) throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return 0;
    }

    /**
     * Elimina una partida de la base de datos.
     * @param numPartida Número de la partida.
     * @return Devuelve 1 si se ha eliminado, 0 si no se ha podido eliminar.
     * @throws SQLException
     */
    public int eliminarPartida(int numPartida) throws SQLException {
        try {
            getConexion();
            
        } finally {
            closeConexion();
        }
        return 0;
    }
}
