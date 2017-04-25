package cardgame.juego;

import java.util.ArrayList;

//TODO Documentación e implementación
/*
 * Esta clase tendrá un contenedor de cartas. Tendrán que desarrollarse
 * los métodos básicos para trabajar con el contenedor.
 */

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
     * Elimina una carta del contenedor.
     * @param posicion Posici�n de la carta a eliminar.
     * ���LE METO UN RETURN A ESTO????
     */
    public void eilminaCarta(int posicion) {
        listaCartas.remove(posicion);        
    }
    
    
    /**
     * Muestra el tama�o del mazo.
     * @return Tama�o del mazo.
     */
    public int size() {
        return listaCartas.size();
    }
    
}