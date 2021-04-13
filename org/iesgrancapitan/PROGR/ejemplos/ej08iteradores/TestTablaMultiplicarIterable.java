package org.iesgrancapitan.PROGR.ejemplos.ej08iteradores;

public class TestTablaMultiplicarIterable {

  public static void main(String[] args) {
    
    System.out.print("Tabla de multiplicar del 5: ");
    var tabla5Iterable = new TablaMultiplicarIterable(5);
    for (int n: tabla5Iterable) {
      System.out.print(n + " ");
    }
    
    System.out.print("\nTabla de multiplicar del 8 (15 resultados): ");
    var tabla8Iterable = new TablaMultiplicarIterable(8, 15);
    tabla8Iterable.forEach(producto -> System.out.print(producto + " "));
  }

}
