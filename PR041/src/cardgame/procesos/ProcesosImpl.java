package cardgame.procesos;

import cardgame.bd.DAO;
import cardgame.bd.ErrorSQL;
import cardgame.juego.Carta;
import cardgame.juego.Jugador;
import cardgame.juego.ListaJugadores;
import cardgame.juego.ListaManos;
import cardgame.juego.ListaPartidas;
import cardgame.juego.Mano;
import cardgame.juego.Mazo;
import cardgame.juego.Partida;
import cardgame.util.UtilidadesES;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Clase orientada al procesamiento de las diferentes
 * opciones del juego.
 * @author Jesús Rivero Muñiz
 */
public class ProcesosImpl implements Procesos {
    
    /**
     * Mazo de cartas.
     */
    private Mazo mazo;
    
    /**
     * Contenedor de jugadores.
     */
    private ListaJugadores listaJugadores;
    
    /**
     * Contenedor de partidas.
     */
    private ListaPartidas listaPartidas;
    
    /**
     * Contenedor de manos.
     */
    private ListaManos listaManos;
    
    /**
     * Objeto de utilidad orientado a E/S.
     */
    private UtilidadesES utilidadesES;
    
    /**
     * Bean DAO.
     */
    private DAO dao;
    
    /**
     * Constructor por defecto al que se le proporciona un bean DAO
     * y un objeto de utilidades para E/S.
     * @param dao Bean DAO
     * @param utilidadesES Objeto de utilidades E/S
     */
    public ProcesosImpl(DAO dao, UtilidadesES utilidadesES) {
        this.dao = dao;
        this.utilidadesES = utilidadesES;
        this.listaPartidas = new ListaPartidas();
    }

    /**
     * Método que procesa una opción determinada.
     * @param opcion Opción a procesar.
     * @throws IOException
     */
    @Override
    public void procesar(int opcion) throws IOException {
        try{
            switch(opcion) {
                case 1: 
                    crearMazoyBarajar();
                    break;
                case 2: 
                    establecerJugadores();
                    break;
                case 3: 
                    if (mazo == null) {
                        utilidadesES.mostrarln("No se puede jugar sin un mazo.");
                    } else if (listaJugadores == null) {
                        utilidadesES.mostrarln("No se puede jugar sin jugadores.");
                    } else
                        jugar();
                    break;
                case 4: 
                    listarJuegoJugador();
                    break;
                case 5: 
                    eliminarJugador();
                    break;
                case 6: 
                    eliminarJuego();
                    break;
                case 7: 
                    salir();
                    break;
                default:
                    utilidadesES.mostrarln("No existe esa opción.");
            }
        } catch(SQLException e) {
            utilidadesES.mostrarln("Error en la base de datos.");
            if (e.getErrorCode() == ErrorSQL.DUPLICATED_ENTRY_ERR)
                utilidadesES.mostrarln("Error de clave duplicada.");
            else {
                while(e != null) {
                    utilidadesES.mostrarln("Mensaje de error (en inglés): " + e.getMessage());
                    utilidadesES.mostrarln("Código de error: " + e.getErrorCode());
                    e = e.getNextException();
                }
            }
        } catch(ErrorSQL e) {
            utilidadesES.mostrarln("Error en la base de datos.");
            utilidadesES.mostrarln("Mensaje de error: " + e.getMsgError());
            utilidadesES.mostrarln("Código de error: " + e.getCodError());
        }
    }
    
    /**
     * Crea el mazo y lo baraja.
     * @throws SQLException
     */
    private void crearMazoyBarajar() throws SQLException {
        try {
            crearMazo();
            mazo.barajar();
            /*
             * Cada vez que se crea un mazo y se baraja, se entiende que
             * empieza otra partida, por tanto, se vuelve a inicializar el
             * contenedor de manos.
             */
            listaManos = new ListaManos();
        } catch (ErrorSQL e) {
            utilidadesES.mostrarln("No se ha podido crear el mazo porque no hay cartas en la base de datos.");
        }
    }
    
    /**
     * Crea un mazo que contiene las cartas almacenadas
     * en la base de datos.
     * @return El mazo con las cartas.
     * @throws ErrorSQL
     * @throws SQLException
     */
    private void crearMazo() throws SQLException, ErrorSQL {
        mazo = dao.recuperarMazo();
        if (mazo.size() != 0) {
            utilidadesES.mostrarln("Se ha creado el mazo correctamente.");
        }
    }
    
