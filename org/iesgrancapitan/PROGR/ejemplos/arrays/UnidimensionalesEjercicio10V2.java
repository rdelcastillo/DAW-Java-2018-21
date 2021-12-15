package org.iesgrancapitan.PROGR.ejemplos.arrays;

import java.util.Arrays;

/**
 * Programa que genera 20 números enteros aleatorios entre 0 y 100 y que los almacene en un array.
 * El programa debe ser capaz de pasar todos los números pares a las primeras posiciones del array
 * (del 0 en adelante) y todos los números impares a las celdas restantes. Utiliza arrays auxiliares
 * si es necesario.
 * 
 * Ejercio 10 de Arrays unidimensionales del libro "Aprende Java con ejercicios".
 * 
 * En esta versión no vamos usar arrays auxiliares, sino que lo que haremos será cambiar de posición
 * cada par que nos encontremos siempre y cuando tenga impares delante.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class UnidimensionalesEjercicio10V2 {

  private static final int TOTAL_NUMBERS = 20;
  private static final int START_NUMBER = 0;
  private static final int FINAL_NUMBER = 100;

  public static void main(String[] args) {
    
    // Generar los números aleatorios
    
    int[] numbers = new int[TOTAL_NUMBERS];
    for (int i = 0; i < TOTAL_NUMBERS; i++) {
      numbers[i] = START_NUMBER + (int) (Math.random()*(FINAL_NUMBER - START_NUMBER + 1));
    }
    System.out.println("Array original: " + Arrays.toString(numbers));
    
    // Proceso
    for (int i = 0; i < numbers.length; i++) {
      int currentPos = i;
      while (currentPos>0 && numbers[currentPos]%2 == 0 && numbers[currentPos-1]%2 != 0) {
        int aux = numbers[currentPos];
        numbers[currentPos] = numbers[currentPos-1];
        numbers[currentPos-1] = aux;
        currentPos--;
      }
    }
    
    System.out.println("Array procesado: " + Arrays.toString(numbers));

  }

}
