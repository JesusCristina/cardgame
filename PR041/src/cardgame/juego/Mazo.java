package cardgame.juego;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Encapsula el concepto de mazo en el juego.
 * @author Cristina Polo S�nchez
 */
public class Mazo {
    private ArrayList<Carta> listaCartas;
    
    /**
     * Constructor por defecto de la clase mazo que inicializa un 
     * contenedor de cartas.
     */
    public Mazo() {
        listaCartas = new ArrayList<Carta>();
    }
    
    /**
     * A�ade cartas al mazo.
     * @param carta Carta a a�adir.
     */
    public void agregarCarta (Carta carta){
        listaCartas.add(carta);
    }
    
    /**
     * Devuelve una carta del contenedor.
     * @param posicion Posici�n de la carta a devolver.
     * @return Carta devuelta.
     */
    public Carta dameCarta(int posicion) {
        Carta carta = listaCartas.get(posicion);
        return carta;
    }
    
    /**
     * Devuelve la �ltia carta a�adida al mazo.
     * @return
     */
    public Carta dameLaUltimaCarta () {
        Carta carta = listaCartas.get(listaCartas.size() -1);
        listaCartas.remove(listaCartas.size() -1);
        return carta;
    }
    
    /**
     * Elimina una carta del contenedor.
     * @param posicion Posici�n de la carta a eliminar.
     */
    public void eliminaCarta(int posicion) {
        listaCartas.remove(posicion);        
    }
    
    
    /**
     * Muestra el tama�o del mazo.
     * @return Tama�o del mazo.
     */
    public int size() {
        return listaCartas.size();
    }

    /**
     * Baraja las cartas del mazo.
     */
    public void barajar() {
        Collections.shuffle(listaCartas);
    }
}
