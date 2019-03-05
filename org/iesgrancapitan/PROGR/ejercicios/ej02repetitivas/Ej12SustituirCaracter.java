package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej12SustituirCaracter {

  // ################################################################################
  // Pide una cadena y dos caracteres por teclado (valida que sea un carácter),
  // sustituye la aparición del primer carácter en la cadena por el segundo carácter.
  // ################################################################################
  // Análisis
  // Leo un cadena y dos caracteres, recorro la cadena, si encuentro un carácter
  // igual al primer carácter que he leído lo sustituyo por el segundo. Para ello voy
  // a ir copiando los caracteres de la cadena a otra cadena, cuando tenga que
  // sustituir un carácter por otro copiaré el segundo.
  // Datos de entrada: Cadena de caracteres, el carácter a buscar y a reemplazar.
  // Información de salida: Cadena con el carácter indicado cambiado por el segundo.
  // Variables:cad, cadenaNueva, caracterABuscar, caracterParaSustituir (carácter), posicion (entero)
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String cadena;
    String caracterABuscar;
    String caracterParaSustituir;
    String cadenaNueva = "";

    // Pedimos datos
    System.out.print("Introduce una cadena: ");
    cadena = s.nextLine();
    do {
      System.out.print("Introduce un carácter a buscar: ");
      caracterABuscar = s.nextLine();
    } while (caracterABuscar.length()!=1);
    do {
      System.out.print("Introduce un carácter para sustituir: ");
      caracterParaSustituir = s.nextLine();
    } while (caracterParaSustituir.length()!=1);

    // Proceso
    for (int posicion=0; posicion<=cadena.length()-1; posicion++) {
      if (cadena.charAt(posicion)==caracterABuscar.charAt(0)) {
        cadenaNueva += caracterParaSustituir;
        // Más posibilidades:
        //cadenaNueva = cadenaNueva.concat(caracterParaSustituir);
      } else {
        cadenaNueva = cadenaNueva.concat(cadena.substring(posicion,posicion+1));
        // Más posibilidades:
        // cadenaNueva += cadena.substring(posicion,posicion+1);
        // cadenaNueva += String.valueOf(cadena.charAt(posicion));
        // cadenaNueva += Character.toString(cadena.charAt(posicion));
      }
    }
    System.out.println("La cadena modificada es "+cadenaNueva);
  }


}

