package org.iesgrancapitan.PROGR.ejemplos.sockets;

/**
 * Ejemplo de uso de Sockets.
 * 
 * Implementamos un servidor de chat.
 * 
 * Implementamos un método main() que lanza el servidor en el puerto 9999.
 * 
 * Ojo, es posible que alguna ocasión falle por no usar semáforos.
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
import java.util.HashMap;
import java.util.Map;

public class ChatServer {

  private static final int PORT = 9999;

  private ServerSocket serverSocket;
  private int numConnections = 0;
  Map<String, ChatClientHandler> clients = new HashMap<>();

  public void start(int port) throws IOException {
    System.out.println("Chat Server started. Waiting for connections from port " + PORT + "...");

    serverSocket = new ServerSocket(port);
    while (true) {
      Socket client = serverSocket.accept();
      System.out.println("Connected with " + client + ". Total connections " + ++numConnections);

      // Lanzamos hilo con la nueva conexión
      var chatClient = new ChatClientHandler(client);
      chatClient.start();
    }
  }

  public void stop() throws IOException {
    serverSocket.close();
    System.out.println("Server closed.");
  }

  public static void main(String[] args) throws IOException {
    var server = new ChatServer();
    server.start(PORT);
  }

  // Clase que maneja las nuevas conexiones creando un hilo
  private class ChatClientHandler extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String nick;

    public ChatClientHandler(Socket socket) throws IOException {
      this.clientSocket = socket;
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    public void run() {
      try {
        // Pedimos nick y lo añadimos, si no es válido acabamos
        if (!readNick()) {
          abortClient();
          return;
        }

        // Avisamos a los clientes que hay un usuario nuevo
        clients.values()
            .forEach(chat -> chat.getOut().println("--- SE UNE AL CHAT " + nick + " ---"));

        // Proceso normal
        clients.put(nick, this);
        out.println("Hello " + nick + ", send me your message (empty message to finish).\n");

        // Leemos mensajes del cliente
        String message;
        while ((message = in.readLine()) != null) {
          if (message.isBlank()) {
            stopClient();
            break;
          }
          writeChat(message);
        }

        // Fin
        if (message == null) {
          abortClient();
        }

      } catch (IOException e) {
        System.out.println("Something wrong with " + clientSocket);
        e.printStackTrace();
      }
    }

    private boolean readNick() throws IOException {
      out.println("I'm ChatServer. Tell me your nick.");
      while ((nick = in.readLine()) != null) {
        if (isValidNick()) {
          break;
        }
      }
      return (nick != null);
    }

    private boolean isValidNick() {
      if (!nick.matches("^[A-Za-z]+\\w+$")) { // nick sintácticamente incorrecto
        out.println(
            "Wrong nick, must start with a letter and one or more alphanumeric characters. Try again.");
        return false;
      }

      if (clients.containsKey(nick)) { // nick existe
        out.println("This nick already exists, try another.");
        return false;
      }

      return true;
    }

    private void writeChat(String message) {
      System.out.println("Received: '" + message + "' from [" + nick + "]");
      for (var chat : clients.values()) {
        chat.getOut().println("[" + nick + "] " + message);
      }
    }

    private void abortClient() throws IOException {
      System.out.println("Connection aborted by " + clientSocket);
      stopClient();
    }

    private void stopClient() throws IOException {
      if (nick == null) {
        nick = "NICK UNIDENTIFIED";
      }
      out.println("Thanks to use ChatServer ;-)");
      System.out.println(clientSocket + " with nick " + nick + " close connection.");
      System.out.println("Total connections " + --numConnections);
      clients.remove(nick);
      in.close();
      out.close();
      clientSocket.close();
      clients.values()
          .forEach(chat -> chat.getOut().println("--- " + nick + " LEAVES THE CHAT ---"));
    }

    public PrintWriter getOut() {
      return out;
    }

  }

}
