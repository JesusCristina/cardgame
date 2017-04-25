package cardgame.juego;

import java.util.ArrayList;

//TODO Documentación e implementación
/*
 * Esta clase tendrá un contenedor de manos. Tendrán que desarrollarse
 * los métodos básicos para trabajar con el contenedor.
 */

public class ListaManos {
    private ArrayList<Mano> listaManos;
    
    public ListaManos() {
        listaManos = new ArrayList<Mano>();  
    }       
    
    public void agregarMano (Mano mano){
        listaManos.add(mano);
    }
    
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

