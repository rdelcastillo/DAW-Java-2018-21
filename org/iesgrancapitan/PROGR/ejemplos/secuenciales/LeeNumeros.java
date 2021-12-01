package org.iesgrancapitan.PROGR.ejemplos.secuenciales;
/**
* Lectura de datos desde teclado
*
* @author Luis J. Sánchez
*
* Modificado por la clase 1ºDaw usando la clase Scanner
*/

import java.util.Scanner;

public class LeeNumeros {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    System.out.println("Por favor, introduce dos números:");
    int primerNumero = s.nextInt();
    int segundoNumero = s.nextInt();
    int total = (2 * primerNumero) + segundoNumero;

    System.out.print("El primer número introducido es " + primerNumero);
    System.out.println(" y el segundo es " + segundoNumero);
    System.out.print("El doble del primer número más el segundo es ");
    System.out.println(total);
  }
}
