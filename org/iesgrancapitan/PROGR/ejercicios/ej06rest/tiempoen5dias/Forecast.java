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
 * Usamos tres mapas para almacenar las mediciones de las temperaturas anteriores,
 * donde la clave será la fecha de medición y el valor una lista con las temperaturas de 
 * ese día.
 */

public class Forecast {
  
  class Temperatures {
    List<Double> stdTemperatures = new ArrayList<>();
    List<Double> maxTemperatures = new ArrayList<>();
    List<Double> minTemperatures = new ArrayList<>();
  }
  
  private Map<String, Temperatures> temperaturesForDate = new TreeMap<>();
  
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
    double temp = result.getMain().getTemp();
    double tempMin = result.getMain().getTempMin();
    double tempMax = result.getMain().getTempMax();
    
    if (!temperaturesForDate.containsKey(date)) {
      temperaturesForDate.put(date, new Temperatures());
    }
    temperaturesForDate.get(date).stdTemperatures.add(temp);
    temperaturesForDate.get(date).minTemperatures.add(tempMin);
    temperaturesForDate.get(date).maxTemperatures.add(tempMax);
  }

  private void showDailyTemperatures() {
    for (String date: temperaturesForDate.keySet()) {
      System.out.println("Día " + dateToSpanish(date));
      System.out.println("--------------");
      showDateTemperatures(temperaturesForDate.get(date));
    }
  }

  private void showDateTemperatures(Temperatures temperatures) {
    double meanTemp = mean(temperatures.stdTemperatures);
    double maxTemp = Collections.max(temperatures.maxTemperatures);
    double minTemp = Collections.min(temperatures.minTemperatures);
    int measurements = temperatures.stdTemperatures.size();

    System.out.println("Temperatura media:  " + temperatureToString(meanTemp));
    System.out.println("Temperatura mínima: " + minTemp + "º y máxima: " + maxTemp + "º");
    System.out.println("Mediciones: " + measurements + "\n");
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

  private void showGlobalTemperatures() {
    System.out.println("MEDICIONES GLOBALES");
    System.out.println("------------_------");
    System.out.println("Temperatura media:  " + temperatureToString(meanGlobalTemp()));
    System.out.println("Temperatura mínima: " + temperatureToString(minGlobalTemp()));
    System.out.println("Temperatura máxima: " + temperatureToString(maxGlobalTemp()));
    System.out.println("Mediciones totales: " + measurementsSize());
  }

  private double meanGlobalTemp() {
    List<Double> globalTemp = new ArrayList<>();
    for (String key: temperaturesForDate.keySet()) {
      globalTemp.addAll(temperaturesForDate.get(key).stdTemperatures);
    }
    return mean(globalTemp);
  }

  private double minGlobalTemp() {
    List<Double> globalMinTemp = new ArrayList<>();
    for (String key: temperaturesForDate.keySet()) {
      globalMinTemp.addAll(temperaturesForDate.get(key).minTemperatures);
    }
    return Collections.min(globalMinTemp);
  }
  
  private double maxGlobalTemp() {
    List<Double> globalMaxTemp = new ArrayList<>();
    for (String key: temperaturesForDate.keySet()) {
      globalMaxTemp.addAll(temperaturesForDate.get(key).minTemperatures);
    }
    return Collections.max(globalMaxTemp);
  }

  /**
   * Este método devuelve el número de mediciones de temperaturas, que coincide
   * con la suma del tamaño de todas las listas del mapa.
   */
  private int measurementsSize() {
    int size = 0;
    for (String key: temperaturesForDate.keySet()) {
      size += temperaturesForDate.get(key).stdTemperatures.size();
    }
    return size;
  }

}
