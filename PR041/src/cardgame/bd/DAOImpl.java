package cardgame.bd;

import cardgame.juego.Carta;
import cardgame.juego.Jugador;
import cardgame.juego.ListaJugadores;
import cardgame.juego.ListaManos;
import cardgame.juego.ListaPartidas;
import cardgame.juego.Mano;
import cardgame.juego.Mazo;
import cardgame.juego.Partida;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.LinkedList;

/**
 * Implementación de la interfaz DAO.
 * @author Jesús Rivero Muñiz
 */
public class DAOImpl implements DAO {
    
    /**
     * Contiene el nombre de la clase Driver.
     */
    private String driver = "com.mysql.jdbc.Driver";

    /**
     * URL base para el acceso a la base de datos.
     */
    private String urlBase = "jdbc:mysql://localhost:3306/";

    /**
     * Nombre de la base datos.
     */
    private String baseDatos = null;

    /**
     * Nombre del usuario con el que se accederá a la base de datos.
     */
    private String usuario = null;

    /**
     * Clave de usuario.
     */
    private String clave = null;

    /**
     * Representa una conexi�n a la base de datos.
     */
    private Connection conexion = null;
    
    /**
     * Construye un bean de DAO a partir de driver, url base, 
     * base de datos, nombre de usuario y clave.
     */
    public DAOImpl(String driver, String urlBase, String baseDatos, String usuario, String clave) {
            this.driver = driver;
            this.urlBase = urlBase;
            this.baseDatos = baseDatos;
            this.usuario = usuario;
            this.clave = clave;
    }
    
    /**
     * Construye un bean de DAO a partir de url base, 
     * base de datos, nombre de usuario y clave.
     */
    public DAOImpl(String urlBase, String baseDatos, String usuario, String clave){
            this.urlBase = urlBase;
            this.baseDatos = baseDatos;
            this.usuario = usuario;
            this.clave = clave;
    }
                            
    /**
     * Construye un bean de DAO a partir de  
     * base de datos, nombre de usuario y clave.
     */
    public DAOImpl(String baseDatos, String usuario, String clave){
            this.baseDatos = baseDatos;
            this.usuario = usuario;
            this.clave = clave;
    }
    
    /**
     * Abre una conexión con la base de datos.
     * @return Devuelve la conexión.
     * @throws SQLException
     */
    public Connection getConexion() throws SQLException {
        if (conexion == null)
            conexion = DriverManager.getConnection(urlBase + baseDatos, usuario, clave);
        return conexion;
    }

    /**
     * Cierra la conexión con la base de datos.
     * @throws SQLException
     */
    public void closeConexion() throws SQLException {
        if (conexion != null) {
            conexion.close();
            conexion = null;
        }
    }
    
    /**
     * Recupera todas las cartas de la base de datos y crea un mazo con ellas.
     * @return Devuelve el mazo con las cartas.
     * @throws ErrorSQL
     * @throws SQLException
     */
    public Mazo recuperarMazo() throws SQLException, ErrorSQL {
        Mazo mazo = new Mazo();
        try {
            getConexion();
            String consulta = "SELECT valor, palo FROM CARTAS";
            Statement statement = conexion.createStatement();
            ResultSet registros = statement.executeQuery(consulta);
            if (registros.next()) {
                registros.beforeFirst();
                while (registros.next()) {
                    String palo = registros.getString("palo");
                    String valor = registros.getString("valor");
                    Carta carta = new Carta(palo, valor);
                    mazo.agregarCarta(carta);
                }
            } else
                throw new ErrorSQL(ErrorSQL.NO_DATA_ERR, "No se han devuelto datos.");
        } finally {
            closeConexion();
        }
        return mazo;
    }

    /**
     * Recupera todos los jugadores que hay registrados en la base de datos.
     * @return Devuelve un contenedor con los jugadores registrados.
     * @throws SQLException
     */
    public ListaJugadores recuperarJugadores() throws SQLException {
        ListaJugadores listaJugadores = null;
        try {
            getConexion();
            String consulta = "SELECT nombre FROM JUGADORES";
            Statement statement = conexion.createStatement();
            ResultSet registros = statement.executeQuery(consulta);
            while (registros.next()) {
                String nombre = registros.getString("nombre");
                Jugador jugador = new Jugador(nombre);
                listaJugadores.agregarJugador(jugador);
            }
        } finally {
            closeConexion();
        }
        return listaJugadores;
    }

