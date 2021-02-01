package org.iesgrancapitan.PROGR.ejemplos.ej03funciones;

/**
 * Prueba de biblioteca de funciones.
 * 
 * usamos import, por lo que NO tenemos que usar el nombre completo para
 * acceder a las funciones de la clase.
 * 
 * @author rafa
 *
 */

import org.iesgrancapitan.PROGR.ejemplos.ej03funciones.estadisticas.Arrays;

public class PruebaEstadisticas2 {
  
  public static void main(String[] args) {
    double[] array= {1,2,3,4,5,6,7,8,9,10};
    
    // Prueba array de números reales
    System.out.print("Array de números reales: { ");
    for (double elemento:array) {
      System.out.print(elemento + " ");
    }
    System.out.println("}");
    System.out.println("La media es    " + Arrays.media(array));
    System.out.println("La varianza es " + Arrays.varianza(array));
    
  }
  
}
