package cardgame.juego;

import java.util.ArrayList;

/**
 * Clase contenedora que guarda una lista de manos.
 * @author Cristina Polo Sánchez.
 */
public class ListaManos {
    private ArrayList<Mano> listaManos;
    
    /**
     * Contenedor interno de esta clase en el que se almacena una
     * lista de manos. El resto de clases trabajarán con "mano", no 
     * directamente con este contenedor.
     */    
    public ListaManos() {
        listaManos = new ArrayList<Mano>();  
    }       
    
    /**
     * Método que sirve para agregar una nueva mano a la lista.
     * @param mano Añade una mano.
     */    
    public void agregarMano (Mano mano){
        listaManos.add(mano);
    }
    
    /**
     * Método que sirve para mostrar manos.
     * @param posicion Posición en la que se encuentra la mano.
     * @return Devuelve la mano.
     */    
    public Mano dameMano(int posicion) {
        Mano mano = listaManos.get(posicion);
        return mano;
    }
    
    /**
     * Se elimina una mano de la lista. Cada mano se diferencia de las 
     * demás por la posición que ocupa en la lista.
     * @param posicion Posición (expresada en un número entero) de una
     * mano en concreto en la lista de manos.
     */    
    public void eilminaMano(int posicion) {
        listaManos.remove(posicion);        
    }
    
    /**
     * Proporciona información sobre el tamaño de la lista de manos.
     * @return Devuelve, en números enteros, el tamaño de la lista de 
     * manos.
     */    
    public int size() {
        return listaManos.size();
    }    
}

