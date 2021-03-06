package org.iesgrancapitan.PROGR.ejemplos.ej05Ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFicheroConBufferedReader3 {

  public static void main(String[] args) {

    try (var file = new BufferedReader(new FileReader("lineas.txt"))) {

      String linea;
      while((linea=file.readLine()) != null) {
        System.out.println(linea);
      }
      
    } catch (IOException e) {
      System.out.println("No se ha podido abrir el fichero.");
    }
  }
}
