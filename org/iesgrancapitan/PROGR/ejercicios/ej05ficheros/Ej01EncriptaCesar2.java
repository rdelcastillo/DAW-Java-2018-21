package org.iesgrancapitan.PROGR.ejercicios.ej05ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa que encripta un fichero que le pasamos como parámetro y almacena el resultado en otro, que también
 * pasamos como parámetro, de manera que:
 * 
 * - Si el programa no recibe dos parámetros termina con un error 1.
 * - Si el programa recibe un solo parámetro guardará la información encriptada en el mismo archivo del que lee, pero
 *   antes advertirá al usuario de que machacará el archivo origen, dando opción a que la operación no se haga.
 * - Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina con un mensaje de error y
 *   código 2.
 * - Si en el fichero destino no se puede escribir da error al abrirlo como lectura) el programa termina con un
 *   mensaje de error y código 2.
 *   
 * Para encriptar usamos el método César, necesitaremos una clave que hay que pedir al usuario.
 *   
 * @author rafa
 *
 */

public class Ej01EncriptaCesar2 {
  public static void main(String[] args) throws IOException {
    // ¿Número de parámetros correcto?
    if (args.length == 0 || args.length > 2) {
      System.err.println("Error en el número de parámetros"); // mensaje a la salida de error
      System.exit(1);
    }
            
    // Averiguamos fichero origen y destino
    String ficheroOrigen = args[0];
    String ficheroDestino = ficheroDestino(args);
        
    // Abrimos fichero origen
    BufferedReader bOrigen = bufferOrigen(ficheroOrigen);
    
    // Leemos fichero y guardamos en una lista
    ArrayList<String> lineasOrigen = new ArrayList<String>();
    String l = bOrigen.readLine();
    while (l != null) {
      lineasOrigen.add(l);
      l = bOrigen.readLine();
    }
    bOrigen.close();

    // Pedimos desplazamiento para el método César
    int desplazamiento = desplazamientoCesar(); 
        
    // Abrimos fichero destino (a encriptar)
    BufferedWriter bDestino = bufferDestino(ficheroDestino);
    
    // Encriptamos y escribimos
    for (String linea: lineasOrigen) {
      bDestino.write(encriptaCesar(linea, desplazamiento));
      bDestino.newLine(); // salto de línea, mejor que "\n"
    }
    bDestino.close();
    
    System.out.println("Proceso concluido.");
  }

  /**
   * 
   * @param args
   * @return Nombre del fichero destino
   */
  private static String ficheroDestino(String[] args) {
    Scanner s = new Scanner(System.in);
    String fichero;
    
    if (args.length == 1) {
      // Fichero origen y destino iguales
      fichero = args[0];

      // Advertimos de que se machacará el archivo origen
      System.out.println("Tenga en cuenta que solo ha indicado un nombre de archivo: " + fichero);
      System.out.println("Está operación machacará los datos de " + fichero);

      // Pedimos confirmación
      String resp;
      do {
        System.out.print("¿Continuamos con la operación? (S/N) ");
        resp = s.next().toUpperCase();
      } while (!resp.equals("S") && !resp.equals("N"));
      if (resp.equals("N")) {
        System.out.println("Proceso cancelado.");
        System.exit(0);
      }
    } else {
      fichero = args[1];  // Fichero origen y destino distintos
    }
    return fichero;
  }

  /**
   * 
   * @param ficheroOrigen
   * @return manejador del fichero abierto para lectura
   */
  private static BufferedReader bufferOrigen(String ficheroOrigen) {
    try {
      return new BufferedReader(new FileReader(ficheroOrigen));
    } catch (Exception e) {
      System.err.println("No se ha podido abrir " + ficheroOrigen);
      System.exit(2);
    }
    return null;
  }
  
  /**
   * Pide el desplazamiento para encriptar usando el método César.
   * @return desplazamiento.
   */
  private static int desplazamientoCesar() {
    Scanner s = new Scanner(System.in);
    int desplazamiento = 0;
    boolean seguirEnElCiclo = true;
    
    do {
      try {
        System.out.print("Desplazamiento para la encriptación usando César: ");
        desplazamiento = s.nextInt(); 
        seguirEnElCiclo = false;
      } catch (Exception e) {
        System.err.println("Tiene que introducir un valor entero.");
        s.nextLine();   // quito Intro del buffer de teclado
      }
    } while (seguirEnElCiclo);
    return desplazamiento;
  }
  
  /**
   * 
   * @param ficheroDestino
   * @return manejador del fichero abierto para escritura
   */
  private static BufferedWriter bufferDestino(String ficheroDestino) {
    try {
      return new BufferedWriter(new FileWriter(ficheroDestino));
    } catch (Exception e) {
      System.err.println("No se ha podido abrir para escritura " + ficheroDestino);
      System.exit(3);
    }
    return null;
  }
  
  /**
   * Encripta la cadena que le pasamos como parámetro. 
   * @param cadena
   * @param desplazamiento
   * @return cadena encriptada
   */
  private static String encriptaCesar(String cadena, int desplazamiento) {
    String letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZáéíóúüñÁÉÍÓÚÜÑ";
    String cadenaEncriptada = "";
    for (char caracter: cadena.toCharArray()) {
      char caracterEncriptado = caracter;
      // si el carácter es alfabético, encriptamos
      if (letras.contains(Character.toString(caracter))) {
        int posicionDondeEsta = letras.indexOf(caracter);
        int posicionCaracterEncriptado = ((posicionDondeEsta + desplazamiento) % letras.length());
        caracterEncriptado = letras.charAt(posicionCaracterEncriptado);
      } 
      cadenaEncriptada += caracterEncriptado;
    }
    return cadenaEncriptada;
  }
}
