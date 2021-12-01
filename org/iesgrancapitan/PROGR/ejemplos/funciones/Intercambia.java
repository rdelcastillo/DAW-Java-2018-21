package org.iesgrancapitan.PROGR.ejemplos.funciones;

/**
 * Este programa prueba una función para intercambiar los valores de 
 * dos variables enteras.
 * 
 * @author rafa
 * 
 * Ojo!!! NO INTERCAMBIA LAS VARIABLES porque se pasan por valor a la función
 *
 */

public class Intercambia {

  public static void main(String[] args) {
    int primero = 5;
    int segundo = 10;
    
    intercambia(primero, segundo);
    
    System.out.println("'primero' es " + primero + " y 'segundo' es " + segundo);

  }
  
  static public void intercambia(int n1, int n2) {
    int aux = n1;
    n1 = n2;
    n2 = aux;
  }

}
