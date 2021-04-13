package org.iesgrancapitan.PROGR.ejemplos.ej08Iteradores;

import java.util.Iterator;

/**
 * Ejemplo de iterador.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class TablaMultiplicarIterator implements Iterator<Integer> {
  
  private int fila = 1;
  private int size;
  private int numero;
  
  public TablaMultiplicarIterator(int numero) {
    this.numero = numero;
    this.size = 10;
  }
  
  public TablaMultiplicarIterator(int numero, int size) {
    this.numero = numero;
    this.size = size;
  }

  @Override
  public boolean hasNext() {
    return fila <= size;
  }

  @Override
  public Integer next() {
    return numero * fila++;
  }

}
