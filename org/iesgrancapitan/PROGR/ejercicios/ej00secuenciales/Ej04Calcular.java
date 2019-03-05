package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net). */

import java.util.Scanner;

public class Ej04Calcular {

  // ################################################################################
  // Dados dos números, mostrar la suma, resta, división y multiplicación de ambos.
  // ################################################################################
  // Análisis
  // Tenemos que leer dos números, calcular la suma, resta, multiplicación y división
  // Datos de entrada: Los dos números (real)
  // Información de salida: suma, resta, multiplicación, división(real)
  // Variables: num1, num2 (Real).
  // Considero que las salidas no es necesario guardarla en variables.
  // ################################################################################
  // Diseño
  // 1. Leer los números
  // 2. Mostrar suma,resta, multiplicación y división
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double num1;
    double num2;

    System.out.print("Introduce el número 1: ");
    num1 = s.nextDouble();
    System.out.print("Introduce el número 2: ");
    num2 = s.nextDouble();

    System.out.println("La suma es "+(num1+num2));
    System.out.println("La resta es "+(num1-num2));
    System.out.println("La multiplicación es "+(num1*num2));
    System.out.println("La división es "+(num1/num2));
  }


}

