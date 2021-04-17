package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

import java.util.Arrays;

/**
 * Esta clase representará una estructura de datos tipo lista de números enteros (versión 2.0).
 * 
 * Estado de los objetos:
 * 
 * - content: array de enteros donde guardaremos los elementos de la lista.
 * - contentSize: número de elementos guardados en la lista.
 * 
 * Comportamiento:
 * 
 * - IntegerList(): crea una lista vacía cuyo tamaño máximo va a estar determinado por una constante 
 *  de la clase (10).
 *  
 * - IntegerList(ele1, ..., eleN): crea una lista con los elementos ele1 ... eleN.
 * 
 * - pop(): me devuelve el último elemento de la lista y lo saca de la lista.
 * 
 * - pop(posición): me devuelve el elemento que está en "posición" y lo saca de la lista.- 
 * 
 * - remove(elemento): borra la primera ocurrencia de "elemento" en la lista. Devolverá true o false
 *  en función del éxito de la operación.
 * 
 * - insert(elemento): añadir "elemento" al final de la lista. 
 *  Devolveremos true o false en función del éxito de la operación.
 * 
 * - insert(elemento, posición): añadir "elemento" en la posición "posición" de la lista.
 *  Devolveremos true o false en función del éxito de la operación.
 * 
 * - clear(): vacía la lista.
 * 
 * - isFull(): me dice si la lista está llena.
 * 
 * - isEmpty(): me dice si la lista está vacía.
 * 
 * - resize(): cambia el tamaño máximo de la lista si el nuevo tamaño máximo no es menor que
 *  el número de elementos que tiene. Devolveremos true o false en función del éxito de la operación. 
 *  
 * - getContenSize(): nos devuelve el número de elementos que hay en la lista.
 * 
 * - maxSize(): tamaño máximo de la lista.
 * 
 * En esta versión mejoraremos algunos aspectos del código y añadiremos las siguientes excepciones: 
 * 
 * - Método insert() cuando pongamos que se añada algo en una posición incorrecta: IndexOutOfBoundsException.
 * - Método pop() cuando la lista esté vacía (marcada).
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class IntegerList {

  private static final int DEFAULT_MAX_SIZE = 10;

  private int[] content;    // array donde almacenamos los elementos de la lista
  private int contentSize;  // tamaño de la lista (nº de elementos almacenados)

  public IntegerList() {
    this.contentSize = 0;
    this.content = new int[DEFAULT_MAX_SIZE];
  }

  public IntegerList(int ... content) {
    this.contentSize = content.length;
    
    // Si el número de parámetros que llegan es mayor que DEFAULT_MAX_SIZE, 
    // el tamaño máximo de mi array aumenta a esta cantidad.
    this.content = (content.length > DEFAULT_MAX_SIZE) 
        ? new int[content.length] : new int[DEFAULT_MAX_SIZE];
    
    // meto los valores llegados como parámetros en el array
    for (int i = 0; i < content.length; i++) {
      this.content[i] = content[i];
    }
  }

  /**
   * Añade un elemento al final de la lista. 
   * 
   * @param element
   * @return éxito de la operación
   */
  public boolean insert(int element) {
    if (this.isFull()) {    // si lista llena acabamos
      return false;
    }
    // situación más común, hay espacio en la lista
    this.content[this.contentSize] = element;
    ++this.contentSize;
    return true;
  }
  
  /**
   * Añade un elemento en la posición indicada de la lista.
   * @param element
   * @param pos
   * @return éxito de la operación
   */
  public boolean insert(int element, int pos) {
    if (pos == this.contentSize) {  // inserción al final (normal)
      return this.insert(element); 
    }
    
    if (this.isErrorPosition(pos)) {
      throw new IndexOutOfBoundsException("Posición fuera de los límites de la lista.");
    }

    if (this.isFull()) {    
      return false;
    }
    
    // desplazamos a la derecha los elementos que están a partir de la posición que hay que insertar
    this.scrollRight(pos);
    
    // insertamos el elemento
    this.content[pos] = element;
    ++this.contentSize;
    return true;    
  }

  private boolean isErrorPosition(int pos) {
    return pos < 0 || pos >= this.contentSize;
  }
  
  private void scrollRight(int pos) {
    for (int i = this.contentSize-1; i >= pos; i--) {
      this.content[i+1] = this.content[i];
    }
  }
  
  /**
   * Devuelve el último elemento de la lista y lo elimina.
   * @return último elemento de la lista
   * @throws IntegerListEmptyException 
   */
  public int pop() throws IntegerListEmptyException {
    if (this.isEmpty()) {   
      throw new IntegerListEmptyException("Lista vacía.");
    }
    --this.contentSize;
    return this.content[this.contentSize];
  }
  
  public int pop(int pos) throws IntegerListEmptyException {
    if (this.isErrorPosition(pos)) {
      throw new IndexOutOfBoundsException("Posición fuera de los límites de la lista.");
    }
    if (this.isEmpty()) {   
      throw new IntegerListEmptyException("Lista vacía");
    }
    
    int aDevolver = this.content[pos];
    
    // desplazamos a la izquierda los elementos a partir de la posición que hay que eliminar
    scrollLeft(pos);
    
    --this.contentSize;
    return aDevolver;
  }

  private void scrollLeft(int pos) {
    for (int i = pos; i < this.contentSize-1; i++) {
      this.content[i] = this.content[i+1];
    }
  }
  
  /**
   * Borra la primera ocurrencia de un elemento en la lista.
   * 
   * @param element
   * @return éxito de la operación.
   */
  public boolean remove(int element) {
    if (this.isEmpty()) {   // si lista vacia acabamos
      return false;
    }
    
    // buscamos element en la lista, si no está terminamos
    int posicionElement = this.indexOf(element);
    if (posicionElement < 0) {
      return false;
    }
    
    // desplazamos a la izquierda los elementos a partir de la posición que hay que eliminar
    scrollLeft(posicionElement);
    
    --this.contentSize;
    return true;
  }

  private int indexOf(int element) {
    int posicionElement = 0;
    while (posicionElement < this.contentSize-1 && this.content[posicionElement] != element) {
      posicionElement++;
    }
    if (this.content[posicionElement] != element) { // si no es el último no está
      return -1;
    }
    return posicionElement;
  }
  
  /**
   * Vacía la lista.
   */
  public void clear() {
    this.contentSize = 0;
  }
  
  /**
   * @return si la lista está llena.
   */
  public boolean isFull() {
    return this.content.length == this.contentSize;
  }
  
  /**
   * @return si la lista está vacía.
   */
  public boolean isEmpty() {
    return this.contentSize == 0;
  }
  
  /**
   * Cambia el tamaño máximo de la lista si el nuevo tamaño máximo no es menor que el número de elementos que tiene. 
   *  
   * @return éxito de la operación.
   */
  public boolean resize(int newMaxSize) {
    // si el nuevo tamaño máximo es menor o igual que el número de elementos de la lista acabamos
    if (newMaxSize <= this.getContentSize()) {
      return false;
    }
    // nuevo array al que copiamos los datos de la lista
    this.content = this.copy(newMaxSize);
    return true;
  }

  private int[] copy(int newMaxSize) {
    int[] newContent = new int[newMaxSize]; 
    for (int i = 0; i < this.contentSize; i++) {
      newContent[i] = this.content[i];
    }
    return newContent;
  }
  
  /**
   * @return número de elementos que hay en la lista.
   */
  public int getContentSize() {
    return this.contentSize;
  }

  /**
   * @return máximo número de elementos que caben en la lista.
   */
  public int getMaxSize() {
    return this.content.length;
  }

  @Override
  public String toString() {
    // array auxiliar que tiene los elementos de la lista y con longitud contentSize
    // (primamos la legibilidad a ahorrarnos una línea)
    int[] arrayAux = Arrays.copyOfRange(this.content, 0, this.contentSize);
    return Arrays.toString(arrayAux);
  }
}