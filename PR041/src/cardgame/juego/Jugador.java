package cardgame.juego;

import java.util.ArrayList;

/**
 * Encapsula el concepto de jugador en el juego.
 * @author Cristina Polo Sánchez.
 */
public class Jugador {
    private String nombre;
    private Mano mano;
    
    
    public String toString() { 
        return nombre;
    }    
    
    /**
     * Devuelve el nombre de un jugador.
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve información sobre la mano, de qué mano se trata.
     * @return La mano.
     */
    public Mano getMano() {
        return mano;
    }

    /** El jugador cogerá la última carta añadida al mazo (la que está arriba del todo)
     * y la almacena en su mano.
     * @param mazo El mazo, de donde toma la carta.
     */
    public void cogerCarta (Mazo mazo) {
        Carta carta = mazo.dameLaUltimaCarta();
        mano.agregarCarta(carta);
    }
  
    
    
    /**
     * El jugador cogerá tantas cartas del mazo como se especifique.
     * @param veces Número de veces que el jugador cogerá una carta.
     */    
    public void cogerCarta (Mazo mazo, int veces) {
        for (int i=0; i<= veces; i++) {
                Carta carta = mazo.dameLaUltimaCarta();
                mano.agregarCarta(carta);
            }
    }    
    
    
    /**
     * El jugador mostrará su mano.
     */
    public void mostrarMano(){
        while (mano.getCartas().hasNext()){
            Carta carta = mano.getCartas().next();
            System.out.println(carta.toString());
            }
    } 
}


