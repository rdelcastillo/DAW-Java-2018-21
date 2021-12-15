package org.iesgrancapitan.PROGR.ejemplos.arrays;

/**
 * Programa que generará 20 números enteros aleatorios. Estos números se deben
 * introducir en un array de 4 filas por 5 columnas. El programa mostrará las
 * sumas parciales de filas y columnas igual que si de una hoja de cálculo se
 * tratara. La suma total debe aparecer en la esquina inferior derecha.
 * 
 * Ejercicio 2 de arrays bidimensionales del libro "Aprende Java con Ejercicios".
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class BidimensionalesEjercicio2 {

  private static final int TOP_NUMBER = 1000;
  private static final int COLUMNS = 5;
  private static final int ROWS = 4;

  public static void main(String[] args) {
    int[][] table = new int[ROWS][COLUMNS];
    int[] rowsSum = new int[ROWS];
    int[] columnsSum = new int[COLUMNS];
    int total = 0;
    
    // Rellenamos la tabla
    for (int row = 0; row < ROWS; row++) {
      for (int col = 0; col < COLUMNS; col++) {
        table[row][col] = (int) (Math.random()*TOP_NUMBER);
      }
    }
    
    // Cálculos (los podríamos haber hecho en el ciclo anterior)
    for (int row = 0; row < ROWS; row++) {
      for (int col = 0; col < COLUMNS; col++) {
        int cell = table[row][col];
        rowsSum[row] += cell;
        columnsSum[col] += cell;
        total += cell;
      }
    }
    
    // Salida (lo podríamos haber hecho en el ciclo anterior)
    
    // valores de las celdas y sumatorio filas
    for (int row = 0; row < ROWS; row++) {
      for (int col = 0; col < COLUMNS; col++) {
        System.out.printf("%5d\t", table[row][col]);
      }
      System.out.printf("| %5d\n", rowsSum[row]);
    }
    
    // sumatorio columnas y total
    String line = "-".repeat(5);
    for (int col = 0; col < COLUMNS; col++) {
      System.out.print(line + "\t");
    }
    System.out.println("| " + line);
    
    for (int col = 0; col < COLUMNS; col++) {
      System.out.printf("%5d\t", columnsSum[col]);
    }
    System.out.printf("| %5d\n", total);
    

  }

}
