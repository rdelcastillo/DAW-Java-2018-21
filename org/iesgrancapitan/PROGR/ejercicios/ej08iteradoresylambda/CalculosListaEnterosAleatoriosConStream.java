package org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda.util.Matematicas;

/**
 * Probamos los streams de Java, que están muy relacionados con las expresiones lambda, 
 * para ello creamos una lista de 1000 números enteros aleatorios entre -5000 y 5000 
 * y usando streams vamos a averiguar:
 * 
 * El máximo de los números pares.
 * El mínimo de los números múltiplos de 3.
 * El total de números negativos.
 * El total de números primos.
 * El máximo número primo.
 * 
 * Referencia: https://www.ecodeup.com/ejemplos-practicos-de-expresiones-lambda-en-java-8/
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CalculosListaEnterosAleatoriosConStream {

  private static final int TOTAL_ENTEROS = 1000;
  private static final int MINIMO = -5000;
  private static final int MAXIMO = 5000;

  public static void main(String[] args) {
    List<Integer> lista = new ArrayList<>(); 
    
    // Creamos la lista de números usando IntStream (streams de números enteros). 
    // Más información: https://www.arquitecturajava.com/trabajando-con-java-8-intstream/
    
    IntStream.range(1, TOTAL_ENTEROS)
        .forEach(n -> lista.add(MINIMO + (int) (Math.random()*(MAXIMO-MINIMO)) + 1));
    
    // Operaciones intermedias:
    // - stream() convierte la colección a un stream 
    // - filter() filtra el stream con la condición de la expresión lambda
    
    // Operaciones terminales:
    // - max().get() devuelve el máximo del stream usando el Comparator de la expresión lambda
    // - min().get() devuelve el mínimo del stream usando el Comparator de la expresión lambda
    // - count() devuelve el número de elementos del stream
    
    int maximoPar = lista.stream()
        .filter(n -> n%2 == 0)
        .max((a,b) -> a.compareTo(b))
        .get();
    
    int minimoMultiplo3 = lista.stream()
        .filter(n -> n%3 == 0)
        .min((a,b) -> a-b)
        .get();
    
    int totalNegativos = (int) lista.stream()
        .filter(n -> n < 0)
        .count();
    
    int totalPrimos = (int) lista.stream()
        .filter(n -> Matematicas.esPrimo(n))
        .count();
    
    int maximoPrimo = lista.stream()
        .filter(n -> Matematicas.esPrimo(n))
        .max(Comparator.naturalOrder())
        .get();
    
    System.out.println("Máximo de los números pares.: " + maximoPar);
    System.out.println("Mínimo de los múltiplos de 3: " + minimoMultiplo3);
    System.out.println("Total de números negativos..: " + totalNegativos);
    System.out.println("Total de números primos.....: " + totalPrimos);
    System.out.println("Máximo de los números primos: " + maximoPrimo);
  }

}
