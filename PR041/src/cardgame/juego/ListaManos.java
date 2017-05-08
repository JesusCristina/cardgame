package cardgame.juego;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase contenedora que guarda una lista de manos.
 * @author Cristina Polo S�nchez.
 */
public class ListaManos {
    private ArrayList<Mano> listaManos;
    
    
    /**
     * Contenedor interno de esta clase en el que se almacena una
     * lista de manos. El resto de clases trabajar�n con "mano", no 
     * directamente con este contenedor.
     */    
    public ListaManos() {
        listaManos = new ArrayList<Mano>();  
    }        
    
    /**
     * M�todo que sirve para agregar una nueva mano a la lista.
     * @param mano A�ade una mano.
     */    
    public void agregarMano (Mano mano){
        listaManos.add(mano);
    }
    
    /**
     * M�todo que sirve para mostrar manos.
     * @param posicion Posici�n en la que se encuentra la mano.
     * @return Devuelve la mano.
     */    
    public Mano dameMano(int posicion) {
        Mano mano = listaManos.get(posicion);
        return mano;
    }
    
    /**
     * Se elimina una mano de la lista. Cada mano se diferencia de las 
     * dem�s por la posici�n que ocupa en la lista.
     * @param posicion Posici�n (expresada en un n�mero entero) de una
     * mano en concreto en la lista de manos.
     */    
    public void eilminaMano(int posicion) {
        listaManos.remove(posicion);        
    }
    
    /**
     * Proporciona informaci�n sobre el tama�o de la lista de manos.
     * @return Devuelve, en n�meros enteros, el tama�o de la lista de 
     * manos.
     */    
    public int size() {
        return listaManos.size();
    }

    public ArrayList<Mano> getListaManos() {
        return listaManos;
    }
}

