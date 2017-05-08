package cardgame.juego;

import java.util.LinkedList;

/**
 * Clase que encapsula el concepto de partida en el juego.
 * @author Cristina Polo Sï¿½nchez.
 */
public class Partida {
    
    /**
     * Nï¿½mero de la partida.
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
     * Mï¿½todo por el que se almacena cada uno de los datos pertinentes para cada partida.
     * @param numPartida El nï¿½mero de partidas.
     * @param jugadores La lista de jugadores.
     * @param resultado El contenedor de manos
     */
    public Partida (int numPartida, LinkedList<Jugador> jugadores, LinkedList<Mano> resultado) {
    this.numPartida = numPartida;
    this.jugadores = jugadores;
    this.resultado = resultado;
    }


    /**
     * Método getter de la propiedad NumPartida, que devuelve el número de la partida.
     * @return El número de la partida.
     */

    public int getNumPartida() {
        return numPartida;
    }

    /**
     * Método getter de la propiedad Jugadores, que devuelve el jugador.
     * @return El jugador.
     */
    public LinkedList<Jugador> getJugadores() {
        return jugadores;
    }
    
    /**
     * Método getter de la propiedad Resultado, que devuelve el resultado.
     * @return El resultado.
     */
    public LinkedList<Mano> getResultado() {
        return resultado;
    }
}
