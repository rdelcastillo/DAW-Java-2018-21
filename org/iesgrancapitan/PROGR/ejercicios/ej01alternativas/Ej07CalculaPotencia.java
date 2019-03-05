package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej07CalculaPotencia {

  // ################################################################################
  // Realiza un algoritmo que calcule la potencia, para ello pide por teclado
  // la base y el exponente. Pueden ocurrir tres cosas:
  // * El exponente sea positivo, sólo tienes que imprimir la potencia.
  // * El exponente sea 0, el resultado es 1.
  // * El exponente sea negativo, el resultado es 1/potencia con el exponente positivo.
  // ################################################################################
  // Análisis
  // Pedimos por teclado dos números: base y exponente
  // Tenemos que comprobar el exponente: si es 0 la potencia es 1,
  // si es menor que 0 la potencia es 1/potencia (con el exponente positivo)
  // y si es mayor que 0 se calcula la potencia.
  // Datos de entrada: base,exponente (entero)
  // Información de salida: Valor de la potencia
  // Variables: base,exponente (entero)
  // ################################################################################
  // Diseño
  // 1. Leer la base y el exponente
  // 2. Si el exponente es igual a 0 se calcula y muestra el resultado de la potencia
  // 3. En caso contrario, si es igual a 0, el resultado de la potencia es 1.
  // 4. En caso contrario,el resultado de la potencia es 1/potencia
  // (con el exponente positivo).
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int base;
    int exponente;

    System.out.print("Dime la base: ");
    base = s.nextInt();
    System.out.print("Dime el exponente: ");
    exponente = s.nextInt();

    if (exponente>0) {
      System.out.println("La potencia es "+Math.pow(base,exponente));
    } else if (exponente==0) {
      System.out.println("La potencia es 1");
    } else {
      System.out.println("La potencia es "+1/(Math.pow(base,Math.abs(exponente))));
    }

  }


}

