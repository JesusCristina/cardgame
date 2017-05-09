package cardgame.juego;

import cardgame.bd.DAO;
import cardgame.bd.DAOImpl;
import cardgame.procesos.Procesos;
import cardgame.procesos.ProcesosImpl;
import cardgame.util.Menu;
import cardgame.util.UtilidadesES;
import java.io.IOException;

/**
 * Clase que ejecuta el juego.
 * @author Cristina Polo Sánchez
 */
public class Juego {
    
    /**
     * Menú del juego.
     */
    private Menu menu;
    
    /**
     * Ofrece utilidad de E/S.
     */
    private UtilidadesES utilidadesES;
    
    /**
     * Bean DAO.
     */
    private DAO dao;
    
    /**
     * Objeto que procesa las opciones del menú del juego.
     */
    private Procesos procesos;
    
    /**
     * Constructor por defecto de la clase Juego que crea
     * un objeto de utilidad para entrada y salida, un
     * objeto orientado aprocesos y un bean DAO para el
     * acceso a base de datos.
     */
    public Juego() {
        // Se utiliza el mismo objeto de utilidad para toda la aplicación.
        utilidadesES = UtilidadesES.getUtilidadesES();
        // Menú del juego inicializado con la técnica de double bracing.
        menu = new Menu(utilidadesES){{
            agregarOpcion("Crear mazo y barajar.");
            agregarOpcion("Establecer número de jugadores (2 o 4).");
            agregarOpcion("Jugar.");
            agregarOpcion("Listar por juego y jugador.");
            agregarOpcion("Eliminar jugador.");
            agregarOpcion("Eliminar juego.");
            agregarOpcion("Salir.");
        }};
        /*
         * Crea un objeto DAO al que se le proporciona la base de datos,
         * el nombre de usuario y su contraseña.
         */
        dao = new DAOImpl("cardgame", "cardgame", "cardgame");
        procesos = new ProcesosImpl(dao, utilidadesES);
    }
    
    /**
     * Muestra el menú del juego y procesa una opción elegida.
     */
    public void ejecutar() {
        int opcion = -1;
        try {
            do {
                menu.mostrarMenu("Bienvenid@ a cardgame");
                opcion = utilidadesES.pideNumero("Elija una opción: ");
                procesos.procesar(opcion);
            }
            while (opcion != 7);
        } catch(IOException e) {
            utilidadesES.mostrarln("Error de E/S.");
        }
    }
}

