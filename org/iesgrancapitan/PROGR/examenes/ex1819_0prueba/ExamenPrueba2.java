package org.iesgrancapitan.PROGR.examenes.ex1819_0prueba;

/**
 * Programa que calcula el elemento N (se pide al usuario)
 * de la serie de Fibonacci.
 * @author rafa
 *
 */
import java.util.Scanner;

public class ExamenPrueba2 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n;  // elemento introducido por el usuario
    int ultimo=1;
    int penultimo=1;
    int fib=1;
    
    // Pedimos datos
    System.out.println("Dame el número de elemento de la serie de Fibonnacci a visualizar: ");
    n = s.nextInt();
    
    // Cálculo
    for (int i=2; i<n; i++) {
      fib = ultimo+penultimo;
      penultimo = ultimo;
      ultimo=fib;
    }
    System.out.println("El elemento es "+fib+" ");
  }

}
