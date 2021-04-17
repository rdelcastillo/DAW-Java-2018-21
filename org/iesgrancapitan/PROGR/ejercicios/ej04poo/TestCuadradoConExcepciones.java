package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

public class TestCuadradoConExcepciones {

  public static void main(String[] args) {
    var c = new CuadradoConExcepciones(5);
    
    try {
      System.out.println("El cuadrado es " + c + "\n");
      c.dibujar();
      c.setLado(7);
      c.dibujar();
      c.setAltura(10);
      c.dibujar();
    } catch (CuadradoIncorrectoException e) {
      System.err.println("Se ha producido un error.");
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
  }

}
