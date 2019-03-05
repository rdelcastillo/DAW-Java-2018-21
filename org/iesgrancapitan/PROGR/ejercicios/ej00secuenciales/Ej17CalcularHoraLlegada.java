package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;
/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej17CalcularHoraLlegada {

  // ################################################################################
  // Un ciclista parte de una ciudad A a las HH horas, MM minutos y SS segundos.
  // El tiempo de viaje hasta llegar a otra ciudad B es de T segundos.
  // Escribir un algoritmo que determine la hora de llegada a la ciudad B.
  // ################################################################################
  // Análisis
  // Tenemos que pedir la hora de salida (hora, minutos y segundos).
  // Tengo que saber también el tiempo en segundo que ha tardado en llegar.
  // Tenemos que calcular la hora de llegada.
  // Datos de entrada: hora, minutos y segundos de salida (entero),
  // segundos que tarda (entero).
  // Información de salida: hora, minutos y segundos de llegada (enteros)
  // Variables: horapartida, minpartida, segpartida, segviaje, horallegada,
  // minllegada, segllegada (enteros)
  // ################################################################################
  // Diseño
  // 1. Leer hora de salida
  // 2. Leer segundos que tarda
  // 3. Convierto la hora de salida a segundos (necesito una variable seginicial)
  // 4 Le sumo los segundos que he tardado(necesito una variable segfinal)
  // 5. Convierto los segundos totales a hora, minuto y segundos
  // 6. Muestro la hora de llegada
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int horallegada;
    int horapartida;
    int minllegada;
    int minpartida;
    int segfinal;
    int seginicial;
    int segllegada;
    int segpartida;
    int segviaje;

    System.out.print("Hora de salida: ");
    horapartida = s.nextInt();
    System.out.print("Minutos de salida: ");
    minpartida = s.nextInt();
    System.out.print("Segundos de salida: ");
    segpartida = s.nextInt();
    System.out.print("Tiempo que has tardado en segundos: ");
    segviaje = s.nextInt();

    // Convierto la hora de salida a segundos
    seginicial = horapartida*3600+minpartida*60+segpartida;
    // Le sumo los segundos que he tardado
    segfinal = seginicial+segviaje;
    // Convierto los segundos totales a hora, minúto y segundos
    horallegada = segfinal/3600;
    minllegada = (segfinal%3600)/60;
    segllegada = (segfinal%3600)%60;

    // Muestro la hora de llegada
    System.out.print("Hora de llegada ");
    System.out.println(horallegada+":"+minllegada+":"+segllegada);
  }


}

