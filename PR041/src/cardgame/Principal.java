package cardgame;

import cardgame.juego.Juego;

/**
 * Main class de la aplicación. Crea y ejecuta el juego.
 */
public class Principal {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.ejecutar();
    }
}
