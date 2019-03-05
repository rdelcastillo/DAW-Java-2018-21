package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net). */

// En java, el nombre de un archivo fuente debe coincidir con el nombre de la clase que contiene,
// por lo que este archivo debería llamarse "CALCULARHIPOTENUSA.java."

import java.util.Scanner;

public class Ej03CalcularHipotenusa {

  // ################################################################################
  // Dados los catetos de un triángulo rectángulo, calcular su hipotenusa.
  // ################################################################################
  // Análisis
  // Tenemos que leer la longitud de los dos catetos y calcular la hipotenusa.
  // (Teorema de Pitágoras)
  // Variables de entrada: cateto1(real), cateto2(real)
  // Variables de salida: hipotenusa(real)
  // ################################################################################
  // Diseño
  // 1. Leer la longitud de los catetos
  // 2. Calcular hipotenusa (En un triángulo rectángulo el cuadrado de la hipotenusa
  // es igual a la suma de los cuadrados de los catetos. )
  // Por lo tanto la hipotenusa es igual a la raí­z cuadrada de la suma de los
  // cuadrados de los catetos.
  // 3. Mostrar la hipotenusa
  // ################################################################################
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double cateto1;
    double cateto2;
    double hipotenusa;

    // Pedimos datos
    System.out.println("Introduce el cateto 1:");
    cateto1 = s.nextDouble();
    System.out.println("Introduce la cateto 2:");
    cateto2 = s.nextDouble();

    // Cálculo ymuestra resultados
    hipotenusa = Math.sqrt(Math.pow(cateto1,2)+Math.pow(cateto2,2));
    System.out.println("La hipotenusa es "+hipotenusa);
  }


}

