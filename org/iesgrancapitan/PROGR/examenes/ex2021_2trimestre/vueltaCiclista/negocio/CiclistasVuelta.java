package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.vueltaCiclista.negocio;

/**
 * Clase que guarda los tiempos de las etapas de ciclistas participantes en una vuelta.
 * 
 * Además permite:
 * 
 * - Importar los datos de un fichero CSV.
 * - Obtener el ganador de la vuelta.
 * - Obtener el ganador de una etapa.
 * - Guardar los ganadores de las etapas.
 * - Acceder a los datos de la lista.
 *   
 *   @author Rafael del Castillo.
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CiclistasVuelta {

  public static final int NUM_ETAPAS = 5;
  
  private List<Ciclista> ciclistas = new ArrayList<>();

  /**
   * Guarda en el arraylist ciclistas los datos del fichero enviado como parámetro.
   * @param nombreFichero
   * @throws IOException
   * @throws CiclistasVueltaCSVException
   */
  public void cargaCSV(String nombreFichero) throws IOException, CiclistasVueltaCSVException {
    var reader = new CiclistasVueltaCSVLoader(ciclistas);
    reader.carga(nombreFichero);
  }

  public Ciclista ganadorVuelta() {
    return (ciclistas.isEmpty()) ? null : Collections.min(ciclistas);
  }

  public Ciclista ganadorEtapa(int etapa) {
    Ciclista ganador = ciclistas.get(0); 
    for (Ciclista c: ciclistas.subList(1, ciclistas.size())) {
      if (c.getTiempoEtapa(etapa) < ganador.getTiempoEtapa(etapa)) {
        ganador = c;
      }
    }
    return ganador;
  }

  public boolean isEmpty() {
    return ciclistas.isEmpty();
  }
  
  public int size() {
    return ciclistas.size();
  }
  
  /**
   * Devuelve ciclista nº i. Empezamos a contar desde 1
   */
  public Ciclista getCiclista(int i) {
    return ciclistas.get(i + 1);
  }
  
  public String toString() {
    String salida = cabeceraTablaTiempos();
    for (Ciclista ciclista: ciclistas) {
      salida += ciclistasTablaTiempos(ciclista);
    }
    return salida;
  }

  private static String cabeceraTablaTiempos() {
    final int longitudDorsalMasCiclista = 25;
    int longitudEtapa = 7;
    int longitudTotal = 11;

    String cabecera = (" ".repeat(longitudDorsalMasCiclista));   // blancos iniciales
    for (int etapa = 1; etapa <= NUM_ETAPAS; etapa++) {
      cabecera += String.format("%3d    ", etapa);
    }
    cabecera += "   TOTAL\n";
    cabecera += " ".repeat(longitudDorsalMasCiclista);
    cabecera += "-".repeat(NUM_ETAPAS * longitudEtapa + longitudTotal) + "\n";
    return cabecera;
  }

  private static String ciclistasTablaTiempos(Ciclista ciclista) {
    String linea = String.format("%3d. %-20s ", ciclista.getDorsal(), ciclista.getNombre());
    for (int etapa = 1; etapa <= NUM_ETAPAS; etapa++) {
      linea += String.format("%,6d ", ciclista.getTiempoEtapa(etapa));
    }
    linea += "| " + tiempoFormateado(ciclista.getTiempoTotal()) + "\n";
    return linea;
  }

  /**
   * Devuelve una cadena con el tiempo al que equivale s en formato HH:MM:SS
   * @param s segundos
   * @return tiempo en formato HH:MM:SS
   */
  public static String tiempoFormateado(int s) {
    int horas = s / 3600;
    int segundos = s % 3600;
    int minutos = segundos / 60;
    segundos = segundos % 60;
    return String.format("%02d:%02d:%02d", horas, minutos, segundos);
  }

  public void guardaGanadoresEtapasCSV(String nombreFichero) throws FileNotFoundException {
    var writer = new CiclistasVueltaCSVWriter(this);
    writer.guarda(nombreFichero);
  }

}
