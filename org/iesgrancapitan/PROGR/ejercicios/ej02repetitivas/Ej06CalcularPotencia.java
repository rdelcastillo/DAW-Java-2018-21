package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej06CalcularPotencia {

  // ################################################################################
  // Escribe un programa que dados dos números, uno real (base) y un entero positivo
  // (exponente), saque por pantalla el resultado de la potencia. No se puede
  // utilizar el operador de potencia.
  // ################################################################################
  // Análisis
  // Leo la base y el exponente de una potencia.
  // El exponente me tengo que asegurar que es positivo.
  // Para realizar la potencio tengo que acumular el productor de la base tantas veces
  // como indique el exponente.
  // Datos de entrada: La base y el exponente
  // Información de salida:La potencia
  // Variables:base,potencia(Real), exponente(entero), i (indice del bucle para)
  // ################################################################################
  // Diseño
  // 1.- Inicializo el acumulador para multiplicación -> potencia <- 1
  // 2.- Leer base
  // 3.- Repetir -> Leer exponente -> hasta que exponente sea positivo
  // 4.- Desde 1 hasta el exponente
  // 5.- Acumulo la multiplicación de la base -> potencia<-potencia*base
  // 6.- Muestro potencia
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double base;
    int exponente;
    double potencia;

    // Pedimos datos
    System.out.print("Dame la base de la potencia: ");
    base = s.nextDouble();
    do {
      System.out.print("Dame el exponente de la potencia: ");
      exponente = s.nextInt();
      if (exponente<0) {
        System.out.println("ERROR: El exponente debe ser positivo");
      }
    } while (exponente<0);

    // Proceso
    potencia = 1;
    for (int i=1;i<=exponente;i++) {
      potencia *= base;
    }
    System.out.println("Potencia: "+potencia);
  }


}

