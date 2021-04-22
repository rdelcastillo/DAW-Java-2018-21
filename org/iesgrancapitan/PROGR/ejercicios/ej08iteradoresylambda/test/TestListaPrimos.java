package org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda.test;

import org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda.ListaPrimos1;
import org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda.ListaPrimos2;

public class TestListaPrimos {

  private static final int MAX = 100;

  public static void main(String[] args) {
    
    System.out.println("Lista de números primos (v1) hasta " + MAX);
    System.out.println("--------------------------------------");
    var listaPrimos1 = new ListaPrimos1(MAX);
    int n = 1;
    for (long primo: listaPrimos1) {
      System.out.println("Primo nº " + n++ + ":\t" + primo);
    }
    System.out.println();

    System.out.println("Lista de números primos (v2) hasta " + MAX);
    System.out.println("--------------------------------------");
    var listaPrimos2 = new ListaPrimos2(MAX);
    n = 1;
    for (long primo: listaPrimos2) {
      System.out.println("Primo nº " + n++ + ":\t" + primo);
    }
  }
}
