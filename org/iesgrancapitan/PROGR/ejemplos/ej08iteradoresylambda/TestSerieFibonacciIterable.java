package org.iesgrancapitan.PROGR.ejemplos.ej08iteradoresylambda;

import java.util.Scanner;

public class TestSerieFibonacciIterable {

  public static void main(String[] args) {
    var s = new Scanner(System.in);
    
    System.out.print("Este programa genera números de la serie de Fibonacci, ¿cuántos generamos? ");
    int cantidadAGenerar = s.nextInt();
    
    var serieFibonacci = new SerieFibonacciIterable(cantidadAGenerar);
    
    int index = 1;
    for (long n: serieFibonacci) {
      System.out.println(index++ + "º:\t" + n);
    }
  }

}
