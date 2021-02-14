package org.iesgrancapitan.PROGR.ejemplos.ej04POO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Ejemplo de uso de ArrayList. Aconsejo ejecutar con el depurador.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class EjemploArrayList {

  public static void main(String[] args) {

    // Creación

    List<StringBuilder> arrayList1 = new ArrayList<>(); // es habitual declarar un arraylist como List
    var arrayList2 = new ArrayList<Integer>();          // usamos inferencia de tipos
    List<Integer> arrayList3 = new ArrayList<>(Arrays.asList(3, 1, 4, 5, 7, 11, -1, 2, 8)); // con valores iniciales

    // Añadimos

    arrayList2.add(100);
    arrayList2.addAll(arrayList3);                      // añadimos los elementos de arrayList3

    System.out.println("arrayList2 --> " + arrayList2);

    arrayList3.addAll(0, List.of(0,0,0,0,0));           // añadimos cinco ceros al principio 

    System.out.println("arrayList3 --> " + arrayList3);

    arrayList1.add(new StringBuilder("uno"));
    arrayList1.add(new StringBuilder("tres"));
    arrayList1.add(new StringBuilder("cuatro"));
    arrayList1.add(1, new StringBuilder("dos"));        // añadimos entre "uno" y "tres"

    System.out.println("arrayList1 --> " + arrayList1);

    // Accedemos

    StringBuilder cadena = arrayList1.get(0);

    cadena.reverse();                                   // ojo!!! el objeto es mutable

    System.out.println("arrayList1 --> " + arrayList1); // el contenido ha cambiado

    // Probamos contains() y clear()

    int n = 100;

    System.out.println(n + " está en " + arrayList2 + ": " + arrayList2.contains(Integer.valueOf(n)));
    System.out.println(n + " está en " + arrayList2 + ": " + arrayList2.contains(n));   // igual que anterior

    ArrayList<Integer> arrayList4 = new ArrayList<>(arrayList2);    // arrayList4 es una copia de arrayList2

    arrayList2.clear();     // borramos todos los elementos del arraylist

    System.out.println(n + " está en " + arrayList2 + ": " + arrayList2.contains(n));
    System.out.println("arrayList4 --> " + arrayList4);

    // Probamos remove()  

    System.out.print("Borramos lo que hay en la posición 3 de " + arrayList3 + " --> ");

    arrayList3.remove(3);                   // no borramos el valor 3, sino el elemento que hay en la posición 3

    System.out.println(arrayList3);

    System.out.print("Borramos lo que hay en la posición 3 de " + arrayList3 + " --> ");

    arrayList3.remove(Integer.valueOf(3));  // no borramos el elemento que hay en la posición 3, sino el objeto cuyo valor es 3

    System.out.println(arrayList3);

    // Probamos removeAll() 

    System.out.print("Borramos de " + arrayList4 + " 1, 3 y 5 --> ");

    arrayList4.removeAll(List.of(1,3,5));   // removeAll() borra del arraylist los elementos de la colección recibida

    System.out.println(arrayList4);

    // Probamos removeIf() 

    System.out.print("Borramos de " + arrayList3 + " los elementos con valor 0 --> ");

    arrayList3.removeIf(entero -> entero==0);

    System.out.println(arrayList3);

    System.out.print("Borramos de " + arrayList1 + " los elementos que contengan 'r' --> ");

    arrayList1.removeIf(cad -> cad.toString().contains("r"));

    System.out.println(arrayList1);

    // Probamos subList()
    
    System.out.print("Borramos de " + arrayList4 + " los elementos de las tres primeras posiciones --> ");
    
    arrayList4.subList(0, 3).clear();   // ojo!!! las lista son mutables
    
    System.out.println(arrayList4);
    
    // Ordenamos
    
    System.out.print("Ordenamos " + arrayList4 + " --> ");
    
    Collections.sort(arrayList4);                               // ordenamos por su orden "natural"
    
    System.out.println(arrayList4);
    
    Collections.sort(arrayList4, Collections.reverseOrder());   // ordenamos en orden inverso
    
    System.out.println("En orden inverso --> " + arrayList4);

    // Probamos recorrido arrayList
    
    System.out.println("Elementos de arrayList1 (recorrido por su índice):");
    
    for (int i = 0; i < arrayList1.size(); i++) {
      System.out.println("- " + arrayList1.get(i));
    }
    
    System.out.println("Elementos de arrayList1 (recorrido habitual, tipo foreach):");
    
    for (StringBuilder elemento: arrayList1) {
      System.out.println("- " + elemento);
    }
  }

}
