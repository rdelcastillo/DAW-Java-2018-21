package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej01CalcularMayor {

  // ################################################################################
  // Algoritmo que pida dos números e indique si el primero es mayor que el segundo.
  // ################################################################################
  // Análisis
  // Tenemos que pedir dos números por teclado, compararlos 
  // e indicar si el primero es mayor que el segundo o no.
  // Datos de entrada: número 1, número 2 
  // Información de salida: Un mensaje de texto indicando si es mayor.
  // Variables: num1,num2 (enteros)
  // ################################################################################
  // Diseño
  // 1. Leer los números
  // 2. Si el número 1 es mayor que el segundo escribir "El primero es mayor"
  // 3. En caso contrario escribir "El primero no es mayor que el segundo"
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    
    int num1;
    int num2;
    
    // Entrada de datos
    
    System.out.println("Dime el número 1:");
    num1 = s.nextInt();
    
    System.out.println("Dime el número 2:");
    num2 = s.nextInt();
    
    // Salida
    
    if (num1 > num2) {
      System.out.println("Número 1 es mayor que número 2");
    } else {
      System.out.println("Número 1 NO es mayor que número 2");
    }
  }


}

