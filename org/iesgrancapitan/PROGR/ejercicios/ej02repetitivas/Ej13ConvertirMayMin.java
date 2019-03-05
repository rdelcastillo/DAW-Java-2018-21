package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej13ConvertirMayMin {

  // ################################################################################
  // Realizar un programa que lea una cadena por teclado y convierta las mayúsculas a
  // minúsculas y viceversa.
  // ################################################################################
  // Análisis
  // Leo un cadena, la recorro y voy copiando cada carácter a otra cadena, teniendo en
  // cuenta que si es mayúsculas la convierto a minúsculas y viceversa.
  // Datos de entrada: Cadena de caracteres
  // Información de salida: Cadena con el cambio de mayúsculas a minúsculas y viceversa.
  // Variables:cadena, cadenaNueva  (carácter), posicion (entero)
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String cadena;
    String cadenaNueva = "";

    // Pedimos datos
    System.out.print("Introduce una cadena: ");
    cadena = s.nextLine();

    // Proceso
    for (int posicion=0; posicion<=cadena.length()-1; posicion++) {
      String letra = cadena.substring(posicion,posicion+1); // String con solo el carácter que está en la posición <posición>
      if (letra.equals(letra.toUpperCase())) {  // Está en mayúsculas, la convierto a minúsculas
        cadenaNueva += letra.toLowerCase();
      }
      else {
        cadenaNueva += letra.toUpperCase();
      }
    }
    System.out.println("La cadena convertida es: "+cadenaNueva);
  }


}

