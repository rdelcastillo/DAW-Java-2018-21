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
    System.out.println("Ejecutando test constructor lista vacía: " + l);
    assertEquals(0, l.getContentSize());
  }

  @Test
  @Order(2)
  void testIntegerListIntArray() {
    IntegerList l1 = new IntegerList(1,2,3,4,5);
    System.out.println("\nEjecutando test constructor lista con valores iniciales: " + l1);
    assertEquals("[1, 2, 3, 4, 5]", l1.toString());
    
    IntegerList l2 = new IntegerList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
    System.out.println("Ejecutando test constructor lista con valores iniciales: " + l2);
    assertEquals(15, l2.getContentSize());
  }

  @Test
  @Order(3)
  void testInsertInt() {
    System.out.println("\nEjecutando test para insertar un elemento en la lista:");
    
    // Lista vacía
    System.out.print("Añado 99 en " + listaVacia + " --> ");
    assertTrue(listaVacia.insert(99));
    assertEquals("[99]", listaVacia.toString());
    System.out.println(listaVacia);
    
    // Lista a la mitad
    System.out.print("Añado 99 en " + lista1a5 + " --> ");
    assertTrue(lista1a5.insert(99));
    assertEquals("[1, 2, 3, 4, 5, 99]", lista1a5.toString());
    System.out.println(lista1a5);
    
    // Lista llena
    System.out.print("Añado 99 en " + lista1a10 + " --> ");
    assertFalse(lista1a10.insert(99));
    assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", lista1a10.toString());
    System.out.println(lista1a10);
  }

  @Test
  @Order(4)
  void testInsertIntInt() {
    System.out.println("\nEjecutando test para insertar un elemento en una posición de la lista:");
    
    // pruebo añadir en el interior de la lista
    System.out.print("Añado 9 en " + lista1a5 +" en posición 2 --> ");
    assertTrue(lista1a5.insert(9, 2));
    assertEquals("[1, 2, 9, 3, 4, 5]", lista1a5.toString());
    System.out.println(lista1a5);
    
    // pruebo añadir en el exterior de la lista
    System.out.print("Añado 99 en " + lista1a5 +" en posición 100 --> ");
    assertTrue(lista1a5.insert(99, 100));
    assertEquals("[1, 2, 9, 3, 4, 5, 99]", lista1a5.toString());
    System.out.println(lista1a5);
    
    // pruebo añadir en la posición 0 de la lista
    System.out.print("Añado 999 en " + lista1a5 +" en posición 0 --> ");
    assertTrue(lista1a5.insert(999, 0));
    assertEquals("[999, 1, 2, 9, 3, 4, 5, 99]", lista1a5.toString());
    System.out.println(lista1a5);
    
    // pruebo añadir en la última posición de la lista
    System.out.print("Añado 9999 en " + lista1a5 +" en posición 7 --> ");
    assertTrue(lista1a5.insert(9999, 7));
    assertEquals("[999, 1, 2, 9, 3, 4, 5, 9999, 99]", lista1a5.toString());
    System.out.println(lista1a5);
    
    // pruebo a insertar en una lista llena
    System.out.print("Añado 99999 en " + lista1a10 +" en posición 7 --> ");
    assertFalse(lista1a10.insert(99999, 7));
    assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", lista1a10.toString());
    System.out.println(lista1a10);
  }

  @Test
  void testPop() {
    assertEquals(5, lista1a5.pop());
    assertEquals("[1, 2, 3, 4]", lista1a5.toString());
  }
  
  @Test
  void testPopInt() {
    assertEquals(0, lista1a5.pop(10));
    assertEquals(3, lista1a5.pop(2));
    assertEquals("[1, 2, 4, 5]", lista1a5.toString());
  }

  @Test
  @Order(5)
  void testRemove() {
    System.out.println("\nEjecutando test para borrar un elemento en la lista:");
    
    // pruebo borrar un elemento que no está en la lista
    System.out.print("Borro 50 de " + lista1a10 + " --> ");
    assertFalse(lista1a10.remove(50));
    System.out.println(lista1a10);
    
    // pruebo borrar un valor que está en el primer elemento de la lista
    System.out.print("Borro 1 de " + lista1a10 + " --> ");
    assertTrue(lista1a10.remove(1));
    System.out.println(lista1a10);
    
    // pruebo borrar un valor que está en el último elemento de la lista
    System.out.print("Borro 10 de " + lista1a10 + " --> ");
    assertTrue(lista1a10.remove(10));
    System.out.println(lista1a10);
    
    // pruebo borrar un valor que está enmedio de la lista
    System.out.print("Borro 5 de " + lista1a10 + " --> ");
    assertTrue(lista1a10.remove(5));
    System.out.println(lista1a10);
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
