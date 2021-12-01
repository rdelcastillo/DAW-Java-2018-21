package org.iesgrancapitan.PROGR.ejemplos.secuenciales;
/**
* Lectura de datos desde teclado
*
* @author Luis J. Sánchez
*
* Modificado por la clase 1ºDaw usando la clase Scanner.
*
* En este ejemplo leemos un entero, después dos palabras y luego otro entero.
*
* Usamos s.next() para leer las palabras.
*/

import java.util.Scanner;

public class LeeNumerosV3 {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    System.out.println("Por favor, introduce 1er número:");
    int primerNumero = s.nextInt();
    System.out.println("Por favor, introduce dos palabras separadas por espacios:");
    String palabra1 = s.next();
    String palabra2 = s.next(); 
    System.out.println("Por favor, introduce 2º  número:");
    int segundoNumero = s.nextInt();
    int total = (2 * primerNumero) + segundoNumero;

    System.out.println("Las palabras introducidas son " + palabra1 + " y " + palabra2);
    System.out.print("El primer número introducido es " + primerNumero);
    System.out.println(" y el segundo es " + segundoNumero);
    System.out.print("El doble del primer número más el segundo es ");
    System.out.println(total);
  }
}
