package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

import java.util.Scanner;

/**
 * Programa que pinta la letra U por pantalla hecha con asteriscos. 
 * El programa pedirá la altura. 
 * El programa inserta un espacio y pinta dos asteriscos menos en la base para 
 * simular la curvatura de las esquinas inferiores.
 * 
 * Ejemplo 1:
 * Introduzca la altura de la U: 5
 * 
 * *     *
 * *     *
 * *     *
 * *     *
 *  * * *
 *  
 * Ejemplo 2:
 * Introduzca la altura de la U: 4
 * 
 * *    *
 * *    *
 * *    *
 *  *  *
 * 
 * @author rafa
 *
 */

public class Ej17DibujaU {

  public static void main(String[] args) {
    System.out.println("Dibujo de una U personalizada");
    System.out.println("-----------------------------");
    
    // Petición de datos
    Scanner s = new Scanner(System.in);
    System.out.print("Altura de la U: ");
    int altura = s.nextInt();
    
    if (altura <= 2) {   // altura insuficiente para dibujar
      System.err.println("Altura insuficiente para dibujar una U");
      System.exit(1);
    }
    
    // Escribir parte superior de la U
    for (int fila = 1; fila < altura; fila++) {
      System.out.print("*");
      for (int blanco = 1; blanco <= altura-2; blanco++) {
        System.out.print(" ");
      }
      System.out.println("*");
    }
    
    // Escribir la base
    System.out.print(" ");
    for (int asterisco = 1; asterisco <= altura-2; asterisco++) {
      System.out.print("*");
    }
    System.out.println(" ");

  }

}
