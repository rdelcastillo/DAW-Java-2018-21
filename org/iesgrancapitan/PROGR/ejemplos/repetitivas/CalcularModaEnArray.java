package org.iesgrancapitan.PROGR.ejemplos.repetitivas;

import java.util.Scanner;

public class CalcularModaEnArray {
  
  /**
   * Este programa generará un array del tamaño que diga
   * el usuario, lo rellenará de números aleatorios entre 0 y 50
   * y buscará la moda.
   * 
   * @param args
   */

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.println("Cálculo de la moda en un array de números aleatorio");
    System.out.println("---------------------------------------------------");
    
    // pedir tamaño del array 
    System.out.print("Tamaño del array: ");
    int tamano = s.nextInt();
    if (tamano <= 0) {
      System.err.println("Tamaño erróneo.");
      System.exit(1);
    }
    
    // crear el array y generar números aleatorios en el array
    int[] numeros = new int[tamano];
    for (int i = 0; i < numeros.length; i++) {
      numeros[i] = (int) (Math.random() * 51);
    }
    
    // calculamos la moda

    // creamos un vector con las ocurrencias de cada número entre 0 y 50
    int[] ocurrencias = new int[51];
    for (int i = 0; i <= 50; i++) {
      ocurrencias[i] = 0;
    }
    
    // actualizamos las ocurrencias de cada número
    for (int n: numeros) {
      ++ocurrencias[n];
    }
    
    // calculamos las ocurrencias del número más repetido (puede haber más de una moda)
    int ocurrenciasModa = ocurrencias[0];
    for (int i = 1; i <= 50; i++) {
      if (ocurrencias[i] > ocurrenciasModa) {
        ocurrenciasModa = ocurrencias[i];
      }
    }
    
    // imprimo la moda
    System.out.print("Valor(es) de la(s) moda(s): ");
    for (int i = 0; i <= 50; i++) {
      if (ocurrencias[i] == ocurrenciasModa) {
        System.out.print(i + " ");
      }
    }
    System.out.println("que se repite(n) " + ocurrenciasModa);

  }

}
