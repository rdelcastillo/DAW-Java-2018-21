package org.iesgrancapitan.PROGR.ejemplos.arrays;

/**
 * Este programa nos generará una quiniela de quince partidos con cinco apuestas.
 * 
 * Consideraremos que la probabilidad de que gane el equipo de casa es del 50%, de
 * empate un 30% y de que pierda un 20%.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Quiniela {

  private static final int MATCHES = 15;
  private static final int BETS = 5;
  private static double HOME_CHANCE = 0.5;
  private static double AWAY_CHANCE = 0.2;

  public static void main(String[] args) {
    char[][] pool = new char[MATCHES][BETS];
    
    // Generación de la quiniela
    for (int match=0; match < MATCHES; match++) {   // partidos
      for (int bet=0; bet < BETS; bet++) {          // apuestas
        double random = Math.random();
        if (random <= HOME_CHANCE) {
          pool[match][bet] = '1';
        } else if (random <= HOME_CHANCE + AWAY_CHANCE) {
          pool[match][bet] = '2';
        } else {
          pool[match][bet] = 'X';
        }
      }
    }
    
    // Impresión
    for (int match=0; match < MATCHES; match++) {
      System.out.print("Partido " + (match+1) + "\t");
      for (int bet=0; bet < BETS; bet++) {
        System.out.print(pool[match][bet] + "\t");
      }
      System.out.println();
    }

  }

}
