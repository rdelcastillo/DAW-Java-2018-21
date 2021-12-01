package org.iesgrancapitan.PROGR.ejemplos.funciones.estadisticas;

/**
 * Clase que agrupa funciones paramanejo de estadísticas
 * sobre arrays.
 * 
 * @author rafa
 *
 */

public class Arrays {
  
  /**
   * Esta función devuelve la media de los valores de <code>array</code>.
   * El ciclo for para recorrer este array es genérico, sería mejor usar
   * el for que hace de foreach.
   * 
   * @param array
   * @return media
   */
  static public double media(double[] array) {
    double suma = 0;
    
    for (int i=0; i<array.length; i++) {
      suma += array[i];
    }
    return suma/array.length;
  }
  
  /**
   * Esta función devuelve la varianza de los elementos del array.
   * 
   * @param array
   * @return varianza
   */
  static public double varianza(double[] array) {
    double m = media(array);
    double suma = 0;
    
    for (double elemento:array) {
      suma += Math.pow(elemento-m, 2);
    }
    return suma/array.length;
  }

}
