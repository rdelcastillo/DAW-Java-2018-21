package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej10PosicicionCircunferencias {

  // ################################################################################
  // Algoritmo que pida los puntos centrales x1,y1,x2,y2 y los radios r1,r2 de dos
  // circunferencias y las clasifique en uno de estos estados:
  // exteriores
  // tangentes exteriores
  // secantes
  // tangentes interiores
  // interiores
  // concéntricas
  // ################################################################################
  // Análisis
  // Pedimos el centro (x1,y1) de una circunferencia y su radio r1, pedimos el
  // centro de otra circunferencia (x2,y2) y su radio r2.
  // En la siguiente página podemos aprender la relación entre dos circunferencias.
  // http://mimosa.pntic.mec.es/clobo/geoweb/circun3.htm
  // Datos de entrada: x1,y1,x3,y2,r1,r2 (real)
  // Información de salida: Tipo de relación entre las circunferencias
  // Variables: x1,y1,x3,y2,r1,r2 (real), distancia (real)
  // ################################################################################
  // Diseño
  // 1.Leer x1,y1,r1
  // 2.Leer x2,y2,r2
  // 3. Calcular distancia entre los centros
  // 4. Si distancia>suma de los radios mostrar "Circunferencias exteriores"
  // 5. Si distancia = suma de los radios mostrar "Tangentes exteriores"
  // 6. Si distancia < suma de los radios Y distancia> que el valor absoluto de la
  // resta de los radios mostrar "Circunferencias secante"
  // 7. Si distancia = que el valor absoluto de la resta de los radios mostrar
  // "Circunferencias tangentes interiores"
  // 8. Si distancia >0 y distancia < que el valor absoluto de la resta de los
  // radios mostrar "Circunferencias interiores"
  // 9. Si distancia = 0  mostrar "Circunferencias concéntricas"
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double distancia;
    double r1;
    double r2;
    double x1;
    double x2;
    double y1;
    double y2;

    // Pedimos datos
    System.out.print("Dime coordenada x primera circunferencia: ");
    x1 = s.nextDouble();
    System.out.print("Dime coordenada y primera circunferencia: ");
    y1 = s.nextDouble();
    System.out.print("Dime radio primera circunferencia: ");
    r1 = s.nextDouble();
    System.out.print("Dime coordenada x segunda circunferencia: ");
    x2 = s.nextDouble();
    System.out.print("Dime coordenada y segunda circunferencia: ");
    y2 = s.nextDouble();
    System.out.print("Dime radio segunda circunferencia: ");
    r2 = s.nextDouble();

    // Proceso
    distancia = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    // circunferencias exteriores
    // La distancia entre los centros, d, es mayor que la suma de los radios.
    if (distancia>(r1+r2)) {
      System.out.println("Circunferencias exteriores");
    }
    // circunferencias tangentes exteriores
    // La distancia entre los centros es igual a la suma de los radios.
    if (distancia==(r1+r2)) {
      System.out.println("Circunferencias tangentes exteriores");
    }
    // circunferencias secantes
    // La distancia  es menor que la suma de los radios y mayor que su diferencia.
    if (distancia<(r1+r2) && distancia>Math.abs(r1-r2)) {
      System.out.println("Circunferencias secantes");
    }
    // Circunferencias tangentes interiores
    // La distancia entre los centros es igual a la diferencia entre los radios.
    if (distancia==Math.abs(r1-r2)) {
      System.out.println("Circunferencias tangentes interiores");
    }
    // Circunferencias interiores
    // La distancia entre los centros es mayor que cero y menor que la diferencia entre los radios.
    if (distancia>0 && distancia<Math.abs(r1-r2)) {
      System.out.println("Circunferencias interiores");
    }
    // Circunferencias concétricas
    // La distancia = 0.
    if (distancia==0) {
      System.out.println("Circunferencias concétricas");
    }
  }


}

