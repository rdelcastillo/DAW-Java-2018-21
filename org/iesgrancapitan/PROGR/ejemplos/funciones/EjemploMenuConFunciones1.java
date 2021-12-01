package org.iesgrancapitan.PROGR.ejemplos.funciones;

import java.util.Scanner;

/**
 * Ejemplo de uso de menús usando funciones.
 * 
 * Tenemos dos números y mostraremos distintas operaciones con ellos.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class EjemploMenuConFunciones1 {

  public static void main(String[] args) {
    int a = 0;  // primer número con el que operar
    int b = 0;  // segundo número con el que operar
    int opcion;
    boolean continuar = true;
    
    do {
      opcion = menu();
      switch (opcion) {
        case 1: 
          Scanner s = new Scanner(System.in);
          System.out.print("\n\nIntroduce los valores de a y b: ");
          a = s.nextInt();
          b = s.nextInt();
          System.out.println("\n\n");
          break;
        case 2: 
          imprimeSuma(a, b);
          break;
        case 3: 
          imprimeResta(a, b);
          break;
        case 4: 
          imprimeMultiplicacion(a, b);
          break;
        case 5:
          imprimeDivision(a, b);
          break;
        case 6:
          continuar = false;
          break;
        default:
          System.out.println("\n\nOpción incorrecta.\n\n");
      }
    } while (continuar);
    System.out.println("\n\n¡Adiós!");
  }

  /**
   * Imprime el menú y devuelve la opción escogida.
   * @return opción
   */
  public static int menu() {
    // escribo el menú
    System.out.println("Menú de opciones");
    System.out.println("----------------");
    System.out.println("1. Introducir a y b.");
    System.out.println("2. Sumar a y b.");
    System.out.println("3. Restar a y b");
    System.out.println("4. Multiplicar a y b");
    System.out.println("5. Dividir a y b");
    System.out.println("6. Salir\n\n");
    
    // leo la opción
    Scanner s = new Scanner(System.in);
    System.out.print("Introduce una opción: ");
    return s.nextInt();
  }

  /**
   * Imprime la resta de a y b.
   * @param a
   * @param b
   */
  public static void imprimeResta(int a, int b) {
    System.out.println("\n\nLa resta de " + a + " y " + b + " es " + (a-b) + "\n\n");
  }

  /**
   * Imprime la suma de a y b.
   * @param a
   * @param b
   */
  public static void imprimeSuma(int a, int b) {
    System.out.println("\n\nLa suma de " + a + " y " + b + " es " + (a+b) + "\n\n");
  }

  /**
   * Imprime la multiplicación de a y b.
   * @param a
   * @param b
   */
  public static void imprimeMultiplicacion(int a, int b) {
    System.out.println("\n\nLa multiplicación de " + a + " y " + b + " es " + (a*b) + "\n\n");
  }

  /**
   * Imprime la división de a y b.
   * @param a
   * @param b
   */
  public static void imprimeDivision(int a, int b) {
    System.out.println("\n\nLa división de " + a + " y " + b + " es " + 
                      ((double) a/b) + "\n\n");
  }
  
}