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

public class DescomposicionFactorialSinFunciones {

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
      // buscamos un factor primo
      while (number % prime != 0) {
        // buscamos siguiente primo, aunque podríamos ir de 1 en 1 y sería más
        // fácil, por motivos didácticos no lo haremos así
        boolean isPrime;
        do {
          prime++;  // siguiente candidato a primo
          // ¿es primo?
          isPrime = (prime % 2 != 0);   // si es par, no es primo
          for (int div = 3; isPrime && div <= Math.sqrt(prime); div += 2) {
            if (prime%div == 0) {
              isPrime = false;
            }
          }
        } while (!isPrime);
      }
      System.out.printf("%3d\n", prime);
      number /= prime;
    } while (number > 1);
    
    System.out.println("  1 |");
  }

}
