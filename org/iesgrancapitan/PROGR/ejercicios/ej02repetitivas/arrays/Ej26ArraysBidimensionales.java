package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas.arrays;

/**
 * Programa que calcule la estatura media, mínima y máxima en centímetros de personas
 * de diferentes países. El array que contiene los nombres de los paises es el siguiente: 
 * pais = {"España", "Rusia", "Japón", "Australia"}. 
 * 
 * Los datos sobre las estaturas se deben simular mediante un array de 4 filas por 
 * 10 columnas con números aleatorios generados al azar entre 140 y 210. Los decimales 
 * de la media se pueden despreciar. 
 * 
 * Los nombres de los países se deben mostrar utilizando el array de países (no se pueden
 * escribir directamente).
 * 
 * Ejercicio 13 (arrays bidimensionales) de "Aprende Java con Ejercicios" (Ed.2019) de 
 * Luis José Sánchez González.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Ej26ArraysBidimensionales {
  
  final static int COLUMNAS = 10;
  final static int ALEATORIO_INICIAL = 140;
  final static int ALEATORIO_FINAL = 210;
  final static String[] PAIS = {"España", "Rusia", "Japón", "Australia"};

  public static void main(String[] args) {
    int[][] estatura = new int[PAIS.length][COLUMNAS];   // habrá tantas filas como países
    int[] minimo = new int[PAIS.length];    // mínimos de cada país 
    int[] maximo = new int[PAIS.length];    // máximos de cada país
    int[] sumatorio = new int[PAIS.length]; // sumas de las estaturas de cada país
    
    // inicializamos sumatorios, mínimos y máximos
    for (int i = 0; i < PAIS.length; i++) {
      sumatorio[i] = 0;
      minimo[i] = Integer.MAX_VALUE;
      maximo[i] = Integer.MIN_VALUE;
    }
    
    // Cabecera tabla
    System.out.println(" ".repeat(16 + COLUMNAS*4) + "MED MÍN MÁX");
    
    // Generamos las estaturas y a la vez buscamos mínimos, máximos, hacemos sumatorios y escribimos
    for (int fila = 0; fila < PAIS.length; fila++) {
      
      // mostramos el país
      System.out.printf("%12s: ", PAIS[fila]);

      // generamos tantas estaturas como columnas
      for (int columna = 0; columna < COLUMNAS; columna++) {
        
        // generamos estatura y la mostramos
        estatura[fila][columna] = ALEATORIO_INICIAL +   
                                  (int)(Math.random() * (ALEATORIO_FINAL - ALEATORIO_INICIAL + 1));
        System.out.printf("%3d ", estatura[fila][columna]);
        
        // actualizamos cálculos
        sumatorio[fila] += estatura[fila][columna];     // actualizamos sumatorio (para calcular la media)
        if (estatura[fila][columna] < minimo[fila]) {   // ¿nuevo mínimo?
          minimo[fila] = estatura[fila][columna];
        }
        if (estatura[fila][columna] > maximo[fila]) {   // ¿nuevo máximo?
          maximo[fila] = estatura[fila][columna];
        }
      }
      
      // mostramos media, mínimo y máximo
      System.out.printf("| %3d ", sumatorio[fila] / COLUMNAS);
      System.out.printf("%3d ", minimo[fila]);
      System.out.printf("%3d\n", maximo[fila]);
    }
    
  }

}
