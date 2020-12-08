package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

import java.util.Scanner;

/**
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Ej19SerpienteAleatoria {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int espacios = 12;
    
    System.out.println("Serpenteo aleatorio");
    System.out.println("-------------------");
    
    // pedir datos y salgo si hay error
    System.out.print("longitud de la serpiente: ");
    int longitud = s.nextInt();
    if (longitud <= 0) {
      System.err.println("La longitud tiene que ser un entero positivo.");
      System.exit(1);
    }
    
    // imprimir la cabeza de la serpiente
    System.out.println("\n" + " ".repeat(espacios) + "@");
    
    // proceso
    for (int i=1; i<=longitud; i++) {
       int serpenteo = (int) (Math.random()*3) - 1;  // genero el serpenteo, aleatorio: -1, 0, 1
       espacios += serpenteo;
       System.out.println(" ".repeat(espacios) + "*");
    }

  }

}
