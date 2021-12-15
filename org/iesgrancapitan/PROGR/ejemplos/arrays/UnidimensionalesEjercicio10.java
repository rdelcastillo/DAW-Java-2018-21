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
 * @author Rafael del Castillo Gomariz
 *
 */

public class UnidimensionalesEjercicio10 {

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
    
    // Paso los pares y los impares a respectivos arrays
    int[] even = new int[TOTAL_NUMBERS];
    int[] odd = new int[TOTAL_NUMBERS];
    int totalEven = 0;
    int totalOdd = 0;
    for (int number: numbers) {
      if (number%2 == 0) {  // ¿Es par?
        even[totalEven] = number;
        totalEven++;
      } else {
        odd[totalOdd] = number;
        totalOdd++;
      }
    }
    
    // Paso todos los pares a las primeras posiciones
    for (int i = 0; i < totalEven; i++) {
      numbers[i] = even[i];
    }
    
    // Paso los impares a las siguientes posiciones
    for (int i = 0; i < totalOdd; i++) {
      numbers[totalEven+i] = odd[i];
    }
    
    System.out.println("Array procesado: " + Arrays.toString(numbers));

  }

}
