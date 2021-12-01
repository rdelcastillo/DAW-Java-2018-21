package org.iesgrancapitan.PROGR.ejemplos.secuenciales;

/**
 * Este programa calcula la suma de los primeros 50 números enteros.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Suma50enterosV2 {

  public static void main(String[] args) {
    int suma = 0;
    int n = 0;
    
    do {
      n++;
      suma += n;
    } while (n < 50);
    
    System.out.println(suma);

  }

}
