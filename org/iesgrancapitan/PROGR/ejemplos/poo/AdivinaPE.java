package org.iesgrancapitan.PROGR.ejemplos.poo;

import java.util.Scanner;

public class AdivinaPE {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int guess = 1 + (int) (Math.random()*10);
    int tries = 0;
    
    while (true) {
      System.out.print("Dame un número entre 1 y 10: ");
      int n = s.nextInt();
      tries++;
      if (n == guess) {
        System.out.println("Acertaste en " + tries + " intentos.");
        break;
      } 
      System.out.println("Te equivocaste, inténtalo de nuevo");
    }

  }

}
