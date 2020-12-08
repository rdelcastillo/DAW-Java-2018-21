package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas.arrays;

import java.util.Scanner;

public class Ej20MaxMinMediaVar {

  /**
   * Programa que calcule el máximo, mínimo, media y varianza de 10 notas introducidas
   * por el usuario.
   * 
   * Media:     Sumatorio de las notas dividido entre el número de notas.
   * Varianza:  Sumatorio de la diferencia de cada nota menos la media al cuadrado
   *            dividido por el número de notas.
   *            
   * Análisis:
   * Hay dos partes:
   * - Cálculo de la media y máximo y mínimo.
   * - Cálculo de la varianza (necesitamos la media).
   * 
   * Variables:
   * - notas: vector con las calificaciones introducidas por el usuario.
   * - máximo y mínimo.
   * - media.
   * - varianza.
   * - sumaNotas: sumatorio notas.
   * - i: contador ciclo.
   * 
   * Algoritmo:
   * ---------
   * sumaNotas <-- 0
   * máximo <-- 0
   * mínimo <-- 10
   * 
   * PARA i DESDE 1 HASTA 10
   *    LEER nota[i]
   *    SI nota[i] > máximo ENTONCES
   *            máximo <-- nota[i]
   *    FIN-SI
   *    SI nota[i] < mínimo ENTONCES
   *            mínimo <-- nota[i]
   *    FIN-SI
   *    sumaNotas <-- sumaNotas + nota[i]
   * FIN-PARA
   * media <-- sumaNotas/10
   * 
   * sumaNotas <-- 0
   * PARA i DESDE 1 HASTA 10
   *    sumaNotas <-- sumaNotas + (nota[i]-media)²
   * FIN-PARA
   * varianza <-- sumaNotas/10
   * 
   * ESCRIBIR máximo, mínimo, media, varianza
   */

  // Constantes
  static final int NUMERO_NOTAS = 10;
  static final String ROJO = "\u001B[31m";
  static final String NORMAL = "\u001B[0m";
  
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double[] notas;   // array (vector) de notas
    double sumaNotas = 0;
    double media;
    double varianza;
    double maximo = 0;  // nota mínima
    double minimo = 10; // nota máxima
    
    notas = new double[NUMERO_NOTAS];   // reservo espacio
    
    // Proceso primera parte: media, máximo y mínimo
    for (int i=0; i<NUMERO_NOTAS; i++) {
      // Pedir nota entre 0 y 10
      System.out.print("Dame la nota número " + (i+1) +": ");
      notas[i] = s.nextDouble();
      while (notas[i]<0 || notas[i]>10) {
        System.out.print(ROJO+"Me has dado una nota errónea, vuelve a introducirla: "+NORMAL);
        notas[i] = s.nextDouble();
      }
      // Actualizar los datos intermedios: sumatorio, máximo y mínimo
      if (notas[i] > maximo) {
        maximo = notas[i];
      }
      if (notas[i] < minimo) {
        minimo = notas[i];
      }
      sumaNotas += notas[i];
    }
    media = sumaNotas/NUMERO_NOTAS;
        
    // Proceso segunda parte: varianza
    sumaNotas = 0;
    for (int i=0; i<NUMERO_NOTAS; i++) {
      sumaNotas += Math.pow(notas[i]-media, 2);
    }
    varianza = sumaNotas/NUMERO_NOTAS;
    
    // Mostramos resultados 
    System.out.println("\nRESULTADOS");
    System.out.println("----------");
    System.out.println("El máximo de las notas es " + maximo);
    System.out.println("El mínimo de las notas es " + minimo);
    System.out.println("La media de las notas es " + media);
    System.out.println("La varianza es: " + varianza);
  }

}

