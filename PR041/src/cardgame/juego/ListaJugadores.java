package cardgame.juego;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase contenedora que guarda una lista de jugadores.
 * @author Cristina Polo Sánchez.
 */
public class ListaJugadores{
    private LinkedList<Jugador> listaJugadores;
    
    
    /**
     * Contenedor interno de esta clase en el que se almacena una lista de 
     * jugadores. El resto de clases trabajarán con "jugador", no directa_
     * mente con este contenedor.
     */
    public ListaJugadores () {
        listaJugadores = new LinkedList<Jugador>();
    }
    
    
    /**
     * Iterador que devuelve los jugadores de la lista.
     * @return Los jugadores de la lista.
     */
    public Iterator<Jugador> getJugadores() {
        return listaJugadores.iterator();
    }
    
    
    
    /**
     * Método que sirve para agregar un nuevo jugador a la lista.
     * @param jugador Añade un jugador.
     */
    public void agregarJugador (Jugador jugador) {
        listaJugadores.add(jugador);
    }
    
    /**
     * Método que sirve para mostrar jugadores.
     * @param posicion Posición en la que se encuentra el jugador en la lista.
     * @return Devuelve el jugador.
     */
    public Jugador dameJugador(int posicion) {
        Jugador jugador = listaJugadores.get(posicion);
        return jugador;
    }  
    
    
    /**
     * Se elimina un jugador de la lista. Cada jugador se diferencia de los
     * demás por la posición que ocupa en la lista.
     * @param posicion Posición (expresada en un número entero) de un jugador
     * en concreto de la lista de jugadores.
     */
    public void eliminaJugador(int posicion) {
        listaJugadores.remove (posicion);
    }   
    
    
    /**
     * Proporciona información sobre el tamaño de la lista de jugadores.
     * @return Devuelve, en números enteros, el tamaño de la lista de 
     * jugadores.
     */
    public int size() {
        return listaJugadores.size();
    }
}