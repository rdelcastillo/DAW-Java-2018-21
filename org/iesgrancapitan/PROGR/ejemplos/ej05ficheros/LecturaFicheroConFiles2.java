package org.iesgrancapitan.PROGR.ejemplos.ej05ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LecturaFicheroConFiles2 {

  public static void main(String[] args) {

    try {

      List<String> lineas = Files.readAllLines(Paths.get("lineas.txt"));
      for (String linea: lineas) {
        System.out.println(linea);
      }
      
    } catch (IOException e) {
      System.out.println("No se ha podido abrir el fichero.");
    }
  }
}
