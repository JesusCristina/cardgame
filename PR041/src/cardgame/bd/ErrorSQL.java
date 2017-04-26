package cardgame.bd;

/**
 * Clase encargada de la gestión de excepciones SQL.
 * @author Jesús Rivero Muñiz
 */
@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class ErrorSQL extends Exception {
    
    /**
     * Código del error.
     */
    private int codError;
    
    /*
     * -- TABLA DE CÓDIGOS DE ERROR SQL --
     * 01 - No se ha devuelto ningún resultado.
     * Excepción: SQLException.
     */
    /**
     * ERR 01 - No se han devuelto datos.
     * Excepción: SQLException.
     */
    public static final int NO_DATA_ERR = 1;
    
    /**
     * Mensaje del error.
     */
    private String msgError;
    
    /**
     * Tipo de excepción del error.
     */
    private Exception excepcion;
    
    /**
     * Constructor que crea un objeto ErrorSQL a través de un código
     * y un mensaje de error.
     * @param codError Código del error.
     * @param msgError Mensaje del error.
     */
    public ErrorSQL(int codError, String msgError) {
        super(msgError);
        this.codError = codError;
        this.msgError = msgError;
    }
    
    /**
     * Constructor que crea un objeto ErrorSQL a través de un código,
     * un mensaje y a su vez encapsula una excepción.
     * @param codError Código del error.
     * @param msgError Mensaje del error.
     * @param excepcion Excepción obtenida.
     */
    public ErrorSQL(int codError, String msgError, Exception excepcion) {
        super(msgError, excepcion);
        this.codError = codError;
        this.msgError = msgError;
        this.excepcion = excepcion;
    }
    
    /**
     * Método getter de la propiedad codError.
     * @return Valor de la propiedad codError.
     */
    public int getCodError() {
        return codError;
    }
    
    /**
     * Método getter de la propiedad msgError.
     * @return Valor de la propiedad msgError.
     */
    public String getMsgError() {
        return msgError;
    }
    
    /**
     * Método getter de la propiedad excepcion.
     * @return Valor de la propiedad excepcion.
     */
    public Exception getExcepcion() {
        return excepcion;
    }
}
