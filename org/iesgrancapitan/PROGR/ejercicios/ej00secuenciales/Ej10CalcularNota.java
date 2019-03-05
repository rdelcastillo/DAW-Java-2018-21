package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej10CalcularNota {

  // ################################################################################
  // Un alumno desea saber cual será su calificación final en la materia de Algoritmos
  // Dicha calificación se compone de los siguientes porcentajes:
  // * 55% del promedio de sus tres calificaciones parciales.
  // * 30% de la calificación del examen final.
  // * 15% de la calificación de un trabajo final.
  // ################################################################################
  // Análisis
  // Hay que leer las notas parciales, la nota del examen final
  // y la nota del trabajo final.
  // Posteriormente se calculan los porcentajes y se suman.
  // Datos de entrada: tres calificaciones parciales, nota examen final,
  // nota trabajo final (real).
  // Información de salida: nota final (real).
  // Variables: parcial,parcial2,parcial3,examen, trabajo, nota(real).
  // ################################################################################
  // Diseño
  // 1. Leer las notas parciales, del examen final y del trabajo.
  // 2. Calculamos la nota 55% de la media de las notas parciales,
  // más el 30% de la nota del examen mas 15% de la nota del trabajo.
  // 3. Mostrar nota final
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double examen;
    double nota;
    double parcial1;
    double parcial2;
    double parcial3;
    double trabajo;

    System.out.println("Dime la nota del parcial 1:");
    parcial1 = s.nextDouble();
    System.out.println("Dime la nota del parcial 2:");
    parcial2 = s.nextDouble();
    System.out.println("Dime la nota del parcial 3:");
    parcial3 = s.nextDouble();
    System.out.println("Dime la nota del examen:");
    examen = s.nextDouble();
    System.out.println("Dime la nota del trabajo:");
    trabajo = s.nextDouble();

    nota = ((parcial1+parcial2+parcial3)/3)*0.55+0.3*examen+0.15*trabajo;
    System.out.println("Nota final: "+nota);
  }


}

