package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej07CalcularHoras {

  // ################################################################################
  // Realiza un programa que reciba una cantidad de minutos y muestre por pantalla a
  // cuantas horas y minutos corresponde.
  // ################################################################################
  // Análisis
  // Tenemos que leer una cantidad de minutos, y calcular cuantas horas y minutos son.
  // Datos de entrada: minutos (entero)
  // Información de salida:horas y minutos (entero)
  // Variables: minutos, resHoras, resMinutos (entero).
  // ################################################################################
  // Diseño
  // 1. Leer los minutos
  // 2. Calcular a cuantas horas corresponde, división entera entre 60.
  // 3. calcular los minutos restantes: resto de la división entre 60.
  // 4. Mostrar horas y minutos
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int minutos;
    int resHoras;
    int resMin;

    System.out.println("Dime la cantidad de minutos:");
    minutos = s.nextInt();

    resHoras = minutos/60;
    resMin = minutos%60;
    System.out.println(resHoras+" horas y "+resMin+" minutos.");
  }


}

