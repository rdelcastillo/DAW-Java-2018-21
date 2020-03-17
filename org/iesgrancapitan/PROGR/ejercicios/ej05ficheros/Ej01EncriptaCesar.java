package org.iesgrancapitan.PROGR.ejercicios.ej05ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
 * Este programa TIENE UN ERROR ¿eres capaz de averiguarlo?
 *   
 * @author rafa
 *
 */

public class Ej01EncriptaCesar {
  public static void main(String[] args) throws IOException {
    Scanner s = new Scanner(System.in);
    
    // ¿Número de parámetros correcto?
    if (args.length == 0 || args.length > 2) {
      System.err.println("Error en el número de parámetros"); // mensaje a la salida de error
      System.exit(1);
    }
            
    // Averiguamos fichero origen y destino
    String ficheroOrigen = args[0];
    String ficheroDestino;
    if (args.length == 1) {
      // Fichero origen y destino iguales
      ficheroDestino = ficheroOrigen;
      
      // Advertimos de que se machacará el archivo origen
      System.out.println("Tenga en cuenta que solo ha indicado un nombre de archivo: " + ficheroOrigen);
      System.out.println("Está operación machacará los datos de " + ficheroOrigen);

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
      ficheroDestino = args[1];  // Fichero origen y destino distintos
    }
    
    // Abrimos fichero origen
    BufferedReader bOrigen = null;
    try {
      bOrigen = new BufferedReader(new FileReader(ficheroOrigen));
    } catch (Exception e) {
      System.err.println("No se ha podido abrir " + ficheroOrigen);
      System.exit(2);
    }

    // Pedimos desplazamiento para el método César
    boolean seguirEnElCiclo = true;
    int desplazamiento = 0;
    do {
      try {
        System.out.print("Desplazamiento para la encriptación usando César: ");
        desplazamiento = s.nextInt();
        seguirEnElCiclo = false;
      } catch (Exception e) {
        System.err.println("Tiene que introducir un valor entero.");
        s.nextLine();   // quito la cadena anterior del buffer de teclado
      }
    } while (seguirEnElCiclo);
        
    // Abrimos fichero destino (a encriptar)
    BufferedWriter bDestino = null;
    try {
      bDestino = new BufferedWriter(new FileWriter(ficheroDestino));
    } catch (Exception e) {
      System.err.println("No se ha podido abrir para escritura " + ficheroDestino);
      System.exit(3);
    }
    
    // Leemos, encriptamos y escribimos
    String linea = bOrigen.readLine();
    while (linea != null) {
      // escribimos línea encriptada
      bDestino.write(encriptaCesar(linea, desplazamiento));
      bDestino.newLine(); // salto de línea, mejor que "\n"
      // leemos siguiente línea, si es <EOF> no entraremos en el ciclo
      linea = bOrigen.readLine();
    }
    
    // Cerramos ficheros
    bOrigen.close();
    bDestino.close();
    System.out.println("Proceso concluido.");
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
    for (int i=0; i<cadena.length(); i++) {
      String caracter = cadena.substring(i, i+1);
      // si el carácter es alfabético, encriptamos
      if (letras.contains(caracter)) {
        int posicionDondeEsta = letras.indexOf(caracter);
        int posicionCaracterEncriptado = ((posicionDondeEsta + desplazamiento) % letras.length());
        caracter = letras.substring(posicionCaracterEncriptado, posicionCaracterEncriptado+1);
      } 
      cadenaEncriptada += caracter;
    }
    return cadenaEncriptada;
  }
}
