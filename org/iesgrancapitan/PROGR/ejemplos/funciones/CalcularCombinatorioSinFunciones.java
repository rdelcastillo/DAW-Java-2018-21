package org.iesgrancapitan.PROGR.ejemplos.funciones;

import java.util.Scanner;

/**
 * Este programa pide dos números (n y m) y calcula su combinatorio si n>m.
 * Si las condiciones no se cumplen terminamos con el programa.
 * 
 * Mucho más eficaz usar funciones para resolverlo.
 * 
 * @author rafa
 *
 */

public class CalcularCombinatorioSinFunciones {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.println("Cálculo del combinatorio de dos números");
    System.out.println("---------------------------------------");
    
    // Petición de datos
    System.out.print("Dame el valor de n: ");
    int n = s.nextInt();    // parte superior del combinatorio
    System.out.print("Dame el valor de m: ");
    int m = s.nextInt();    // parte inferior del combinatorio
    
    // ¿Todo correcto?
    if (m >= n || n < 1 || m < 1) {   // datos erróneos
      System.err.println("Datos de entrada erróneos.");
      System.exit(1);
    }
    
    // Cálculos: combinatorio = n! / (m! - (n-m)!)
    long factorialN = 1;
    for (int i = n; i >= 2; i--) {
      factorialN *= i;
    }
    
    long factorialM = 1;
    for (int i = m; i >= 2; i--) {
      factorialM *= i;
    }
    
    long factorialNminusM = 1;
    for (int i = n-m; i >= 2; i--) {
      factorialNminusM *= i;
    }
    
    long combinatorial = factorialN / (factorialM * factorialNminusM);
    
    // Resultados
    System.out.printf("El número combinatorio de %d sobre %d es %d\n", n, m, combinatorial);
  }

}
