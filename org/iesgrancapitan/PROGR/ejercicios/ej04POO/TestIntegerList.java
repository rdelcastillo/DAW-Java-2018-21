package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class TestIntegerList {
  IntegerList listaVacia;
  IntegerList lista1a5;
  IntegerList lista1a10;

  @BeforeEach
  void setUp() throws Exception {
    listaVacia = new IntegerList();
    lista1a5 = new IntegerList(1,2,3,4,5);
    lista1a10 = new IntegerList(1,2,3,4,5,6,7,8,9,10);
  }

  @Test
  @Order(1)
  void testIntegerList() {
    IntegerList l = new IntegerList();
    assertEquals(0, l.getContentSize());
  }

  @Test
  @Order(2)
  void testIntegerListIntArray() {
    IntegerList l1 = new IntegerList(1,2,3,4,5);
    assertEquals("[1, 2, 3, 4, 5]", l1.toString());
    
    IntegerList l2 = new IntegerList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
    assertEquals(15, l2.getContentSize());
  }

  @Test
  @Order(3)
  void testInsertInt() {
    // Lista vacía
    assertTrue(listaVacia.insert(99));
    assertEquals("[99]", listaVacia.toString());
    
    // Lista a la mitad
    assertTrue(lista1a5.insert(99));
    assertEquals("[1, 2, 3, 4, 5, 99]", lista1a5.toString());
    
    // Lista llena
    assertFalse(lista1a10.insert(99));
    assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", lista1a10.toString());
  }

  @Test
  @Order(4)
  void testInsertIntInt() {
    // pruebo añadir en el interior de la lista
    assertTrue(lista1a5.insert(9, 2));
    assertEquals("[1, 2, 9, 3, 4, 5]", lista1a5.toString());
    
    // pruebo añadir en el exterior de la lista, debe saltar una excepción
    Exception exception = assertThrows(
        IndexOutOfBoundsException.class, 
        () -> lista1a5.insert(99, 100));
    assertEquals("Posición fuera de los límites de la lista.", exception.getMessage());
    
    // pruebo añadir en la posición 0 de la lista
    assertTrue(lista1a5.insert(999, 0));
    assertEquals("[999, 1, 2, 9, 3, 4, 5]", lista1a5.toString());
    
    // pruebo añadir en la última posición de la lista
    assertTrue(lista1a5.insert(9999, 7));
    assertEquals("[999, 1, 2, 9, 3, 4, 5, 9999]", lista1a5.toString());
    
    // pruebo a insertar en una lista llena
    assertFalse(lista1a10.insert(99999, 7));
    assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", lista1a10.toString());
  }

  @Test
  void testPop() throws IntegerListEmptyException {
    Exception exception = assertThrows(
        IntegerListEmptyException.class, 
        () -> listaVacia.pop());
    assertEquals("Lista vacía.", exception.getMessage());
    
    assertEquals(5, lista1a5.pop());
    assertEquals("[1, 2, 3, 4]", lista1a5.toString());
  }
  
  @Test
  void testPopInt() throws IntegerListEmptyException {
    Exception exception = assertThrows(
        IndexOutOfBoundsException.class, 
        () -> lista1a5.pop(10));
    assertEquals("Posición fuera de los límites de la lista.", exception.getMessage());
    
    assertEquals(3, lista1a5.pop(2));
    assertEquals("[1, 2, 4, 5]", lista1a5.toString());
  }

  @Test
  @Order(5)
  void testRemove() {
    // pruebo borrar un elemento que no está en la lista
    assertFalse(lista1a10.remove(50));
    
    // pruebo borrar un valor que está en el primer elemento de la lista
    assertTrue(lista1a10.remove(1));
    
    // pruebo borrar un valor que está en el último elemento de la lista
    assertTrue(lista1a10.remove(10));
    
    // pruebo borrar un valor que está enmedio de la lista
    assertTrue(lista1a10.remove(5));
  }

  @Test
  void testClear() {
    lista1a10.clear();
    assertEquals(0, lista1a10.getContentSize());
    assertTrue(lista1a10.isEmpty());
    assertEquals("[]", lista1a10.toString());
  }

  @Test
  void testIsFull() {
    assertEquals(lista1a10.getContentSize(), lista1a10.getMaxSize());
  }

  @Test
  void testIsEmpty() {
    assertEquals(0, listaVacia.getContentSize());
  }  

  @Test
  void testResize() {
    assertFalse(lista1a10.resize(5));
    assertTrue(lista1a5.resize(20));
    assertEquals(20, lista1a5.getMaxSize());
    assertEquals("[1, 2, 3, 4, 5]", lista1a5.toString());
  }
  
}
