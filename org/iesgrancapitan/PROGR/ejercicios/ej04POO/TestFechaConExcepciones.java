package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFechaConExcepciones {
  FechaConExcepciones fecha;

  @BeforeEach
  void setUp() throws Exception {
    fecha = new FechaConExcepciones(28, 2, 2021);
  }

  @Test
  void testFechaConExcepciones() {
    Exception exception = assertThrows(
        FechaIncorrectaException.class, 
        () -> new FechaConExcepciones(87, 0, 2020));
    assertEquals("Fecha incorrecta.", exception.getMessage());
  }

  @Test
  void testSetDia() {
    Exception exception = assertThrows(
        FechaIncorrectaException.class, 
        () -> fecha.setDia(87));
    assertEquals("Día incorrecto para la fecha.", exception.getMessage());
  }

  @Test
  void testSetMes() {
    Exception exception = assertThrows(
        FechaIncorrectaException.class, 
        () -> fecha.setMes(87));
    assertEquals("Mes incorrecto para la fecha.", exception.getMessage());
  }

  @Test
  void testSetAnyo() {
    Exception exception = assertThrows(
        FechaIncorrectaException.class, 
        () -> fecha.setAnyo(0));
    assertEquals("Año incorrecto para la fecha.", exception.getMessage());
  }

  @Test
  void testSumarDias() {
    fecha.sumarDias(68);
    assertTrue(fecha.equals(new FechaConExcepciones(7,5,2021)));
  }

  @Test
  void testRestarDias() {
    fecha.restarDias(97);
    assertTrue(fecha.equals(new FechaConExcepciones(23,11,2020)));
  }

  @Test
  void testRestar() {
    assertEquals(75, FechaConExcepciones.restar(fecha, new FechaConExcepciones(15, 12, 2020)));
  }

}
