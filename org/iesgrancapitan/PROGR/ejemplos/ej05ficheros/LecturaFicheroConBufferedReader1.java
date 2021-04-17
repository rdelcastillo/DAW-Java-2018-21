package org.iesgrancapitan.PROGR.ejemplos.ej05ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFicheroConBufferedReader1 {

  public static void main(String[] args) throws IOException {
    File file = new File("lineas.txt");
    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);

    String linea = br.readLine();
    while (linea != null) {
      System.out.println(linea);
      linea = br.readLine();
    }
    fr.close();
  }

}
