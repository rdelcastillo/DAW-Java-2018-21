package org.iesgrancapitan.PROGR.ejemplos.poo;

import java.util.Scanner;

public class TestFraccionConExcepciones {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    var f = new FraccionConExcepciones(3, 4); 

    // Si meten un 0 saltará la excepción
    System.out.print("Dame un nuevo denominador para la fracción " + f + " --> ");
    f.setDenominador(s.nextInt());
    System.out.println("Nueva fracción: " + f);

    // Capturamos la excepción
    try {
      System.out.print("Dame un nuevo denominador para la fracción " + f + " --> ");
      f.setDenominador(s.nextInt());
      System.out.println("Nueva fracción: " + f);  
    } catch (Exception e) { // No debemos hacerlo así (usando la clase genérica)
      System.out.println("Se ha producido una excepción: " + e.getClass());
      System.out.println("Mensaje: " + e.getMessage());
    }

    // Si se produce la excepción pedimos denominador de nuevo
    while (true) {
      try { 
        System.out.print("Dame un otro nuevo denominador para la fracción: ");
        f.setDenominador(s.nextInt());      
        System.out.println("Nueva fracción: " + f);
        break;
      } catch (ArithmeticException e) {
        System.out.println("Una fracción no puede tener como denominador cero.");
        System.out.println("Excepción generada: " + e.getMessage());
      }
    }

  }

}
