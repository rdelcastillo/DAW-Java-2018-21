package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas.arrays;

/**
 * Rellena un array de 6 filas por 10 columnas con números enteros 
 * positivos aleatorios comprendidos entre 0 y 1000 (ambos incluidos) 
 * sin que se repita ninguno.
 * 
 * A continuación, se da la posición tanto del máximo como del mínimo.
 * 
 * Ejercicio 6 (arrays bidimensionales) de "Aprende Java con Ejercicios" 
 * (Ed.2019) de Luis José Sánchez González.
 * 
 * @author Rafael del Castillo Gomariz
 * 
 * Este programa está incompleto.
 *
 */

public class Ej25ArraysBidimensionalesConFunciones {
  
  final static int FILAS = 6;
  final static int COLUMNAS = 10;
  final static int ALEATORIO_INICIAL = 0;
  final static int ALEATORIO_FINAL = 1000;

  public static void main(String[] args) {
    int[][] numeros = new int[FILAS][COLUMNAS];     // array de números
    
    
    RellenaArrayAleatorios(numeros);
    MostrarArray(numeros);
    
    // Mostramos posición máximo y mínimo
    int maximo = Maximo(numeros);
    int minimo = Minimo(numeros);
    
    for (int fila = 0; fila < FILAS; fila++) {
      for (int columna = 0; columna < COLUMNAS; columna++) {
        if (numeros[fila][columna] == maximo) {
          System.out.println("Máximo: " + numeros[fila][columna] + 
              " en (" + fila + "," + columna + ")");
        } else if (numeros[fila][columna] == minimo) {
          System.out.println("Mínimo: " + numeros[fila][columna] + 
              " en (" + fila + "," + columna + ")");
        }
      }
    }
  }

  private static int Maximo(int[][] numeros) {
    int maximo = Integer.MIN_VALUE;
    for (int fila = 0; fila <= FILAS; fila++) {
      for (int columna = 0; columna < COLUMNAS; columna++) {
        if (numeros[fila][columna] > maximo) {
          maximo = numeros[fila][columna];
        }
      }
    }
    return maximo;
  }

  private static int Minimo(int[][] numeros) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static void RellenaArrayAleatorios(int[][] numeros) {
    // TODO Auto-generated method stub
    
  }

  public static void MostrarArray(int[][] numeros) {
    // TODO Auto-generated method stub
    
  }
}