    /**
     * Pregunta cuántos jugadores se quieren establecer para el
     * juego de cartas.
     * @throws IOException
     * @throws ErrorSQL
     * @throws SQLException
     */
    private void establecerJugadores() throws IOException, SQLException, ErrorSQL {
        utilidadesES.mostrarln("¿Cuántos jugadores quieres establecer? (2 o 4)");
        /*
         * Cada vez que se establecen los jugadores en el juego, se
         * vuelve a incializar el contenedor de jugadores.
         */
        listaJugadores = new ListaJugadores();
        int opcion;
        do {
            opcion = utilidadesES.pideNumero("Jugadores: ");
            if (opcion == 2 || opcion == 4)
                agregarJugadores(opcion);
            else
                utilidadesES.mostrarln("RECUERDA: Sólo se pueden establecer 2 o 4 jugadores.");
        } while (opcion != 2 && opcion != 4);
    }
    
    /**
     * Agrega los jugadores al contenedor de jugadores del juego.
     * @param jugadoresaAgregar Número máximo de jugadores establecido.
     * @throws ErrorSQL
     * @throws SQLException
     */
    private void agregarJugadores(int jugadoresaAgregar) throws SQLException, ErrorSQL {
        try {
            /*
             * Agrega jugadores al contenedor mientras no se exceda el
             * número de jugadores establecido.
             */
            for (int i = 1; i <= jugadoresaAgregar; i++) {
                // Se pedirá el nombre del jugador y se transformará a minúsculas.
                String nombre = utilidadesES.pideCadena("Nombre del jugador: ").toLowerCase();
                if (utilidadesES.esUnNumero(nombre)) {
                    utilidadesES.mostrarln("Un nombre no puede estar formado sólo por números.");
                    // Controla que i no aumente y termine el bucle.
                    i--;
                } else if (utilidadesES.contieneNumero(nombre)) {
                    utilidadesES.mostrarln("Un nombre sólo puede estar formado por letras.");
                    // Controla que i no aumente y termine el bucle.
                    i--;
                } else {
                    Jugador jugador = new Jugador(nombre);
                    listaJugadores.agregarJugador(jugador);
                    // Si el jugador ya ha jugado antes, muestra un mensaje de bienvenida.
                    if (dao.existeJugador(nombre))
                        utilidadesES.mostrarln("Hola " + nombre + ", bienvenid@ de nuevo.");
                    /*
                     * Sólo inserta el jugador en la base de datos si se ha
                     * agregado al contenedor de jugadores y si no existe ya
                     * en la base de datos.
                     */
                    if (listaJugadores.contiene(jugador) && !dao.existeJugador(nombre)){
                        if (dao.insertarJugadores(jugador) != 0)
                            utilidadesES.mostrarln("Se ha insertado a " + nombre + " correctamente.");
                        else
                            utilidadesES.mostrarln("No se ha podido insertar el jugador.");
                    }
                }
            }
        } catch (NullPointerException e) {
            utilidadesES.mostrarln("No has introducido un nombre.");
        }
    }
    
    /**
     * Los jugadores cogen cartas del mazo, las guardan en sus manos
     * y muestran las cartas obtenidas. Cuando se termina de jugar,
     * se almacenan los resultados en la base de datos.
     * @throws SQLException
     * @throws ErrorSQL
     */
    private void jugar() throws SQLException, ErrorSQL {
        for (Jugador jugador: listaJugadores.getListaJugadores()) {
            utilidadesES.mostrarln("El jugador " + jugador.getNombre() + " ha obtenido los siguientes resultados:");
            if (listaJugadores.size() == 2) {
                for (int i = 1; i <= 5; i++) {
                    jugador.cogerCarta(mazo, 5);
                    jugador.getMano().setPropietario(jugador.getNombre());
                    utilidadesES.mostrarln("Mano nº: " + i);
                    jugador.mostrarMano();
                    listaManos.agregarMano(jugador.getMano());
                    mazo = jugador.dejarCartasMano(mazo);
                    mazo.barajar();
                }
            }
            else if (listaJugadores.size() == 4) {
                for (int i = 1; i <= 2; i++) {
                    jugador.cogerCarta(mazo, 5);
                    jugador.getMano().setPropietario(jugador.getNombre());
                    utilidadesES.mostrarln("Mano nº: " + i);
                    jugador.mostrarMano();
                    listaManos.agregarMano(jugador.getMano());
                    mazo = jugador.dejarCartasMano(mazo);
                    mazo.barajar();
                }
            }
        }
        terminarPartida();
    }
    
