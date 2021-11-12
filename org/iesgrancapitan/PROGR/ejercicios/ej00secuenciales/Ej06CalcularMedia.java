package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej06CalcularMedia {

  // ################################################################################
  // Calcular la media de tres números pedidos por teclado
  // ################################################################################
  // Análisis
  // Tenemos que leer tres números y calcular la media. Suma50enteros de los tres partido 3.
  // Datos de entrada: los tres números (real)
  // Información de salida: la media (real)
  // Variables: num1,num2,num3, media (Real).
  // ################################################################################
  // Diseño
  // 1. Leer los tres nÃºmeros
  // 2. Calcular la media: (num1+num2+num3)/3
  // 3. Mostrar la media
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double media;
    double num1;
    double num2;
    double num3;

    System.out.print("Introduce el número 1: ");
    num1 = s.nextDouble();
    System.out.print("Introduce el número 2: ");
    num2 = s.nextDouble();
    System.out.print("Introduce el número 3: ");
    num3 = s.nextDouble();

    media = (num1+num2+num3)/3;
    System.out.println("La media es "+media);
  }


}

