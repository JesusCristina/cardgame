package cardgame.juego;

import java.util.Iterator;
import java.util.LinkedList;

//TODO DocumentaciÃ³n e implementaciÃ³n
/*
 * Esta clase tendrÃ¡ un contenedor de partidas. TendrÃ¡n que desarrollarse
 * los mÃ©todos bÃ¡sicos para trabajar con el contenedor.
 */

/**
 * @author
 */
public class ListaPartidas {
    private LinkedList<Partida> listaPartidas;
    
    public ListaPartidas () {
        listaPartidas = new LinkedList<Partida>();
    }
    
    
    /**
     * Iterador que devuelve los jugadores de la lista.
     * @return Los jugadores de la lista.
     */
    public Iterator<Partida> getPartidas() {
        return listaPartidas.iterator();
    }
    
    
    
    /**
     * Método que sirve para agregar un nuevo jugador a la lista.
     * @param jugador Añade un jugador.
     */
    public void agregarPartida (Partida partida) {
        listaPartidas.add(partida);
    }
    
    /**
     * Método que sirve para mostrar jugadores.
     * @param posicion Posición en la que se encuentra el jugador en la lista.
     * @return Devuelve el jugador.
     */
    public Partida damePartida(int posicion) {
        Partida partida = listaPartidas.get(posicion);
        return partida;
    }  
    
    
    /**
     * Se elimina un jugador de la lista. Cada jugador se diferencia de los
     * demás por la posición que ocupa en la lista.
     * @param posicion Posición (expresada en un número entero) de un jugador
     * en concreto de la lista de jugadores.
     */
    public void eliminaPartida(int posicion) {
        listaPartidas.remove (posicion);
    }   
    
    
    /**
     * Proporciona información sobre el tamaño de la lista de jugadores.
     * @return Devuelve, en números enteros, el tamaño de la lista de 
     * jugadores.
     */
    public int size() {
        return listaPartidas.size();
    }    

}
