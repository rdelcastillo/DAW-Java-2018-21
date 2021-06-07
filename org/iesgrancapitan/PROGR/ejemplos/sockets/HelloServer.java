package org.iesgrancapitan.PROGR.ejemplos.sockets;

/**
 * Ejemplo de uso de Sockets.
 * 
 * Implementamos un servidor que saluda y espera un saludo de vuelta.
 * 
 * Implementamos un método main() que lanza el servidor en el puerto 6666.
 * 
 * Más información: https://www.baeldung.com/a-guide-to-java-sockets
 * 
 * @author Rafael del Castillo
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
  
  private static final int PORT = 6666;
  
  private ServerSocket serverSocket;
  private Socket clientSocket;
  private PrintWriter out;
  private BufferedReader in;

  public void start(int port) throws IOException {
    System.out.println("Server started. Waiting for connection from port " + PORT + "...");
    
    serverSocket = new ServerSocket(port);  // creamos socket para el servidor
    clientSocket = serverSocket.accept();   // esperamos conexión
    System.out.println("Established connection with " + clientSocket);

    // Canales de entrada y salida
    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    
    // Enviamos mensaje al cliente
    out.println("Tell me 'hello' please...");
    
    // Leemos respuesta
    String response = in.readLine();
    if ("hello".equalsIgnoreCase(response)) {
      out.println("Hello friend!! Have a good day ;-)");
    } else {
      out.println("You are not very nice :-(");
    }
    
    // Fin
    stop();
  }

  public void stop() throws IOException {
    in.close();
    out.close();
    clientSocket.close();
    serverSocket.close();
    System.out.println("Connection closed.");
  }

  public static void main(String[] args) throws IOException {
    HelloServer server = new HelloServer();
    server.start(PORT);
  }
}
