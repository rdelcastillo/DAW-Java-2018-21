package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej09EsPrimo {

  // ################################################################################
  // Escribe un programa que diga si un número introducido por teclado es o no primo.
  // Un número primo es aquel que sólo es divisible entre él mismo y la unidad.
  // Nota: Es suficiente probar hasta la raíz cuadrada del número para ver si es
  // divisible por algún otro número.
  // ################################################################################
  // Análisis
  // Leemos un número y vamos comprobando si es divisible entre 2 hasta la raíz
  // cuadrada del número. Si es divisible por algún número no es primo.
  // Si no es divisible por ningún número es primo.
  // Para saber si es divisible usamos el operador módulo.
  // Datos de entrada: el número a comprobar si es primo o no
  // Información de salida: Un mensaje diciendo si es primo o no
  // Variables: numeroEsPrimo (entero), num (entero) contador desde 2 hasta
  // raíz cuadrada del num_esPrimo, esPrimo (lógico)
  // ################################################################################
  // Diseño
  // 1.- Supongo que el número es primo -> esPrimo<-Verdadero
  // 2.- Leer num_esPrimo
  // 3.- Desde num = 2 hasta raíz(numero_es_rpimo)
  // 4.- Si numeroEsPrimo es divisible entre num -> esPrimo<-Falso
  // 5.- Si esPrimo -> Mostrar "Es primo"
  // 6.- Si no -> Mostrar "No es primo"
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    boolean esPrimo = true;
    int numeroEsPrimo;

    // Pedimos datos
    System.out.print("Introduce un número para comprobar si es primo: ");
    numeroEsPrimo = s.nextInt();

    // Proceso
    for (int num=2; num<=Math.sqrt(numeroEsPrimo) && esPrimo; num++) {
      if (numeroEsPrimo%num==0) {
        esPrimo = false;
      }
    }
    if (esPrimo) {
      System.out.println("Es Primo");
    } else {
      System.out.println("No es Primo");
    }
  }


}

