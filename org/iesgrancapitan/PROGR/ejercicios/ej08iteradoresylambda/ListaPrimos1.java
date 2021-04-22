package org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda;

import java.util.Iterator;
import org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda.util.Matematicas;

/**
 * Itera sobre la lista de números primos, desde 2 hasta uno dado como máximo.
 *  
 * @author Rafael del Castillo Gomariz
 *
 */

public class ListaPrimos1 implements Iterable<Long> {
  
  private long maximo;

  public ListaPrimos1(long maximo) {
    if (maximo < 2) {
      throw new IllegalArgumentException(maximo + " es un valor inferior al primer primo.");
    }
    this.maximo = maximo;
  }

  @Override
  public Iterator<Long> iterator() {
    Iterator<Long> iterator = new Iterator<Long>() {
      long primoSiguiente = 2;

      @Override
      public boolean hasNext() {
        return primoSiguiente <= maximo;
      }

      @Override
      public Long next() {
        long primo = primoSiguiente;
        calculaPrimoSiguiente();
        return primo;
      }

      private void calculaPrimoSiguiente() {
        primoSiguiente++;
        while (! Matematicas.esPrimo(primoSiguiente)) {
          primoSiguiente++;
        }
      }
    };
    
    return iterator;
  }

}
