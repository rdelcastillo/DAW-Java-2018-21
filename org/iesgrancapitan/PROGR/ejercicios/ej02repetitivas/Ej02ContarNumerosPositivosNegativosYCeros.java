package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej02ContarNumerosPositivosNegativosYCeros {

  // ################################################################################
  // Realizar un algoritmo que pida números (se pedirá por teclado la cantidad de
  // números a introducir). El programa debe informar de cuantos números introducidos
  // son mayores que 0, menores que 0 e iguales a 0.
  // ################################################################################
  // Análisis
  // Se pide la cantidad de números que se van a leer. Vamos introduciendo números.
  // Tenemos que contar los positivos, negativos y 0.
  // Datos de entrada:Cantidad de números, los números.
  // Información de salida: Cantidad de positivos, de negativos y de 0.
  // Variables:cantidad_num,num,contPositivos,cant_negativos,cantidad_ceros(entero)
  // ################################################################################
  // Diseño
  // 1.- Inicializo los contadores
  // 2.- Leer cantidad de números
  // 3.- Desde 1 hasta cantidad de números
  // 4.- Leer num
  // 5.- Si num> 0-> incremento contPositivos
  // 6.- Si num< 0-> incremento contNegativos
  // 7.- Si num = 0-> incremento contCeros.
  // Muestro cont_postivos, contNegativos, contCeros
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int cantidad_num;
    int contCeros = 0;
    int contNegativos = 0;
    int contPositivos = 0;
    int i;
    int num;

    // Pedimos cantidad de números a introducir
    System.out.print("¿Cuántos números vas a introducir?: ");
    cantidad_num = s.nextInt();

    // Ciclo
    for (i=1; i<=cantidad_num; i++) {
      System.out.print("Número "+i+": ");
      num = s.nextInt();
      // Comprobamos si es +, - ó 0 e incrementamos contador
      if (num>0) {
        contPositivos = contPositivos+1;
      } else if (num<0) {
          contNegativos = contNegativos+1;
      } else {
          contCeros = contCeros+1;
      }
    }

    // Mostramos resultados
    System.out.println("Números positivos: "+contPositivos);
    System.out.println("Números negativos: "+contNegativos);
    System.out.println("Números igual a 0: "+contCeros);
  }


}

