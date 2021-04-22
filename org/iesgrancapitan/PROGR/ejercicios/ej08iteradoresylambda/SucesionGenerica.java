package org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda;

import java.util.Iterator;
import java.util.function.Function;

/**
 * Clase que permite iterar sobre los N primeros números de una sucesión de números enteros (long) 
 * representada por una expresión lambda que devuelve el término iésimo de la sucesión.
 *  
 * @author Rafael del Castillo Gomariz
 *
 */

public class SucesionGenerica implements Iterable<Long> {
  
  private int totalElementos;
  Function<Integer, Long> lambda;

  public SucesionGenerica(int totalElementos, Function<Integer, Long> lambda) {
    if (totalElementos < 2) {
      throw new IllegalArgumentException(totalElementos + " es menor que 0.");
    }
    this.totalElementos = totalElementos;
    this.lambda = lambda;
  }

  @Override
  public Iterator<Long> iterator() {
    Iterator<Long> iterator = new Iterator<Long>() {
      int index = 1;

      @Override
      public boolean hasNext() {
        return index <= totalElementos;
      }

      @Override
      public Long next() {
        return lambda.apply(index++);
      }
    };
    
    return iterator;
  }

}
