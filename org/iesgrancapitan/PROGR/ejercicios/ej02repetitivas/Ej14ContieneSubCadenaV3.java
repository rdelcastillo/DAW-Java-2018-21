package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej14ContieneSubCadenaV3 {

  // ################################################################################
  // Realizar un programa que compruebe si una cadena contiene una subcadena.
  // Las dos cadenas se introducen por teclado.
  // ################################################################################
  // Análisis
  // Java tiene funciones que hacen esto, no necesito hacer las operaciones de la
  // versión anterior.
  // Datos de entrada: Cadena de caracteres y subcadena a buscar.
  // Información de salida: Mensaje indicadndo si la cadea contiene la subcadena o no.
  // Variables:cadena, subcadena  (carácter), numSubcadenas,nsubc (entero),
  // estaSubcadena (lógico)
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String cadena;
    String subcadena;

    // Pedimos datos
    System.out.print("Introduce una cadena: ");
    cadena = s.nextLine();
    System.out.print("Introduce una subcadena a buscar en la cadena anterior: ");
    subcadena = s.nextLine();

    // Proceso
    if (cadena.contains(subcadena)) {
      System.out.println("La cadena contiene la subcadena.");
    } else {
      System.out.println("La cadena no contiene la subcadena.");
    }
  }


}

