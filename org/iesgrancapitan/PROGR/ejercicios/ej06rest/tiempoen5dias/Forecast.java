package org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias;

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
 * El cometido de esta clase es mostrar las temperaturas medias, mínimas y máximas por día
 * y globales.
 * 
 * Para invocarla se llama a un método estático (show) que será quien cree un objeto a 
 * través de su constructor privado.
 * 
 * Usamos un mapa con una clase envoltorio para almacenar las mediciones de las temperaturas 
 * anteriores, donde la clave será la fecha de medición y el valor una lista con las temperaturas 
 * de ese día.
 */

public class Forecast {
  
  /**
   * Clase para almacenar la medición de una temperatura (normal, mínimo y máximo).
   * No usamos getters ni setters porque la vamos a usar como una estructura de datos.
   */
  class Temperature {
    double normal;
    double max;
    double min;
    
    public Temperature(double normal, double max, double min) {
      this.normal = normal;
      this.max = max;
      this.min = min;
    }
  }
  
  private Map<String, List<Temperature>> temperaturesForDate = new TreeMap<>();
  
  /**
   * Método estático al que se llama desde fuera de la clase para mostrar el pronóstico
   * de temperaturas.
   */
  public static void show(String json) {
    Forecast forecast = new Forecast(json);
    forecast.showDailyTemperatures();    
    forecast.showGlobalTemperatures();
  }

  private Forecast(String json) {
    Gson gson = new Gson();
    DTO dto = gson.fromJson(json, DTO.class);
    loadTemperatures(dto);
  }

  /**
   * Este método pone cada medición de temperatura (que la extrae del DTO)
   * en su clave de fecha correspondiente en cada mapa.
   */
  private void loadTemperatures(DTO dto) {
    for (Result result: dto.getResults()) {
      addResult(result);
    }
  }

  private void addResult(Result result) {
    String date = result.getDtTxt().substring(0,10);
    double tempNormal = result.getMain().getTemp();
    double tempMin = result.getMain().getTempMin();
    double tempMax = result.getMain().getTempMax();
    Temperature temp = new Temperature(tempNormal, tempMax, tempMin);
    
    if (!temperaturesForDate.containsKey(date)) {
      temperaturesForDate.put(date, new ArrayList<Temperature>());
    }
    temperaturesForDate.get(date).add(temp);
  }

  private void showDailyTemperatures() {
    for (String date: temperaturesForDate.keySet()) {
      System.out.println("Día " + dateToSpanish(date));
      System.out.println("--------------");
      showDateTemperatures(temperaturesForDate.get(date));
    }
  }

  private void showDateTemperatures(List<Temperature> temperatures) {
    System.out.println("Temperatura media:  " + temperatureToString(meanTemperature(temperatures)));
    System.out.println("Temperatura mínima: " + temperatureToString(minTemperature(temperatures)));
    System.out.println("Temperatura máxima: " + temperatureToString(maxTemperature(temperatures)));
    System.out.println("Mediciones: " + temperatures.size() + "\n");
  }

  private static double meanTemperature(List<Temperature> temperatures) {
    double sum = 0;
    for (Temperature temp: temperatures) {
      sum += temp.normal;
    }
    return sum / temperatures.size();
  }
  
  private static double maxTemperature(List<Temperature> temperatures) {
    List<Double> maxTemperatures = new ArrayList<>();
    temperatures.forEach(temp -> maxTemperatures.add(temp.max));
    return Collections.max(maxTemperatures);
  }
  
  private static double minTemperature(List<Temperature> temperatures) {
    List<Double> minTemperatures = new ArrayList<>();
    temperatures.forEach(temp -> minTemperatures.add(temp.min));
    return Collections.min(minTemperatures);
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

  private void showGlobalTemperatures() {
    List<Temperature> globalTemperatures = globalTemperatures();
    double meanGlobalTemp = meanTemperature(globalTemperatures);
    double maxGlobalTemp = maxTemperature(globalTemperatures);
    double minGlobalTemp = minTemperature(globalTemperatures);
    
    System.out.println("MEDICIONES GLOBALES");
    System.out.println("------------_------");
    System.out.println("Temperatura media:  " + temperatureToString(meanGlobalTemp));
    System.out.println("Temperatura mínima: " + temperatureToString(minGlobalTemp));
    System.out.println("Temperatura máxima: " + temperatureToString(maxGlobalTemp));
    System.out.println("Mediciones totales: " + globalTemperatures.size());
  }

  private List<Temperature> globalTemperatures() {
    List<Temperature> globalTemperatures = new ArrayList<>(); 
    for (String date: temperaturesForDate.keySet()) {
      globalTemperatures.addAll(temperaturesForDate.get(date));
    }
    return globalTemperatures;
  }

}
