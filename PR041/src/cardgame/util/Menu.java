package cardgame.util;

/**
 * Encapsula un menú que estará disponible para ser mostrado cuando se le
 * añadan opciones.
 * @author Jesús Rivero Muñiz
 */
public class Menu {
    /**
     * Opciones del menú.
     */
    private OpcionesMenu opcionesMenu;
    
    /**
     * Flujo de entrada y salida.
     */
    private UtilidadesES utilidadesES;
    
    /**
     * Constructor por defecto que crea un contenedor de opciones vacío.
     * @param utilidadesES Clase orientada al flujo de entrada/salida.
     */
    public Menu(UtilidadesES utilidadesES) {
        this.opcionesMenu = new OpcionesMenu();
        this.utilidadesES = utilidadesES;
    }
    
    /**
     * Agrega una opción al menú.
     * @param opcion Opción a agregar.
     */
    public void agregarOpcion(String opcion) {
        this.opcionesMenu.add(opcion);
    }
    
    /**
     * Muestra el menú.
     */
    public void mostrarMenu() {
        int indice = 1;
        for (String opcion: opcionesMenu.getOpcionesMenu()) {
            utilidadesES.mostrarln(indice + " " + opcion);
            indice++;
        }
    }
    
    /**
     * Muestra el menú con un mensaje personalizado.
     */
    public void mostrarMenu(String mensaje) {
        int indice = 1;
        utilidadesES.mostrarln(mensaje);
        for (String opcion: opcionesMenu.getOpcionesMenu()) {
            utilidadesES.mostrarln(indice + " - " + opcion);
            indice++;
        }
    }
}
