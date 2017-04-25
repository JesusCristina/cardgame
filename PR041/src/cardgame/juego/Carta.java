package cardgame.juego;

//TODO DocumentaciÃ³n e implementaciÃ³n
/*
 * Implementar mÃ©todo toString() con la siguiente sintaxis de ejemplo:
 * "A de TrÃ©boles". TambiÃ©n se tienen que implementar los metodos
 * getter.
 */
/**
 * Encapsula el concepto de carta del juego.
 * @author Cristina Polo Sánchez
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
     * Devuelve la definición de la carta, su información.
     * @return la definición de la carta (valor + palo).
     */
    public String toString() { 
        return valor + " de " + palo;
    }

    /**
     * Da información sobre el palo, de cuál de los cuatro se trata.
     * @return el palo.
     */
    public String getPalo() {
        return palo;
    }

    /**
     * Da información sobre el valor, qué valor tiene la carta.
     * @return el valor
     */
    public String getValor() {
        return valor;
    }
}