    /**
     * Consulta si existe un jugador de la base de datos.
     * @param nombre Nombre del jugador a consultar.
     * @return Devuelve true si existe, false si no existe.
     * @throws SQLException
     */
    public boolean existeJugador(String nombre) throws SQLException {
        boolean existe = false;
        try {
            getConexion();
            String consulta = "SELECT nombre FROM JUGADORES WHERE nombre LIKE '" + nombre + "'";
            Statement statement = conexion.createStatement();
            ResultSet registros = statement.executeQuery(consulta);
            if (registros.next()) {
                existe = true;
            }
        } finally {
            closeConexion();
        }
        return existe;
    }

    /**
     * Recupera el número de la ultima partida insertada en la base
     * de datos.
     * @return Devuelve el número de la última partida insertada,
     * si no se había insertado ninguna antes, devuelve 1, si
     * ha habido algún tipo de error, devuelve 0.
     * @throws SQLException
     */
    public int ultimaPartida() throws SQLException {
        int numPartida = 0;
        try {
            getConexion();
            String consulta = "SELECT MAX(id_partida) FROM PARTIDAS";
            Statement statement = conexion.createStatement();
            ResultSet registros = statement.executeQuery(consulta);
            if (registros.next())
                numPartida = registros.getInt("MAX(id_partida)");
            else
                numPartida = 1;
        } finally {
            closeConexion();
        }
        return numPartida;
    }
    
    /**
     * Recupera todas las partidas almacenadas en la base de datos.
     * @return Devuelve un contenedor con las partidas recuperadas.
     * @throws SQLException
     */
    public ListaPartidas recuperarPartidas() throws SQLException {
        ListaPartidas listaPartidas = null;
        try {
            getConexion();
            String consulta = "SELECT MANOS.id_mano, CARTAS.valor, CARTAS.palo, JUGADORES.nombre, PARTIDAS.id_partida " +
                "FROM MANOS " +
                "LEFT JOIN PARTIDAS ON PARTIDAS.id_mano = MANOS.id_mano " +
                "LEFT JOIN CARTAS ON CARTAS.id_carta = MANOS.id_carta " +
                "LEFT JOIN JUGADORES ON JUGADORES.id_jug = PARTIDAS.id_jug " +
                "ORDER BY PARTIDAS.id_mano";
            Statement statement = conexion.createStatement();
            ResultSet registros = statement.executeQuery(consulta);
            // Compruebo que se han devuelto datos
            if (registros.next()) {
                // Inicializo el contenedor que se devolverá
                listaPartidas = new ListaPartidas();
                // Declaro e inicializo los objetos que servirán de buffer para añadir datos a cada partida
                LinkedList<Jugador> listaJugadores = new LinkedList<Jugador>();
                LinkedList<Mano> resultado = new LinkedList<Mano>();
                Mano mano = new Mano();
                // Variable que sirve para controlar cuando hay una nueva partida
                int numPartida = registros.getInt("PARTIDAS.id_partida");
                // Variable que sirve para controlar cuando hay una nueva mano
                int numMano = registros.getInt("MANOS.id_mano");
                // Devuelvo el cursor del ResultSet a su posición inicial
                registros.beforeFirst();
                // Bucle encargado de añadir datos a los contenedores
                while (registros.next()) {
                    // Declaración de variables
                    String palo = registros.getString("CARTAS.palo");
                    String valor = registros.getString("CARTAS.valor");
                    String nombre = registros.getString("JUGADORES.nombre");
                    // Se crea una carta con el palo y el valor devuelto por la consulta SQL
                    Carta carta = new Carta(palo, valor);
                    // Agrego la carta a la mano
                    mano.agregarCarta(carta);
                    // Agrego jugadores al contenedor de jugadores controlando si hay duplicados
                    if (!listaJugadores.contains(nombre) || listaJugadores.isEmpty()) {
                        Jugador jugador = new Jugador(nombre);
                        listaJugadores.add(jugador);
                    }
                    // Cuando hay una nueva mano, la añado al contenedor resultados y creo una nueva Mano
                    if (numMano != registros.getInt("MANOS.id_mano") || registros.isLast()) {
                        numMano = registros.getInt("MANOS.id_mano");
                        mano.setPropietario(nombre);
                        resultado.add(mano);
                        mano = new Mano();
                    }
                    // Cuando hay una nueva partida, guardo un objeto Partida en el contenedor de partidas
                    if (numPartida != registros.getInt("PARTIDAS.id_partida") || registros.isLast()) {
                        numPartida = registros.getInt("PARTIDAS.id_partida");
                        Partida partida = new Partida(numPartida, listaJugadores, resultado);
                        listaPartidas.agregarPartida(partida);
                        // Reinicio los buffers de datos
                        listaJugadores = new LinkedList<Jugador>();
                        resultado = new LinkedList<Mano>();
                    }
                }
            }
        } finally {
            closeConexion();
        }
        return listaPartidas;
    }
    
