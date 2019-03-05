package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

/**
  * Programa que pide caracteres e imprime 'VOCAL' si son vocales y 'NO VOCAL'
  * en caso contrario, el programa termina cuando se introduce un espacio.
  *
  */

public class Ej03VocalConsonanteCF {

  // ################################################################################
  // Algoritmo que pida caracteres e imprima 'VOCAL' si son vocales y 'NO VOCAL'
  // en caso contrario, el programa termina cuando se introduce un espacio.
  // ################################################################################
  // Análisis
  // Leer un carácter hasta que sea el espacio.
  // Si el carácter no es espacio -> si es una vocal -> Muestro "Es vocal"
  // Si no muestro "No es vocal"
  // Datos de entrada:vamos leyendo un carácter.
  // Información de salida:Mensajes: "Es vocal", "No es vocal"
  // Variables:car (caracter)
  // ################################################################################
  // Diseño
  // 1.- Repetir -> Leer carácter hasta que sea un sólo carácter
  // 2.- Mientras no sea espacio
  // 3.- Si car no es el espacio
  // 4.- Si es A,E,I,O,U o a,e,i,o,u -> Mostrar "Es vocal"
  // 5.-Si no mostrar "No es vocal"
  // 6.- Repetir -> Leer carácter hasta que sea un sólo carácter
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String car;

    // Pedimos un solo carácter y si no se introduce lo pedimos de nuevo
    car = caracter();

    //Proceso
    while (!car.equals(" ")) {
      if (esVocal(car)) {
        System.out.println("VOCAL");
      } else {
        System.out.println("NO VOCAL");
      }
      // Pedimos otro carácter
      do {
        System.out.print("Introduce un carácter: ");
        car = s.nextLine();
      } while (car.length()!=1);
    }
  }

  // Funciones

  /**
   * Pide un solo carácter y comprueba si se ha introducido correctamente,
   * si no es así lo pide de nuevo.
   * @return <code>String de longitud 1</code>
   */
  public static String caracter() {
    Scanner s = new Scanner(System.in);
    String car;
    do {
      System.out.print("Introduce un carácter: ");
      car = s.nextLine();
    } while (car.length()!=1);
    return car;
  }

  /**
   * Comprueba si una cadena es vocal o no.
   *
   * @param c un cadena de caracteres
   * @return <code>true</code> si la cadena es vocal y <code>false</code> en caso contrario
   */
  public static boolean esVocal(String c) {
    c = c.toUpperCase();
    return "AEIOUÁÉÍÓÚ".contains(c) && c.length()==1;
  }
}

