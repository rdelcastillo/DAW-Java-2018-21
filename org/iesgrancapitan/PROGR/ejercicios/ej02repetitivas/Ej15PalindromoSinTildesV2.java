package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej15PalindromoSinTildesV2 {

  // ################################################################################
  // Introducir una cadena de caracteres e indicar si es un palíndromo. Una palabra
  // palíndroma es aquella que se lee igual adelante que atrás.
  // ################################################################################
  // Análisis
  // Leo una cadena. Uso dos índices (i,j) que recorren la cadena simultáneamente
  // uno por el principio y otro por el final, obvian los espacios y comparan sus caracteres,
  // si no coinciden acaba, si se cruzan los índices-> Es un palíndromo.
  // Datos de entrada: Cadena de caracteres
  // Información de salida: Mensaje indicando si es palíndromo o no.
  // Variables: cadena, i,j, esPalindromo
  // ################################################################################

  public static void main(String args[]) {

    // Variables
    Scanner s = new Scanner(System.in);
    String cadena;        // cadena original
    boolean esPalindromo = true;
    int i = 0;
    int j;

    // Pedimos datos
    System.out.print("Introduce una cadena para comprobar si es palíndroma: ");
    cadena = s.nextLine();

    // Proceso
    cadena = cadena.trim();  // quitamos espacios iniciales y finales de la cadena
    j = cadena.length()-1;
    while (esPalindromo && i<j) {
      // Si hay un espacio en la posición i saltamos
      while (cadena.charAt(i)==' ') {
        i++;
      }
      // Si hay un espacio en la posición j saltamos
      while (cadena.charAt(j)==' ') {
        j--;
      }
      if (i<j && !cadena.substring(i,i+1).equalsIgnoreCase(cadena.substring(j,j+1))) {
        esPalindromo = false;
      }
      i++;
      j--;
    }

    // ¿Es palíndromo?
    if (esPalindromo) {
      System.out.println("Es un palíndromo");
    } else {
      System.out.println("No es un palíndromo");
    }

  }


}

