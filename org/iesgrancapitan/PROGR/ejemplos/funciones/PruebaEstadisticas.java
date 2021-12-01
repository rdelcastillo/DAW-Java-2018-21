package org.iesgrancapitan.PROGR.ejemplos.funciones;
/**
 * Prueba de biblioteca de funciones.
 * 
 * No usamos import, por lo que tenemos que usar el nombre completo para
 * acceder a las funciones de la clase.
 * 
 * @author rafa
 *
 */
public class PruebaEstadisticas {
  
  public static void main(String[] args) {
    double[] array= {1,2,3,4,5,6,7,8,9,10};
    
    // Prueba array de números reales
    System.out.print("Array de números reales: { ");
    for (double elemento:array) {
      System.out.print(elemento + " ");
    }
    System.out.println("}");
    System.out.println("La media es    " + org.iesgrancapitan.PROGR.ejemplos.funciones.estadisticas.Arrays.media(array));
    System.out.println("La varianza es " + org.iesgrancapitan.PROGR.ejemplos.funciones.estadisticas.Arrays.varianza(array));
  }
  
}
