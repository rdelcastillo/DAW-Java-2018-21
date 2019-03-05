package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej04CalcularDivision {

  // ################################################################################
  // Crea un programa que pida al usuario dos números y muestre su división
  // si el segundo no es cero, o un mensaje de aviso en caso contrario.
  // ################################################################################
  // Análisis
  // Tenemos que pedir dos números, y mostrar el resultado de la división.
  // Si el divisor es 0 debemos responder un mensaje de error.
  // Datos de entrada: dividendo, divisor (entero)
  // Información de salida: El resultado de la división o un mensaje de error
  // indicando que el divisor es igual a 0.
  // Variables: dividendo,divisor (enteros)
  // ################################################################################
  // Diseño
  // 1. Leer los números
  // 2. Si el divisor es igual a 0 escribir "No se puede dividir por 0"
  // 3. En caso contrario mostrar el resultado de la división
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int dividendo;
    int divisor;

    System.out.print("Dime el número 1: ");
    dividendo = s.nextInt();
    System.out.print("Dime el número 2: ");
    divisor = s.nextInt();

    if (divisor==0) {
      System.out.println("No puedes dividir por 0");
    } else {
      System.out.println("La división es "+dividendo/divisor);
    }
  }


}