    /**
     * Recupera todas las partidas almacenadas en la base de datos de un determinado jugador.
     * @param nombreJug Nombre del jugador
     * @return Devuelve un contenedor con las partidas recuperadas para ese jugador.
     * @throws ErrorSQL
     * @throws SQLException
     */
    public ListaPartidas recuperarPartidas(String nombreJug) throws SQLException, ErrorSQL {
        ListaPartidas listaPartidas = null;
        try {
            getConexion();
            String consulta = "SELECT JUGADORES.nombre, PARTIDAS.id_mano, CARTAS.palo, CARTAS.valor, PARTIDAS.id_partida " +
                "FROM JUGADORES " +
                "LEFT JOIN PARTIDAS ON JUGADORES.id_jug = PARTIDAS.id_jug " +
                "LEFT JOIN MANOS ON PARTIDAS.id_mano = MANOS.id_mano " +
                "LEFT JOIN CARTAS ON MANOS.id_carta = CARTAS.id_carta " +
                "WHERE nombre LIKE '" + nombreJug + "' ORDER BY PARTIDAS.id_mano";
            Statement statement = conexion.createStatement();
            ResultSet registros = statement.executeQuery(consulta);
            // Compruebo que se han devuelto datos
            if (registros.next()) {
                // Inicializo el contenedor que se devolverá
                listaPartidas = new ListaPartidas();
                // Declaro e inicializo los objetos que servirán de buffer para añadir datos a cada partida
                LinkedList<Jugador> listaJugadores = new LinkedList<Jugador>();
                LinkedList<Mano> resultado = new LinkedList<Mano>();
                Mano mano = new Mano();
                // Agrego el jugador a la lista de jugadores
                String nombre = registros.getString("JUGADORES.nombre");
                Jugador jugador = new Jugador(nombre);
                listaJugadores.add(jugador);
                // Variable que sirve para controlar cuando hay una nueva partida
                int numPartida = registros.getInt("PARTIDAS.id_partida");
                // Variable que sirve para controlar cuando hay una nueva mano
                int numMano = registros.getInt("PARTIDAS.id_mano");
                // Devuelvo el cursor del ResultSet a su posición inicial
                registros.beforeFirst();
                // Bucle encargado de añadir datos a los contenedores
                while (registros.next()) {
                    // Declaración de variables
                    String palo = registros.getString("CARTAS.palo");
                    String valor = registros.getString("CARTAS.valor");
                    // Se crea una carta con el palo y el valor devuelto por la consulta SQL
                    Carta carta = new Carta(palo, valor);
                    // Agrego la carta a la mano
                    mano.agregarCarta(carta);
                    // Cuando hay una nueva mano, la añado al contenedor resultados y creo una nueva Mano
                    if (numMano != registros.getInt("PARTIDAS.id_mano") || registros.isLast()) {
                        numMano = registros.getInt("PARTIDAS.id_mano");
                        mano.setPropietario(nombre);
                        resultado.add(mano);
                        mano = new Mano();
                    }
                    // Cuando hay una nueva partida, guardo un objeto Partida en el contenedor de partidas
                    if (numPartida != registros.getInt("PARTIDAS.id_partida") || registros.isLast()) {
                        Partida partida = new Partida(numPartida, listaJugadores, resultado);
                        numPartida = registros.getInt("PARTIDAS.id_partida");
                        listaPartidas.agregarPartida(partida);
                        // Reinicio los buffers de datos
                        listaJugadores = new LinkedList<Jugador>();
                        resultado = new LinkedList<Mano>();
                    }
                }
            } else
                throw new ErrorSQL(ErrorSQL.NO_DATA_ERR, "No se han devuelto datos.");
        } finally {
            closeConexion();
        }
        return listaPartidas;
    }

