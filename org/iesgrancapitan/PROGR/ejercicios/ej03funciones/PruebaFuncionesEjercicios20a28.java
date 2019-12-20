package org.iesgrancapitan.PROGR.ejercicios.ej03funciones;

import org.iesgrancapitan.PROGR.ejercicios.ej03funciones.arrays.FuncionesEj20a28;

public class PruebaFuncionesEjercicios20a28 {
  public static void main(String[] args) {
    int [] array = {1,2,3,4,5};
    
    System.out.println("Array antes de rotar: ");
    imprimeArray(array);
    FuncionesEj20a28.rotaDerechaArrayInt(array, 2);
    System.out.println("Array después de rotar a la derecha 2 posiciones: ");
    imprimeArray(array);
    FuncionesEj20a28.rotaDerechaArrayInt(array, -2);
    System.out.println("Array después de rotar a la derecha -2 posiciones: ");
    imprimeArray(array);
    FuncionesEj20a28.rotaDerechaArrayInt(array, 10);
    System.out.println("Array después de rotar a la derecha 10 posiciones: ");
    imprimeArray(array);
  }
  
  public static void imprimeArray(int[] array) {
    for (int n : array) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

}
