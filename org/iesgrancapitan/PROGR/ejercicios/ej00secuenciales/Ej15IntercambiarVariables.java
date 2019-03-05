package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;
/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej15IntercambiarVariables {

  // ################################################################################
  // Dadas dos variables numÃ©ricas A y B, que el usuario debe teclear,
  // se pide realizar un algoritmo que intercambie los valores de ambas variables
  // y muestre cuanto valen al final las dos variables.
  // ################################################################################
  // Análisis
  // Se piden el valor de dos variables (el tipo puede ser el que queramos).
  // Hay que intercambiar los valores de las variables
  // Datos de entrada: dos números en dos variables (entero).
  // Información de salida: Las dos variables pero con los datos cambiados (entero)
  // Variables: a,b (entero).
  // ################################################################################
  // Diseño
  // 1. Leer los dos números
  // 2. Intercambio los valores. Necesito una variable auxiliar (aux).
  // Asigno "a" en "aux", "b" en "a" y "aux" en "b"
  // 3. Mostrar "a" y "b"
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int a;
    int b;
    int aux; //auxiliar

    // Pedimos datos
    System.out.print("Introduce valor de la variable A: ");
    a = s.nextInt();
    System.out.print("Introduce valor de la variable B: ");
    b = s.nextInt();

    // Intercambiamos variables usando la auxiliar
    aux = a;
    a = b;
    b = aux;

    // Mostramos resultados
    System.out.println("Nuevo valor de A: "+a);
    System.out.println("Nuevo valor de B: "+b);
  }


}

