package org.iesgrancapitan.PROGR.ejemplos.repetitivas;

import java.util.Scanner;

/**
 * Este programa pide dos números (n y m) y calcula su combinatorio si n>m.
 * Si las condiciones no se cumplen terminamos con el programa.
 * 
 * @author rafa
 *
 */

public class CalcularCombinatorio {

  public static void main(String[] args) {
    int n;          // parte superior del combinatorio
    int m;          // parte inferior del combinatorio
    long factN = 1;  // factorial de n
    long factM = 1;  // factorial de m
    long factNM = 1; // factorial de n-m
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
    for (int i=n; i>1; i--) {   // n!
      factN *= i;
    }
    
    for (int i=m; i>1; i--) {   // m!
      factM *= i;
    }
    
    for (int i=n-m; i>1; i--) {   // (n-m)!
      factNM *= i;
    }
    
    combinatorio = factN / (factM * factNM);
    
    // Resultados
    System.out.printf("El número combinatorio de %d sobre %d es %d\n", n, m, combinatorio);

  }

}
