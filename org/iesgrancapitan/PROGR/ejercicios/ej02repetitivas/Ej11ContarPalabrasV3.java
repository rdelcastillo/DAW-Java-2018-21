package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/**
 * Suponiendo que hemos introducido una cadena por teclado que representa una frase
 * (palabras separadas por espacios), realiza un programa que cuente cuantas
 * palabras tiene.
 * 
 * Podemos ir recorriendo la cadena de forma que cuando nos encontremos un carácter que no 
 * sea un espacio aumentamos el número de palabras en uno, necesitaremos un contador y un 
 * interruptor que nos diga si estamos en un espacio o no. 
 * 
 * */

import java.util.Scanner;

public class Ej11ContarPalabrasV3 {
  
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String cadena;
    int contadorPalabras = 0;
    boolean estoyEnPalabra = false;

    // Pedimos datos
    System.out.print("Introduce una cadena: ");
    cadena = s.nextLine();

    // Proceso
    for (char c: cadena.toCharArray()) {
      if (c != ' ') {
        if (!estoyEnPalabra) {
          contadorPalabras++;
          estoyEnPalabra = true;
        }
      } else {
        estoyEnPalabra = false;
      }
    }
    
    // Salida    
    System.out.println("La cadena tiene "+contadorPalabras+" palabras.");
  }


}

