package cardgame.juego;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase contenedora que guarda una lista de partidas.
 * @author Cristina Polo Sánchez
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
     * Iterador que devuelve las partidas de la lista.
     * @return Los partidas de la lista.
     */
    public Iterator<Partida> getPartidas() {
        return listaPartidas.iterator();
    }
    
    
    
    /**
     * Método que sirve para agregar una nueva partida a la lista.
     * @param jugador Añade una partida.
     */
    public void agregarPartida (Partida partida) {
        listaPartidas.add(partida);
    }
    
    /**
     * Método que sirve para mostrar partidas.
     * @param posicion Posición en la que se encuentra la partida en la lista.
     * @return Devuelve la partida.
     */
    public Partida damePartida(int posicion) {
        Partida partida = listaPartidas.get(posicion);
        return partida;
    }  
    
    
    /**
     * Se elimina una partida de la lista. Cada partida se diferencia de las
     * demás por la posición que ocupa en la lista.
     * @param posicion Posición (expresada en un número entero) de una partida
     * en concreto de la lista de partidas.
     */
    public void eliminaPartida(int posicion) {
        listaPartidas.remove (posicion);
    }   
    
    
    /**
     * Proporciona información sobre el tamaño de la lista de partidas.
     * @return Devuelve, en números enteros, el tamaño de la lista de 
     * partidas.
     */
    public int size() {
        return listaPartidas.size();
    }    

}
