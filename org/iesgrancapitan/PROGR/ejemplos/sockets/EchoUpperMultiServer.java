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

public class EchoUpperMultiServer {

  private static final int PORT = 6669;

  private ServerSocket serverSocket;
  private int totalConnections = 0;

  public void start(int port) throws IOException {
    System.out.println("Server started. Waiting for connections from port " + PORT + "...");

    serverSocket = new ServerSocket(port);
    int lastConnection = 0;
    while (true) {
      Socket client = serverSocket.accept();
      System.out.println("Established connection number " + ++lastConnection + " with " + client);
      System.out.println("Total connections " + ++totalConnections);

      // Lanzamos hilo con la nueva conexión
      var echoUpperClient = new EchoUpperClientHandler(client, lastConnection);
      echoUpperClient.start();
    }
  }

  public void stop() throws IOException {
    serverSocket.close();
    System.out.println("Server closed.");
  }

  public static void main(String[] args) throws IOException {
    var server = new EchoUpperMultiServer();
    server.start(PORT);
  }

  // Clase que maneja las nuevas conexiones creando un hilo
  private class EchoUpperClientHandler extends Thread {
    private Socket clientSocket;
    private int connection;
    private PrintWriter out;
    private BufferedReader in;

    public EchoUpperClientHandler(Socket socket, int connection) throws IOException {
      this.clientSocket = socket;
      this.connection = connection;
      this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      this.out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    public void run() {
      try {
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

        System.out.println("Closing connection number " + connection + " from " + clientSocket);
        System.out.println("Total connections " + --totalConnections);

        in.close();
        out.close();
        clientSocket.close();

      } catch (IOException e) {
        System.out.println("Something wrong with " + clientSocket);
        e.printStackTrace();
      }
    }
  }

}
