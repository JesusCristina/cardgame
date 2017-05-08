package cardgame.juego;

import java.util.LinkedList;

/**
 * Clase que encapsula el concepto de partida en el juego.
 * @author Cristina Polo S�nchez.
 */
public class Partida {
    
    /**
     * N�mero de la partida.
     */
    private int numPartida;
    
    /**
     * Lista de jugadores.
     */
    private LinkedList<Jugador> jugadores;
    
    /**
     * El contenedor de manos.
     */
    private LinkedList<Mano> resultado;
    
    
    /**
     * M�todo por el que se almacena cada uno de los datos pertinentes para cada partida.
     * @param numPartida El n�mero de partidas.
     * @param jugadores La lista de jugadores.
     * @param resultado El contenedor de manos
     */
    public Partida (int numPartida, LinkedList<Jugador> jugadores, LinkedList<Mano> resultado) {
    this.numPartida = numPartida;
    this.jugadores = jugadores;
    this.resultado = resultado;
    }


    /**
     * M�todo getter de la propiedad NumPartida, que devuelve el n�mero de la partida.
     * @return El n�mero de la partida.
     */

    public int getNumPartida() {
        return numPartida;
    }

    /**
     * M�todo getter de la propiedad Jugadores, que devuelve el jugador.
     * @return El jugador.
     */
    public LinkedList<Jugador> getJugadores() {
        return jugadores;
    }
    
    /**
     * M�todo getter de la propiedad Resultado, que devuelve el resultado.
     * @return El resultado.
     */
    public LinkedList<Mano> getResultado() {
        return resultado;
    }
}
