package org.iesgrancapitan.PROGR.ejemplos.funciones;

import java.util.Scanner;

public class FactorialRecursivo {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.print("Dame un número mayor o igual a 1 para calcular su factorial: ");
    int num = s.nextInt();
    if (num < 1) {
      System.err.println("Número erróneo");
      System.exit(1);
    }
    
    System.out.println("El factorial de " + num + " es " + factorial(num));
  }

  public static long factorial(int n) {
    return (n == 1) ? 1 : n*factorial(n-1);
  }

}
