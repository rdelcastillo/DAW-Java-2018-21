package org.iesgrancapitan.PROGR.ejemplos.arrays;

import java.util.Arrays;

/**
 * Muestra 50 números enteros aleatorios entre 100 y 199 (ambos incluidos) separados por espacios. 
 * Muestra también el máximo, el mínimo, la moda, la media, la mediana y la desviación típica de esos números.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class UnidimensionalesEjercicio5 {
  
  private static final int TOTAL_NUM = 50;
  private static final int START_NUMBER = 100;
  private static final int FINAL_NUMBER = 199;

  public static void main(String[] args) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int[] numbers = new int[TOTAL_NUM];
    int[] frecuencies = new int[FINAL_NUMBER - START_NUMBER + 1];
    double sum = 0;
    
    System.out.print("Generamos " + TOTAL_NUM + " aleatorios: ");
    
    // Generación de números aleatorio, impresión de los números y 
    // cálculo de máximo, mínimo, media y frecuencia de aparición de cada número
    
    for (int i = 0; i < numbers.length; i++) {
      int random = START_NUMBER + (int) (Math.random() * (FINAL_NUMBER-START_NUMBER+1)); 
      System.out.print(random + " ");
      if (random > max) {
        max = random;
      }
      if (random < min) {
        min = random;
      }
      ++frecuencies[random-START_NUMBER];
      sum += random;
      numbers[i] = random;
    }
    
    // Impresión de máximo, mínimo y media
    System.out.println("\nMáximo y mínimo: " + max + ", " + min);
    double mean = sum / TOTAL_NUM;
    System.out.println("Media: " + mean);
    
    // Cálculo de la mediana e impresión
    
    Arrays.sort(numbers);
    double median;
    if (numbers.length%2 == 0) {    // la media es la media de los dos elementos que hay en medio
      int n1 = numbers[TOTAL_NUM/2 - 1];
      int n2 = numbers[TOTAL_NUM/2];
      median = (double) (n1 + n2)/2 ;
    } else {
      median = numbers[TOTAL_NUM/2];
    }
    System.out.println("Mediana: " + median);
    
    // Cálculo de la moda, tendremos en cuenta que puede haber varias modas
    
    // primer paso: ver la frecuencia de aparición de los números que sean moda
    int maxFrecuency = Integer.MIN_VALUE;
    for (int frecuency: frecuencies) {
      if (frecuency > maxFrecuency) {
        maxFrecuency = frecuency;
      }
    }
    // segundo paso: imprimo todos los números que coincidan con el máximo anterior (son la moda)
    System.out.print("Moda(s): ");
    for (int n = START_NUMBER; n <= FINAL_NUMBER; n++) {
      if (frecuencies[n - START_NUMBER] == maxFrecuency) {
        System.out.print(n + " ");
      }
    }
    System.out.println("(" + maxFrecuency + " veces)");

    // Cálculo de la desviación típica
    sum = 0;
    for (int n: numbers) {
      sum += Math.pow(n - mean, 2);
    }
    double sd = Math.sqrt(sum / TOTAL_NUM);
    System.out.println("Desviación típica: " + sd);
    
  }

}
