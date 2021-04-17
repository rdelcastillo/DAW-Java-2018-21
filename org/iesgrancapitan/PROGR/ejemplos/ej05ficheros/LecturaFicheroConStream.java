package org.iesgrancapitan.PROGR.ejemplos.ej05ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LecturaFicheroConStream {

  public static void main(String[] args) {

    try (Stream<String> file = Files.lines(Paths.get("lineas.txt"))) {

     file.forEach(linea -> System.out.println(linea));
      
    } catch (IOException e) {
      System.out.println("No se ha podido abrir el fichero.");
    }
  }
}
