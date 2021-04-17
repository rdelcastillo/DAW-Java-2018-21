package org.iesgrancapitan.PROGR.ejemplos.ej05ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LecturaFicheroConFiles1 {

  public static void main(String[] args) {

    try (var file = Files.newBufferedReader(Paths.get("lineas.txt"))) {

      String linea;
      while((linea=file.readLine()) != null) {
        System.out.println(linea);
      }
      
    } catch (IOException e) {
      System.out.println("No se ha podido abrir el fichero.");
    }
  }
}