    /**
     * Inserta una partida en la base de datos.
     * @param partida Partida a insertar
     * @return Devuelve 1 si se ha podido insertar, 0 si no.
     * @throws ErrorSQL
     * @throws SQLException
     */
    public int insertarPartida(Partida partida) throws SQLException, ErrorSQL {
        int partidaInsertada = 0;
        try {
            getConexion();
            String insert = "INSERT INTO PARTIDAS VALUES (?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(insert);
            statement.setInt(1, partida.getNumPartida());
            for (Mano mano: partida.getResultado()) {
                statement.setInt(2, averiguarIdJugador(mano.getPropietario()));
                statement.setInt(3, ultimaManoPartidas() + 1);
                statement.executeUpdate();
                partidaInsertada = 1;
            }
        } finally {
            closeConexion();
        }
        return partidaInsertada;
    }
    
    /**
     * Devuelve el número de la última mano registrada en la
     * tabla PARTIDAS de la base de datos.
     * @return Número de la última mano.
     * @throws SQLException
     */
    private int ultimaManoPartidas() throws SQLException {
        int idMano = 0;
        String consulta = "SELECT MAX(id_mano) FROM PARTIDAS";
        Statement statement = conexion.createStatement();
        ResultSet registros = statement.executeQuery(consulta);
        if (registros.next())
            idMano = registros.getInt("MAX(id_mano)");
        else
            idMano = 0;
        return idMano;
    }
    
    /**
     * Devuelve el ID en base de datos de un jugador
     * a través de su nombre.
     * @param nombre Nombre del jugador.
     * @return ID del jugador.
     * @throws SQLException
     * @throws ErrorSQL
     */
    private int averiguarIdJugador(String nombre) throws SQLException, ErrorSQL {
        int idJugador = 0;
        String consulta = "SELECT id_jug FROM JUGADORES WHERE nombre LIKE '" + nombre + "'";
        Statement statement = conexion.createStatement();
        ResultSet registros = statement.executeQuery(consulta);
        if (registros.next())
            idJugador = registros.getInt("id_jug");
        else
            throw new ErrorSQL(ErrorSQL.NO_DATA_ERR, "No se han devuelto datos.");
        return idJugador;
    }

    /**
     * Inserta una lista de jugadores en la base de datos.
     * @param listaJugadores Contenedor con los jugadores.
     * @return Devuelve el número de registros insertados.
     * @throws ErrorSQL
     * @throws SQLException
     */
    public int insertarJugadores(ListaJugadores listaJugadores) throws SQLException, ErrorSQL {
        int jugadoresInsertados = 0;
        try {
            getConexion();
            String insert = "INSERT INTO JUGADORES VALUES (?,?)";
            PreparedStatement statement = conexion.prepareStatement(insert);
            for (Jugador jugador: listaJugadores.getListaJugadores()) {
                statement.setInt(1, ultimoJugador() + 1);
                statement.setString(2, jugador.getNombre());
                jugadoresInsertados += statement.executeUpdate();
            }
        } finally {
            closeConexion();
        }
        return jugadoresInsertados;
    }

    /**
     * Inserta un jugador en la base de datos.
     * @param jugador Jugador a insertar.
     * @return Devuelve 1 si se ha insertado, 0 si no se ha podido insertar.
     * @throws ErrorSQL
     * @throws SQLException
     */
    public int insertarJugadores(Jugador jugador) throws SQLException, ErrorSQL {
        int jugadorInsertado = 0;
        try {
            getConexion();
            String insert = "INSERT INTO JUGADORES VALUES (?,?)";
            PreparedStatement statement = conexion.prepareStatement(insert);
            statement.setInt(1, ultimoJugador() + 1);
            statement.setString(2, jugador.getNombre());
            jugadorInsertado += statement.executeUpdate();
        } finally {
            closeConexion();
        }
        return jugadorInsertado;
    }
    
    /**
     * Devuelve el número del último jugador registrado en la
     * base de datos.
     * @return Numero del último jugador.
     * @throws ErrorSQL Informa de que no se han devuelto datos.
     * @throws SQLException
     */
    private int ultimoJugador() throws ErrorSQL, SQLException {
        int ultimoJugador;
        String consulta = "SELECT MAX(id_jug) FROM JUGADORES";
        Statement statement = conexion.createStatement();
        ResultSet registros = statement.executeQuery(consulta);
        if (registros.next())
            ultimoJugador = registros.getInt("MAX(id_jug)");
        else
            ultimoJugador = 0;
        return ultimoJugador;
    }

