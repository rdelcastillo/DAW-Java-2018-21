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
 */

public class Ej25ArraysBidimensionalesConFunciones {

  final static int FILAS = 6;
  final static int COLUMNAS = 10;
  final static int ALEATORIO_INICIAL = 0;
  final static int ALEATORIO_FINAL = 1000;

  public static void main(String[] args) {
    int[][] numeros = new int[FILAS][COLUMNAS];     // array de números

    rellenaArrayAleatorios(numeros);  // rellena el array de números aleatorios que no se repiten
    muestraArray(numeros);
    muestraPosicion(numeros, maximo(numeros), "Máximo");
    muestraPosicion(numeros, minimo(numeros), "Mínimo");
  }

  /**
   * Calcula el máximo de los valores del array pasado como parámetro.
   * @param numeros array de enteros.
   * @return valor máximo.
   */
  public static int maximo(int[][] numeros) {
    int max = Integer.MIN_VALUE;

    for (int fila = 0; fila < FILAS; fila++) {
      for (int columna = 0; columna < COLUMNAS; columna++) {
        if (numeros[fila][columna] > max) {
          max = numeros[fila][columna];
        }
      }
    }
    return max;
  }

  /**
   * Calcula el mínimo de los valores del array pasado como parámetro.
   * @param numeros array de enteros.
   * @return valor mínimo.
   */
  private static int minimo(int[][] numeros) {
    int min = Integer.MAX_VALUE;

    // también podemos acceder con un foreach, comparad con la función anterior 
    for (int[] fila: numeros) {
      for (int n: fila) {
        if (n < min) {
          min = n;
        }
      }
    }
    return min;
  }

  /**
   * Rellena el array pasado como parámetro de números aleatorios que no se repiten.
   * @param numeros
   */
  public static void rellenaArrayAleatorios(int[][] numeros) {

    // vector donde guardaremos true si el aleatorio generado está en el array y false si no está
    boolean[] estaEnArray = new boolean[ALEATORIO_FINAL - ALEATORIO_INICIAL + 1];

    // lo inicializamos a false, de momento no hay ninguno en el array
    for (int i = 0; i < estaEnArray.length; i++) {
      estaEnArray[i] = false;
    }

    // proceso
    for (int fila = 0; fila < FILAS; fila++) {
      for (int columna = 0; columna < COLUMNAS; columna++) {

        // generamos un número aleatorio nuevo y que no exista en el array
        int n;
        do {
          // generamos número aleatorio candidato
          n = ALEATORIO_INICIAL + (int)(Math.random() * (ALEATORIO_FINAL - ALEATORIO_INICIAL + 1));
        } while (estaEnArray[n - ALEATORIO_INICIAL]);   // si está el aleatorio ya generado repetimos

        estaEnArray[n - ALEATORIO_INICIAL] = true;      // lo marcamos como generado
        numeros[fila][columna] = n;                     // asignamos aleatorio
      }
    }
  }

  /**
   * Muestra el array de números por pantalla.
   * 
   * @param numeros
   */
  public static void muestraArray(int[][] numeros) {
    for (int[] fila: numeros) {
      for (int n: fila) {
        System.out.printf("%5d ", n);
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * Muestra las posiciones del array en las que aparece un valor determinado.
   * 
   * @param numeros array donde buscar.
   * @param valor valor a buscar.
   * @param etiqueta cadena de caracteres que identifica al valor
   */
  public static void muestraPosicion(int[][] numeros, int valor, String etiqueta) {
    System.out.print(etiqueta + ": " + valor + " en ");
    for (int fila = 0; fila < FILAS; fila++) {
      for (int columna = 0; columna < COLUMNAS; columna++) {
        if (numeros[fila][columna] == valor) {
          System.out.println("(" + fila + "," + columna + ") ");
          return;   // solo hay un valor, lo hemos encontrado, podemos terminar
        }
      }
    }
  }

}
