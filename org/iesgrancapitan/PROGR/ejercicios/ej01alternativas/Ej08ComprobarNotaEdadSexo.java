package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej08ComprobarNotaEdadSexo {

  // ################################################################################
  // Algoritmo que pida dos números 'nota' y 'edad' y un carácter 'sexo'
  // y muestre el mensaje 'ACEPTADA' si la nota es mayor o igual a cinco,
  // la edad es mayor o igual a dieciocho y el sexo es 'F'.
  // En caso de que se cumpla lo mismo, pero el sexo sea 'M', debe imprimir 'POSIBLE'.
  // Si no se cumplen dichas condiciones se debe mostrar 'NO ACEPTADA'.
  // ################################################################################
  // Análisis
  // Pedimos por teclado dos números: nota y edad y un carácter sexo.
  // Se muestra "ACEPTADA" si nota>=5, edad>=18 y el sexo es femenino.
  // Si se cumple las mismas condiciones pero con el sexo masculino -> "POSIBLE"
  // en caso contrario se muestra "NO ACEPTADA"
  // Datos de entrada: nota, edad (entero) y sexo (cadena)
  // Información de salida: Mensaje de información
  // Variables: nota, edad (entero) y sexo (cadena)
  // ################################################################################
  // Diseño
  // 1. Leer la nota, la edad y el sexo
  // 2. si nota>=5, edad>=18
  // 3. si sexo="F" mostrar "ACEPTADA"
  // 4. si sexo="M" mostrar "POSIBLE"
  // 5. En caso contrario, mostrar "NO ACEPTADA"
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int edad;
    int nota;
    String sexo;

    // Pedimos datos
    System.out.print("Introduce la nota: ");
    nota = s.nextInt();
    System.out.print("Introduce la edad: ");
    edad = s.nextInt();
    s.nextLine();  // Para evitar problemas: https://es.stackoverflow.com/questions/22395/scanner-nextline-no-actua-correctamente-despues-de-scanner-nextint
    System.out.print("Introduce el sexo (F/M): ");
    sexo = s.nextLine();

    // Proceso
    if (nota>=5 && edad>=18) {
      if (sexo.toUpperCase().equals("F")) {
        System.out.println("Aceptada");
      } else if (sexo.toUpperCase().equals("M")) {
          System.out.println("Posible");
      } else {
          System.out.println("El sexo no es F ni M. No Aceptada");
      }
    } else {
      System.out.println("No Aceptada");
    }
  }


}

