package org.iesgrancapitan.PROGR.ejemplos.repetitivas;
import java.util.Scanner;

/**
 * Este programa va a pedir diez números al usuario y calculará su media
 * y su varianza.
 *
 * @author rafa
 *
 */
public class Estadisticas2 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    double suma = 0;
    int[] numeros = new int[10];
    double media;
    double varianza;
    
    // Calculo la media
    
    // Pido los diez números y los acumulo
    for (int i=0; i<10; i++) {
      System.out.print("Dame el número " + (i+1) + ": ");
      numeros[i] = s.nextInt();
      suma += numeros[i];
    }
    media = suma / 10;
    
    // Calculo la varianza
    suma = 0;
    for (int i=0; i<10; i++) {
      suma += Math.pow(numeros[i]-media, 2);
    }
    varianza = suma / 10;
    
    // Muestro resultados
    System.out.println("La media es " + media);
    System.out.println("La varianza es " + varianza);
    
  }

}
