package cardgame.procesos;

import cardgame.bd.DAO;
import cardgame.bd.ErrorSQL;

import cardgame.juego.Jugador;
import cardgame.juego.ListaJugadores;
import cardgame.juego.ListaManos;
import cardgame.juego.ListaPartidas;
import cardgame.juego.Mazo;
import cardgame.util.UtilidadesES;

import java.io.IOException;

import java.sql.SQLException;

/**
 * Clase orientada al procesamiento de las diferentes
 * opciones del juego.
 * @author Jesús Rivero Muñiz
 */
public class ProcesosImpl implements Procesos {
    
    /**
     * Mazo de cartas.
     */
    private Mazo mazo;
    
    /**
     * Contenedor de jugadores.
     */
    private ListaJugadores listaJugadores;
    
    /**
     * Contenedor de partidas.
     */
    private ListaPartidas listaPartidas;
    
    /**
     * Contenedor de manos.
     */
    private ListaManos listaManos;
    
    /**
     * Objeto de utilidad orientado a E/S.
     */
    private UtilidadesES utilidadesES;
    
    /**
     * Bean DAO.
     */
    private DAO dao;
    
    /**
     * Constructor por defecto al que se le proporciona un bean DAO
     * y un objeto de utilidades para E/S.
     * @param dao Bean DAO
     * @param utilidadesES Objeto de utilidades E/S
     */
    public ProcesosImpl(DAO dao, UtilidadesES utilidadesES) {
        this.dao = dao;
        this.utilidadesES = utilidadesES;
        this.listaPartidas = new ListaPartidas();
    }

    /**
     * Método que procesa una opción determinada.
     * @param opcion Opción a procesar
     */
    @Override
    public void procesar(int opcion) throws IOException {
        try{
            switch(opcion) {
                case 1: 
                    crearMazoyBarajar();
                    break;
                case 2: 
                    establecerJugadores();
                    break;
                case 3: 
                    jugar();
                    break;
                case 4: 
                    listarJuegoJugador();
                    break;
                case 5: 
                    eliminarJugador();
                    break;
                case 6: 
                    eliminarJuego();
                    break;
                case 7: 
                    salir();
                    break;
                default:
                    utilidadesES.mostrarln("No existe esa opción.");
            }
        } catch(SQLException e) {
            utilidadesES.mostrarln("Error en la base de datos.");
            if (e.getErrorCode() == ErrorSQL.DUPLICATED_ENTRY_ERR)
                utilidadesES.mostrarln("Error de clave duplicada.");
            else {
                while(e != null) {
                    utilidadesES.mostrarln("Mensaje de error (en inglés): " + e.getMessage());
                    utilidadesES.mostrarln("Código de error: " + e.getErrorCode());
                    e = e.getNextException();
                }
            }
        } catch(ErrorSQL e) {
            utilidadesES.mostrarln("Error en la base de datos.");
            utilidadesES.mostrarln("Mensaje de error: " + e.getMsgError());
            utilidadesES.mostrarln("Código de error: " + e.getCodError());
        }
    }
    
    /**
     * Crea el mazo y lo baraja.
     */
    private void crearMazoyBarajar() throws SQLException {
        crearMazo();
        mazo.barajar();
        listaJugadores = new ListaJugadores();
        listaManos = new ListaManos();
    }
    
    /**
     * Crea un mazo que contiene las cartas almacenadas
     * en la base de datos.
     * @return El mazo con las cartas.
     */
    private void crearMazo() throws SQLException {
        mazo = dao.recuperarMazo();
    }
    
    /**
     * Pregunta cuántos jugadores quiere establecer para el
     * juego de cartas.
     */
    private void establecerJugadores() throws IOException, SQLException, ErrorSQL {
        utilidadesES.mostrarln("¿Cuántos jugadores quieres establecer? (2 o 4)");
        int opcion;
        do {
            opcion = utilidadesES.pideNumero("Jugadores: ");
            if (opcion != 2 || opcion != 4)
                utilidadesES.mostrarln("RECUERDA: Sólo se pueden establecer 2 o 4 jugadores.");
            else
                agregarJugadores(opcion);
        } while (opcion != 2 || opcion != 4);
    }
    
    /**
     * Agrega los jugadores al contenedor de jugadores del juego.
     * @param jugadoresaAgregar Número máximo de jugadores establecido.
     * @throws SQLException
     * @throws ErrorSQL
     */
    private void agregarJugadores(int jugadoresaAgregar) throws SQLException, ErrorSQL {
        for (int i = 1; i <= jugadoresaAgregar; i++) {
            // Se pedirá el nombre del jugador y se transformará a minúsculas.
            String nombre = utilidadesES.pideCadena("Nombre del jugador: ").toLowerCase();
            if (utilidadesES.esUnNumero(nombre)) {
                utilidadesES.mostrarln("Un nombre no puede estar formado sólo por números.");
                i--;
            } else if (utilidadesES.contieneNumero(nombre)) {
                utilidadesES.mostrarln("Un nombre sólo puede estar formado por letras.");
                i--;
            } else {
                Jugador jugador = new Jugador(nombre);
                listaJugadores.agregarJugador(jugador);
                /*
                 * Sólo inserta el jugador en la base de datos si se ha
                 * agregado al contenedor de jugadores y si no existe ya
                 * en la base de datos.
                 */
                if (listaJugadores.contiene(jugador) && !dao.existeJugador(nombre))
                    dao.insertarJugadores(jugador);
                // Si el jugador ya ha jugado antes, muestra un mensaje de bienvenida.
                if (dao.existeJugador(nombre))
                    utilidadesES.mostrarln("Hola, " + nombre + " bienvenid@ de nuevo.");
            }
        }
    }

    private void jugar() {
        
    }

    private void listarJuegoJugador() {
        
    }
    
    private void eliminarJugador() {
        
    }

    private void eliminarJuego() {
        
    }

    private void salir() throws SQLException {
        utilidadesES.mostrarln("Has decidido salir del juego, las partidas se guardarán.");
        dao.insertarPartidas(listaPartidas);
    }
}
