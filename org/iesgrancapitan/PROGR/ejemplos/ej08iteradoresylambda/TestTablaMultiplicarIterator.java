package org.iesgrancapitan.PROGR.ejemplos.ej08iteradoresylambda;

public class TestTablaMultiplicarIterator {

  public static void main(String[] args) {
    
    System.out.print("Tabla de multiplicar del 5: ");
    var tabla5Iterator = new TablaMultiplicarIterator(5);
    while (tabla5Iterator.hasNext()) {
      System.out.print(tabla5Iterator.next() + " ");
    }
    
    System.out.print("\nTabla de multiplicar del 8 (15 resultados): ");
    var tabla8Iterator = new TablaMultiplicarIterator(8, 15);
    tabla8Iterator.forEachRemaining(producto -> System.out.print(producto + " "));
    
  }

}
