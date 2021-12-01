package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LecturaFicheroConFiles3 {

  public static void main(String[] args) {

    try {

      String lineas = Files.readString(Paths.get("lineas.txt"));
      System.out.println(lineas);
      
    } catch (IOException e) {
      System.out.println("No se ha podido abrir el fichero.");
    }
  }
}
