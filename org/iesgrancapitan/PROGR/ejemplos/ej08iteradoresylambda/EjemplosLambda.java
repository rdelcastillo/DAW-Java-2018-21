package org.iesgrancapitan.PROGR.ejemplos.ej08iteradoresylambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Ejemplos de uso de expresiones lambda.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class EjemplosLambda {
  
  // Interfaz funcional para lambda.
  // El decorador no es obligatorio, aunque aconsejable.
  // Los objetos lambda de este tipo deberán tener un parámetro String y su código encajará 
  // en el método run() (nos vale cualquier otro identificador, pero solo un método abstracto).
  @FunctionalInterface
  interface LambdaConParametro {
    void run(String mensaje);
  }
  
  @FunctionalInterface
  interface LambdaSinParametros {
    void hazAlgo();
  }
  
  public static void main(String[] args) {
    
    // creamos una expresión lambda con la interfaz funcional
    LambdaSinParametros lambdaAbsurda = () -> System.out.println("No hago nada de nada.");
    lambdaAbsurda.hazAlgo();
    
    LambdaConParametro lambdaMensaje = (mensaje) -> {
      System.out.print("\nExpresiones lambda");
      System.out.print(": ");
      System.out.println(mensaje);
      System.out.println("-".repeat(mensaje.length() + 20));
    };
    
    lambdaMensaje.run("las podemos pasar a un método como parámetro, como a un 'foreach' de una lista");
    List<Integer> lista = List.of(1,2,3,4,5);
    lista.forEach(elemento -> System.out.println("Mi valor es " + elemento));
    
    lambdaMensaje.run("tipo 'Consumidor': acepta un solo valor y no devuelve ninguno");
    Consumer<String> lambdaImprime1 = mensaje -> System.out.println(mensaje);
    lambdaImprime1.accept("Soy una lambda consumidora.");
    
    lambdaMensaje.run("expresión lambda tipo 'Proveedor': no tiene parámetros pero devuelve resultado");
    Supplier<Double> lambdaAleatorio = () -> Math.random();
    for (int i = 1; i <= 10; i++) {
      System.out.println("Aleatorio entre 0 y 1: " + lambdaAleatorio.get());
    }
    
    lambdaMensaje.run("expresión lambda tipo 'Función': tiene parámetros y devuelve un resultado, como un cuadrado");
    Function<Integer, Long> lambdaFactorial = n -> {
      long f = 1;
      for (int i = 2; i <= n; i++) {
        f *= i;
      }
      return f;
    };
    System.out.println("El factorial de 5 es " + lambdaFactorial.apply(5));
    
    lambdaMensaje.run("expresión lambda tipo 'Predicado': tiene parámetros y devuelve un valor lógico");
    Predicate<Integer> lambdaEsPositivo = n -> n > 0;
    System.out.println("¿Es positivo 5 " + lambdaEsPositivo.test(5));
    System.out.println("¿Es positivo -5 " + lambdaEsPositivo.test(-5));
    
    lambdaMensaje.run("pueden acceder a las variables locales, aunque sean lambdas");
    Function<Integer, Integer> lambdaAleatorio1aN = n -> {
      if (lambdaEsPositivo.test(n)) {
        return 1 + (int) (Math.random() * n);
      } else {
        System.err.println(n + " es un valor no válido.");
        return null;
      }
    };
    System.out.println("Aleatorio entre 1 y 10: " + lambdaAleatorio1aN.apply(10));
    System.out.println("Aleatorio entre 1 y 99: " + lambdaAleatorio1aN.apply(99));
    System.out.println("Aleatorio entre 1 y -1: " + lambdaAleatorio1aN.apply(-1));
    
    lambdaMensaje.run("pueden hacer referencias a métodos");
    Consumer<String> lambdaImprime2 = System.out::println;
    lambdaImprime2.accept("Y con esto terminamos");
  }

}
