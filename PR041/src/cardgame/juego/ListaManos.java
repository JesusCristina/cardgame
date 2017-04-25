package cardgame.juego;

import cardgame.util.Menu;
import cardgame.util.OpcionesMenu;
import cardgame.util.UtilidadesES;

import java.util.ArrayList;

//TODO Documentación e implementación
/*
 * Esta clase tendrá un contenedor de manos. Tendrán que desarrollarse
 * los métodos básicos para trabajar con el contenedor.
 */

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
     * Contenedor de manos, que es con la que trabajar�an el resto de 
     * clases. 
     * @param posicion
     * @return
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
    
    
}

