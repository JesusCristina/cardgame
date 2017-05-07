package cardgame.juego;

import java.util.ArrayList;

/**
 * Encapsula el concepto de jugador en el juego.
 * @author Cristina Polo S�nchez.
 */
public class Jugador {
    private String nombre;
    private Mano mano;
    
    
    /**
     * Constructor por defecto de la clase jugador que inicializa un 
     * contenedor de jugadores.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la definici�n del jugador; los jugadores se distinguen entre s� por el
     * nombre.
     * @return La definici�n del jugador (nombre).
     */    
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
        mano = new Mano();
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
    
    public Mazo dejarCartasMano(Mazo mazo) {
        Carta carta;
        while (mano.getCartas().hasNext()) {
            carta = mano.getCartas().next();
            mazo.agregarCarta(carta);
        }
        this.mano = null;
        return mazo;
    }
}


