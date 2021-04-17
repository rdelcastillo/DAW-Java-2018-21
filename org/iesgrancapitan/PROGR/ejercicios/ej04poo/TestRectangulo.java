package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestRectangulo {
  Rectangulo r1 = new Rectangulo(5,10);
  Rectangulo r2 = new Rectangulo(7,7);
  Rectangulo r3 = new Rectangulo(10,5);
  Rectangulo r4 = new Rectangulo(5,10);

  @Test
  void testRectangulo() {
    Assertions.assertEquals(5, r1.getAnchura());
    Assertions.assertEquals(10, r1.getAltura());
  }
  
  @Test
  void testSetAnchura() {
    r2.setAnchura(4);
    Assertions.assertEquals(4, r2.getAnchura());
  }

  @Test
  void testSetAltura() {
    r2.setAltura(4);
    Assertions.assertEquals(4, r2.getAltura());
  }

  @Test
  void testCompareTo() {
    Assertions.assertTrue(r1.compareTo(r2) > 0);
    Assertions.assertTrue(r2.compareTo(r1) < 0);
    Assertions.assertEquals(r1.compareTo(r3), 0);
  }

  @Test
  void testEqualsObject() {
    Assertions.assertTrue(r1.equals(r4));
    Assertions.assertFalse(r2.equals(r1));
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Rectangulo [ancho=5, alto=10]", r1.toString());
  }

  @Test
  void testClone() {
    Rectangulo r = r1.clone();
    Assertions.assertTrue(r.equals(r1));
  }

  @Test
  void testGetPerimetro() {
    Assertions.assertEquals(30, r1.getPerimetro());
  }

  @Test
  void testGetArea() {
    Assertions.assertEquals(50, r1.getArea());
  }

  @Test
  void testDibujar() {
    System.out.println("Dibujo de " + r2);
    r2.dibujar();
    
    // Probamos rectángulo altura 1
    Rectangulo r5 = new Rectangulo(5, 1);
    System.out.println("Dibujo de " + r5);
    r5.dibujar();
    
    // Probamos rectángulo anchura 1
    Rectangulo r6 = new Rectangulo(1, 5);
    System.out.println("Dibujo de " + r6);
    r6.dibujar();
    
    // Probamos rectángulo anchura y altura 1
    Rectangulo r7 = new Rectangulo(1, 1);
    System.out.println("Dibujo de " + r7);
    r7.dibujar();
  }

}
