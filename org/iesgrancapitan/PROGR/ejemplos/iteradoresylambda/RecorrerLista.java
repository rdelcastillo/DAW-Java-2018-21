package org.iesgrancapitan.PROGR.ejemplos.iteradoresylambda;

import java.util.Iterator;
import java.util.List;

/**
 * Las colecciones permiten recorrerse con un foreach porque tienen un objeto iterador.
 * Podemos acceder directamente a ese objeto para recorrer la colección.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class RecorrerLista {

  public static void main(String[] args) {
    List<Integer> lista = List.of(1,2,3,4,5);
    
    Iterator<Integer> iterador = lista.iterator();
    while (iterador.hasNext()) {
      System.out.print(iterador.next() + " ");
    }
    System.out.println("\n");
  }
}
