package org.iesgrancapitan.PROGR.ejemplos.alternativas;

import java.util.Scanner;

/**
 * Sentencia múltiple (switch) 
 *
 * @author Rafael del Castillo
 */

public class SentenciaSwitchClasica {
  
  public static void main(String[] args) { 
    Scanner s = new Scanner(System.in);
       
    System.out.print("Por favor, introduzca un número de día de la semana: ");
    int dia = s.nextInt();
    
    String nombreDelDia;
    
    switch (dia) {
      case 1:
        nombreDelDia = "lunes";
        break;
      case 2:
        nombreDelDia = "martes";
        break;
      case 3:
        nombreDelDia = "miércoles";
        break;
      case 4:
        nombreDelDia = "jueves";
        break;
      case 5:
        nombreDelDia = "viernes";
        break;
      case 6:
        nombreDelDia = "sábado";
        break;
      case 7:
        nombreDelDia = "domingo";
        break;
      default:
        nombreDelDia = "no existe ese día de la semana";
    }

    System.out.println("Día de la semana " + dia + ": " + nombreDelDia);
  }
}
