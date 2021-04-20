package org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias.dto.DTO;
import org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias.dto.Result;
import com.google.gson.Gson;

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

public class TiempoEn5DiasRefactorizable {

  private static final String ROOT_ENDPOINT = "https://api.openweathermap.org";
  private static final String PATH = "/data/2.5/forecast";

  public static void main(String[] args) {
    validateArgs(args);
    String endpoint = getEndpoint(args[0]);

    try {
      String responseJson = getResponseOpenWeather(endpoint);
      showForecast(responseJson);

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

  /**
   * Este método muestra las temperaturas medias, mínimas y máximas por día y globales.
   * 
   * Usamos tres mapas para almacenar las mediciones de las temperaturas anteriores,
   * donde la clave será la fecha de medición y el valor una lista con las temperaturas de 
   * ese día.
   */
  private static void showForecast(String json) {
    Gson gson = new Gson();
    DTO dto = gson.fromJson(json, DTO.class);

    Map<String, List<Double>> temperatures = new TreeMap<>();
    Map<String, List<Double>> maxTemperatures = new TreeMap<>();
    Map<String, List<Double>> minTemperatures = new TreeMap<>();

    loadTemperatures(dto, temperatures, maxTemperatures, minTemperatures);
    showTemperatures(temperatures, maxTemperatures, minTemperatures);
  }

  /**
   * Este método pone cada medición de temperatura (que la extrae del DTO)
   * en su clave de fecha correspondiente en cada mapa.
   */
  private static void loadTemperatures(DTO dto, Map<String, List<Double>> temperatures,
      Map<String, List<Double>> maxTemperatures, Map<String, List<Double>> minTemperatures) {

    for (Result result: dto.getResults()) {
      String date = result.getDtTxt().substring(0,10);
      addResult(result.getMain().getTemp(), date, temperatures);
      addResult(result.getMain().getTempMax(), date, maxTemperatures);
      addResult(result.getMain().getTempMin(), date, minTemperatures);
    }
  }

  private static void addResult(double temp, String date, Map<String, List<Double>> temperatures) {
    if (!temperatures.containsKey(date)) {
      temperatures.put(date, new ArrayList<>());
    }
    temperatures.get(date).add(temp);
  }

  /**
   * Este método muestra las temperaturas diarias y globales sacando los valores de los mapas.
   */
  private static void showTemperatures(Map<String, List<Double>> temperatures,
      Map<String, List<Double>> maxTemperatures, Map<String, List<Double>> minTemperatures) {

    showDailyTemperatures(temperatures, maxTemperatures, minTemperatures);    
    showGlobalTemperatures(temperatures, minTemperatures, maxTemperatures);
  }

  private static void showDailyTemperatures(Map<String, List<Double>> temperatures,
      Map<String, List<Double>> maxTemperatures, Map<String, List<Double>> minTemperatures) {

    for (String date: temperatures.keySet()) {
      List<Double> measurements = temperatures.get(date);
      List<Double> maxMeasurements = maxTemperatures.get(date);
      List<Double> minMeasurements = minTemperatures.get(date);
      showDateTemperatures(date, measurements, maxMeasurements, minMeasurements);
    }
  }

  private static void showDateTemperatures(String date, List<Double> measurements, 
      List<Double> maxMeasurements, List<Double> minMeasurements) {

    double meanTemp = mean(measurements);
    double maxTemp = Collections.max(maxMeasurements);
    double minTemp = Collections.min(minMeasurements);

    System.out.println("Día " + dateToSpanish(date));
    System.out.println("--------------");
    System.out.println("Temperatura media:  " + temperatureToString(meanTemp));
    System.out.println("Temperatura mínima: " + minTemp + "º y máxima: " + maxTemp + "º");
    System.out.println("Mediciones: " + measurements.size() + "\n");
  }

  /**
   * Este método devuelve la media de la lista.
   */
  private static double mean(List<Double> measurements) {
    double sum = 0;
    for (double measurement: measurements) {
      sum += measurement;
    }
    return sum / measurements.size();
  }
  
  /**
   * Este método devuelve la fecha en formato dd/mm/aaaa.
   */
  private static String dateToSpanish(String date) {
    return date.substring(8) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
  }
  
  /**
   * Este método formatea una temperatura para obtener una cadena con dos
   * decimales y el carácter punto decimal.
   */
  private static String temperatureToString(double temperature) {
    return String.format(Locale.ROOT, "%5.2f", temperature) + "º";
  }

  private static void showGlobalTemperatures(Map<String, List<Double>> temperatures,
      Map<String, List<Double>> minTemperatures, Map<String, List<Double>> maxTemperatures) {

    double meanTemp = meanGlobalTemp(temperatures);
    double maxTemp =  maxGlobalTemp(maxTemperatures);
    double minTemp =  minGlobalTemp(minTemperatures);

    System.out.println("MEDICIONES GLOBALES");
    System.out.println("-------------------");
    System.out.println("Temperatura media:  " + temperatureToString(meanTemp));
    System.out.println("Temperatura mínima: " + temperatureToString(minTemp));
    System.out.println("Temperatura máxima: " + temperatureToString(maxTemp));
    System.out.println("Mediciones totales: " + measurementsSize(temperatures));
  }

  private static double meanGlobalTemp(Map<String, List<Double>> temperatures) {
    List<Double> globalList = temperaturesList(temperatures);
    return mean(globalList);
  }

  private static double maxGlobalTemp(Map<String, List<Double>> maxTemperatures) {
    List<Double> globalList = temperaturesList(maxTemperatures);
    return Collections.max(globalList);
  }

  private static double minGlobalTemp(Map<String, List<Double>> minTemperatures) {
    List<Double> globalList = temperaturesList(minTemperatures);
    return Collections.min(globalList);
  }

  /**
   * Este método extrae todas las listas de temperaturas del mapa pasado como parámetro
   * y las devuelve en una única lista global.
   */
  private static List<Double> temperaturesList(Map<String, List<Double>> temperatures) {
    List<Double> globalList = new ArrayList<>();
    for (String key: temperatures.keySet()) {
      globalList.addAll(temperatures.get(key));
    }
    return globalList;
  }

  /**
   * Este método devuelve el número de mediciones de temperaturas, que coincide
   * con la suma del tamaño de todas las listas del mapa.
   */
  private static int measurementsSize(Map<String, List<Double>> temperatures) {
    int size = 0;
    for (String key: temperatures.keySet()) {
      size += temperatures.get(key).size();
    }
    return size;
  }
}
