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
  
  private static final int[] IMPORTE_CAMBIO = {500, 200, 100, 50, 20, 10, 5, 2, 1};

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
    for (int i = 0; i < IMPORTE_CAMBIO.length; i++) {
      int unidades = cantidadACambiar / IMPORTE_CAMBIO[i];
      
      // ¿Hay monedas o billetes de ese importe?
      if (unidades > 0) {
        if (IMPORTE_CAMBIO[i] > 2) {    // ¿Billetes o monedas?
          System.out.print("Billetes");
        } else {
          System.out.print("Monedas");
        }
        System.out.println(" de " + IMPORTE_CAMBIO[i] + " euros: " + unidades);
       
        cantidadACambiar -= unidades * IMPORTE_CAMBIO[i];   // nos quedamos con el resto
      }
    }

  }

}
