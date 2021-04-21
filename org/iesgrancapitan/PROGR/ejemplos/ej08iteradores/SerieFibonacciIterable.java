package org.iesgrancapitan.PROGR.ejemplos.ej08iteradores;

import java.util.Iterator;

/**
 * Ejemplo de iterable con un iterador interno en una clase anónima
 * que genera números de la serie de Fibonacci
 *  
 * @author Rafael del Castillo Gomariz
 *
 */

public class SerieFibonacciIterable implements Iterable<Long> {
  
  private int size;

  public SerieFibonacciIterable(int size) {
    this.size = size;
  }

  @Override
  public Iterator<Long> iterator() {
    Iterator<Long> iterator = new Iterator<Long>() {
      
      int index = 1;
      long penultimoGenerado = 1;
      long ultimoGenerado = 0;

      @Override
      public boolean hasNext() {
        return index <= size;
      }

      @Override
      public Long next() {
        long numeroGenerado = penultimoGenerado + ultimoGenerado;
        penultimoGenerado = ultimoGenerado;
        ultimoGenerado = numeroGenerado;
        index++;
        return numeroGenerado;
      }
    };
    
    return iterator;
  }

}
