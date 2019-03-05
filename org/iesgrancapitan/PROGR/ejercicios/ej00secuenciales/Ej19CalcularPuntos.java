package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;
/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej19CalcularPuntos {

  // ################################################################################
  // Escribir un algoritmo para calcular la nota final de un estudiante, considerando que:
  // por cada respuesta correcta 5 puntos, por una incorrecta -1 y por respuestas en
  // blanco 0. Imprime el resultado obtenido por el estudiante.
  // ################################################################################
  // Análisis
  // Se piden la cantidad de respuestas correctas, incorrectas. Calculamos la nota 5:
  // 5 puntos por respuesta correcta, -1 por incorrecta.
  // Datos de entrada:respuesta correctas, incorrectas y en blanco(entero).
  // Información de salida: puntos (entero)
  // Variables: correctas, incorrectas, puntos (entero)
  // ################################################################################
  // Diseño
  // 1. Leer preguntas correctas, incorrectas y en blanco
  // 2. Calcular nota: número de correctas * 5 + número de incorrectas * -1
  // 3. Mostrar puntos
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int correctas;
    int incorrectas;
    int puntos;

    System.out.print("Dime cantidad de respuestas correctas: ");
    correctas = s.nextInt();
    System.out.print("Dime cantidad de respuestas incorrectas: ");
    incorrectas = s.nextInt();

    puntos = correctas*5+incorrectas*(-1);
    System.out.println("Puntos: "+puntos);
  }


}

