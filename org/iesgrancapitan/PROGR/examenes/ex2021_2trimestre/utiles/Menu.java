package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
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
    int opcion = leerEntero();

    while (opcion <= 0 || opcion > this.opciones.size()) {
      System.out.print("Opción incorrecta, introduzca otra: ");
      opcion = leerEntero();
    }

    System.out.println();
    return opcion;
  }

  private int leerEntero() {
    Scanner s = new Scanner(System.in);
    while (true) {
      try {
        return s.nextInt();
      } catch (InputMismatchException e) {
        System.out.print("Solo puede introducir datos enteros. Pruebe de nuevo: ");
        s.nextLine();
      }
    }
  }

  @Override
  public String toString() {
    return "Menu [titulo=" + titulo + ", opciones=" + opciones + "]";
  }

}
