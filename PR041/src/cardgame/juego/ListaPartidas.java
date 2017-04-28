package cardgame.juego;

import java.util.Iterator;
import java.util.LinkedList;

//TODO Documentación e implementación
/*
 * Esta clase tendrá un contenedor de partidas. Tendrán que desarrollarse
 * los métodos básicos para trabajar con el contenedor.
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
     * M�todo que sirve para agregar un nuevo jugador a la lista.
     * @param jugador A�ade un jugador.
     */
    public void agregarPartida (Partida partida) {
        listaPartidas.add(partida);
    }
    
    /**
     * M�todo que sirve para mostrar jugadores.
     * @param posicion Posici�n en la que se encuentra el jugador en la lista.
     * @return Devuelve el jugador.
     */
    public Partida damePartida(int posicion) {
        Partida partida = listaPartidas.get(posicion);
        return partida;
    }  
    
    
    /**
     * Se elimina un jugador de la lista. Cada jugador se diferencia de los
     * dem�s por la posici�n que ocupa en la lista.
     * @param posicion Posici�n (expresada en un n�mero entero) de un jugador
     * en concreto de la lista de jugadores.
     */
    public void eliminaPartida(int posicion) {
        listaPartidas.remove (posicion);
    }   
    
    
    /**
     * Proporciona informaci�n sobre el tama�o de la lista de jugadores.
     * @return Devuelve, en n�meros enteros, el tama�o de la lista de 
     * jugadores.
     */
    public int size() {
        return listaPartidas.size();
    }    

}
