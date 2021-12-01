package org.iesgrancapitan.PROGR.ejemplos.cadenas;

import java.util.Scanner;

/**
 * Ejemplo de lectura de datos con la clase Scanner.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class EjemploLecturaDatos {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    // Leer una cadena de caracteres
    System.out.print("Introduce una cadena de caracteres: ");
    String cadena1 = s.nextLine();
    System.out.println("Has introducido: " + cadena1);
    
    // Leer tres trozos de una cadena
    System.out.print("Introduce tres números: ");
    int n1 = Integer.parseInt(s.next());
    System.out.println("El primer número es " + n1);
    int n2 = Integer.parseInt(s.next());
    System.out.println("El segundo número es " + n2);
    int n3 = Integer.parseInt(s.next());
    System.out.println("El tercer número es " + n3);
    
    // Leer un entero y después una cadena de caracteres
    System.out.print("Introduce un entero: ");
    int n4 = s.nextInt();
    System.out.print("Introduce una cadena: ");
    // Ojo, aparentemente se salta esta instrucción si no saco el salto de línea del buffer
    s.nextLine();
    String cadena2 = s.nextLine();
    System.out.println("El entero ha sido " + n4 + " y la cadena " + cadena2);
  }

}
