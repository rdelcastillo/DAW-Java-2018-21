package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/**
 * Programa que pida dos números e indique si el primero es mayor que el segundo.
 * 
 * Versión mejorada.
 * 
 */

import java.util.Scanner;

public class Ej01CalcularMayor2 {

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
        
    // Entrada de datos
    
    System.out.print("Dime el número 1: ");
    int num1 = s.nextInt();

    System.out.print("Dime el número 2: ");
    int num2 = s.nextInt();
    
    // Salida
    
    if (num1 > num2) {
      System.out.printf("%d es mayor que %d\n", num1, num2);
    } else {
      System.out.printf("%d NO es mayor que %d\n", num1, num2);
    }
  }


}