    /**
     * Inserta una lista de manos en la base de datos.
     * @param listaManos Contenedor con las manos.
     * @return Devuelve el número de registros insertados.
     * @throws SQLException
     * @throws ErrorSQL
     */
    public int insertarManos(ListaManos listaManos) throws SQLException, ErrorSQL {
        int manosInsertadas = 0;
        try {
            getConexion();
            String insert = "INSERT INTO MANOS VALUES (?,?)";
            PreparedStatement statement = conexion.prepareStatement(insert);
            for (Mano mano: listaManos.getListaManos()) {
                statement.setInt(1, ultimaMano() + 1);
                for (Carta carta: mano.getCartas()) {
                    statement.setInt(2, averiguarIdCarta(carta));
                    manosInsertadas += statement.executeUpdate();
                }
            }
        } finally {
            closeConexion();
        }
        return manosInsertadas;
    }
    
    /**
     * Devuelve el número de la última mano registrada en la
     * base de datos.
     * @return Numero de la última mano.
     * @throws ErrorSQL Informa de que no se han devuelto datos.
     * @throws SQLException
     */
    private int ultimaMano() throws ErrorSQL, SQLException {
        int ultimaMano;
        String consulta = "SELECT MAX(id_mano) FROM MANOS";
        Statement statement = conexion.createStatement();
        ResultSet registros = statement.executeQuery(consulta);
        if (registros.next())
            ultimaMano = registros.getInt("MAX(id_mano)");
        else
            ultimaMano = 0;
        return ultimaMano;
    }
    
    /**
     * Devuelve el ID en base de datos de una carta a través
     * de su palo y su valor.
     * @param carta Carta proporcionada.
     * @return Devuelve el ID de la carta.
     * @throws ErrorSQL
     * @throws SQLException
     */
    private int averiguarIdCarta(Carta carta) throws ErrorSQL, SQLException {
        int idCarta = 0;
        String palo = carta.getPalo();
        String valor = carta.getValor();
        String consulta = "SELECT id_carta FROM CARTAS " +
            "WHERE palo LIKE '" + palo + "' AND valor LIKE '" + valor + "'";
        Statement statement = conexion.createStatement();
        ResultSet registros = statement.executeQuery(consulta);
        if (registros.next())
            idCarta = registros.getInt("id_carta");
        else
            throw new ErrorSQL(ErrorSQL.NO_DATA_ERR, "No se han devuelto datos.");
        return idCarta;
    }

    /**
     * Elimina las manos de un jugador en la base de datos.
     * @param nombre Nombre del jugador.
     * @return Devuelve el número de manos eliminadas, 0 si no se ha eliminado ninguna.
     * @throws SQLException
     */
    public int eliminarJugador(String nombre) throws SQLException {
        int manosEliminadas = 0;
        try {
            getConexion();
            String consulta = "SELECT id_mano " + 
            "FROM PARTIDAS " + 
            "WHERE id_jug = (SELECT id_jug FROM JUGADORES WHERE nombre LIKE '" + nombre + "')";
            Statement statement1 = conexion.createStatement();
            Statement statement2 = conexion.createStatement();
            ResultSet registros = statement1.executeQuery(consulta);
            while (registros.next()) {
                int id = registros.getInt("id_mano");
                String delete = "DELETE FROM MANOS WHERE id_mano = " + id;
                manosEliminadas += statement2.executeUpdate(delete);
            }
        } finally {
            closeConexion();
        }
        return manosEliminadas;
    }

    /**
     * Elimina una partida de la base de datos.
     * @param numPartida Número de la partida.
     * @return Devuelve el número de manos eliminadas, 0 si no se ha eliminado ninguna.
     * @throws SQLException
     */
    public int eliminarPartida(int numPartida) throws SQLException {
        int manosEliminadas = 0;
        try {
            getConexion();
            // Consulta las manos a borrar
            String consulta = "SELECT id_mano " + 
            "FROM PARTIDAS " + 
            "WHERE id_partida = " + numPartida;
            Statement statement1 = conexion.createStatement();
            Statement statement2 = conexion.createStatement();
            Statement statement3 = conexion.createStatement();
            ResultSet registros = statement1.executeQuery(consulta);
            // Borra la partida
            String deletePartida = "DELETE FROM PARTIDAS WHERE id_partida = " + numPartida;
            statement2.executeUpdate(deletePartida);
            while (registros.next()) {
                // Borra las manos
                int id = registros.getInt("id_mano");
                String deleteManos = "DELETE FROM MANOS WHERE id_mano = " + id;
                manosEliminadas += statement3.executeUpdate(deleteManos);
            }
        } finally {
            closeConexion();
        }
        return manosEliminadas;
    }
}
