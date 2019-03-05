package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej04NumerosPares {

  // ################################################################################
  // Escribir un programa que imprima todos los números pares entre dos números que
  // se le pidan al usuario.
  // ################################################################################
  // Análisis
  // Leemos un número. Si es impar, le sumo 1 y ya es par. Leemos el segundo número.
  // Escribo el número desde el primero hasta el segundo de dos en dos.
  // Datos de entrada: dos números
  // Información de salida:Los números pares que hay entre los dos anteriores
  // Variables:num, num1,num2 (entero)
  // ################################################################################
  // Diseño
  // 1.- Leer num1,num2
  // 2.- Si num1 es impar -> num1=num1+1
  // 3.- Desde num1 hasta num2 de 2 en 2
  // 4.- Escribir el número
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int num;
    int num1;
    int num2;

    // Pedimos datos
    System.out.print("Introduce el número 1: ");
    num1 = s.nextInt();
    System.out.print("Introduce el número 2: ");
    num2 = s.nextInt();

    // Si primer número es impar pasamos al siguiente par
    if (num1%2==1) {
      num1++;
    }

    // Mostramos salida
    for (num=num1; num<=num2; num+=2) {
      System.out.print(num+" ");
    }
  }


}

