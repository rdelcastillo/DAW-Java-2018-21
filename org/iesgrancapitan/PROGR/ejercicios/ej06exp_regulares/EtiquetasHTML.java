package org.iesgrancapitan.PROGR.ejercicios.ej06exp_regulares;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Programa que recibe una url y el nombre de una etiqueta html. 
 * 
 * Si la url es válida debe mostrar por la pantalla el contenido de cada etiqueta.
 * 
 * Ejemplo: si ejecuto java miprograma https://www.iesgrancapitan.org h2
 * 
 * La salida sería:
 * 
 * Últimos artículos de nuestro blog de centro.
 * 
 * Número de etiquetas encontradas: 1
 * 
 * @author rafa
 *
 */

public class EtiquetasHTML {

  public static void main(String[] args) {

    // ¿Número de parámetros correcto?
    if (args.length != 2) {
      System.err.println("Error en el número de parámetros"); 
      System.exit(1);
    }
    
    // Parámetros
    String urlALeer = args[0];
    String etiqueta = args[1];
    String html = "";
    
    try {
      
      // Abrimos y definimos conexión http
      URL url = new URL(urlALeer);
      HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
      conexion.setRequestMethod("GET");
      
      // Establecemos la conexión y leemos 
      System.out.println("Respuesta servidor web: " + conexion.getResponseCode() + "\n");
      BufferedReader bf = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
      String linea;
      while ((linea = bf.readLine()) != null) {
         html += linea + "\n";
      }
      bf.close();
      
      // Busco el contenido de la etiqueta en el html leído
      Pattern patron = Pattern.compile("<" + etiqueta + "[^>]*>(.*?)</" + etiqueta + ">", //? para reluctant (perezoso)
                                        Pattern.DOTALL); // deshabilita multilínea
      Matcher matcher = patron.matcher(html);

      int n = 0;
      while (matcher.find()) {
        System.out.println("Ocurrencia nº " + ++n + ": " + matcher.group(1));
      }
      
      System.out.println("\nTotal etiquetas <" + etiqueta + "> encontradas: " + n);
      
    } catch (Exception e) {
      System.err.println("Error al manejar la URL " + e.getMessage());
    }
    
  }
}
