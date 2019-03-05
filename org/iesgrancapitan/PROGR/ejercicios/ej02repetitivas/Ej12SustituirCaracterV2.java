package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej12SustituirCaracterV2 {

  // ################################################################################
  // Pide una cadena y dos caracteres por teclado (valida que sea un carácter),
  // sustituye la aparición del primer carácter en la cadena por el segundo carácter.
  // ################################################################################
  // Análisis
  // Variación del ejercicio anterior usando las potencialidades de java, en este caso
  // usaremos el método replace de la clase String.
  // Datos de entrada: Cadena de caracteres, el carácter a buscar y a reemplazar.
  // Información de salida: Cadena con el carácter indicado cambiado por el segundo.
  // Variables:cad, cadenaNueva, caracterABuscar, caracterASustituir (carácter), posicion (entero)
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String cadena;
    String caracterABuscar;
    String caracterASustituir;
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
      caracterASustituir = s.nextLine();
    } while (caracterASustituir.length()!=1);

    // Proceso
    cadenaNueva = cadena.replace(caracterABuscar.charAt(0),caracterASustituir.charAt(0));
    System.out.println("La cadena modificada es "+cadenaNueva);
  }


}

