package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net). */

// En java, el nombre de un archivo fuente debe coincidir con el nombre de la clase que contiene,
// por lo que este archivo debería llamarse "RECTANGULO.java."

import java.util.Scanner;

public class Ej02Rectangulo {

  // ################################################################################
  // Calcular el perí­metro y área de un rectángulo dada su base y su altura.
  // ################################################################################
  // Análisis
  // Tenemos que leer la base y la altura del triangulo y calcular el perí­metro y el
  // área
  // Datos de entrada: base(real), altura(real)
  // Información de salida: perímetro(real) y área(real)
  // Variables: base, altura, perimetro y area (Real)
  // ################################################################################
  // Diseño
  // 1. Leer base y altura
  // 2. Calcular perí­metro(2*base + 2*altura)
  // 3. Calcular área (base * altura
  // 4. Mostrar perí­metro y área
  // ################################################################################
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double altura;
    double area;
    double base;
    double perimetro;
    System.out.println("Introduce la base:");
    base = Double.parseDouble(s.nextLine());
    System.out.println("Introduce la altura:");
    altura = Double.parseDouble(s.nextLine());
    perimetro = 2*base+2*altura;
    area = base*altura;
    System.out.println("El perí­metro es "+perimetro+" y el área es "+area);
  }


}

