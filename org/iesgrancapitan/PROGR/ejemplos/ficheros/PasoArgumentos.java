package org.iesgrancapitan.PROGR.ejemplos.ficheros;

/**
 * Ejemplo de paso de argumentos a un programa.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class PasoArgumentos {

  public static void main(String[] args) {
    System.out.println("El número de argumentos pasados son: " + args.length);
    for (int i = 0; i < args.length; i++) {
      System.out.println("El argumento nº " + (i+1) + " es " + args[i]);
    }
  }

}
