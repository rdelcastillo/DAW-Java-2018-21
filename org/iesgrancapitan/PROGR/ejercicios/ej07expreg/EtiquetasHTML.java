package org.iesgrancapitan.PROGR.ejercicios.ej07expreg;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Programa que recibe una url y el nombre de una etiqueta html. 
 * 
 * Si la url es válida debe mostrar por la pantalla el contenido de cada etiqueta.
 * 
 * Ejemplo: si ejecuto java EtiquetasHTML http://www.example.com p
 * 
 * La salida sería:
 * --------------------------------------
   Ocurrencia nº 1: This domain is for use in illustrative examples in documents. You may use this
                    domain in literature without prior coordination or asking for permission.
   Ocurrencia nº 2: <a href="https://www.iana.org/domains/example">More information...</a>

   Total etiquetas <p> encontradas: 2
 * --------------------------------------
 * 
 * @author Rafael del Castillo
 *
 */

public class EtiquetasHTML {

  public static void main(String[] args) {
    validateArgs(args);
    String url = args[0];
    String label = args[1];

    try {
      String html = getHtml(url);
      showLabels(label, html);
      
    } catch (Exception e) {
      System.err.println("Error al manejar la URL " + e.getMessage());
    }
    
  }

  private static void showLabels(String label, String html) {
    System.out.println("HTML donde buscar la etiqueta <" + label + ">");
    System.out.println("-------------------------------" + "-".repeat(label.length() + 1));
    System.out.println(html + "\n");
    
    System.out.println("Resultados");
    System.out.println("----------");
    String regexp = "<" + label + "[^>]*>(.*?)</" + label + ">"; //*? para reluctant (perezoso)
    
    Pattern pattern = Pattern.compile(regexp, Pattern.DOTALL);   // deshabilita multilínea
    Matcher matcher = pattern.matcher(html);

    // proceso de búsqueda de etiquetas
    int n = 0;
    while (matcher.find()) {
      System.out.println("Ocurrencia nº " + ++n + ": " + matcher.group(1));
    }
    System.out.println("\nTotal etiquetas <" + label + "> encontradas: " + n);
  }

  private static void validateArgs(String[] args) {
    if (args.length != 2) {
      System.err.println("Error en el número de parámetros"); 
      System.exit(1);
    }
  }
  
  private static String getHtml(String url) throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    return response.body();
  }
}
