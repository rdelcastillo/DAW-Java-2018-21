package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net). */

import java.util.Scanner;

public class Ej05CalcularGradosCelsius {

  // ################################################################################
  // Escribir un programa que convierta un valor dado en grados Fahrenheit a grados
  // Celsius.
  // ################################################################################
  // Análisis
  // Tenemos que leer una temperatura en grados Fahrenheit y devolverla en grados
  // celsius.
  // Datos de entrada: grados Fahrenheit (real)
  // Información de salida: grado Celsius (real)
  // Variables: fahrenheit, celsius (Real).
  // ################################################################################
  // Diseño
  // 1. Leer la temperatura en grados Fahrenheit
  // 2. Calcular los grados celsius (C = (F-32)*5/9)
  // 3. Mostrar grados celsius
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double celsius;
    double fahrenheit;

    System.out.print("Introduce la temperatura ºF: ");
    fahrenheit = s.nextDouble();
    celsius = (fahrenheit-32)*5/9;
    System.out.println("La temperatura es "+celsius+" ºC.");
  }


}

