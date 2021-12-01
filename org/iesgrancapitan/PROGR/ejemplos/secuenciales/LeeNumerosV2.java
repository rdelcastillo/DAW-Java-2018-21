package org.iesgrancapitan.PROGR.ejemplos.secuenciales;
/**
* Lectura de datos desde teclado
*
* @author Luis J. Sánchez
*
* Modificado por la clase 1ºDaw usando la clase Scanner.
*
* En este ejemplo leemos un entero, después una cadena y luego otro entero.
* Después de leer el primer entero se nos queda un salto de línea (\n) en
* el buffer de teclado. Si no lo sacamos de ahí no podremos leer la cadena
* después de leer el entero, queda el salto de línea suelto y al leer
* el sistema entiende que estoy introduciendo una cadena vacía y se "salta"
* la istrucción.
*
* Sacamos el salto de línea del buffer de teclado llamando a s.nextLine().
*/

import java.util.Scanner;

public class LeeNumerosV2 {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    System.out.println("Por favor, introduce 1er número:");
    int primerNumero = s.nextInt(); s.nextLine();  //saco el salto del línea del buffer
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
