package cardgame.juego;

import java.util.LinkedList;

//TODO Documentación e implementación
/*
 * En la clase partida se almacenarán los datos de una partida en
 * concreto. Ej.: numPartida = 1; jugadores = Pepe y Juan; mano =
 * Manos de cada jugador.
 */
public class Partida {
    private int numPartida;
    private LinkedList<Jugador> jugadores;
    private LinkedList<Mano> resultado;
    
    
    public Partida (int numPartida, LinkedList<Jugador> jugadores, LinkedList<Mano> resultado) {
    this.numPartida = numPartida;
    this.jugadores = jugadores;
    this.resultado = resultado;
    
    
    
    }
    
}