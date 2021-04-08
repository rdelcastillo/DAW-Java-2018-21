package org.iesgrancapitan.PROGR.ejemplos.ej05Ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EscrituraFicheroConBufferedWriter3 {

  public static void main(String[] args) {

    try (var file = Files.newBufferedWriter(Paths.get("numeros.txt"), 
                                            StandardOpenOption.CREATE,
                                            StandardOpenOption.TRUNCATE_EXISTING)) {
      for (int i = 1; i <= 10; i++) {
        file.write("NewBW. Línea nº " + i);
        file.newLine();
      }
      System.out.println("Escritura realizada.");

    } catch (IOException e) {
      System.out.println("No se ha podido escribir en el fichero.");
    }

  }

}
