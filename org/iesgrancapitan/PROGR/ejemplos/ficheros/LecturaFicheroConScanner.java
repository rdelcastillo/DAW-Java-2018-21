package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LecturaFicheroConScanner {

  public static void main(String[] args) {
    
    try (var file = new Scanner(new BufferedReader(new FileReader("lineas.txt")))) {
      
      while (file.hasNextLine()) {
        System.out.println(file.nextLine());
      }
      
    } catch (FileNotFoundException e) {
      System.out.println("No se ha podido abrir el fichero.");
    }
  }

}
