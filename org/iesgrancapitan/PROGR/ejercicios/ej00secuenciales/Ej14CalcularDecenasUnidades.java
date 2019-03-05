package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;
/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej14CalcularDecenasUnidades {

  // ################################################################################
  // Dado un número de dos cifras, diseÃ±e un algoritmo que permita obtener el
  // número invertido.
  // ################################################################################
  // Análisis
  // Se pide un número de dos cifras y se debe mostrar el número de centenas
  // y de unidades
  // Datos de entrada: el número (entero).
  // Información de salida: primera cifra, segunda cifra (enteros)
  // Variables: num, decenas, unidades (entero)
  // ################################################################################
  // Diseño
  // 1. Leer el número de dos cifras (en estos momentos no podemos determinar que el
  // número es de dos cifras)
  // 2. Calcular decenas: división entera del número entre 10.
  // 3. Calcular unidades: resto de dividir el número entre 10.
  // 4. Mostrar decenas y unidades
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int decenas;
    int num;
    int unidades;

    System.out.print("Dime un número de dos cifras: ");
    num = s.nextInt();

    decenas = num/10;
    unidades = num%10;

    System.out.println("Primera cifra (decenas): "+decenas);
    System.out.println("Segunda cifra (unidades): "+unidades);
    System.out.println("El número invertido es "+(10*unidades+decenas));
  }


}

