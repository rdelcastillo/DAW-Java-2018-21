package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;
/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej18Iniciales {

  // ################################################################################
  // Pedir el nombre y los dos apellidos de una persona y mostrar las iniciales.
  // ################################################################################
  // Análisis
  // Hay que pedir el nombre y los apellidos, y mostrar las iniciales.
  // Primer carácter de cada cadena.
  // Datos de entrada: nombre y apellidos (cadena)
  // Información de salida: Iniciales (cadena)
  // Variables: nombre, apellido1, apellido2, inicial (cadena).
  // ################################################################################
  // Diseño
  // 1. Leer nombre y apellidos
  // 2. Obtener primer carácter de cada cadena
  // 3. Concatenar los caracteres
  // 4. Mostrar iniciales
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String apellido1;
    String apellido2;
    String inicial;
    String nombre;

    System.out.print("Dime tu nombre: ");
    nombre = s.nextLine();
    System.out.print("Dime tu primer apellido: ");
    apellido1 = s.nextLine();
    System.out.print("Dime tu segundo apellido: ");
    apellido2 = s.nextLine();

    inicial = nombre.substring(0,1);
    inicial = inicial.concat(apellido1.substring(0,1));
    inicial = inicial.concat(apellido2.substring(0,1));
    inicial = inicial.toUpperCase();

    System.out.println("Las iniciales son: "+inicial);
  }


}

