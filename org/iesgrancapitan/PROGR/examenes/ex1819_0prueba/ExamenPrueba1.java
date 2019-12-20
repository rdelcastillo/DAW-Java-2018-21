package org.iesgrancapitan.PROGR.examenes.ex1819_0prueba;

import java.util.Scanner;

/**
 * Este programa calcula el combinatorio de dos números. Si hay un error en la
 * introducción debe indicarlo.
 * 
 * @author rafa
 *
 */

public class ExamenPrueba1 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n; // primer número
    int m; // segundo número
    double resultado;

    // Pedir los datos
    System.out.println("Cálculo del combinatorio de n sobre m\n");
    System.out.print("Dame valor n: ");
    n = s.nextInt();
    System.out.print("Dame valor m: ");
    m = s.nextInt();
    if (m >= n || m < 0 || n < 0) {
      System.out.println("Los datos introducidos son erróneos");
      System.exit(1);
    }

    // Cálculos
    resultado = (double) factorial(n) / (factorial(m) * factorial(n - m));

    // Mostrar resultados
    System.out.println("El combinatorio es " + resultado);
  }

  /**
   * Devuelve el factorial del número pasado como parámetro.
   * 
   * @param n número entero del que queremos calcular su factorial
   * 
   * @return <code>long</code> con el valor del factorial
   */
  public static long factorial(int n) {
    long f = 1;

    for (int i = 2; i <= f; i++) {
      f *= i;
    }
    return f;
  }

}
