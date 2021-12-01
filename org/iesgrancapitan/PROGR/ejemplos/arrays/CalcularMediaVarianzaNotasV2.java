package org.iesgrancapitan.PROGR.ejemplos.arrays;

import java.util.Scanner;

/**
 * Este programa calculará la media y la varianza de un número de notas
 * introducidas por el usuario.
 * 
 * En esta versión recorremos el array de notas para el cálculo de la varianza
 * con un for-each.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CalcularMediaVarianzaNotasV2 {

  private static final int NUM_NOTES = 5;

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.println("Cálculo de la media y varianza de una serie de notas");
    System.out.println("----------------------------------------------------");
    
    double[] note = new double[NUM_NOTES];
    
    // Petición de las notas y cálculo de la media
    double sumNotes = 0;
    for (int i = 0; i < note.length; i++ ) {
      System.out.print("Introduce la nota número " + (i+1) + ": ");
      note[i] = s.nextDouble();
      sumNotes += note[i];
    }
    double meanNotes = sumNotes / note.length;
    
    // Cálculo de la varianza
    double sum = 0;
    for (double n: note) {
      sum += Math.pow(n - meanNotes, 2);
    }
    double variance = sum / note.length;

    // Mostrar resultados
    System.out.println("La media de las notas es: " + meanNotes);
    System.out.println("Y su varianza es: " + variance);
  }

}
