package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraFicheroConBufferedWriter {

  public static void main(String[] args) {

    try (var file = new BufferedWriter(new FileWriter("numeros.txt", true))) {
      for (int i = 1; i <= 10; i++) {
        file.write("BW. Línea nº " + i);
        file.newLine();
      }
      System.out.println("Escritura realizada.");

    } catch (IOException e) {
      System.out.println("No se ha podido escribir en el fichero.");
    }

  }

}
