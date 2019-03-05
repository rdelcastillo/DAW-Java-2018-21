package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej18DiaDeLaSemana {

  // ################################################################################
  // Realiza un programa que pida el dí­a de la semana (del 1 al 7) y escriba
  // el dí­a correspondiente.
  // Si introducimos otro número nos da un error.
  // ################################################################################
  // Análisis
  // Leer un día de la semana como número y mostrar el día que corresponde.
  // Si el número introducido es incorrecto mostrar mensaje de error.
  // Datos de entrada: día (entero)
  // Información de salida: nombre del día
  // Variables: día (entero)
  // ################################################################################
  // Diseño
  // 1. Leer día de la semana como entero
  // 2. Según el valor del día mostrar el nombre del día de la semana
  // 3. Si es un día incorrecto, mostrar mensaje de error
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int dia;

    // Pedimos datos
    System.out.print("Dime un día de la semana (1-7): ");
    dia = s.nextInt();

    // Proceso
    switch (dia) {
      case 1:
        System.out.println("Lunes");
        break;
      case 2:
        System.out.println("Martes");
        break;
      case 3:
        System.out.println("Miércoles");
        break;
      case 4:
        System.out.println("Jueves");
        break;
      case 5:
        System.out.println("Viernes");
        break;
      case 6:
        System.out.println("Sábado");
        break;
      case 7:
        System.out.println("Domingo");
        break;
      default:
        System.out.println("Día incorrecto");
    }
  }


}

