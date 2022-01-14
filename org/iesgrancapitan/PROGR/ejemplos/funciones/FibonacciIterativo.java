package org.iesgrancapitan.PROGR.ejemplos.funciones;

import java.util.Scanner;

public class FibonacciIterativo {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Cálculo número serie Fibonnaci");
    System.out.println("------------------------------");
    
    System.out.print("Dame la posición del término que quieres saber (>=1): ");
    int num = s.nextInt();
    if (num < 1) {
      System.err.println("Número erróneo");
      System.exit(1);
    }
    
    System.out.println("El término número " + num + " es " + fibonnacci(num));
  }

  public static long fibonnacci(int n) {

    // caso trivial
    if (n == 1) {
      return 0;
    } 

    // casos generales
    long current = 1;
    long last = 0;
    for (int position = 3; position <= n; position++) {
      long currentOld = current;
      current += last;
      last = currentOld;
    }
    return current;
  }

}
