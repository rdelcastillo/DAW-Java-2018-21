package org.iesgrancapitan.PROGR.ejemplos.ej08iteradores;

public class TestTablaMultiplicarIterable {

  public static void main(String[] args) {
    int numeroTabla;
    int filaTabla;
    
    numeroTabla = 5;
    filaTabla = 1;
    System.out.println("Tabla de multiplicar del " + numeroTabla + ": ");
    var tabla5Iterable = new TablaMultiplicarIterable(numeroTabla);
    for (int producto: tabla5Iterable) {
      System.out.println(filaTabla++ + " x " + numeroTabla + " = " + producto);
    }
    
    numeroTabla = 8;
    filaTabla = 1;
    System.out.print("\nTabla de multiplicar del " + numeroTabla + " (15 resultados): ");
    var tabla8Iterable = new TablaMultiplicarIterable(numeroTabla, 15);
    tabla8Iterable.forEach(producto -> System.out.print(producto + " "));
  }

}
