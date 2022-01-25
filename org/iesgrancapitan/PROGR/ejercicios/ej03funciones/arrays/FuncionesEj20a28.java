package org.iesgrancapitan.PROGR.ejercicios.ej03funciones.arrays;

/**
 * Crea una biblioteca de funciones para arrays (de una dimensión) de números
 * enteros que contenga las siguientes funciones:
 * 
 * 1. generaArrayInt: Genera un array de tamaño n con números aleatorios
 * cuyo intervalo (mínimo y máximo) se indica como parámetro.
 * 
 * 2. minimoArrayInt: Devuelve el mínimo del array que se pasa como parámetro.
 * 
 * 3. maximoArrayInt: Devuelve el máximo del array que se pasa como parámetro.
 * 
 * 4. mediaArrayInt: Devuelve la media del array que se pasa como parámetro.
 * 
 * 5. estaEnArrayInt: Dice si un número está o no dentro de un array.
 * 
 * 6. posicionEnArray: Busca un número en un array y devuelve la posición 
 * (el índice) en la que se encuentra.
 * 
 * 7. volteaArrayInt: Le da la vuelta a un array.
 * 
 * 8. rotaDerechaArrayInt: Rota n posiciones a la derecha los números de un array.
 * 
 * 9. rotaIzquierdaArrayInt: Rota n posiciones a la izquierda los números de un array.
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios" (edición 2029) de 
 * Luis José Sánchez González.
 * 
 * Nota: normalmente pongo los nombres de variables y funciones en inglés, esta vez haré 
 * una excepción ya que el enunciado del ejercicio pide las funciones en castellano.
 * 
 * @author Rafael del Castillo
 *
 */

public class FuncionesEj20a28 {
  
  public static int[] generaArrayInt(int tamanyo, int minimo, int maximo) {
    int[] array = new int[tamanyo];
    for (int i = 0; i < tamanyo; i++) {
      array[i] = minimo + (int) (Math.random() * (maximo-minimo+1));
    }
    return array;
  }
  
  public static int minimoArrayInt(int[] numeros) {
    int minimo = Integer.MAX_VALUE;
    for (int n: numeros) {
      if (n < minimo) {
        minimo = n;
      }
    }
    return minimo;
  }
  
  public static int maximoArrayInt(int[] numeros) {
    int maximo = Integer.MIN_VALUE;
    for (int n: numeros) {
      if (n > maximo) {
        maximo = n;
      }
    }
    return maximo;
  }
  
  public static double mediaArrayInt(int[] numeros) {
    double suma = 0;
    for (int n: numeros) {
      suma += n;
    }
    return suma/numeros.length;
  }
  
  public static boolean estaEnArrayInt(int[] numeros, int numeroABuscar) {
    for (int n: numeros) {
      if (n == numeroABuscar) {
        return true;
      }
    }
    return false;
  }
  
  public static int posicionEnArray(int[] numeros, int numeroABuscar) {
    for (int posicion = 0; posicion < numeros.length; posicion++) {
      if (numeroABuscar == numeros[posicion]) {
        return posicion;
      }
    }
    return -1;
  }
  
  public static void volteaArrayInt(int[] numeros) {
    // creamos un duplicado del array (podríamos hacerlo con Arrays.copyOf())
    int[] copiaNumeros = new int[numeros.length];
    for (int i = 0; i < numeros.length; i++) {
      copiaNumeros[i] = numeros[i];
    }
    
    // volteamos
    for (int i=0; i < numeros.length; i++) {
      numeros[i] = copiaNumeros[numeros.length - i - 1];
    }
  }
  
  /*
  public static void rotaDerechaArrayInt(int[] numeros, int rotaciones) {
    int rotacionesReales = rotaciones % numeros.length; // por si rotaciones > numeros.length
    int[] copiaNumeros = Arrays.copyOf(numeros, numeros.length);

    // desplazamos primera parte (podríamos hacerlo con un solo ciclo usando %)
    for (int i = 0; i < numeros.length-rotacionesReales; i++) {
      numeros[i + rotacionesReales] = copiaNumeros[i];
    }
    
    // desplazamos segunda parte (podríamos hacerlo con un solo ciclo usando %)
    for (int i = numeros.length-rotacionesReales; i < numeros.length; i++) {
      numeros[i - (numeros.length-rotacionesReales)] = copiaNumeros[i];
    }
  }
  */
  
  public static void rotaDerechaArrayInt(int[] numeros, int rotaciones) {
    for (int i = 1; i <= rotaciones; i++) {
      rotaUnoDerechaArrayInt(numeros);
    }
  }
  
  
  private static void rotaUnoDerechaArrayInt(int[] numeros) {
    int ultimoNumero = numeros[numeros.length-1];
    for (int i = numeros.length-1; i > 0; i--) {
      numeros[i] = numeros[i - 1];
    }
    numeros[0] = ultimoNumero;
    
  }

  /*
  public static void rotaIzquierdaArrayInt(int[] numeros, int rotaciones) {
    int rotacionesReales = rotaciones % numeros.length; // por si rotaciones > numeros.length
    int[] copiaNumeros = Arrays.copyOf(numeros, numeros.length);
    for (int i = 0; i < numeros.length; i++) {
      numeros[(numeros.length-rotacionesReales+i) % numeros.length] = copiaNumeros[i];
    }
  }
  */
  
  public static void rotaIzquierdaArrayInt(int[] numeros, int rotaciones) {
    for (int i = 1; i <= rotaciones; i++) {
      rotaUnoIzquierdaArrayInt(numeros);
    }
  }

  private static void rotaUnoIzquierdaArrayInt(int[] numeros) {
    int primerNumero = numeros[0];
    for (int i = 0; i < numeros.length - 1; i++) {
      numeros[i] = numeros[i + 1];
    }
    numeros[numeros.length - 1] = primerNumero;
  }
}
