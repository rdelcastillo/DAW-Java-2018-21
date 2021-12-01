package org.iesgrancapitan.PROGR.ejemplos.alternativas;

import java.util.Scanner;

/**
 * Sentencia múltiple (switch) 
 *
 * @author Rafael del Castillo
 */

public class SentenciaSwitchJava17 {
  
  public static void main(String[] args) { 
    Scanner s = new Scanner(System.in);
       
    System.out.print("Por favor, introduzca un número de día de la semana: ");
    int dia = s.nextInt();
    
    String nombreDelDia;
    
    switch (dia) {
      case 1 -> nombreDelDia = "lunes";
      case 2 -> nombreDelDia = "martes";
      case 3 -> nombreDelDia = "miércoles";
      case 4 -> nombreDelDia = "jueves";
      case 5 -> nombreDelDia = "viernes";
      case 6 -> nombreDelDia = "sábado";
      case 7 -> nombreDelDia = "domingo";
      default -> nombreDelDia = "no existe ese día de la semana";
    }

    System.out.println("Día de la semana " + dia + ": " + nombreDelDia);
  }
}
