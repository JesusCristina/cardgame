package cardgame.bd;

import cardgame.juego.Jugador;
import cardgame.juego.ListaJugadores;
import cardgame.juego.ListaManos;
import cardgame.juego.ListaPartidas;
import cardgame.juego.Mano;
import cardgame.juego.Mazo;

import cardgame.juego.Partida;

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
    
    /**
     * Recupera todas las cartas de la base de datos y crea un mazo con ellas.
     * @return Devuelve el mazo con las cartas.
     * @throws ErrorSQL
     * @throws SQLException
     */
    public Mazo recuperarMazo() throws SQLException, ErrorSQL;
    
    
    /**
     * Recupera todos los jugadores que hay registrados en la base de datos.
     * @return Devuelve un contenedor con los jugadores registrados.
     * @throws SQLException
     */
    public ListaJugadores recuperarJugadores() throws SQLException;
    
    
      /**
       * Consulta si existe un jugador de la base de datos.
       * @param nombre Nombre del jugador a consultar.
       * @return Devuelve true si existe, false si no existe.
       * @throws SQLException
       */
    public boolean existeJugador(String nombre) throws SQLException;

    /**
     * Recupera el número de la ultima partida insertada en la base
     * de datos.
     * @return Devuelve el número de la última partida insertada,
     * si no se había insertado ninguna antes, devuelve 1, si
     * ha habido algún tipo de error, devuelve 0.
     * @throws SQLException
     */
    public int ultimaPartida() throws SQLException;

     /**
      * Recupera todas las partidas almacenadas en la base de datos.
      * @return Devuelve un contenedor con las partidas recuperadas.
      * @throws SQLException
      */
    public ListaPartidas recuperarPartidas() throws SQLException;
    
    /**
     * Recupera todas las partidas almacenadas en la base de datos de un determinado jugador.
     * @param nombreJug Nombre del jugador
     * @return Devuelve un contenedor con las partidas recuperadas para ese jugador.
     * @throws ErrorSQL
     * @throws SQLException
     */
    public ListaPartidas recuperarPartidas(String nombreJug) throws SQLException, ErrorSQL;
    
    /**
     * Inserta una partida en la base de datos.
     * @param partida Partida a insertar
     * @return Devuelve 1 si se ha podido insertar, 0 si no.
     * @throws ErrorSQL
     * @throws SQLException
     */
    public int insertarPartida(Partida partida) throws SQLException, ErrorSQL;
    
     /**
      * Inserta una lista de jugadores en la base de datos.
      * @param listaJugadores Contenedor con los jugadores.
      * @return Devuelve el número de registros insertados.
      * @throws SQLException
      */
    public int insertarJugadores(ListaJugadores listaJugadores) throws SQLException, ErrorSQL;
    
    /**
     * Inserta un jugador en la base de datos.
     * @param jugador Jugador a insertar.
     * @return Devuelve 1 si se ha insertado, 0 si no se ha podido insertar.
     * @throws SQLException
     */
    public int insertarJugadores(Jugador jugador) throws SQLException, ErrorSQL;
    
     /**
      * Inserta una lista de manos en la base de datos.
      * @param listaManos Contenedor con las manos.
      * @return Devuelve el número de registros insertados.
      * @throws SQLException
      * @throws ErrorSQL
      */
    public int insertarManos(ListaManos listaManos) throws SQLException, ErrorSQL;
    
    /**
     * Elimina un jugador de la base de datos.
     * @param nombre Nombre del jugador.
     * @return Devuelve 1 si se ha eliminado, 0 si no se ha podido eliminar.
     * @throws SQLException
     */
    public int eliminarJugador(String nombre) throws SQLException;
    
    /**
     * Elimina una partida de la base de datos.
     * @param numPartida Número de la partida.
     * @return Devuelve 1 si se ha eliminado, 0 si no se ha podido eliminar.
     * @throws SQLException
     */
    public int eliminarPartida(int numPartida) throws SQLException;
}
