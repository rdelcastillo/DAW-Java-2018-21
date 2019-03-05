package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej11TipoTriangulo {

  // ################################################################################
  // Programa que lea 3 datos de entrada A, B y C. Estos corresponden a las
  // dimensiones de los lados de un triángulo.
  // El programa debe determinar que tipo de triángulo es, teniendo en cuenta:
  // Si se cumple Pitágoras entonces es triángulo rectángulo
  // Si sólo dos lados del triángulo son iguales entonces es isósceles.
  // Si los 3 lados son iguales entonces es equilátero.
  // Si no se cumple ninguna de las condiciones anteriores, es escaleno.
  // ################################################################################
  // Análisis
  // Pedir la medida de los tres lados de un triángulo:
  // Si se cumple el teorema de pitágoras es un triángulo rectángulo
  // Además, si tienes dos lados iguales y uno desigual, es isósceles
  // O si tiene todos los lados iguales es equilátero
  // o si son los tres distintos es escaleno.
  // Datos de entrada: los tres lados del triángulo (real)
  // Información de salida: Tipo de rectángulo
  // Variables: ladoA, ladoB, ladoC (real)
  // ################################################################################
  // Diseño
  // 1.Leer ladoA, ladoB, ladoC
  // 2.Si se cumple el teorema de pitágoras ( tenemos que suponer que cualquier
  // lado puede ser la hipotenusa) mostrar "Triángulo rectángulo"
  // 3.Si tiene dos lados iguales y uno desigual mostrar "Triángulo Isósceles"
  // 4. En otro caso, si tiene los tres lados iguales, mostrar "Triángulo Equilátero"
  // 5. En otro caso, mostrar "Triángulo Escaleno"
  // ################################################################################
  // Ejemplos
  // (3,4,5) rectángulo,escaleno
  // (7,7,9.8994949366117) rectángulo,isósceles
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double ladoa;
    double ladob;
    double ladoc;

    // Pedimos datos
    System.out.print("Introduce longitud lado A: ");
    ladoa = s.nextDouble();
    System.out.print("Introduce longitud lado B: ");
    ladob = s.nextDouble();
    System.out.print("Introduce longitud lado C: ");
    ladoc = s.nextDouble();

    // Pitágoras
    if (Math.pow(ladoa,2)+Math.pow(ladob,2)==Math.pow(ladoc,2) || Math.pow(ladob,2)+Math.pow(ladoc,2)==Math.pow(ladoa,2) || Math.pow(ladoc,2)+Math.pow(ladoa,2)==Math.pow(ladob,2)) {
      System.out.println("Triángulo Rectángulo");
    }
    // isósceles
    if ((ladoa==ladob && ladoa!=ladoc) || (ladob==ladoc && ladob!=ladoa) || (ladoc==ladoa && ladoc!=ladob)) {
      System.out.println("Triángulo Isósceles");
    // equilátero
    } else if (ladoa==ladob && ladoa==ladoc) {
        System.out.println("Triángulo Equilátero");
    // escaleno
    } else {
        System.out.println("Triángulo Escaleno");
    }
  }


}

