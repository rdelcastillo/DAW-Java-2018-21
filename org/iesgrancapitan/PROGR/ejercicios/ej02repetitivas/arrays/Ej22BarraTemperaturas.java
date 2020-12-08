package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas.arrays;

import java.util.Scanner;

/**
 * Programa que pide la temperatura media que ha hecho en cada mes de un determinado año 
 * y muestra un diagrama de barras horizontales con esos datos. 
 * 
 * Las barras del diagrama se pueden dibujar a base de asteriscos o cualquier otro carácter.
 * 
 * Ejercicio 8 (arrays) de "Aprende Java con Ejercicios" (Ed.2019) 
 * de Luis José Sánchez González.
 *
 * @author Rafael del Castillo
 */
public class Ej22BarraTemperaturas {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    final String[] mes = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
      };
    int[] temperaturas = new int[12];    // temperaturas medias de cada mes
    
    System.out.println("Temperaturas medias de los meses del año");
    System.out.println("----------------------------------------");
    
    // pedimos datos
    for (int i = 0; i < temperaturas.length; i++) {
      System.out.print("Introduzca la temperatura media de " + mes[i] + ": ");
      temperaturas[i] = s.nextInt();
    }

    // imprimimos diagrama de barras con la temperatura de cada mes
    System.out.println("\n");
    for (int i = 0; i < 12; i++) {
      System.out.printf("%12s │", mes[i]);
      for (int j = 0; j < temperaturas[i]; j++) {
        System.out.print("▄");
      }
      System.out.println(" " + temperaturas[i] + "ºC");
    }
  }
}
