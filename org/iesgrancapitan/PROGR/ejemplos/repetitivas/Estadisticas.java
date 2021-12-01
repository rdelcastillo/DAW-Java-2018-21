package org.iesgrancapitan.PROGR.ejemplos.repetitivas;
import java.util.Scanner;

/**
 * Este programa va a pedir diez números al usuario y calculará su media.
 *
 * @author rafa
 *
 */
public class Estadisticas {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int suma = 0;
    double media;
    
    // Pido los diez números y los acumulo
    for (int i=1; i<=10; i++) {
      System.out.print("Dame el número " + i + ": ");
      suma += s.nextInt();
    }
    
    // Calculo la media y muestro resultado
    media = (double) suma / 10;
    System.out.println("La media es " + media);

  }

}
