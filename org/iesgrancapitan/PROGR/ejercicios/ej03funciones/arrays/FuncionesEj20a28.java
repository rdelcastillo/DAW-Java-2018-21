package org.iesgrancapitan.PROGR.ejercicios.ej03funciones.arrays;

/**
 Crea una biblioteca de funciones para arrays (de una dimensión) de números
enteros que contenga las siguientes funciones:
1. generaArrayInt: Genera un array de tamaño n con números aleatorios
cuyo intervalo (mínimo y máximo) se indica como parámetro.
2. minimoArrayInt: Devuelve el mínimo del array que se pasa como pará-
metro.
3. maximoArrayInt: Devuelve el máximo del array que se pasa como
parámetro.
4. mediaArrayInt: Devuelve la media del array que se pasa como paráme-
tro.
5. estaEnArrayInt: Dice si un número está o no dentro de un array.
6. posicionEnArray: Busca un número en un array y devuelve la posición
(el índice) en la que se encuentra.
7. volteaArrayInt: Le da la vuelta a un array.
8. rotaDerechaArrayInt: Rota n posiciones a la derecha los números de un
array.
9. rotaIzquierdaArrayInt: Rota n posiciones a la izquierda los números de
un array.
 * @author rafa
 *
 */

public class FuncionesEj20a28 {
  public static void rotaDerechaArrayInt(int[] array, int n) {
    int [] copia = new int[array.length];
    int c = n; // contador array copia
    
    // llevando al array copia el desplazamiento
    for (int i=0; i<array.length; i++) {
      copia[c] = array[i];
      c++;
      if (c == array.length) {
        c = 0;
      }
    }
    
    // llevo la copia al array que me llega como parámetro
    for (int i=0; i<array.length; i++) {
      array[i] = copia[i];
    }
  }

}
