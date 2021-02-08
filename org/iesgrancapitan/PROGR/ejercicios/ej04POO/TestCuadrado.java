package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCuadrado {
  Cuadrado c1 = new Cuadrado(5);
  Cuadrado c2 = new Cuadrado(8);

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void testSetAnchura() {
    c1.setAnchura(6);
    assertEquals(6, c1.getAltura());
    c1.setAnchura(5);
    assertEquals(5, c1.getAnchura());
  }

  @Test
  void testSetAltura() {
    c1.setAltura(6);
    assertEquals(6, c1.getAnchura());
    c1.setAnchura(5);
    assertEquals(5, c1.getLado());
  }

  @Test
  void testSetLado() {
    c2.setLado(9);
    assertEquals(9, c2.getLado());
  }
  
  @Test 
  void testDibujar() {
    System.out.println("Dibujo de " + c1);
    c1.dibujar();
    System.out.println("Dibujo de " + c2);
    c2.dibujar();
  }

}
