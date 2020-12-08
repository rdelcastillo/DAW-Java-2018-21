package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas.arrays;

/**
 * Programa que genera 20 números enteros aleatorios entre 0 y 100 y los almacena en un array.
 * Después pasa todos los números pares a las primeras posiciones del array (del 0 en adelante)
 * y todos los números impares a las celdas restantes. 
 * 
 * Este programa admite mejoras.
 * 
 * Ejercicio 10 (arrays) de "Aprende Java con Ejercicios" (Ed.2019) 
 * de Luis José Sánchez González.
 *
 * @author Rafael del Castillo
 */

public class Ej23Arrays {
  final static int N = 20;  // guardamos la cantidad a generar en una contante

  public static void main(String[] args) {
    int[] numeros = new int[N];
    
    // Generamos el array de números aleatorios
    for (int i = 0; i < numeros.length; i++) {
      numeros[i] = (int)(Math.random() * 101);
    }
    
    // Mostramos el array
    System.out.print("Array original:  ");
    for (int n: numeros) {
      System.out.printf("%3d ", n);
    }
    System.out.println();
    
    // Guardamos los números pares en otro array
    int[] pares = new int[N];
    int contadorPares = 0;
    for (int n: numeros) {  // recorremos el array numeros para sacar los pares
      if (n % 2 == 0) {
        pares[contadorPares] = n;
        contadorPares++;
      }
    }
    
    // Guardamos los números impares en otro array
    int[] impares = new int[N];
    int contadorImpares = 0;
    for (int n: numeros) {  // recorremos numeros para sacar los pares
      if (n % 2 != 0) {
        impares[contadorImpares] = n;
        contadorImpares++;
      }
    }
    
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
    for (int n: numeros) {
      System.out.printf("%3d ", n);
    }
    System.out.println();
  }
}
