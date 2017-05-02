package cardgame.juego;

import java.util.LinkedList;

/**
 * Clase que encapsula el concepto de partida en el juego.
 * @author Cristina Polo Sánchez.
 */
public class Partida {
    
    /**
     * Número de la partida.
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
     * Método por el que se almacena cada uno de los datos pertinentes para cada partida.
     * @param numPartida El número de partidas.
     * @param jugadores La lista de jugadores.
     * @param resultado El contenedor de manos
     */
    public Partida (int numPartida, LinkedList<Jugador> jugadores, LinkedList<Mano> resultado) {
    this.numPartida = numPartida;
    this.jugadores = jugadores;
    this.resultado = resultado;
    }
    
}
