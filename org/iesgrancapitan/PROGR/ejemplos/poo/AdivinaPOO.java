package org.iesgrancapitan.PROGR.ejemplos.poo;

import java.util.Scanner;

public class AdivinaPOO {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    JuegoAdivina game = new JuegoAdivina();
    
    while (true) {
      System.out.print("Dame un número entre 1 y 10: ");
      int n = s.nextInt();
      if (game.check(n)) {
        System.out.println("Acertaste en " + game.getTries() + " intentos.");
        break;
      }
      System.out.println("Te equivocaste, inténtalo de nuevo");
    }

  }

}
