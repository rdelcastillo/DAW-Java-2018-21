package org.iesgrancapitan.PROGR.ejercicios.ej08iteradoresylambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Itera sobre la lista de números primos, desde 2 hasta uno dado como máximo.
 * 
 * Usamos el algoritmo de la criba de Eratóstenes.
 *  
 * @author Rafael del Castillo Gomariz
 *
 */

public class ListaPrimos2 implements Iterable<Long> {
  
  private long maximo;
  private List<Long> listaPrimos = new ArrayList<>();

  public ListaPrimos2(long maximo) {
    if (maximo < 2) {
      throw new IllegalArgumentException(maximo + " es un valor inferior al primer primo.");
    }
    this.maximo = maximo;
    generaListaPrimos();
  }

  private void generaListaPrimos() {
    inicializaListaPrimos();
    cribaListaPrimos();
  }

  private void inicializaListaPrimos() {
    for (long i = 2; i <= maximo; i++) {
      listaPrimos.add(i);
    }
  }
  
  private void cribaListaPrimos() {
    int index = 0;
    while (Math.pow(listaPrimos.get(index),2) <= maximo) {
      long primo = listaPrimos.get(index);
      listaPrimos.subList(index+1, listaPrimos.size()).removeIf(n -> (n % primo) == 0);
      index++;
    }
  }

  @Override
  public Iterator<Long> iterator() {
    return listaPrimos.iterator();
  }

}
