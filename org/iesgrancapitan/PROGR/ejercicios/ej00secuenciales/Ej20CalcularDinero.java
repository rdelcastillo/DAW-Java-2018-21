package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;
/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej20CalcularDinero {

  // ################################################################################
  // Diseñar un algoritmo que nos diga el dinero que tenemos (en euros y céntimos)
  // después de pedirnos cuantas monedas tenemos de 2e, 1e, 50 céntimos, 20 céntimos
  // o 10 céntimos).
  // ################################################################################
  // Análisis
  // Se piden la cantidad de monedas que tenemos (de 2e, 1e, 50 céntimos,
  // 20 céntimos o 10 céntimos) y calculamos el dinero que tenemos (euros y céntimos)
  // Datos de entrada: monedas de 2e, 1e, 50 céntimos, 20 céntimos o 10 céntimos) (entero).
  // Información de salida: total de dinero: euros y céntimos (enteros)
  // Variables: euro2,euro1,cent50,cent20,cent10, total_euros, total_centimos (entero)
  // ################################################################################
  // Diseño
  // 1. Leer el monedas de 2e, 1e, 50 céntimos, 20 céntimos o 10 céntimos.
  // 2. Calcular Euros (sumar monedas de 2 euros * 2 + monedas de 1 euro
  // 3. Calcular céntimos
  // monedas de 50c * 50 + monedas de 30c * 30 + moneda de 20c * 20 + moneda de 10c * 10
  // 4. Convertir céntimos a euros (división entera entre 100)
  // 5. Mostrar euros y céntimos totales
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int cent10;
    int cent20;
    int cent50;
    int euro1;
    int euro2;
    int totalCentimos;
    int totalEuros;

    System.out.print("Monedas de 2 euros: ");
    euro2 = s.nextInt();
    System.out.print("Monedas de 1 euro: ");
    euro1 = s.nextInt();
    System.out.print("Monedas de 50 céntimos: ");
    cent50 = s.nextInt();
    System.out.print("Monedas de 20 céntimos: ");
    cent20 = s.nextInt();
    System.out.print("Monedas de 10 céntimos: ");
    cent10 = s.nextInt();

    // 2. Calular Euros (sumar monedas de 2 euros * 2 + monedas de 1 euro
    totalEuros = euro2*2+euro1;
    // 3. Calcular centimos (monedas de 50c * 50 + monedas de 30c * 30 + moneda de 20c * 20 `moneda de 10c * 10
    totalCentimos = cent50*50+cent20*20+cent10*10;
    // 4. Convertir céntimos a euros (división entera entre 100)
    totalEuros = totalEuros+(totalCentimos/100);
    totalCentimos = totalCentimos%100;

    System.out.println(totalEuros+" euros y "+totalCentimos+" céntimos.");
  }


}

