package org.iesgrancapitan.PROGR.ejercicios.ej03funciones;

import org.iesgrancapitan.PROGR.ejercicios.ej03funciones.matematicas.FuncionesEj1a14;

/**
 * Probamos clase de funciones de los ejercicios 1 a 14.
 * 
 * @author rafa
 *
 */

public class PruebaFuncionesEjercicios1a14 {
  public static void main(String[] args) {
    System.out.println("Prueba función esPrimo:");
    System.out.println("-----------------------");
    System.out.println("2: " + FuncionesEj1a14.esPrimo(2));
    System.out.println("4: " + FuncionesEj1a14.esPrimo(4));
    System.out.println("9: " + FuncionesEj1a14.esPrimo(9));
    System.out.println("17: " + FuncionesEj1a14.esPrimo(17));
    System.out.println("-4: " + FuncionesEj1a14.esPrimo(-4));
    System.out.println("-17: " + FuncionesEj1a14.esPrimo(-17));
    System.out.println();
    
    System.out.println("Prueba función siguientePrimo:");
    System.out.println("------------------------------");
    System.out.println("2: " + FuncionesEj1a14.siguientePrimo(2));
    System.out.println("4: " + FuncionesEj1a14.siguientePrimo(4));
    System.out.println("9: " + FuncionesEj1a14.siguientePrimo(9));
    System.out.println("17: " + FuncionesEj1a14.siguientePrimo(17));
    System.out.println("-4: " + FuncionesEj1a14.siguientePrimo(-4));
    System.out.println("-17: " + FuncionesEj1a14.siguientePrimo(-17));
    System.out.println();
    
    System.out.println("Prueba función volteado:");
    System.out.println("------------------------");
    System.out.println("2: " + FuncionesEj1a14.voltea(2));
    System.out.println("23: " + FuncionesEj1a14.voltea(23));
    System.out.println("327: " + FuncionesEj1a14.voltea(327));
    System.out.println("2098: " + FuncionesEj1a14.voltea(2098));
    System.out.println("-234: " + FuncionesEj1a14.voltea(-234));
    System.out.println();
  }

}
