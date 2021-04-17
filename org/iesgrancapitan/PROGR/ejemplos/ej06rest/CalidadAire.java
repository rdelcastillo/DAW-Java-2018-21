package org.iesgrancapitan.PROGR.ejemplos.ej06rest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import org.iesgrancapitan.PROGR.ejemplos.ej06rest.dtoCalidadAire.DTO;
import org.iesgrancapitan.PROGR.ejemplos.ej06rest.dtoCalidadAire.Measurement;
import org.iesgrancapitan.PROGR.ejemplos.ej06rest.dtoCalidadAire.Result;
import com.google.gson.Gson;

/**
 * Este programa nos muestra las mediciones de los parámetros de calidad del 
 * aire en Córdoba usando el servicio web api.openaq.org.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CalidadAire {

  private static final String ROOT_ENDPOINT = "https://api.openaq.org";
  private static final String PATH = "/v1/latest";
  private static final String PARAMS = "?city=Córdoba&parameter=no2";

  public static void main(String[] args) {
    try {
      String responseJson = getResponseOpenAQ();
      muestraDatos(responseJson);

    } catch (IOException | InterruptedException e) {
      System.out.println("Error al acceder al hacer la petición: " + e.getMessage());
    }
  }

  private static String getResponseOpenAQ() throws IOException, InterruptedException {
    String endpoint = ROOT_ENDPOINT + PATH + PARAMS;
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(endpoint))
        .GET()
        .build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    return response.body();
  }

  private static void muestraDatos(String json) {
    Gson gson = new Gson();
    DTO dto = gson.fromJson(json, DTO.class);
    
    System.out.println("Puntos de medición encontrados: " + dto.getMeta().getFound() + "\n");
    for (Result result: dto.getResults()) {
      muestraLocalizacion(result);
      muestraMediciones(result.getMeasurements());
    }
  }

  private static void muestraLocalizacion(Result result) {
    System.out.println("Localización: " + result.getLocation() + ". "
                     + "Coordenadas: " 
                     + result.getCoordinates().getLatitude() + ", " 
                     + result.getCoordinates().getLongitude());
  }

  private static void muestraMediciones(List<Measurement> list) {
    System.out.println("------------");
    for (Measurement measurement: list) {
      System.out.println(measurement.getParameter().toUpperCase() + ": " 
                       + measurement.getValue() + " " + measurement.getUnit());
      System.out.println("Actualizado el " + measurement.getLastUpdated() + "\n");
    }
  }

}
