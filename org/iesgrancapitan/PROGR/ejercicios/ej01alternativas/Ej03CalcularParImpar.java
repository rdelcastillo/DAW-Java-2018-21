package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej03CalcularParImpar {

  // ################################################################################
  // Escribe un programa que lea un número e indique si es par o impar.
  // ################################################################################
  // Análisis
  // Tenemos que pedir un número por teclado, y comprobar si es par o impar.
  // Datos de entrada: número (entero)
  // Información de salida: Un mensaje de texto indicando si el número es par o impar.
  // Variables: num (enteros)
  // ################################################################################
  // Diseño
  // 1. Leer el numero
  // 2. Si el resto de dividir el número entre 2 es igual a 0 el número es par.
  // 3. En caso contrario es impar
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    
    System.out.print("Dime el número: ");
    int num = s.nextInt();
    
    if (num%2 == 0) {
      System.out.println("Es Par");
    } else {
      System.out.println("Es impar");
    }
  }


}

