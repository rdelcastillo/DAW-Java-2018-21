package org.iesgrancapitan.PROGR.ejemplos.arrays;

import java.util.Scanner;

/**
 * Este programa pedirá una cantidad en euros y devolverá el cambio ideal en
 * billetes (500, 200, 100, 50, 20, 10, 5) y monedas (2, 1).
 * 
 * Guardaremos en un vector el valor cada uno de los billetes y monedas.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class DevolverCambio {
  
  private static final int[] IMPORTE = {500, 200, 100, 50, 20, 10, 5, 2, 1};

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    // Petición de datos
    System.out.print("¿Cuántos euros quieres cambiar? ");
    int cantidadACambiar = s.nextInt();
    if (cantidadACambiar <= 0) {
      System.err.println("No puedo cambiar cantidades negativas.");
      System.exit(1);
    }
    
    // Proceso de cambio
    for (int i = 0; i < IMPORTE.length; i++) {
      int unidades = cantidadACambiar / IMPORTE[i];
      
      if (unidades > 0) {
        // ¿Billetes o monedas?
        if (IMPORTE[i] > 2) {
          System.out.print("Billetes");
        } else {
          System.out.print("Monedas");
        }
        // Unidades
        System.out.println(" de " + IMPORTE[i] + " euros: " + unidades);
        cantidadACambiar -= unidades*IMPORTE[i];
      }
    }

  }

}
