package org.iesgrancapitan.PROGR.ejemplos.ej03funciones;

import java.util.Scanner;

/**
 * Este programa pide dos números (n y m) y calcula su combinatorio si n>m.
 * Si las condiciones no se cumplen terminamos con el programa.
 * 
 * @author rafa
 *
 */

public class CalcularCombinatorioConFunciones {

  public static void main(String[] args) {
    int n;          // parte superior del combinatorio
    int m;          // parte inferior del combinatorio
    long combinatorio;
    Scanner s = new Scanner(System.in);
    
    System.out.println("Cálculo del combinatorio de dos números");
    System.out.println("---------------------------------------");
    
    // Petición de datos
    System.out.print("Dame el valor de n: ");
    n = s.nextInt();
    System.out.print("Dame el valor de m: ");
    m = s.nextInt();
    
    // ¿Todo correcto?
    if (m>=n || n<1 || m<1) {   // datos erróneos
      System.err.println("Datos de entrada erróneos.");
      System.exit(1);
    }
    
    // Cálculos
    combinatorio = factorial(n) / (factorial(m) * factorial(n-m));
    
    // Resultados
    System.out.printf("El número combinatorio de %d sobre %d es %d\n", n, m, combinatorio);
  }

  /**
   * Calcula y devuelve el factorial de un número.
   * 
   * @param num número a calcular.
   * @return factorial
   */
  static public long factorial(int num) {
    long f = 1;
    
    for (int i=num; i>1; i--) {   
      f *= i;
    }
    
    return f;
    
  }
}
