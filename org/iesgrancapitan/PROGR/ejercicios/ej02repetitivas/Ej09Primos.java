package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej09Primos {

  // ################################################################################
  // Mostrar en pantalla los N primeros números primos. Se pide por teclado la cantidad
  // de números primos que queremos mostrar.
  // ################################################################################
  // Análisis
  // Tengo que leer la cantidad de números primos que voy a mostrar. La cantidad debe
  // ser positivo. El primer número primo es el 2 (lo muestro) a partir de este son
  // todos impares. Voy probando desde el 3 todos los impares hasta que muestre la
  // cantidad que hemos indicados (necesito un contador).
  // Para comprobar si son primos, los voy dividiendo desde 3 hasta la raíz cuadrada
  // del número, si es divisible por algún número no es primo (necesito un indicador).
  // Datos de entrada: Cantidad de números a mostrar.
  // Información de salida: Los números primos indicados.
  // Variables: cantidadAMostrar, cant_mostradis, divisor (entero), esPrimo(lógico)
  // ################################################################################
  // Diseño
  // 1.- Leer cantidad de número primos a mostrar, debe ser positivo
  // 2.- Muestro el primer número primo, el 2.
  // 3.- Inicializo el contador de número mostrados a 1.
  // 4.- Inicializo la variable donde guardo el número a probar -> num=3
  // 4.- Mientras no haya mostrado la cantidad de número indicados
  // 5.- Considero que es primo. Inicializo el indicador -> esPrimo=Verdadero
  // 6.- desde el 3 hasta la raíz cuadrada del número
  // 7.- Si es divisible -> Ya no es primo -> esPrimo=Falso
  // 8.- Si es primo
  // 9.- Incremento el contador de números mostrados
  // 10.- Escribo el número primo
  // 11.- Como son impares, incremento en 2 el número a probar
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int cantidadAMostrar;
    int cantidadMostrados;
    int num;

    // Pedimos datos
    do {
      System.out.print("Ingrese la cantidad de números primos a mostrar: ");
      cantidadAMostrar = s.nextInt();
    } while (cantidadAMostrar<=0);

    // Proceso

    // el primer primo es 2, los otros son todos impares...
    System.out.println("1: 2");
    cantidadMostrados = 1;
    // ...a partir de 3
    num = 3;
    while (cantidadMostrados < cantidadAMostrar) {
      // pienso que es primo hasta que encuentre con que dividirlo
      boolean esPrimo = true;
      // ya sabemos que es impar
      for (int divisor=3; divisor<=Math.sqrt(num) && esPrimo; divisor+=2) {
        // si la división da exacta...
        if (num%divisor==0) {
          // ...ya no es primo
          esPrimo = false;
        }
      }
      if (esPrimo) {
        cantidadMostrados++;
        System.out.println(cantidadMostrados+": "+num);
      }
      num += 2;
    }
  }


}

