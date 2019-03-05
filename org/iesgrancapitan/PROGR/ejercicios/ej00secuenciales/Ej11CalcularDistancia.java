package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;
/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej11CalcularDistancia {

  // ################################################################################
  // Pide al usuario dos números y muestra la "distancia" entre ellos
  // (el valor absoluto de su diferencia, de modo que el resultado sea siempre positivo).
  // ################################################################################
  // Análisis
  // Se piden dos números y se calcula el valor absoluto de la diferencia.
  // Datos de entrada: dos números (entero).
  // Información de salida: distancia (entero).
  // Variables: num1,num2(entero).
  // ################################################################################
  // Diseño
  // 1. Leer los dos números.
  // 2. Mostrar distancia (valor absoluto de la diferencia)
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int num1;
    int num2;

    System.out.print("Dime el número1: ");
    num1 = s.nextInt();
    System.out.print("Dime el número2: ");
    num2 = s.nextInt();

    System.out.println("Distancia: "+Math.abs(num1-num2));
  }


}

