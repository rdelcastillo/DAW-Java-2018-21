package org.iesgrancapitan.PROGR.ejemplos.sockets;

/**
 * Ejemplo de uso de Sockets.
 * 
 * Implementamos el cliente para HelloServer.
 * 
 * Más información: https://www.baeldung.com/a-guide-to-java-sockets
 * 
 * @author Rafael del Castillo
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloClient {
  
  public static void main(String[] args) {
    try {
      // Creamos socket y lo conectamos con el servidor 
      var clientSocket = new Socket("localhost", 6666);
      
      // Establecemos canales de salida y entrada
      var out = new PrintWriter(clientSocket.getOutputStream(), true);  // true para autoflush
      var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      
      // Leemos, escribimos y leemos de nuevo
      System.out.println(in.readLine());
      out.println("Hello");
      System.out.println(in.readLine());
      
      clientSocket.close();
      
    } catch (IOException e) {
      System.out.println("Error al establecer la conexión.");
      e.printStackTrace();
    }
  }
}
