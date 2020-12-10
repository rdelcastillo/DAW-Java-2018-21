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
 */

public class Ej25ArraysBidimensionales {
  
  final static int FILAS = 2;
  final static int COLUMNAS = 3;
  final static int ALEATORIO_INICIAL = 0;
  final static int ALEATORIO_FINAL = 1000;

  public static void main(String[] args) {
    int[][] numeros = new int[FILAS][COLUMNAS];     // array de números
    
    // Inicialización de variables
    
    int filaMaximo = 0;     // posición máximo
    int columnaMaximo = 0;

    int filaMinimo = 0;     // posición mínimo
    int columnaMinimo = 0;
    
    // Rellenamos array de números aleatorios
    
    for (int fila = 0; fila < FILAS; fila++) {
      for (int columna = 0; columna < COLUMNAS; columna++) {

        // generamos un número aleatorio nuevo y que no exista en el array
        boolean estaAleatorioEnArray;  // interruptor

        do {
          // generamos número aleatorio candidato
          numeros[fila][columna] = ALEATORIO_INICIAL + 
                                  (int)(Math.random() * (ALEATORIO_FINAL - ALEATORIO_INICIAL + 1));
          
          // ¿está ese aleatorio en el array? lo buscamos...
          estaAleatorioEnArray = false;
          int numerosGenerados = fila*COLUMNAS + columna;   // números generados y guardados en el array
          
          for (int i = 0; i < numerosGenerados && !estaAleatorioEnArray; i++) {
            // calculamos fila y columna del array al que corresponde la posición i
            int f = i / COLUMNAS;
            int c = i % COLUMNAS;
            // ¿está el número aleatorio generado en esa posición?
            if (numeros[fila][columna] == numeros[f][c]) {
              estaAleatorioEnArray = true;
            }
          }
        } while (estaAleatorioEnArray); // si está el aleatorio en el array repetimos

        // ¿es un nuevo máximo o mínimo el número generado?
        if (numeros[fila][columna] > numeros[filaMaximo][columnaMaximo]) {
          filaMaximo = fila;
          columnaMaximo = columna;
        } else if (numeros[fila][columna] < numeros[filaMinimo][columnaMinimo]) {
          filaMinimo = fila;
          columnaMinimo = columna;
        }
      }
    }
    
    // Mostramos array
    for (int fila = 0; fila < FILAS; fila++) {
      for (int columna = 0; columna < COLUMNAS; columna++) {
        System.out.printf("%5d ", numeros[fila][columna]);
      }
      System.out.println();
    }
    
    // Mostramos posición máximo y mínimo
    System.out.println("\nMáximo: " + numeros[filaMaximo][columnaMaximo] + 
                        " en (" + filaMaximo + "," + columnaMaximo + ")");
    System.out.println("Mínimo: " + numeros[filaMinimo][columnaMinimo] + 
        " en (" + filaMinimo + "," + columnaMinimo + ")");
  }

}
