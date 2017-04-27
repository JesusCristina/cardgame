package cardgame.juego;

import java.util.Iterator;
import java.util.LinkedList;

public class Mano {
    
    /**
     * Encapsula las manos de cartas del juego.
     * Una mano es un conjunto de 5 cartas.
     * @author Cristina Polo S�nchez.
     */
    private LinkedList<Carta> cartas;

    /**
     * Devuelve las cartas de la mano.
     * @return Las cartas de la mano.
     */
    public Iterator<Carta> getCartas() {
        return cartas.iterator();
    }
}
