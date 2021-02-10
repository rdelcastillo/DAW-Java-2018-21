package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

import java.util.Arrays;

/**
 * Esta clase representará una estructura de datos tipo lista de números enteros.
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
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class IntegerList {

  // variables de clase

  private static final int DEFAULT_MAX_SIZE = 10;

  // variables de instancia

  private int[] content;    // array donde almacenamos los elementos de la lista
  private int contentSize;  // tamaño de la lista (nº de elementos almacenados)

  // constructores

  public IntegerList() {
    this.contentSize = 0;
    this.content = new int[DEFAULT_MAX_SIZE];
  }

  public IntegerList(int ... content) {
    this.contentSize = content.length;
    
    // Si el número de parámetros que llegan es mayor que DEFAULT_MAX_SIZE, 
    // el tamaño máximo de mi array aumenta a esta cantidad.
    if (content.length > DEFAULT_MAX_SIZE) {
      this.content = new int[content.length];
    } else {
      this.content = new int[DEFAULT_MAX_SIZE]; 
    }
    
    // meto los valores llegados como parámetros en el array
    for (int i = 0; i < content.length; i++) {
      this.content[i] = content[i];
    }
  }

  // resto métodos

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
    // si lista llena acabamos
    if (this.isFull() || pos < 0) {    
      return false;
    }
    
    // si la posición donde debe insertarse es igual o superior al número de elementos 
    // que hay, insertamos al final
    if (pos >= this.contentSize) {
      return this.insert(element);
    }
    
    // situación más común, insertamos en medio
    
    // desplazamos a la derecha los elementos que están a partir de la posición que hay que insertar
    for (int i = this.contentSize-1; i >= pos; i--) {
      this.content[i+1] = this.content[i];
    }
    // insertamos el elemento
    this.content[pos] = element;
    
    ++this.contentSize;
    return true;    
  }
  
 
  /**
   * Devuelve el último elemento de la lista y lo elimina.
   * @return último elemento de la lista
   */
  public int pop() {
    // lista vacía (deberíamos lanzar una excepción, en una siguiente versión)
    if (this.isEmpty()) {   
      System.err.println("Excepción. La lista está vacía.");
      return 0;
    }
    
    // situación común
    --this.contentSize;
    return this.content[this.contentSize];
  }
  
  public int pop(int pos) {
    // lista vacía o posición inexistente (deberíamos lanzar una excepción, en una siguiente versión)
    if (this.isEmpty() || pos >= this.contentSize || pos < 0) {   
      System.err.println("Excepción. Posición errónea.");
      return 0;
    }
    
    // situación común
    int aDevolver = this.content[pos];
    for (int i = pos; i < this.contentSize-1; i++) {
      this.content[i] = this.content[i+1];
    }
    --this.contentSize;
    return aDevolver;
  }
  
  /**
   * Borra la primera ocurrencia de un elemento en la lista.
   * 
   * @param element
   * @return éxito de la operación.
   */
  public boolean remove(int element) {
    // si lista vacia acabamos
    if (this.isEmpty()) {
      return false;
    }
    
    // buscamos element dentro de la lista
    int posicionElement = 0;
    while (posicionElement < this.contentSize-1 && this.content[posicionElement] != element) {
      posicionElement++;
    }

    // si no está en la lista terminamos
    if (this.content[posicionElement] != element) {
      return false;
    }
    
    // desplazamos a la izquierda los elementos a partir de posicionElement
    for (int i = posicionElement; i < this.contentSize-1; i++) {
      this.content[i] = this.content[i+1];
    }
    
    --this.contentSize;
    return true;
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
    
    // situación más común
    int[] newContent = new int[newMaxSize]; // nuevo array al que copiamos los datos de la lista
    for (int i = 0; i < this.contentSize; i++) {
      newContent[i] = this.content[i];
    }
    this.content = newContent;
    return true;
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