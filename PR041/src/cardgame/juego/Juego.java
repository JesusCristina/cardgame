package cardgame.juego;

import cardgame.bd.DAOImpl;
import cardgame.util.Menu;
import cardgame.util.UtilidadesES;


/**
 * Clase contenedora de la mecánica del juego.
 */
public class Juego {
    
    /**
     * Contenedor del menú del juego.
     */
    private Menu menu;
    
    /**
     * Contenedor de las utilidades del juego.
     */
    private UtilidadesES utilidadesES;
    
    /**
     * Contenedor del mazo para jugar.
     */
    private Mazo mazo;
    
    /**
     * Contenedor DAO.
     */
    private DAOImpl daoImpl;
    
    /**
     * Contenedor con la lista de jugadores.
     */
    private ListaJugadores listaJugadores;
    
    /**
     * Contenedor de la lista de partidas.
     */
    private ListaPartidas listaPartidas;
    
    /**
     * Contenedor de la lista de manos.
     */
    private ListaManos listaManos;
    
    /**
     * Método que inicializa el juego.
     */
    public void ejecutar() {
    }
}

