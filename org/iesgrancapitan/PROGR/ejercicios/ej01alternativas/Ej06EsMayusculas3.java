package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/**
 * Versión anterior con algunas modificaciones menores y con la identificación
 * de caracteres acentuados.
 */

import java.util.Scanner;

public class Ej06EsMayusculas3 {

  public static void main(String args[]) {
    String MAYUSCULAS_ESPECIALES = "ÁÉÍÓÚÜÑ";
    Scanner s = new Scanner(System.in);

    // Pedir datos
    System.out.print("Introduce una cadena: ");
    String ch = s.nextLine();

    // Comprobamos y mostramos resultados
    if (ch.length()==1                                      // un solo carácter
        && ((ch.charAt(0) >= 'A' && ch.charAt(0) <= 'Z')    // carácter en mayúsculas
        || MAYUSCULAS_ESPECIALES.indexOf(ch) != -1))  {     // ó vocal con tilde, Ñ ó Ü
      System.out.println("La cadena es una letra mayúscula");
    } else {
      System.out.println("La cadena no es una letra mayúscula");
    }
  }


}

