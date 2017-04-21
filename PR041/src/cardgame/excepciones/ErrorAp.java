package cardgame.excepciones;

/**
 * Clase encargada de la gestión de excepciones de la aplicación.
 * @author Jesús Rivero Muñiz
 */
@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class ErrorAp extends Exception{
    
    /**
     * Código del error.
     */
    private int codError;
    
    // TODO: Incluir todos los códigos de error posibles.
    /*
     * -- TABLA DE CÓDIGOS DE ERROR --
     * 01 - Error de Entrada/Salida.
     * Excepción: IOException.
     * .
     * .
     */
    
    /**
     * Mensaje del error.
     */
    private String msgError;
    
    /**
     * Tipo de excepción del error.
     */
    private Exception excepcion;
    
    /**
     * Constructor que crea un objeto ErrorAp a través de un código
     * y un mensaje de error.
     * @param codError Código del error.
     * @param msgError Mensaje del error.
     */
    public ErrorAp(int codError, String msgError) {
        super(msgError);
        this.codError = codError;
        this.msgError = msgError;
    }
    
    /**
     * Constructor que crea un objeto ErrorAp a través de un código,
     * un mensaje y a su vez encapsula una excepción.
     * @param codError Código del error.
     * @param msgError Mensaje del error.
     * @param excepcion Excepción obtenida.
     */
    public ErrorAp(int codError, String msgError, Exception excepcion) {
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
