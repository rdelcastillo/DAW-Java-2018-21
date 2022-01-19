package org.iesgrancapitan.PROGR.ejercicios.ej03funciones;

import static org.iesgrancapitan.PROGR.ejercicios.ej03funciones.arrays.FuncionesEj20a28.*;
import java.util.Scanner;

public class PruebaFuncionesEjercicios20a28 {
  public static void main(String[] args) {
    int [] array = generaArrayInt(5, 0, 9);
    imprimeArray("Array aleatorio", array);
    System.out.println();
    
    volteaArrayInt(array);
    imprimeArray("Array volteado", array);
    volteaArrayInt(array);
    imprimeArray("Array volteado de nuevo", array);
    System.out.println();
    
    rotaDerechaArrayInt(array, 1);
    imprimeArray("Rotamos 1 a la derecha", array);
    rotaDerechaArrayInt(array, 2);
    imprimeArray("Rotamos 2 a la derecha", array);
    rotaDerechaArrayInt(array, 13);
    imprimeArray("Rotamos 13 a la derecha", array);
    System.out.println();
    
    rotaIzquierdaArrayInt(array, 1);
    imprimeArray("Rotamos 1 a la izquierda", array);
    rotaIzquierdaArrayInt(array, 2);
    imprimeArray("Rotamos 2 a la izquierda", array);
    rotaIzquierdaArrayInt(array, 13);
    imprimeArray("Rotamos 13 a la izquierda", array);
    
    System.out.println("\nMínimo: " + minimoArrayInt(array));
    System.out.println("Máximo: " + maximoArrayInt(array));
    System.out.println("Media:  " + mediaArrayInt(array));
    
    int n = leeInt("\nDame un número y te diré si está en el array: ");
    if (estaEnArrayInt(array, n)) {
      System.out.println(n + " está en la posición " + posicionEnArray(array, n) + " del array.");
    } else {
      System.out.println(n + " no está en el array.");
    }
    
  }

  public static void imprimeArray(String titulo, int[] array) {
    System.out.printf("%-27s", titulo + ":");
    for (int n : array) {   // podríamos imprimir el array con Arrays.toString()
      System.out.print(n + " ");
    }
    System.out.println();
  }
  
  public static int leeInt(String prompt) {
    Scanner s = new Scanner(System.in);
    System.out.print(prompt);
    return s.nextInt();
  }

}
