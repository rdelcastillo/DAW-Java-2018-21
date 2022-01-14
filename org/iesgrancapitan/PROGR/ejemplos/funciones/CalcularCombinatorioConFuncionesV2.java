package org.iesgrancapitan.PROGR.ejemplos.funciones;

import java.util.Scanner;

/**
 * Este programa pide dos números (n y m) y calcula su combinatorio si n>m.
 * Si las condiciones no se cumplen terminamos con el programa.
 * 
 * @author rafa
 *
 */

public class CalcularCombinatorioConFuncionesV2 {

  public static void main(String[] args) {        
    printPresentation();
    
    int n = readInt("Dame el valor de n: ");
    int m = readInt("Dame el valor de m: ");
    exitIfWrong(n, m);
    
    long combinatorial = factorial(n) / (factorial(m) * factorial(n-m));
    System.out.printf("El número combinatorio de %d sobre %d es %d\n", n, m, combinatorial);
  }

  public static void printPresentation() {
    System.out.println("Cálculo del combinatorio de dos números");
    System.out.println("---------------------------------------");
  }

  public static int readInt(String prompt) {
    Scanner s = new Scanner(System.in);
    System.out.print(prompt);
    return s.nextInt();
  }

  public static void exitIfWrong(int n1, int n2) {
    if (n2 >= n1 || n1 < 1 || n2 < 1) {   // datos erróneos
      System.err.println("Datos de entrada erróneos.");
      System.exit(1);
    }
  }

  /**
   * Calcula y devuelve el factorial de un número.
   * 
   * @param num número a calcular.
   * @return factorial
   */
  static public long factorial(int num) {
    long f = 1;
    for (int i = num; i > 1; i--) {   
      f *= i;
    }
    return f;
  }
}
