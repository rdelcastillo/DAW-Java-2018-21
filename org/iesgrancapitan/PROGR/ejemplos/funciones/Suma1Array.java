package org.iesgrancapitan.PROGR.ejemplos.funciones;

/**
 * Probamos una función a la que le pasamos un vector de enteros
 * y suma uno a su contenido a pesar de que se pasa el parámetro 
 * por valor.
 * 
 * @author rafa
 *
 */

public class Suma1Array {

  public static void main(String[] args) {
   int[] v = {1,2,3,4,5,6};
   suma1(v);
   //pon1(v);   // no va a funcionar
   for (int n:v) {
     System.out.println(n);
   }
  }

  public static void suma1(int[] v) {
    for (int i=0; i<v.length; i++) {
      ++v[i];
    }
  }
  
  public static void pon1(int[] v) {
    v = new int[6]; // demostramos que no hay paso por referencia
    for (int i=0; i<v.length; i++) {
      v[i] = 1;
    }
  }

}
