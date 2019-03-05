package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;
/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej12CalcularDistanciaEntrePuntos {

  // ################################################################################
  // Pide al usuario dos pares de números x1,y2 y x2,y2, que representen dos puntos
  // en el plano. Calcula y muestra la distancia entre ellos.
  // ################################################################################
  // Análisis
  // Se piden dos puntos y se calcula la distancia entre ellos.
  // Datos de entrada: dos puntos; cuatro coordenadas (x1,y1) (x2,y2) (entero).
  // Información de salida: distancia (real).
  // Variables: x1,y1,x2,y2(entero), distancia(real).
  // ################################################################################
  // Diseño
  // 1. Leer las cuatro coordenadas.
  // 2. Calcular distancia: raíz cuadrada de (x2-x1)^2 + (y2-y1)^2
  // 3. Mostrar distancia
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double distancia;
    int x1;
    int x2;
    int y1;
    int y2;

    System.out.println("Dime las coordenadas del punto 1:");
    x1 = s.nextInt();
    y1 = s.nextInt();
    System.out.println("Dime las coordenadas del punto 2:");
    x2 = s.nextInt();
    y2 = s.nextInt();

    distancia = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));

    System.out.println("Distancia: "+distancia);
  }


}

