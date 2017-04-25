package cardgame.juego;

import java.util.ArrayList;

//TODO DocumentaciÃ³n e implementaciÃ³n
/*
 * Esta clase tendrÃ¡ un contenedor de cartas. TendrÃ¡n que desarrollarse
 * los mÃ©todos bÃ¡sicos para trabajar con el contenedor.
 */

/**
 * Encapsula el concepto de mazo en el juego.
 * @author Cristina Polo Sánchez
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
     * Añade cartas al mazo.
     * @param carta Carta a añadir.
     */
    public void agregarCarta (Carta carta){
        listaCartas.add(carta);
    }
    
    /**
     * Devuelve una carta del contenedor.
     * @param posicion Posición de la carta a devolver.
     * @return Carta devuelta.
     */
    public Carta dameCarta(int posicion) {
        Carta carta = listaCartas.get(posicion);
        return carta;
    }
    
    /**
     * Elimina una carta del contenedor.
     * @param posicion Posición de la carta a eliminar.
     * ¿¿¿LE METO UN RETURN A ESTO????
     */
    public void eilminaCarta(int posicion) {
        listaCartas.remove(posicion);        
    }
    
    
    /**
     * Muestra el tamaño del mazo.
     * @return Tamaño del mazo.
     */
    public int size() {
        return listaCartas.size();
    }
    
}