package org.iesgrancapitan.PROGR.ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * En este ejemplo vamos a acceder a la url http://example.com/ y vamos a mostrar por la pantalla
 * su código html.
 * 
 * Nos basamos en la información de:
 * 
 * https://www.baeldung.com/java-http-request
 * https://stackoverflow.com/questions/1485708/how-do-i-do-a-http-get-in-java
 * 
 * Diferencia con el anterior: guardo el html en una única variable tipo cadena
 * y acorto el ciclo de lectura.
 * 
 * @author rafa
 *
 */

public class EjemploLecturaURL2 {
  
  public static void main(String[] args) throws IOException {
    String html = "";

    // Definir una conexión
    URL url = new URL("http://www.example.com");
    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
    conexion.setRequestMethod("GET");
    
    // Establecer y leer información de la conexión
    System.out.println("Respuesta del servidor: " + conexion.getResponseCode()); 
    BufferedReader bf = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
    String linea;
    while ((linea=bf.readLine()) != null) {
       html += linea + "\n";
    }
    bf.close();
    
    // Muestro el contenido html
    System.out.println(html);
      
  }

}
