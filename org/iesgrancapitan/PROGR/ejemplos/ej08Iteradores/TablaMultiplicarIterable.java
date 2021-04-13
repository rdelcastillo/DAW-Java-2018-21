package org.iesgrancapitan.PROGR.ejemplos.ej08Iteradores;

import java.util.Iterator;

/**
 * Ejemplo de iterable (que necesita un iterador).
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class TablaMultiplicarIterable implements Iterable<Integer> {
  
  private int size;
  private int numero;

  public TablaMultiplicarIterable(int numero, int size) {
    this.numero = numero;
    this.size = size;
  }

  public TablaMultiplicarIterable(int numero) {
    this.numero = numero;
    this.size = 10;
  }

  @Override
  public Iterator<Integer> iterator() {
    return new TablaMultiplicarIterator(numero, size);
  }

}
