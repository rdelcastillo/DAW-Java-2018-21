package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/**
 * En esta versión usaremos métodos estáticos de la clase Character.
 * 
 */

import java.util.Scanner;

public class Ej06EsMayusculas4 {

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);

    // Pedir datos
    System.out.print("Introduce una cadena: ");
    String ch = s.nextLine();

    // Comprobamos y mostramos resultados
    if (ch.length()==1 && Character.isUpperCase(ch.charAt(0))) {     
      System.out.println("La cadena es una letra mayúscula");
    } else {
      System.out.println("La cadena no es una letra mayúscula");
    }
  }


}

