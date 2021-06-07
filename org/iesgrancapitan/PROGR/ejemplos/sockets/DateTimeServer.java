package org.iesgrancapitan.PROGR.ejemplos.sockets;

/**
 * Este programa sirve la fecha y hora actual a los clientes que se le conecten
 * a través del puerto definido.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeServer {

  private static final int PORT = 6667;

  public static void main(String[] args) {
    try {
      // Socket para el servidor y cliente
      var serverSocket = new ServerSocket(PORT);
      System.out.println("Served started.");
      
      // Ciclo infinito
      for (;;) {
        var clientSocket = serverSocket.accept(); // esperamos conexión
        System.out.println("Request from " + clientSocket);

        // Enviamos fecha y hora al cliente y cerramos la conexión
        var out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Now is " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        clientSocket.close();
      }

    } catch (IOException e) {
      System.out.println("There is a problem.");
      e.printStackTrace();
    }


  }

}
