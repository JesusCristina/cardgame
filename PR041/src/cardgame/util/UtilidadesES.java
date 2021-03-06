package cardgame.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Clase dedicada a la interacción con el usuario.
 * @author Jesús Rivero Muñiz
 */
public class UtilidadesES {
    /**
     * Flujo de entrada.
     */
    private BufferedReader flujoEntrada;

    /**
     * Flujo de salida.
     */
    private PrintStream flujoSalida;
    
    private static UtilidadesES utilidadesES;
    
    /**
     * No permite que se genere un constructor por defecto.
     */
    private UtilidadesES() {
        this.flujoEntrada = new BufferedReader(new InputStreamReader(System.in));
        this.flujoSalida = System.out;
    }
    
    /**
     * Crea un objeto de clase UtilidadesES si no existe.
     * @return Objeto UtilidadesES.
     */
    public static UtilidadesES getUtilidadesES() {
        if (utilidadesES == null)
            utilidadesES = new UtilidadesES();
        return utilidadesES;
    }

    /**
     * Muestra un mensaje por el flujo de salida.
     * @param cadena Mensaje que se mostrará.
     */
    public void mostrar(String cadena) {
        flujoSalida.print(cadena);
    }

    /**
     * Muestra un mensaje por el flujo de salida con salto de línea.
     * @param cadena Mensaje que se mostrará.
     */
    public void mostrarln(String cadena) {
        mostrar(cadena + "\n");
    }

    /**
     * Pide una cadena desde el flujo de entrada mostrando previamente
     * un mensaje.
     * @param mensaje Mensaje que se muestra.
     * @return Cadena leída.
     * @throws IOException Error en lectura de datos desde flujo entrada.
     */
    public String pideCadena(String mensaje) {
        String respuesta = null;
        mostrar(mensaje);
        try {
            respuesta = flujoEntrada.readLine();
        } catch (IOException e) {
            flujoSalida.println("Error de Entrada/Salida.");
        }
        return respuesta;
    }

    /**
     * Pide una cadena desde el flujo de entrada.
     * @return Cadena leída.
     * @throws IOException Error en lectura de datos desde flujo entrada.
     */
    public String pideCadena() {
        String respuesta = null;
        try {
            respuesta = flujoEntrada.readLine();
        } catch (IOException e) {
            flujoSalida.println("Error de Entrada/Salida.");
        }
        return respuesta;
    }

    /**
     * Pide una cadena desde el flujo de entrada que posteriormente
     * transforma a número mostrando previamente un mensaje.
     * @param mensaje Mensaje que se muestra.
     * @return Número leído.
     * @throws IOException Error en lectura de datos desde flujo entrada.
     * @throws NumberFormatException Formato no válido.
     */
    public int pideNumero(String mensaje) throws IOException {
        int respuesta = 0;
        mostrar(mensaje);
        try {
            respuesta = Integer.parseInt(flujoEntrada.readLine());
        } catch (NumberFormatException e) {
            flujoSalida.println("No se ha introducido un número.");
        }
        return respuesta;
    }

    /**
     * Pide una cadena desde el flujo de entrada que posteriormente
     * transforma a número.
     * @return Número leído.
     * @throws IOException Error en lectura de datos desde flujo entrada.
     * @throws NumberFormatException Formato no válido.
     */
    public int pideNumero(){
        int respuesta = 0;
        try {
            respuesta = Integer.parseInt(flujoEntrada.readLine());
        } catch (IOException e) {
            flujoSalida.println("Error de Entrada/Salida.");
        } catch (NumberFormatException e) {
            flujoSalida.println("No se ha introducido un número.");
        }
        return respuesta;
    }
    
    /**
     * Método que verifica si una cadena es un número o no.
     * @param cadena Cadena a verificar.
     * @return Devuelve true si es un número o false si no lo es.
     */
    public boolean esUnNumero(String cadena)
    {  
      try  
      {  
        double d = Double.parseDouble(cadena);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }
    
    /**
     * Método que verifica si una cadena es contiene un número o no.
     * @param cadena Cadena a verificar.
     * @return Devuelve true si contiene un número o false si no.
     */
    public boolean contieneNumero(String cadena) {
        // Controla que la cadena no está vacía.
        if (cadena != null && !cadena.isEmpty()) {
            // Si encuentra un número en alguna posición de la cadena, devuelve true.
            for (char c : cadena.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
