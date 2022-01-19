package org.iesgrancapitan.PROGR.ejercicios.ej03funciones;

import java.util.Arrays;

/**
 * Define la función mezcla con la siguiente cabecera:
 * 
 * public static int[] mezcla(int[] a, int[] b)
 * 
 * Esta función toma dos arrays como parámetros y devuelve un array que es
 * el resultado de mezclar los números de ambos de forma alterna, se coge un
 * número de a, luego de b, luego de a, etc. Los arrays a y b pueden tener
 * longitudes diferentes; por tanto, si se terminan los números de un array se
 * terminan de coger todos los que quedan del otro.
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios" (edición 2029) de 
 * Luis José Sánchez González.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Ej50Mezcla {

  public static void main(String[] args) {
    int[] array1 = {4, 5, 6};
    int[] array2 = {2, 3, 1, 8, 9};
    int[] mezclaArray12 = mezcla(array1, array2);
    System.out.println("La mezcla de " + Arrays.toString(array1) + " y " + Arrays.toString(array2) + " es:");
    System.out.println(Arrays.toString(mezclaArray12));
  }

  private static int[] mezcla(int[] array1, int[] array2) {
    int longitudMinimaArray = (array1.length < array2.length) ? array1.length : array2.length;
    int[] mezclaArrays = new int[array1.length + array2.length];
    
    // 1ª parte: mezclo los elementos de ambos arrays
    for (int i = 0; i < longitudMinimaArray; i++) {
      mezclaArrays[i*2] = array1[i];
      mezclaArrays[i*2 + 1] = array2[i];
    }
    
    // 2ª parte: añado el resto del array con más tamaño
    int[] arrayMayor = (array1.length > array2.length) ? array1 : array2;
    for (int i = longitudMinimaArray; i < arrayMayor.length; i++) {
      mezclaArrays[longitudMinimaArray + i] = arrayMayor[i];
    } 
    
    return mezclaArrays;
  }

}
