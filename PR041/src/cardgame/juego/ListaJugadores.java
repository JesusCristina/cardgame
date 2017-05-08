package cardgame.juego;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase contenedora que guarda una lista de jugadores.
 * @author Cristina Polo S�nchez.
 */
public class ListaJugadores{
    private LinkedList<Jugador> listaJugadores;
    
    
    /**
     * Contenedor interno de esta clase en el que se almacena una lista de 
     * jugadores. El resto de clases trabajar�n con "jugador", no directa_
     * mente con este contenedor.
     */
    public ListaJugadores () {
        listaJugadores = new LinkedList<Jugador>();
    }
    
    
    /**
     * M�todo que sirve para agregar un nuevo jugador a la lista.
     * @param jugador A�ade un jugador.
     */
    public void agregarJugador (Jugador jugador) {
        listaJugadores.add(jugador);
    }
    
    /**
     * M�todo que sirve para mostrar jugadores.
     * @param posicion Posici�n en la que se encuentra el jugador en la lista.
     * @return Devuelve el jugador.
     */
    public Jugador dameJugador(int posicion) {
        Jugador jugador = listaJugadores.get(posicion);
        return jugador;
    }  
    
    
    /**
     * Se elimina un jugador de la lista. Cada jugador se diferencia de los
     * dem�s por la posici�n que ocupa en la lista.
     * @param posicion Posici�n (expresada en un n�mero entero) de un jugador
     * en concreto de la lista de jugadores.
     */
    public void eliminaJugador(int posicion) {
        listaJugadores.remove (posicion);
    }   
    
    
    /**
     * Proporciona informaci�n sobre el tama�o de la lista de jugadores.
     * @return Devuelve, en n�meros enteros, el tama�o de la lista de 
     * jugadores.
     */
    public int size() {
        return listaJugadores.size();
    }
    
    /**
     * Informa si el contenedor contiene o no a un jugador.
     * @param jugador Jugador proporcionado.
     * @return Devuelve true si lo contiene, false si no lo contiene.
     */
    public boolean contiene(Jugador jugador) {
        if (listaJugadores.contains(jugador))
            return true;
        else
            return false;
    }

    public LinkedList<Jugador> getListaJugadores() {
        return listaJugadores;
    }
}
