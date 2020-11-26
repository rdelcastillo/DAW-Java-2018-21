package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

import java.util.Scanner;

/**
 * Realiza un conversor del sistema decimal al sistema de “palotes”.
 * 
 * Ejemplo:
 * Por favor, introduzca un número entero positivo: 47021
 * El 47021 en decimal es el | | | | - | | | | | | | - - | | - | en el sistema de palotes.
 * 
 * Ejercicio 37 del libro "Aprende Java con Ejercicios" (edición 2019) de Luis J. Sánchez
 * 
 * En este enlace se puede ver cómo se ha hecho https://youtu.be/7RXfkXbssY8
 * 
 * @author Rafael del Castillo
 *
 */

public class Ej16ConversorDecimalPalotes {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Conversor decimal a sistema de palotes");
    System.out.println("--------------------------------------");

    // Pedimos datos
    System.out.print("Por favor, introduzca un número entero positivo: ");
    long num = s.nextLong();    // con s.nextInt() tendríamos un error con números grandes
    if (num <= 0) {
      System.err.println("El programa solo funciona con enteros positivos.");
    }

    // Averiguamos el número de dígitos
    int numDigitos = 0;
    long aux = num;
    while (aux > 0) {
      numDigitos++;
      aux = aux / 10;
    }

    // Conversión de cada dígito e impresión

    aux = num;
    for (int peso = numDigitos-1; peso > 0; peso--) {
      // Averiguamos dígito
      long potencia10 = (long) Math.pow(10, peso);
      int digito = (int) (aux / potencia10);
      aux = aux % potencia10;

      // Imprimimos palotes del dígito con el separador
      for (int i = 1; i <= digito; i++) {
        System.out.print("|");
      }
      System.out.print("-");
    }
    // Último dígito
    for (int i = 1; i <= aux; i++) {
      System.out.print("|");
    }

    // Fin
    s.close();
  }

}
