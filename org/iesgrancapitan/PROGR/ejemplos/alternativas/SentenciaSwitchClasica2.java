package org.iesgrancapitan.PROGR.ejemplos.alternativas;

import java.util.Scanner;

/**
 * Sentencia múltiple (switch) 
 *
 * @author Rafael del Castillo
 */

public class SentenciaSwitchClasica2 {
  
  public static void main(String[] args) { 
    Scanner s = new Scanner(System.in);
       
    System.out.print("Por favor, introduzca un número de mes: ");
    int mes = s.nextInt();
    
    String estacion;
    
    switch (mes) {
      case 1: case 2:
        estacion = "invierno";
        break;
      case 3:
        estacion = "invierno/primavera";
        break;
      case 4: case 5:
        estacion = "primavera";
        break;
      case 6:
        estacion = "primavera/verano";
        break;
      case 7: case 8:
        estacion = "verano";
        break;
      case 9:
        estacion = "verano/otoño";
        break;
      case 10: case 11:
        estacion = "otoño";
        break;
      case 12:
        estacion = "otoño/invierno";
        break;
      default:
        estacion = "no existe ese mes";
    }

    System.out.println("Estación correspondiente al " + mes + ": " + estacion);
  }
}
