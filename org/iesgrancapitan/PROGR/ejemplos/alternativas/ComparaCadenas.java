package org.iesgrancapitan.PROGR.ejemplos.alternativas;


import java.util.Scanner;

public class ComparaCadenas {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    String cadena1;
    String cadena2;
    String cadena3;
    String cadena4;

    //Ejemplo de equals()
    System.out.print("Por favor, introduce La cadena número 1:");
    cadena1 = s.nextLine();
    System.out.print("Por favor, introduce La cadena número 2:");
    cadena2 = s.nextLine();
    if (cadena1.equals(cadena2)) {
      System.out.println("'" + cadena1 + "' es igual a '" + cadena2 + "'");
    } else {
      System.out.println("'" + cadena1 + "' es distinta a '" + cadena2 + "'");
    }

    //Ejemplo de compareTo()
    System.out.print("Por favor, introduce La cadena número 3:");
    cadena3 = s.nextLine();
    System.out.print("Por favor, introduce La cadena número 4:");
    cadena4 = s.nextLine();
    if (cadena3.compareTo(cadena4) < 0) {
      System.out.println("'" + cadena3 + "' es menor que '" + cadena4 + "'");
    } else if (cadena3.compareTo(cadena4) > 0) {
      System.out.println("'" + cadena3 + "' es mayor que '" + cadena4 + "'");
    } else {
      System.out.println("'" + cadena3 + "' es igual a '" + cadena4 + "'");
    }
  }
}
