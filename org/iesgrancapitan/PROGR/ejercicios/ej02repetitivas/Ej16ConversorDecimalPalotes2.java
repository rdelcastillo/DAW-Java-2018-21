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
 * @author Rafael del Castillo
 *
 */

public class Ej16ConversorDecimalPalotes2 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Conversor decimal a sistema de palotes");
    System.out.println("--------------------------------------");

    // Pedimos datos
    System.out.print("Introduzca un número entero positivo: ");
    String num = s.nextLine();  
    if (Long.parseLong(num) <= 0) {
      System.err.println("El programa solo funciona con enteros positivos.");
    }

    // Proceso

    // Conversión de cada dígito e impresión
    String palotes = "";
    for (char d: num.toCharArray()) {
      int digito = Integer.parseInt(d + "");    // Averiguamos dígito
      palotes += "|".repeat(digito) + "-";
    }
    palotes = palotes.substring(0, palotes.length()-1);

    // Fin
    System.out.println(palotes);
    s.close();
  }

}
