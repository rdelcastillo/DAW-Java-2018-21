package org.iesgrancapitan.PROGR.examenes.ex2122_1trimestre;

import java.util.Scanner;

/**
 * Versión simplificada del juego Master Mind. El juego consistirá en adivinar una cadena de números
 * distintos. Al principio, el programa debe pedir la longitud de la cadena (de 2 a 9 cifras) y generarla
 * aleatoriamente.
 *  
 * Después el programa debe ir pidiendo que intentes adivinar la cadena de números. En cada intento, 
 * el programa informará de cuántos números han sido acertados (el programa considerará que se ha acertado 
 * un número si coincide el valor y la posición).
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class MasterMindSimplificado {

  private static final int MAX_SIZE = 9;
  private static final int MIN_SIZE = 2;

  public static void main(String[] args) {
    System.out.println("Master Mind Simplicado");
    System.out.println("----------------------");
    
    // Entrada de datos
    Scanner s = new Scanner(System.in);
    System.out.print("Tamaño de la cadena a adivinar "
        + "(de " + MIN_SIZE + " a " + MAX_SIZE + "): ");
    int size = s.nextInt();
    if (size < MIN_SIZE || size > MAX_SIZE) {
      System.err.println("Tamaño de cadena erróneo.");
      System.exit(1);
    }
    s.nextLine();   // quitamos salto de línea del buffer de teclado
    
    // Generación de la cadena a adivinar
    String stringToGuess = "";
    for (int i = 0; i < size; i++) {
      boolean isGenerated = false;
      int random;
      // genero número aleatorio hasta que tenga uno no generado
      do {
        random = (int) (Math.random() * 10);
        isGenerated = false;
        for (int j = 0; j < i; j++) {
          if (random == Character.getNumericValue(stringToGuess.charAt(j))) {
            isGenerated = true;
            break;
          }
        }
      } while (isGenerated);
      stringToGuess += random;
    }    
    
    // Proceso
    String stringUser = null;
    int attempts = 1;
    do {
      // pedimos cadena al usuario mientras no introduzca la longitud correcta
      while (true) {
        System.out.print("\nIntento " + attempts++ + ": ");
        stringUser = s.nextLine();
        if (stringUser.length() == size) {
          break;
        }
        System.out.println("Error, la cadena introducida no tiene " + size + "caracteres.");
      }
      // contamos los aciertos
      int hits = 0;
      for (int i = 0; i < size; i++) {
        if (stringUser.charAt(i) == stringToGuess.charAt(i)) {
          hits++;
        }
      }
      System.out.println("Aciertos: " + hits);
    } while (!stringToGuess.equals(stringUser));
    
    System.out.println("\n¡Enhorabuena! Espero que hayas disfrutado del juego :-)");

  }

}
