package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas.arrays;

/**
 * Programa que genera 20 números enteros aleatorios entre 0 y 100 y los almacena en un array.
 * Después pasa todos los números pares a las primeras posiciones del array (del 0 en adelante)
 * y todos los números impares a las celdas restantes. 
 * 
 * Ejercicio 10 (arrays) de "Aprende Java con Ejercicios" (Ed.2019) 
 * de Luis José Sánchez González.
 *
 * @author Rafael del Castillo
 */

public class Ej23ArraysV2 {
  final static int N = 20;  // guardamos la cantidad a generar en una contante

  public static void main(String[] args) {
    int[] numeros = new int[N];     // números generados
    int[] pares = new int[N];       // pares de los números generados
    int[] impares = new int[N];     // impares de los números generados
    int contadorPares = 0;
    int contadorImpares = 0;
    
    // Generamos el array de números aleatorios y guardamos los pares e impares en arrays auxiliares
    for (int i = 0; i < numeros.length; i++) {
      numeros[i] = (int)(Math.random() * 101);
      
      // si es par, a los pares, si es impar, a los impares
      if (numeros[i] % 2 == 0) {
        pares[contadorPares++] = numeros[i];    // incrementamos también el contador
      } else {
        impares[contadorImpares++] = numeros[i]; 
      }
    }
    
    // Mostramos el array
    System.out.print("Array original:  ");
    muestraArray(numeros);    

    // Metemos los pares en las primeras posiciones del array original.
    for (int i = 0; i < contadorPares; i++) {
      numeros[i] = pares[i];
    }
    
    // Metemos los impares en las siguientes posiciones del array original.
    for (int i = contadorPares; i < N; i++) {
      numeros[i] = impares[i - contadorPares];
    }
    
    // Mostramos el array resultante
    System.out.print("Array resultado: ");
    muestraArray(numeros);
  }

  public static void muestraArray(int[] numeros) {
    for (int n: numeros) {
      System.out.printf("%3d ", n);
    }
    System.out.println();
  }
}
