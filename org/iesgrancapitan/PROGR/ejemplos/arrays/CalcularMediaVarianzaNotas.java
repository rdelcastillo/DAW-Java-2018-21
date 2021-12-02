package org.iesgrancapitan.PROGR.ejemplos.arrays;

import java.util.Scanner;

/**
 * Este programa calculará la media y la varianza de un número de notas
 * introducidas por el usuario.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CalcularMediaVarianzaNotas {

  private static final int NUM_NOTES = 5;

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.println("Cálculo de la media y varianza de una serie de notas");
    System.out.println("----------------------------------------------------");
    
    double[] notes = new double[NUM_NOTES];
    
    // Petición de las notas y cálculo de la media
    double sumNotes = 0;
    for (int i = 0; i < notes.length; i++ ) {
      System.out.print("Introduce la nota número " + (i+1) + ": ");
      notes[i] = s.nextDouble();
      sumNotes += notes[i];
    }
    double meanNotes = sumNotes / notes.length;
    
    // Cálculo de la varianza
    double sum = 0;
    for (int i = 0; i < notes.length; i++) {
      sum += Math.pow(notes[i] - meanNotes, 2);
    }
    double variance = sum / notes.length;

    // Mostrar resultados
    System.out.println("La media de las notas es: " + meanNotes);
    System.out.println("Y su varianza es: " + variance);
  }

}
