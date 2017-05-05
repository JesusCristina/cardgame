package cardgame.juego;

import cardgame.bd.DAO;
import cardgame.bd.DAOImpl;

import cardgame.procesos.Procesos;

import cardgame.procesos.ProcesosImpl;

import cardgame.util.Menu;
import cardgame.util.UtilidadesES;

import java.io.IOException;


/**
 * Clase contenedora de la mec�nica del juego.
 */
public class Juego {
    
    /**
     * Contenedor del men� del juego.
     */
    private Menu menu;
    
    /**
     * Contenedor de las utilidades del juego.
     */
    private UtilidadesES utilidadesES;
    
    /**
     * Bean DAO.
     */
    private DAO dao;
    
    /**
     * Objeto orientado a los procesos del juego.
     */
    private Procesos procesos;
    
    /**
     * Constructor por defecto de la clase Juego que crea
     * objetos de utilidad, procesos y un bean DAO para el
     * acceso a base de datos.
     */
    public Juego() {
        utilidadesES = UtilidadesES.getUtilidadesES();
        menu = new Menu(utilidadesES){{
            agregarOpcion("Crear mazo y barajar.");
            agregarOpcion("Establecer número de jugadores (2 o 4).");
            agregarOpcion("Jugar.");
            agregarOpcion("Listar por juego y jugador.");
            agregarOpcion("Eliminar jugador.");
            agregarOpcion("Eliminar juego.");
            agregarOpcion("Salir.");
        }};
        dao = new DAOImpl("cardgame", "cardgame", "cardgame");
        procesos = new ProcesosImpl(dao, utilidadesES);
    }
    
    /**
     * M�todo que inicializa el juego.
     */
    public void ejecutar() {
        int opcion = -1;
        try {
            menu.mostrarMenu("Bienvenid@ a cardgame");
            do {
                opcion = utilidadesES.pideNumero("Elija una opción: ");
                procesos.procesar(opcion);
            }
            while (opcion != 7);
        } catch(IOException e) {
            utilidadesES.mostrarln("Error de E/S.");
        }
    }
}

