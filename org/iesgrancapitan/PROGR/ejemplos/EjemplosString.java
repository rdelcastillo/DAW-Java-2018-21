package org.iesgrancapitan.PROGR.ejemplos;

/**
 * Ejemplo de uso de los métodos de la clase String.
 * 
 * Estos métodos se pueden encontrar en: 
 * 
 * @author rafa
 *
 */

public class EjemplosString {

  public static void main(String[] args) {
    String cadena1 = "Soy una cadena para probar los métodos de la clase String";
    //var cadena2 = "Y yo soy otra cadena creada por inferencia de tipos";
    
    /* public char charAt (int index) 
     * 
     * Devuelve el valor char en el índice especificado. 
     * Un índice varía de 0 a length() - 1. 
     * El primer valor de carácter de la secuencia está en el índice 0, el siguiente 
     * en el índice 1, y así sucesivamente, como para la indexación de arrays.
     */
    
    int index = 10;
    System.out.println("El carácter en posición " + index + " de \"" + cadena1 + "\" es '" +
        cadena1.charAt(index) + "'");

  }

}
