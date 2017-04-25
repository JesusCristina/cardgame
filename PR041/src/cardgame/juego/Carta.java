package cardgame.juego;

//TODO Documentación e implementación
/*
 * Implementar método toString() con la siguiente sintaxis de ejemplo:
 * "A de Tréboles". También se tienen que implementar los metodos
 * getter.
 */
/**
 * Encapsula el concepto de carta del juego.
 * @author Cristina Polo S�nchez
 */

public class Carta {
    /**
     * El palo de la carta.
     */
    private String palo;
    
    /**
     * El valor de la carta.
     */
    private String valor;

    /**
     * El constructor por defecto de la carta, ue crea una carta con un palo y un valor.
     * @param palo El palo de la carta.
     * @param valor El valor de la carta.
     */
    public Carta (String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }


    /**
     * Devuelve la definici�n de la carta, su informaci�n.
     * @return la definici�n de la carta (valor + palo).
     */
    public String toString() { 
        return valor + " de " + palo;
    }

    /**
     * Da informaci�n sobre el palo, de cu�l de los cuatro se trata.
     * @return el palo.
     */
    public String getPalo() {
        return palo;
    }

    /**
     * Da informaci�n sobre el valor, qu� valor tiene la carta.
     * @return el valor
     */
    public String getValor() {
        return valor;
    }
}