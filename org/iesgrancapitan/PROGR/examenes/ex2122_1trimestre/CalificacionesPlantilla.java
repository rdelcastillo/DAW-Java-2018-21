package org.iesgrancapitan.PROGR.examenes.ex2122_1trimestre;

/**
 * Programa que dada una tabla de 12x31 donde se almacenan las temperaturas medias diarias (enteras) de la ciudad de Córdoba nos dice:
 * 
 * La temperatura media de cada mes.
 * El día más caluroso y el más frío de cada mes (puede haber más de uno) y su temperatura.
 * El día más caluroso y el más frío del año (puede haber más de uno) y su temperatura.
 * 
 * Las temperaturas se crean aleatoriamente con una semilla única (siempre se crean las mismas) y se almacenan en el array
 * temperatures.
 */

import java.util.Random;

public class CalificacionesPlantilla {
  
  private static final int MAX_DAYS_MONTH = 31;
  private static final int MONTHS_YEAR = 12;
  private static int[] DAYS_MONTHS = {31,28,31,30,31,30,31,31,30,31,30,31};
  private static String[] NAMES_MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto",
      "Septiembre","Octubre","Noviembre","Diciembre"};
  
  public static void main(String[] args) {
    int[][] temperatures = new int[MONTHS_YEAR][MAX_DAYS_MONTH];
    
    // Rellenamos las temperaturas aleatoriamente y las mostramos
    fillTemperatures(temperatures);
    showTemperatures(temperatures);
    
    // haced el examen a partir de aquí cambiando el nombre del paquete y dejando intactas las funciones
  }

  /**
   * Rellena las temperaturas aleatoriamente usando una semilla.
   * @param temperatures
   */
  private static void fillTemperatures(int[][] temperatures) {
    final int[] BASE_TEMPERATURES = {8,10,13,15,19,24,27,27,23,19,12,8};
    final int LOWER_VARIATION_INTERVAL = -5;
    final int UPPER_VARIATION_INTERVAL = 5;
    final long SEED = 100;
    
    Random random = new Random(SEED);
    for (int month = 0; month < MONTHS_YEAR; month++) {
      for (int day = 0; day < DAYS_MONTHS[month]; day++) {
        temperatures[month][day] = BASE_TEMPERATURES[month] 
            + LOWER_VARIATION_INTERVAL + (int) (random.nextDouble()*(UPPER_VARIATION_INTERVAL-LOWER_VARIATION_INTERVAL+1));
      }
    }
  }
  
  /**
   * Muestra las temperaturas
   * @param temperatures
   */
  private static void showTemperatures(int[][] temperatures) {
    System.out.print(" ".repeat(11));
    for (int day = 1; day <= MAX_DAYS_MONTH; day++) {
      System.out.printf("%2d  ", day);
    }
    System.out.println();
    for (int month = 0; month < MONTHS_YEAR; month++) {
      System.out.printf("%-10s ", NAMES_MONTHS[month]);
      for (int day = 0; day < DAYS_MONTHS[month]; day++) {
        System.out.printf("%2dº ", temperatures[month][day]);
      }
      System.out.println();
    }
  }

}
