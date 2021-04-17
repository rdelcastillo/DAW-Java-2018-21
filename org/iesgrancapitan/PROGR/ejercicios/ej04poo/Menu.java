package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase para gestionar menús de forma que las opciones se almacenan en un ArrayList.
 */

import java.util.Scanner;

public class Menu {
  
  String titulo;
  List<String> opciones;

  public Menu(String titulo, String... opciones) {
    
    this.titulo = titulo;
    this.opciones = new ArrayList<>(Arrays.asList(opciones));
    
    /*
    // añado uno a uno
    this.opciones = new ArrayList<String>();
    
    for (String opcion: opciones) {
      this.opciones.add(opcion);
    }
    */
  }

  public int elegir() {
    
    // Mostramos el menú
    System.out.println(this.titulo);
    System.out.println("-".repeat(this.titulo.length()) +"\n");
    
    for (int i = 0; i < this.opciones.size(); i++) {
      System.out.println((i+1) + ". " + this.opciones.get(i));
    }
    System.out.print("\nIntroduce una opción: ");
    
    // Leo la opción
    Scanner s = new Scanner(System.in);
    int opcion = s.nextInt();
    
    while (opcion <= 0 || opcion > this.opciones.size()) {
      System.out.print("Opción incorrecta, introduzca otra: ");
      opcion = s.nextInt();
    }
    
    return opcion;
  }

  @Override
  public String toString() {
    return "Menu [titulo=" + titulo + ", opciones=" + opciones + "]";
  }

}
