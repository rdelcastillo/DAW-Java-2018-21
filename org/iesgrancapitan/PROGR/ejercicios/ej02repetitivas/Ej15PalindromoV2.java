package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej15PalindromoV2 {

  // ################################################################################
  // Introducir una cadena de caracteres e indicar si es un palíndromo. Una palabra
  // palíndroma es aquella que se lee igual adelante que atrás.
  // ################################################################################
  // Análisis
  // Leo una cadena. La paso a mayúsculas, le quito espacios y vocales con tilde,
  // después creo una nueva cadena invirtiendo la cadena anterior. Si ambas cadenas
  // son iguales-> Es un palíndromo.
  // Datos de entrada: Cadena de caracteres
  // Información de salida: Mensaje indicando si es palíndromo o no.
  // Variables: cadena, cadena1, cadena2, i (posición)
  //
  // Se diferencia del anterior en que en vez de "reemplazar" vocales con tilde y
  // espacios construimos una cadena nueva
  // ################################################################################

  public static void main(String args[]) {
    final String VOCALES_CON_TILDE = "ÁÉÍÓÚ";
    final String VOCALES_SIN_TILDE = "AEIOU";

    // Variables
    Scanner s = new Scanner(System.in);
    String cadena;        // cadena original
    String cadena1 = "";  // cadena original en mayúscula, sin espacios ni tildes
    String cadena2 = "";  // cadena anterior invertida

    // Pedimos datos
    System.out.print("Introduce una cadena para comprobar si es palíndroma: ");
    cadena = s.nextLine();

    // Proceso

    // Pasamos a mayúsculas la cadena orginal, quitamos tildes y espacios
    cadena = cadena.toUpperCase(); // mayúsculas
    for (int i=0; i<cadena.length(); i++) {
      String caracter = cadena.substring(i,i+1);  //caracter en posición i (como String)
      if (!caracter.equals(" ")) { // no es un espacio, añadimos carácter
        // comprobamos si es una vocal con tilde, si lo es la sustituimos
        int posicion = VOCALES_CON_TILDE.indexOf(caracter);
        if (posicion>=0) { // lleva tilde, "posicion" nos da el índice de la vocal sin tilde
          caracter = VOCALES_SIN_TILDE.substring(posicion,posicion+1);
        }
        cadena1 += caracter;
      }
    }

    // Invertimos cadena anterior
    for (int i=cadena1.length()-1; i>=0; i--) {
      cadena2 += cadena1.substring(i,i+1);
    }

    // ¿Es palíndromo?
    if (cadena1.equals(cadena2)) {
      System.out.println("Es un palíndromo");
    } else {
      System.out.println("No es un palíndromo");
    }

  }


}

