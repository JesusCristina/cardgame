package cardgame.procesos;

import java.io.IOException;

/**
 * Clase orientada al procesamiento de las diferentes
 * opciones del juego.
 * @author Jesús Rivero Muñiz
 */
public interface Procesos {
    
    /**
     * Método que procesa una opción determinada.
     * @param opcion Opción a procesar
     */
    public void procesar(int opcion) throws IOException;
}
