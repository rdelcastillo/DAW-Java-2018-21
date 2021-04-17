package org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * Usando la API de OpenWeather obtendremos el pronóstico del tiempo para una ciudad que 
 * se pasa como parámetro de los próximos cinco días, mostraremos:
 * 
 * Temperatura media, mínima y máxima (en grados Celsius) para cada día y global.
 * 
 * Para las temperaturas medias usaremos la clave "temp" del json devuelto por la API.
 * Para las temperaturas mínimas usaremos la clave "temp_min" del json devuelto por la API.
 * Para las temperaturas máximas usaremos la clave "temp_max" del json devuelto por la API.
 * 
 * Esta clase se puede refactorizar dividiéndola en otras clases que disminuyan su complejidad.
 * en otro ejercicio posterior lo hacemos.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class TiempoEn5Dias {

  private static final String ROOT_ENDPOINT = "https://api.openweathermap.org";
  private static final String PATH = "/data/2.5/forecast";

  public static void main(String[] args) {
    validateArgs(args);
    String endpoint = getEndpoint(args[0]);

    try {
      String responseJson = getResponseOpenWeather(endpoint);
      Forecast.show(responseJson);

    } catch (IOException | InterruptedException e) {
      System.out.println("Error al acceder al hacer la petición: " + e.getMessage());
    }
  }

  private static void validateArgs(String[] args) {
    if (args.length != 1) {
      System.err.println("Número de argumentos inválido.");
      System.exit(1);
    }
  }

  private static String getEndpoint(String ciudad) {
    String params = "?q=" + ciudad + "&appid=" + System.getenv().get("OPEN_WEATHER_KEY") + "&units=metric&lang=es";
    return ROOT_ENDPOINT + PATH + params;
  }

  /**
   * Este método devuelve la respuesta (JSON) a la petición http realizada a la API OpenWeather.
   */
  private static String getResponseOpenWeather(String endpoint) throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(endpoint))
        .GET()
        .build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    return response.body();
  }

}
