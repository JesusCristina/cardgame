package cardgame.juego;

import java.util.LinkedList;

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
