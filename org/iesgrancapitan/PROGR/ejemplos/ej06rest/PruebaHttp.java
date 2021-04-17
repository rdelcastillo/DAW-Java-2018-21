package org.iesgrancapitan.PROGR.ejemplos.ej06rest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * Ejemplo de acceso HTTP desde Java.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class PruebaHttp {
  
  public static void main(String[] args) throws IOException, InterruptedException {
    
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://example.com"))
        .GET()
        .build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    
    System.out.println("Petición URL: " + response.uri());
    System.out.println("Status Code: " + response.statusCode());
    System.out.println("HTML devuelto:\n" + response.body());
  }
}
