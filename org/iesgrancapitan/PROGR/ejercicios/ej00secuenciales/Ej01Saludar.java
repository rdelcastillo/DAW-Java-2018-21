package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net). */

// En java, el nombre de un archivo fuente debe coincidir con el nombre de la clase que contiene,
// por lo que este archivo debería llamarse "SALUDAR.java."

import java.util.Scanner;

public class Ej01Saludar {

  // ################################################################################
  // Escribir un programa que pregunte al usuario su nombre, y luego lo salude.
  // ################################################################################
  // Análisis
  // Tenemos que pedir un nombre por teclado y luego escribir un mensaje de saludo
  // Datos de entrada: nombre (Cadena)
  // Variables: nombre (Cadena)
  // ################################################################################
  // Diseño
  // 1. Leer nombre
  // 2. Escribir mensaje de saludo
  // ################################################################################
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String nombre;
    System.out.println("Dime tu nombre:");
    nombre = s.nextLine();
    System.out.println("Hola "+nombre);
  }


}

