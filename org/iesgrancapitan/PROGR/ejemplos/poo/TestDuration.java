package org.iesgrancapitan.PROGR.ejemplos.poo;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Test de la clase Duration.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class TestDuration {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Pido t1
    System.out.print("Introduce un instante temporal en horas, minutos y segundos: ");
    int h = sc.nextInt();
    int m = sc.nextInt();
    int s = sc.nextInt();    
    
    Duration t1 = Duration.parse("PT" + h + "H" + m + "M" + s + ".0S");
    Duration t2 = Duration.ofSeconds(5*3600 + 100*60 - 5);
    
    // Probamos impresión
    System.out.println("Tiempo 1: " + t1);
    System.out.println("Tiempo 2: " + t2 + "\n");
    
    // Probamos suma y resta
    Duration suma = t1.plus(t2);
    System.out.println(t1 + " + " + t2 + " : " + suma);
    System.out.println(t1 + " - " + t2 + " : " + t1.minus(t2) + "\n");
    
    // Probamos suma y resta de segundos
    System.out.print(t1 + " + 22 segundos = ");
    t1 = t1.plusSeconds(22);
    //t1 = t1.plus(22, ChronoUnit.SECONDS)
    System.out.println(t1);
    
    System.out.print(t1 + " - 22 segundos = ");
    //t1 = t1.minusSeconds(22);
    t1 = t1.minus(22, ChronoUnit.SECONDS);
    System.out.println(t1 + "\n");
    
    // Probamos suma y resta de minutos
    System.out.print(t1 + " + 102 minutos = ");
    t1 = t1.plusMinutes(102);
    //t1 = t1.plus(102, ChronoUnit.MINUTES);
    System.out.println(t1);
    
    System.out.print(t1 + " - 102 minutos = ");
    //t1 = t1.minusMinutes(102);
    t1 = t1.minus(102, ChronoUnit.MINUTES);
    System.out.println(t1 + "\n");
    
    // Probamos suma y resta de horas
    System.out.print(t1 + " + 5 horas = ");
    t1 = t1.plusHours(5);
    //t1 = t1.plus(5, ChronoUnit.HOURS);
    System.out.println(t1);
    
    System.out.print(t1 + " - 5 horas = ");
    //t1 = t1.minusHours(5);
    t1 = t1.minus(5, ChronoUnit.HOURS);
    System.out.println(t1 + "\n");
    
  }

}
