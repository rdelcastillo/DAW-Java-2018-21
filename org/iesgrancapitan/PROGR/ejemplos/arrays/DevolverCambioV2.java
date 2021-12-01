package org.iesgrancapitan.PROGR.ejemplos.arrays;

import java.util.Scanner;

/**
 * Este programa pedirá una cantidad en euros y devolverá el cambio ideal en
 * billetes (500, 200, 100, 50, 20, 10, 5) y monedas (2, 1).
 * 
 * Guardaremos en un vector el valor cada uno de los billetes y monedas.
 * 
 * En esta versión usaremos foreach y el operador ?
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class DevolverCambioV2 {
  
  private static final int[] IMPORTE_CAMBIO = {500, 200, 100, 50, 20, 10, 5, 2, 1};

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    // Petición de datos
    System.out.print("¿Cuántos euros quieres cambiar? ");
    int cantidadACambiar = s.nextInt();
    while (cantidadACambiar <= 0) {
      System.err.println("No puedo cambiar cantidades negativas.");
      System.exit(1);
    }
    
    // Proceso de cambio
    for (int importe: IMPORTE_CAMBIO) {
      int unidades = cantidadACambiar / importe;
      
      // ¿Hay monedas o billetes de ese importe?
      if (unidades > 0) {
        System.out.print((importe > 2) ? "Billetes": "Monedas");    
        System.out.println(" de " + importe + " euros: " + unidades);

        cantidadACambiar -= unidades * importe; // nos quedamos con el resto
      }
    }

  }

}
