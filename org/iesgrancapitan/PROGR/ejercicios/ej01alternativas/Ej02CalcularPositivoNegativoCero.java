package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej02CalcularPositivoNegativoCero {

  // ################################################################################
  // Algoritmo que pida un número y diga si es positivo, negativo o 0.
  // ################################################################################
  // Análisis
  // Tenemos que pedir un número por teclado, compararlo con 0, e indicar si es igual,
  // mayor o menor que 0.
  // Datos de entrada: número (entero)
  // Información de salida: Un mensaje de texto indicando si el número es igual,
  // mayor o menor que 0.
  // Variables: num (enteros)
  // ################################################################################
  // Diseño
  // 1. Leer el numero
  // 2. Si el número es igual 0 escribir "Es igual a 0"
  // 3. En caso contrario si es mayor que 0 escribir "Es mayor que 0"
  // 4. En otro caso escribir "Es menor que 0"
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int num;

    System.out.print("Dime el número: ");
    num = s.nextInt();
    if (num==0) {
      System.out.println("Es igual a 0");
    } else if (num>0) {
        System.out.println("Es positivo");
    }
    else {
        System.out.println("Es negativo");
    }
  }


}

