package org.iesgrancapitan.PROGR.ejemplos.repetitivas;
/**
*
* Averiguamos si un número (7)) es primo.
*
* Sacado del ejemplo del libro de Python página 134.
*
* @author Rafael del Castillo
*/

public class EsPrimov3 {
  public static void main(String[] args) {
    int numero=7;
    int restosNoNulos = 0;

    for (int divisor=2; divisor<numero; divisor++) {
        if (numero%divisor != 0) {
            restosNoNulos++;
        }
    }

    if (restosNoNulos == numero-2) {
        System.out.printf("El número %d es primo\n",numero);
    }
    else {
        System.out.printf("El número %d NO es primo\n",numero);
    }

  }
}
