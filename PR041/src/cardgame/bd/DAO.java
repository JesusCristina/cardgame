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
     * @throws SQLException
     */
    public Mazo recuperarMazo() throws SQLException;
    
    
    /**
     * Recupera todos los jugadores que hay registrados en la base de datos.
     * @return Devuelve un contenedor con los jugadores registrados.
     * @throws SQLException
     */
    public ListaJugadores recuperarJugadores() throws SQLException;
    
    
     /**
      * Consulta si existe un jugador de la base de datos.
      * @param nombre Nombre del jugador.
      * @return Devuelve un objeto jugador si existe, null si no existe.
      * @throws SQLException
      */
    public Jugador existeJugador(String nombre) throws SQLException, ErrorSQL;

    /**
     * Consulta todas las partidas almacenadas en la base de datos.
     * @return Devuelve un contenedor con las partidas.
     * @throws SQLException
     */
    public ListaPartidas consultarPartidas() throws SQLException;
    
    /**
     * Recupera una partida de la base de datos.
     * @param numPartida Número de partida.
     * @return Devuelve un objeto partida con los datos almacenados.
     * @throws SQLException
     */
    public Partida recuperarPartida(int numPartida) throws SQLException;
    
    /**
     * Inserta una lista de partidas en la base de datos.
     * @param listaPartidas Contenedor con las partidas.
     * @return Devuelve el número de registros insertados.
     * @throws SQLException
     */
    public int insertarPartidas(ListaPartidas listaPartidas) throws SQLException;
    
    /**
     * Inserta una partida en la base de datos.
     * @param partida Partida a almacenar.
     * @return Devuelve 1 si se ha insertado, 0 si no se ha podido insertar.
     * @throws SQLException
     */
    public int insertarPartidas(Partida partida) throws SQLException;
    
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
      * Inserta una mano en la base de datos.
      * @param mano Mano a insertar.
      * @return Devuelve 1 si se ha insertado, 0 si no se ha podido insertar.
      * @throws SQLException
      */
    public int insertarManos(Mano mano) throws SQLException, ErrorSQL;
    
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
