package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej12CalcularYearBisiesto {

  // ################################################################################
  // Escribir un programa que lea un año indicar si es bisiesto.
  // Nota: un año es bisiesto si es un número divisible por 4, pero no si es
  // divisible por 100, excepto que también sea divisible por 400.
  // ################################################################################
  // Análisis
  // Pedir un año y comprobar si es bisiesto.
  // Datos de entrada: el año (entero)
  // Información de salida: Si el año es bisiesto o no
  // Variables: year (entero)
  // ################################################################################
  // Diseño
  // 1.Leer year
  // 2.Si el año es divisible por 4, pero no si es divisible por 100, excepto que
  // también sea divisible por 400 mostrar "Año bisiesto"
  // 3. En caso contrario, mostrar "Año no bisiesto"
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int year;

    // Pedimos datos
    System.out.print("Introduce el año: ");
    year = s.nextInt();

    // Proceso
    if ((year%4==0 && !(year%100==0)) || year%400==0) {
      System.out.println("Año bisiesto.");
    } else {
      System.out.println("Año no bisiesto.");
    }
  }


}

