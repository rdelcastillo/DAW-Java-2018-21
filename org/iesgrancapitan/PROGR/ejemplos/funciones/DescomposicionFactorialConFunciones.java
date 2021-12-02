package org.iesgrancapitan.PROGR.ejemplos.funciones;

import java.util.Scanner;

/**
 * Este programa pide un número y lo muestra como producto de sus factores primos.
 * 
 * https://es.wikipedia.org/wiki/Factorizaci%C3%B3n_de_enteros
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class DescomposicionFactorialConFunciones {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.println("Descomposición en factores primos");
    System.out.println("---------------------------------");
    
    System.out.print("Número a descomponer: ");
    int number = s.nextInt();
    if (number < 2) {
      System.err.println("Número inválido, tiene que ser mayor que 1");
      System.exit(1);
    }
    
    int prime = 2;
    do {
      System.out.printf("%3d | ", number);
      while (number % prime != 0) { // buscamos un factor primo
        prime = nextPrime(prime);
      }
      System.out.printf("%3d\n", prime);
      number /= prime;
    } while (number > 1);
    
    System.out.println("  1 |");
  }

  private static int nextPrime(int prime) {
    int candidate = prime + 1;
    while (!isPrime(candidate)) {
      candidate++;
    } 
    return candidate;
  }

  private static boolean isPrime(int candidate) {
    boolean isPrime = (candidate%2 != 0);
    for (int div = 3; isPrime && div <= Math.sqrt(candidate); div += 2) {
      if (candidate%div == 0) {
        isPrime = false;
      }
    }
    return isPrime;
  }

}
