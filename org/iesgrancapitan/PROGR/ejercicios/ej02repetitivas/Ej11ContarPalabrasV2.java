package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej11ContarPalabrasV2 {

  // ################################################################################
  // Suponiendo que hemos introducido una cadena por teclado que representa una frase
  // (palabras separadas por espacios), realiza un programa que cuente cuantas
  // palabras tiene.
  // ################################################################################
  // Análisis
  // Tengo que contar cuantos espacios hay en la frase, y tendré el número + 1 palabras.
  // No debo contar los espacios que puada haber antes de la primera palabra, y los
  // espacios al final de la frase. Además si entre palabras hay varios espacios sólo
  // puedo contar 1.
  // Datos de entrada: Frase
  // Información de salida: contador de palabras
  // Variables: cad (Caracter), posicion, cont (enteros)
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String cadena;
    int contadorPalabras = 0;

    // Pedimos datos
    System.out.print("Introduce una cadena: ");
    cadena = s.nextLine();

    // Borro los posibles espacios al principio y final de la cadena
    cadena = cadena.trim();

    // Si nos dan la cadena vacía terminamos la ejecución con un código de error
    if (cadena.isEmpty()) {
      System.out.println("Has introducido una cadena vacía, no hay nada que contar");
      System.exit(1);
    }

    // Desde el primer caracter distinto de espacio
    for (int posicion = 0; posicion<=cadena.length()-1; posicion++) {
      if (cadena.charAt(posicion)==' ') {
        contadorPalabras++;
        // No tengo en cuanta los posibles espacios que haya entre las palabras
        while (posicion<=cadena.length()-1 && cadena.charAt(posicion)==' ') {
          posicion++;
        }
      }
    }
    // Si no acaba en espacios tengo que contar la última palabra (no hace falta aquí)
    // if (!cadena.endsWith(" ")) {
    //   contadorPalabras++;
    // }
    contadorPalabras++;

    System.out.println("La cadena tiene "+contadorPalabras+" palabras.");
  }


}

