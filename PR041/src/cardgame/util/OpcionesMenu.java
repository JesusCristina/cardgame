package cardgame.util;

import java.util.ArrayList;

/**
 * Encapsula las opciones del menú.
 * @author Jesús Rivero Muñiz
 */
public class OpcionesMenu {
    /**
     * Contenedor de opciones.
     */
    private ArrayList<String> opcionesMenu;
    
    /**
     * Constructor por defecto que crea un nuevo contenedor de opciones.
     */
    public OpcionesMenu() {
        opcionesMenu = new ArrayList<String>();
    }
    
    /**
     * Añade elementos al contenedor.
     * @param opcion Elemento a añadir.
     */
    public void add(String opcion) {
        opcionesMenu.add(opcion);
    }
    
    /**
     * Método getter del contenedor de opciones.
     * @return Devuelve el contenedor de opciones.
     */
    public ArrayList<String> getOpcionesMenu() {
        return opcionesMenu;
    }
}
