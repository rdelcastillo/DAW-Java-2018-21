package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej09OrdenarNumeros {

  // ################################################################################
  // Algoritmo que pida tres números y los muestre ordenados (de mayor a menor);
  // ################################################################################
  // Análisis
  // Pedimos por teclado tres números, se comparan para mostrarlos ordenados.
  // Datos de entrada: num1, num2, num3 (entero)
  // Información de salida: Los tres número ordenados de mayor a menor
  // Variables: num1, num2, num3 (entero)
  // ################################################################################
  // Diseño
  // 1. Leer num1,num2,num3
  // 2. Si num1>num2>num3 mostrar num1,num2,num3
  // 3. Si num2>num1>num3 mostrar num2,num1,num3
  // 4. Si num2>num3>num1 mostrar num2,num3,num1
  // 5. Si num3>num2>num1 mostrar num3,num2,num1
  // 6. Si num3>num1>num2 mostrar num3,num1,num2
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int num1;
    int num2;
    int num3;

    // Pedimos datos
    System.out.print("Dime el número 1: ");
    num1 = s.nextInt();
    System.out.print("Dime el número 2: ");
    num2 = s.nextInt();
    System.out.print("Dime el número 3: ");
    num3 = s.nextInt();

    // Proceso
    if (num1>num2 && num1>num3) {
      if (num2>num3) {
        System.out.println(num1+" "+num2+" "+num3);
      } else {
        System.out.println(num1+" "+num3+" "+num2);
      }
    }
    if (num2>num1 && num2>num3) {
      if (num1>num3) {
        System.out.println(num2+" "+num1+" "+num3);
      } else {
        System.out.println(num2+" "+num3+" "+num1);
      }
    }
    if (num3>=num1 && num3>=num2) {
      if (num1>num2) {
        System.out.println(num3+" "+num1+" "+num2);
      } else {
        System.out.println(num3+" "+num2+" "+num1);
      }
    }
  }


}

