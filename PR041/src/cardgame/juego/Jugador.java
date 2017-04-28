package cardgame.juego;

import java.util.ArrayList;

//TODO Documentación e implementación
/*
 * Implementar lo siguiente:
 * - Método toString() con la siguiente sintaxis de ejemplo: "Pepe".
 * - Métodos getter.
 * - Método cogerCarta(Mazo mazo): El jugador cogerá la primera carta
 * del mazo y la almacenará en su mano.
 * - Método cogerCarta(Mazo mazo, int veces): El jugador cogerá tantas
 * cartas del mazo como se especifique.
 * - Método mostrarMano(): El jugador mostrará su mano.
 */

/**
 * Encapsula el concepto de jugador en el juego.
 * @author Cristina Polo S�nchez.
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
     * Devuelve informaci�n sobre la mano, de qu� mano se trata.
     * @return La mano.
     */
    public Mano getMano() {
        return mano;
    }

    /** El jugador coger� la �ltima carta a�adida al mazo (la que est� arriba del todo)
     * y la almacena en su mano.
     * @param mazo El mazo, de donde toma la carta.
     */
    public void cogerCarta (Mazo mazo) {
        Carta carta = mazo.dameLaUltimaCarta();
        mano.agregarCarta(carta);
    }
  
    
    
    /**
     * El jugador coger� tantas cartas del mazo como se especifique.
     * @param veces N�mero de veces que el jugador coger� una carta.
     */    
    public void cogerCarta (Mazo mazo, int veces) {
        for (int i=0; i<= veces; i++) {
                Carta carta = mazo.dameLaUltimaCarta();
                mano.agregarCarta(carta);
            }
    }    
    
    
    /**
     * El jugador mostrar� su mano.
     */
    public void mostrarMano(){
        while (mano.getCartas().hasNext()){
            Carta carta = mano.getCartas().next();
            System.out.println(carta.toString());
            }
    } 
}


