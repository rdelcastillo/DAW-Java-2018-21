package org.iesgrancapitan.PROGR.ejemplos.repetitivas;
/**
*
* Averiguamos si un número (7)) es primo.
*
* Sacado del ejemplo del libro de Python página 134.
*
* @author Rafael del Castillo
*/

public class EsPrimov1 {
  public static void main(String[] args) {
    int numero=7;
    int divisor;    //esta declaración puedo hacerla en el for

    for (divisor=2; divisor<numero; divisor++) {
        System.out.println(numero + " entre " + divisor +" es " + numero/divisor +
                                    " con resto " + numero%divisor);
    }
  }
}
