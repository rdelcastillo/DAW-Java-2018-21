package org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda.test;

import java.util.function.Function;
import org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda.SucesionGenerica;
import org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda.util.Matematicas;

public class TestSucesionGenerica {
  
  private static int SIZE = 10;

  public static void main(String[] args) {
    
    muestraSucesion("pares", n -> n*2L);
    muestraSucesion("impares", n -> (n-1)*2L + 1);
    muestraSucesion("múltiplos de 5", n -> n*5L);
    muestraSucesion("potencias de 2", n -> (long) Math.pow(2, n));
    muestraSucesion("Fibonnacci", n -> Matematicas.Fibonacci(n));
    muestraSucesion("aleatorios entre 1 y 100", n -> (long) (100 * Math.random()) + 1); // no uso n
  }
  
  static void muestraSucesion(String nombre, Function<Integer,Long> lambda) {
    var sucesion = new SucesionGenerica(SIZE, lambda);
    System.out.print("Sucesión de " + nombre + ": ");
    sucesion.forEach(elemento -> System.out.print(elemento + " "));
    System.out.println("\n");
  }

}
