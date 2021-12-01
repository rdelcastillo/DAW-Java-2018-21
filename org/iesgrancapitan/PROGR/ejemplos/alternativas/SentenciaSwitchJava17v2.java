package org.iesgrancapitan.PROGR.ejemplos.alternativas;

import java.util.Scanner;

/**
 * Sentencia múltiple (switch) 
 *
 * @author Rafael del Castillo
 */

public class SentenciaSwitchJava17v2 {
  
  public static void main(String[] args) { 
    Scanner s = new Scanner(System.in);
       
    System.out.print("Por favor, introduzca un número de mes: ");
    int mes = s.nextInt();
    
    String estacion;
    
    switch (mes) {
      case 1,2 ->   estacion = "invierno";
      case 3 ->     estacion = "invierno/primavera";
      case 4,5 ->   estacion = "primavera";
      case 6 ->     estacion = "primavera/verano";
      case 7,8 ->   estacion = "verano";
      case 9 ->     estacion = "verano/otoño";
      case 10,11 -> estacion = "otoño";
      case 12 ->    estacion = "otoño/invierno";
      default ->    estacion = "no existe ese mes";
    }

    System.out.println("Estación correspondiente al " + mes + ": " + estacion);
  }
}
