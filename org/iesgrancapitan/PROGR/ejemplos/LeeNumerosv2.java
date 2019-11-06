/**
* Lectura de datos desde teclado
*
* @author Luis J. Sánchez
*
* Modificado por la clase 1ºDaw usando la clase Scanner
*/

import java.util.Scanner;

public class LeeNumerosv2 {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    System.out.println("Por favor, introduce 1er número:");
    int primerNumero = s.nextInt();
    System.out.println("Por favor, introduce una cadena:");
    String cadena = s.nextLine();
    System.out.println("Por favor, introduce 2º  número:");
    int segundoNumero = s.nextInt();
    int total = (2 * primerNumero) + segundoNumero;

    System.out.println("La cadena introducida es " + cadena);
    System.out.print("El primer número introducido es " + primerNumero);
    System.out.println(" y el segundo es " + segundoNumero);
    System.out.print("El doble del primer número más el segundo es ");
    System.out.println(total);
  }
}
