package org.iesgrancapitan.PROGR.Java.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej06EsMayusculas {

  // ################################################################################
  // Programa que lea una cadena por teclado y compruebe si es una letra mayúscula.
  // ################################################################################
  // Análisis
  // Pedimos por teclado una cadena
  // y hay que comprobar que todas las letras sean mayúsculas.
  // Datos de entrada: cadena (cadena)
  // Información de salida: Mensajes de es mayúsculas o no es mayúsculas.
  // Variables: cadena (cadena)
  // ################################################################################
  // Diseño
  // 1. Leer la cadena
  // 2. Si la cadena es igual a la cadena convertida en mayúsculas,
  // mostrar "La cadena es mayúsculas"
  // 3. En caso contrario mostrar "La cadena no es mayúsculas"
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String cad;

    // Pedir datos
    System.out.print("Introduce una cadena: ");
    cad = s.nextLine();

    // Comprobamos ymostramos resultados
    if (cad.length()==1 && (cad.compareTo("A")>=0 && cad.compareTo("Z")<=0)) {
      System.out.println("La cadena es una letra mayúscula");
    } else {
      System.out.println("La cadena no es una letra mayúscula");
    }
  }


}

