package org.iesgrancapitan.PROGR.ejemplos.funciones;

/**
 * Ejemplo de uso de funciones con varargs (paso de número variable de parámetros).
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class EjemploFuncionesVarargs {

  public static void main(String[] args) {
    System.out.println("El máximo de " + lista("Ristra numérica", 3,6,7,7,9,10) + " es " +
                        maximo(3,6,7,7,9,10) + " y la media es " + media(3,6,7,7,9,10));
    imprime();
    imprime(50);
    imprime("Soy una cadena");
    imprime(1,2,3,4,5,6);
    imprime(Math.random(),Math.random(),Math.random(),Math.random(),Math.random());
  }
  
  
  public static String lista(String nombre, int ... v) {
    String ristra = "[ " + nombre + ": ";
    for (int n: v) {
      ristra += n + " ";
    }
    ristra += "]";
    return ristra;
  }

  public static int maximo(int ... v) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < v.length; i++) {
      if (v[i] > max) {
        max = v[i];
      }
    }
    return max;
  }

  public static double media(int ... lista) {
    double sumatorio = 0;
    for (int n: lista) {
      sumatorio += n;
    }
    return sumatorio/lista.length;
  }
  
  public static void imprime() {
    System.out.println("Imprimo un entero: 10");
  }
  
  
  public static void imprime(int n) {
    System.out.println("Imprimo un entero: " + n);
  }
  
  public static void imprime(int ... v) {
    System.out.print("Imprimo una lista de enteros: ");
    for (int n: v) {
      System.out.print(n + " ");
    }
    System.out.println();
  }
  
  public static void imprime(double ... v) {
    System.out.print("Imprimo una lista de flotantes: ");
    for (double x: v) {
      System.out.print(x + " ");
    }
    System.out.println();
  }
  
  public static void imprime(String cadena) {
    System.out.println("Imprimo una cadena: " + cadena);
  }
  
}
