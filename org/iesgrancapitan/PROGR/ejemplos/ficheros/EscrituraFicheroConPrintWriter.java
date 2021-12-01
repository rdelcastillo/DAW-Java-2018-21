package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class EscrituraFicheroConPrintWriter {

  public static void main(String[] args) {
    
    try {
      PrintWriter file = new PrintWriter("numeros.txt");
      for (int i = 1; i <= 10; i++) {
        file.println("PW. Línea nº " + i);
      }
      file.close();
      System.out.println("Escritura realizada.");
      
    } catch (FileNotFoundException e) {
      System.out.println("No se ha podido escribir en el fichero.");
    }

  }

}
