package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej17Dado {

  // ################################################################################
  // Realiza un programa que pida por teclado el resultado (dato entero) obtenido
  // al lanzar un dado de seis caras y muestre por pantalla el número en letras
  // (dato cadena) de la cara opuesta al resultado obtenido.
  // * Nota 1: En las caras opuestas de un dado de seis caras están los números:
  // 1-6, 2-5 y 3-4.
  // * Nota 2: Si el número del dado introducido es menor que 1 o mayor que 6,
  // se mostrará el mensaje: "ERROR: número incorrecto.".
  // ################################################################################
  // Análisis
  // Leer la cara del dado como entero
  // y mostrar el número de la cara opuesta con letras.
  // Si el número introducido es incorrecto mostrar mensaje de error.
  // Datos de entrada: número de la cara (entero)
  // Información de salida: número de la cara opuesta (carácter)
  // Variables: cara (entero)
  // ################################################################################
  // Diseño
  // 1. Leer número de la cara
  // 2. Según el valor introducido:
  // 3. Si es = 1 muestro "SEIS"
  // 4. Si es = 2 muestro "CINCO"
  // 5. Si es = 3 muestro "CUATO"
  // 6. Si es = 4 muestro "TRES"
  // 7. Si es = 5 muestro "DOS"
  // 8. Si es = 6 muestro "UNO"
  // 9. Si es otro número, mostrar mensaje de error
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int cara;

    // Pedimos datos
    System.out.print("Introduce el número de la cara: ");
    cara = s.nextInt();

    // Proceso
    switch (cara) {
      case 1:
        System.out.println("SEIS");
        break;
      case 2:
        System.out.println("CINCO");
        break;
      case 3:
        System.out.println("CUATRO");
        break;
      case 4:
        System.out.println("TRES");
        break;
      case 5:
        System.out.println("DOS");
        break;
      case 6:
        System.out.println("UNO");
        break;
      default:
        System.out.println("Error: número incorrecto.");
    }
  }


}

