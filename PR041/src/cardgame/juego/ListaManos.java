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
public class ListaManos {
    private ArrayList<Mano> listaManos;
    
    /*Contenedor de lista mano*/
    public ListaManos() {
        listaManos = new ArrayList<Mano>();  
    }       
    
    public void agregarMano (Mano mano){
        listaManos.add(mano);
    }
    
    /*esto es un contenedor de manos*/
    /**
     * 
     * @param posicion
     * @return
     */
    public Mano dameMano(int posicion) {
        Mano mano = listaManos.get(posicion);
        return mano;
    }
    
    public void eilminaMano(int posicion) {
        listaManos.remove(posicion);        
    }
    
    public int size() {
        return listaManos.size();
    }    
    
    
}

