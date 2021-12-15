package org.iesgrancapitan.PROGR.ejemplos.arrays;

/**
 * Este programa genera una jugada de la bonoloto. 
 * Para ello generaremos 50.000 números aleatorios y nos quedaremos con los ocho
 * (seis + complementario + reintegro) que más se repitan.
 * 
 * Usaremos un vector de enteros de 49 posiciones para contabilizar el número de
 * veces que se repite cada número, después sacaremos los que tengan mayor frecuencia
 * de aparición.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Bonoloto {

  private static final int TOTAL_NUMBERS_TO_GENERATE = 50000;
  private static final int TOTAL_NUMBERS_BONOLOTO = 8;
  private static final int MAX_NUMBER = 49;

  public static void main(String[] args) {
    int[] numberFrecuencies = new int[MAX_NUMBER];
    
    // generamos los números aleatorios y calculamos su frecuencia
    for (int i=0; i<TOTAL_NUMBERS_TO_GENERATE; i++) {
      int number = 1 + (int) (Math.random()*MAX_NUMBER);
      ++numberFrecuencies[number-1];
    }
    
    // sacamos los que más se repiten
    System.out.print("Números de la bonoloto: ");
    for (int i=0; i<TOTAL_NUMBERS_BONOLOTO; i++) {
      // en cada iteración averiguaremos cuál es el que más se repite
      int numberMostFrequently = 1; // inicialmente asumimos que es el 1º
      for (int n=2; n<=MAX_NUMBER; n++) {
        if (numberFrecuencies[n-1] > numberFrecuencies[numberMostFrequently-1]) {
          numberMostFrequently = n;
        }
      }
      System.out.print(numberMostFrequently + " ");
      // para que en la siguiente iteración no se repita ese número cambiamos su frecuencia a -1
      numberFrecuencies[numberMostFrequently-1] = -1;
    }
  }
}
