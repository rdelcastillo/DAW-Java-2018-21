package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

import java.util.Scanner;

/**
 * Programa que pinta por pantalla una serpiente con un “serpenteo” aleatorio. 
 * La cabeza se representará con el carácter @ y se debe colocar exactamente en la 
 * posición 13 (con 12 espacios delante). 
 * 
 * A partir de ahí, el cuerpo irá serpenteando de la siguiente manera: 
 * 
 * Se generará de forma aleatoria un valor entre tres posibles que hará que el siguiente 
 * carácter se coloque una posición a la izquierda del anterior, alineado con el anterior
 * o una posición a la derecha del anterior. 
 * 
 * La longitud de la serpiente se pedirá por teclado.
 * 
 * Ejercicio 22 (números aleatorios) de "Aprende Java con Ejercicios" (Ed.2019) 
 * de Luis José Sánchez González.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Ej19SerpienteAleatoria {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int espacios = 12;
    
    System.out.println("Serpenteo aleatorio");
    System.out.println("-------------------");
    
    // pedir datos y salgo si hay error
    System.out.print("longitud de la serpiente: ");
    int longitud = s.nextInt();
    if (longitud <= 0) {
      System.err.println("La longitud tiene que ser un entero positivo.");
      System.exit(1);
    }
    
    // imprimir la cabeza de la serpiente
    System.out.println("\n" + " ".repeat(espacios) + "@");
    
    // proceso
    for (int i=1; i<=longitud; i++) {
       int serpenteo = (int) (Math.random()*3) - 1;  // genero el serpenteo, aleatorio: -1, 0, 1
       espacios += serpenteo;
       System.out.println(" ".repeat(espacios) + "*");
    }

  }

}
