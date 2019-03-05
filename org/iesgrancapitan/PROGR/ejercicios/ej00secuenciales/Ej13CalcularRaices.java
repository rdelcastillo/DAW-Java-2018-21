package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;
/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej13CalcularRaices {

  // ################################################################################
  // Realizar un algoritmos que lea un número y que muestre su raíz cuadrada
  // y su raíz cúbica.
  // PSeInt no tiene ninguna función predefinida que permita calcular la raíz cúbica,
  // ¿cómo se puede calcular?
  // ################################################################################
  // Análisis
  // Se piden número y se muestra la raíz cuadrada y la cúbica.
  // Datos de entrada: numero (entero).
  // Información de salida: raíz cuadrada, raíz cúbica(real).
  // Variables: num (entero).
  // ################################################################################
  // Diseño
  // 1. Leer el número.
  // 2. Calcular raíz cuadrada: tenemos una función
  // 3. Calcular raíz cúbica: es igual que elevar el número a 1/3
  // 4. Mostrar las raíces
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int num;

    System.out.print("Dime el número: ");
    num = s.nextInt();

    System.out.println("Raíz cuadrada: "+Math.sqrt(num));
    System.out.println("Raíz cúbica: "+Math.pow(num,(double)1/3));
  }


}

