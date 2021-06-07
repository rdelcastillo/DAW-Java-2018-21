package org.iesgrancapitan.PROGR.ejemplos.sockets;

/**
 * Ejemplo de uso de Sockets.
 * 
 * Implementamos un servidor que hace eco del cliente en mayúsculas.
 * 
 * Distinguimos si la conexión la cierra el cliente abruptamente o no.
 * 
 * Implementamos un método main() que lanza el servidor en el puerto 6668.
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

public class EchoUpperServer {

  private static final int PORT = 6668;

  private ServerSocket serverSocket;
  private Socket clientSocket;
  private PrintWriter out;
  private BufferedReader in;

  public void start(int port) throws IOException {
    System.out.println("Server started. Waiting for connection from port " + PORT + "...");

    serverSocket = new ServerSocket(port); // creamos socket para el servidor
    clientSocket = serverSocket.accept(); // esperamos conexión
    System.out.println("Established connection with " + clientSocket);

    // Canales de entrada y salida
    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    out = new PrintWriter(clientSocket.getOutputStream(), true);

    // Enviamos mensaje al cliente
    out.println("I'm EchoUpperServer. Tell me something or 'bye' to finish...");

    // Leemos entradas de teclado
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
      if ("bye".equalsIgnoreCase(inputLine)) {
        out.println("Nice to meet you ;-)");
        break;
      }
      System.out.println("Received: '" + inputLine + "'");
      out.println(inputLine.toUpperCase());
    }

    // Fin
    if (inputLine == null) {
      System.out.println("Connection aborted by " + clientSocket);
    }
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
    var server = new EchoUpperServer();
    server.start(PORT);
  }

}
