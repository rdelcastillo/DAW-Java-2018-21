package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

import java.util.Arrays;
import java.util.Scanner;

public class MenuSimple {
  
  String[] opciones;

  public MenuSimple(String... opciones) {
    
    this.opciones = new String[opciones.length];
    
    for (int i = 0; i < opciones.length; i++) {
      this.opciones[i] = opciones[i];
    }
  }

  public int elegir() {
    
    // Mostramos el menú
    System.out.println("Menú de opciones");
    System.out.println("----------------\n");
    
    for (int i = 0; i < this.opciones.length; i++) {
      System.out.println((i+1) + ". " + this.opciones[i]);
    }
    System.out.print("\nIntroduce una opción: ");
    
    // Leo la opción
    Scanner s = new Scanner(System.in);
    int opcion = s.nextInt();
    
    while (opcion <= 0 || opcion > this.opciones.length) {
      System.out.print("Opción incorrecta, introduzca otra: ");
      opcion = s.nextInt();
    }
    
    return opcion;
  }
  
  @Override
  public String toString() {
    return "Menu [opciones=" + Arrays.toString(opciones) + "]";
  }

}
