package cardgame.juego;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase contenedora que guarda una lista de partidas.
 * @author Cristina Polo S�nchez
 */
public class ListaPartidas {
    private LinkedList<Partida> listaPartidas;
    
    /**
     * Contenedor interno de esta clase en el que se almacena una lista de 
     * partidas.
     */
    public ListaPartidas () {
        listaPartidas = new LinkedList<Partida>();
    }
    
    /**
     * M�todo que sirve para agregar una nueva partida a la lista.
     * @param jugador A�ade una partida.
     */
    public void agregarPartida (Partida partida) {
        listaPartidas.add(partida);
    }
    
    /**
     * M�todo que sirve para mostrar partidas.
     * @param posicion Posici�n en la que se encuentra la partida en la lista.
     * @return Devuelve la partida.
     */
    public Partida damePartida(int posicion) {
        Partida partida = listaPartidas.get(posicion);
        return partida;
    }  
    
    
    /**
     * Se elimina una partida de la lista. Cada partida se diferencia de las
     * dem�s por la posici�n que ocupa en la lista.
     * @param posicion Posici�n (expresada en un n�mero entero) de una partida
     * en concreto de la lista de partidas.
     */
    public void eliminaPartida(int posicion) {
        listaPartidas.remove (posicion);
    }   
    
    
    /**
     * Proporciona informaci�n sobre el tama�o de la lista de partidas.
     * @return Devuelve, en n�meros enteros, el tama�o de la lista de 
     * partidas.
     */
    public int size() {
        return listaPartidas.size();
    }

    public LinkedList<Partida> getListaPartidas() {
        return listaPartidas;
    }
}
