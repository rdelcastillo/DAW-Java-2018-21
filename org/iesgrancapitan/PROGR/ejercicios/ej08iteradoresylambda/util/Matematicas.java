package org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda.util;

public class Matematicas {
  
  public static boolean esPrimo(long primoCandidato) {
    if (primoCandidato%2 == 0 && primoCandidato > 2) {
      return false;
    }
    boolean esPrimo = true;
    for (int divisor = 3; esPrimo && divisor <= Math.sqrt(primoCandidato); divisor += 2) {
      esPrimo = (primoCandidato%divisor != 0);
    }
    return esPrimo;
  }
  
  public static long Fibonacci(int n) {
    long ultimo = 0;
    long penultimo = 1;
    for (int i = 1; i <= n; i++) {
      long actual = penultimo + ultimo;
      penultimo = ultimo;
      ultimo = actual;
    }
    return ultimo;
  }

}