    /**
     * Lista las manos obtenidas por un jugador en cada partida que ha jugado.
     * @throws SQLException
     * @throws ErrorSQL
     */
    private void listarJuegoJugador() throws SQLException, ErrorSQL {
        String nombre = utilidadesES.pideCadena("Nombre del jugador a consultar: ").toLowerCase();
        ListaPartidas partidasJugador = dao.recuperarPartidas(nombre);
        if (partidasJugador.getListaPartidas().get(0).getNumPartida() != 0) {
            for (Partida partida : partidasJugador.getListaPartidas()) {
                utilidadesES.mostrarln("Manos obtenidas en la partida número " + partida.getNumPartida());
                int numMano = 1;
                for (Mano mano : partida.getResultado()) {
                    utilidadesES.mostrarln("Mano nº " + numMano);
                    for (Carta carta : mano.getCartas())
                        utilidadesES.mostrarln(carta.toString());
                    numMano++;
                }
            }
        } else
            utilidadesES.mostrarln("Ese jugador no ha jugado todavía.");
    }
    
    /**
     * Elimina las manos de un jugador en la base de datos.
     * @throws SQLException
     */
    private void eliminarJugador() throws SQLException {
        String nombre = utilidadesES.pideCadena("Nombre del jugador del que eliminar las manos: ").toLowerCase();
        int manosBorradas = dao.eliminarJugador(nombre);
        if (manosBorradas != 0) {
            utilidadesES.mostrarln("Se han eliminado " + manosBorradas + " manos");
        } else 
            utilidadesES.mostrarln("No se ha podido borrar las manos de ese jugador.");
    }
    
    /**
     * Elimina una los datos de una partida determinada
     * @throws SQLException
     * @throws IOException
     */
    private void eliminarJuego() throws SQLException, IOException {
        int numPartida = utilidadesES.pideNumero("Partida a eliminar: ");
        int manosBorradas = dao.eliminarPartida(numPartida);
        if (manosBorradas != 0) {
            utilidadesES.mostrarln("Se han eliminado " + manosBorradas + " manos de la partida nº: " + numPartida);
        } else 
            utilidadesES.mostrarln("No se ha podido borrar esa partida.");
    }
    
    /**
     * Informa al usuario que va a salir del juego.
     */
    private void salir() {
        utilidadesES.mostrarln("Has decidido salir del juego.");
    }

    /**
     * Agrega los jugadores que han jugado una partida en concreto a un contenedor.
     * @return Devuelve el contenedor con los jugadores de la partida.
     */
    private LinkedList<Jugador> agregarJugadoresPartida() {
        LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
        for (Jugador jugador: listaJugadores.getListaJugadores())
            jugadores.add(jugador);
        return jugadores;
    }

    /**
     * Agrega las manos que han salido en una partida a un contenedor de resultados.
     * @return Devuelve el contenedor con los resultados de la partida.
     */
    private LinkedList<Mano> agregarResultadoPartida() {
        LinkedList<Mano> resultado = new LinkedList<Mano>();
        for (Mano mano: listaManos.getListaManos())
            resultado.add(mano);
        listaManos = new ListaManos();
        return resultado;
    }
    
    /**
     * Termina la partida, insertando los resultados obtenidos en la base de datos.
     * @throws SQLException
     * @throws ErrorSQL
     */
    private void terminarPartida() throws SQLException, ErrorSQL {
        Partida partida;
        int manosInsertadas = dao.insertarManos(listaManos);
        if (manosInsertadas != 0) {
            manosInsertadas = manosInsertadas / listaJugadores.size();
            utilidadesES.mostrarln("Se han insertado " + manosInsertadas + " manos en la base de datos.");
        } else 
            utilidadesES.mostrarln("No se han podido insertar las manos de esta partida.");
        LinkedList<Jugador> jugadores = agregarJugadoresPartida();
        LinkedList<Mano> resultado = agregarResultadoPartida();
        if (jugadores != null && resultado != null) {
            int numPartida = dao.ultimaPartida() + 1;
            partida = new Partida(numPartida, jugadores, resultado);
            utilidadesES.mostrarln("Finalizada la partida nº " + numPartida + ".");
            int partidaInsertada = dao.insertarPartida(partida);
            if (partidaInsertada != 0)
                utilidadesES.mostrarln("Se ha insertado la partida en la base de datos.");
            else
                utilidadesES.mostrarln("No se ha podido insertar ninguna partida.");
            listaPartidas.agregarPartida(partida);
        } else
            utilidadesES.mostrarln("No se ha podido almacenar la partida.");
    }
}
