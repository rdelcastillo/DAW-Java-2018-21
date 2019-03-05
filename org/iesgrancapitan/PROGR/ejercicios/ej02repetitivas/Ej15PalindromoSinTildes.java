package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej15PalindromoSinTildes {

  // ################################################################################
  // Introducir una cadena de caracteres e indicar si es un palíndromo. Una palabra
  // palíndroma es aquella que se lee igual adelante que atrás.
  // ################################################################################
  // Análisis
  // Leo una cadena. La paso a mayúsculas, le quito espacios y
  // después creo una nueva cadena invirtiendo la cadena anterior. Si ambas cadenas
  // son iguales-> Es un palíndromo.
  // Datos de entrada: Cadena de caracteres
  // Información de salida: Mensaje indicando si es palíndromo o no.
  // Variables: cadena, cadena1, cadena2, i (posición)
  // ################################################################################

  public static void main(String args[]) {

    // Variables
    Scanner s = new Scanner(System.in);
    String cadena;        // cadena original
    String cadena1 = "";  // cadena original en mayúscula, sin espacios ni tildes
    String cadena2 = "";  // cadena anterior invertida

    // Pedimos datos
    System.out.print("Introduce una cadena para comprobar si es palíndroma: ");
    cadena = s.nextLine();

    // Proceso

    // Pasamos a mayúsculas la cadena orginal y quitamos espacios
    cadena1 = cadena.toUpperCase(); // mayúsculas
    cadena1 = cadena1.replace(" ","");

    // Invertimos cadena anterior
    for (int i=cadena1.length()-1; i>=0; i--) {
      cadena2 += cadena1.charAt(i);
    }

    // ¿Es palíndromo?
    if (cadena1.equals(cadena2)) {
      System.out.println("Es un palíndromo");
    } else {
      System.out.println("No es un palíndromo");
    }

  }


}

