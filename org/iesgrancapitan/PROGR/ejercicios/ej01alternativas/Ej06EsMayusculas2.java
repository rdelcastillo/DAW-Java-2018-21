package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/**
 * Versión anterior con algunas modificaciones menores y con la identificación
 * de caracteres acentuados.
 */

import java.util.Scanner;

public class Ej06EsMayusculas2 {

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);

    // Pedir datos
    System.out.print("Introduce una cadena: ");
    String ch = s.nextLine();

    // Comprobamos y mostramos resultados
    if (ch.length()==1 
        && (ch.charAt(0) >= 'A' && ch.charAt(0) <= 'Z') 
            || ch.equals("Á") || ch.equals("É") || ch.equals("Í") || ch.equals("Ó") || ch.equals("Ú")
            || ch.equals("Ü") || ch.equals("Ñ")) {
      System.out.println("La cadena es una letra mayúscula");
    } else {
      System.out.println("La cadena no es una letra mayúscula");
    }
  }


}

