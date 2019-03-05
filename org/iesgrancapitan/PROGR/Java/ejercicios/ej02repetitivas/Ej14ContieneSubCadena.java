package org.iesgrancapitan.PROGR.Java.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej14ContieneSubCadena {

  // ################################################################################
  // Realizar un programa que compruebe si una cadena contiene una subcadena.
  // Las dos cadenas se introducen por teclado.
  // ################################################################################
  // Análisis
  // Leo dos cadenas. Tengo que ir comprobando todas las subcadenas de la primera
  // cadena que tengan la misma longitud que la segunda. Si alguna de estas subcadenas
  // es igual a la segunda, la primera cadena contiene la segunda.
  // Datos de entrada: Cadena de caracteres y subcadena a buscar.
  // Información de salida: Mensaje indicando si la cadea contiene la subcadena o no.
  // Variables:cadena, subcadena  (carácter), numSubcadenas,nsubc (entero),
  // estaSubcadena (lógico)
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String cadena;
    String subcadena;
    boolean estaSubcadena = false;
    int numSubcadenas;

    // Pedimos datos
    System.out.print("Introduce una cadena: ");
    cadena = s.nextLine();
    System.out.print("Introduce una subcadena a buscar en la cadena anterior: ");
    subcadena = s.nextLine();

    // Proceso
    numSubcadenas = cadena.length()-subcadena.length()+1;
    for (int nsubc=0; nsubc<=numSubcadenas-1 && !estaSubcadena; nsubc++) {
      if (cadena.substring(nsubc,nsubc+subcadena.length()).equals(subcadena)) {
        estaSubcadena = true;
      }
    }
    if (estaSubcadena) {
      System.out.println("La cadena contiene la subcadena.");
    } else {
      System.out.println("La cadena no contiene la subcadena.");
    }
  }


}

