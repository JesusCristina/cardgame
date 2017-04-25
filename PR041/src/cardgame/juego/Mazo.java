package cardgame.juego;

import java.util.ArrayList;

//TODO Documentación e implementación
/*
 * Esta clase tendrá un contenedor de cartas. Tendrán que desarrollarse
 * los métodos básicos para trabajar con el contenedor.
 */
public class Mazo {
    private ArrayList<Carta> listaCartas;
    
    public Mazo() { /*crear el objeto*/
        listaCartas = new ArrayList<Carta>();
    }
    
    public void agregarCarta (Carta carta){
        listaCartas.add(carta);
    }
    
    public Carta dameCarta(int posicion) {
        Carta carta = listaCartas.get(posicion);
        return null;
    }
    
    public void eilminaCarta(int posicion) {
        listaCartas.remove(posicion);        
    }
    
    public int size() {
        return listaCartas.size();
    }
    
}