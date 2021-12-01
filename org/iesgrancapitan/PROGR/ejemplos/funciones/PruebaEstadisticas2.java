package org.iesgrancapitan.PROGR.ejemplos.funciones;

import org.iesgrancapitan.PROGR.ejemplos.funciones.estadisticas.Arrays;

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
