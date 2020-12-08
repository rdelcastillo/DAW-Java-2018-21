package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

import java.time.LocalDate;

/**
 * <p>Programa que muestre tres apuestas de la quiniela en tres columnas para los 14 partidos y 
 * el pleno al quince (15 filas) de forma que:</p>
 * 
 * <ul>
 * <li>La probabilidad de que salga un 1 sea de 1/2.</li>
 * <li>La probabilidad de que salga X sea de 1/3.</li>
 * <li>y la probabilidad de que salga 2 sea de 1/6.</li>
 * </ul>
 * 
 * <p>Pista: 1/2 = 3/6 y 1/3 = 2/6.</p>
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Ej21Quiniela {

  public static void main(String[] args) {
    System.out.println("Pronóstico para la quiniela de la jornada " + LocalDate.now());
    System.out.println("----------------------------------------------------");
    System.out.print(" ".repeat(13) + "\tAP1\tAP2\tAP3");
    
    // Impresión de los resultados de los 15 partidos
    for (int i = 1; i <= 15; i++) {
      System.out.print("\nPartido nº " + i + ":");
      
      // impresión de cada columna
      for (int c = 1; c <= 3; c++) {
        System.out.print("\t");     // para separar columnas
        
        // pronóstico del partido
        int pronostico = 1 + (int) (Math.random()*6);
        
        // impresión
        switch (pronostico) {
          case 1: case 2: case 3:   // Probabilidad 1: 1/2 = 3/6
            System.out.print("1  ");
            break;
          case 4: case 5:           // Probabilidad X: 1/3 = 2/6
            System.out.print(" X ");
            break;
          case 6:                   // Probabilidad 2: 1/6
            System.out.print("  2");
        }
      }
    }

  }

}
