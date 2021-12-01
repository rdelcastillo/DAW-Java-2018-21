package org.iesgrancapitan.PROGR.ejemplos.funciones;

/**
 * Ejemplo de uso de variables estáticas.
 * 
 * @author rafa
 *
 */

public class EjemploVariablesEstaticas {
  
  public static int n = 0;
  
  public static void main(String[] args) {
    for (int i=1; i<=10; i++) {
      System.out.println("Iteración " + i +". Número aleatorio: " + aleatorio(0,i));
    }
  }

  /**
   * Genera un número aleatorio entre <code>n1</code> y <code>n2</code>.
   * 
   * @param n1
   * @param n2
   * @return
   */
  public static int aleatorio(int n1, int n2) {
    n++;
    System.out.println("Número de veces que he llamado a la función 'aleatorio': "+n);
    return n1 + (int) (Math.random()*(n2-n1+1));
  }

}
