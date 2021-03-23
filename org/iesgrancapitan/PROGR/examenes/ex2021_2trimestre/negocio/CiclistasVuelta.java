package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.negocio;

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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CiclistasVuelta {

  public static final int NUM_ETAPAS = 5;
  public static final String CABECERA_CSV = "Nombre,Dorsal,Etapa1,Etapa2,Etapa3,Etapa4,Etapa5";
  
  List<Ciclista> ciclistas = new ArrayList<>();

  /**
   * Guarda en el arraylist ciclistas los datos del fichero enviado como parámetro.
   * @param nombreFichero
   * @throws IOException
   * @throws CSVEtapasCiclistasException
   */
  public void cargaCSV(String nombreFichero) throws IOException, CSVEtapasCiclistasException {
    var fichero = Files.newBufferedReader(Paths.get(nombreFichero));
    validaCabeceraCSV(fichero);

    String ciclista;
    while ((ciclista=fichero.readLine()) != null) {
      validaCiclistaCSV(ciclista);
      addCiclistaCSV(ciclista);
    }

    fichero.close();
    Collections.sort(ciclistas);
  }

  private static void validaCabeceraCSV(BufferedReader fichero) throws IOException, CSVEtapasCiclistasException {
    String cabecera = fichero.readLine();
    if (! cabecera.equalsIgnoreCase(CABECERA_CSV)) {
      throw new CSVEtapasCiclistasException("Cabecera del CSV Errónea: " + cabecera);
    }
  }

  private static void validaCiclistaCSV(String ciclista) throws CSVEtapasCiclistasException {
    // ¿El nombre del ciclista está encerrado entre comillas?
    if (! ciclista.startsWith("\"")) {
      throw new CSVEtapasCiclistasException("Nombre del ciclista no empieza con \": " + ciclista);
    }

    int posFinNombre = ciclista.indexOf("\",", 1);
    if (posFinNombre == -1) {
      throw new CSVEtapasCiclistasException("Nombre del ciclista no termina con \": " + ciclista);
    }
    // ¿Resto de campos son la cantidad correcta y numéricos?
    String dorsalYEtapas = ciclista.substring(posFinNombre + 2);
    validaDorsalYEtapas(dorsalYEtapas);

  }
  private static void validaDorsalYEtapas(String dorsalYEtapas) throws CSVEtapasCiclistasException {
    String[] campos = dorsalYEtapas.split(","); 
    int numCamposEsperado = CABECERA_CSV.split(",").length - 1;
    if (campos.length != numCamposEsperado) {
      throw new CSVEtapasCiclistasException("Número de campos del CSV incorrecto en línea con: " + dorsalYEtapas);
    }
    // ¿Son los campos numéricos?
    for (String num: campos) {
      validaCampoNumerico(num);
    }
  }

  private static void validaCampoNumerico(String num) throws CSVEtapasCiclistasException {
    for (char d: num.toCharArray()) {
      if (! Character.isDigit(d)) {
        throw new CSVEtapasCiclistasException(num + " no es numérico.");
      }
    }
  }

  private void addCiclistaCSV(String ciclista) {
    String nombre = getNombreCiclista(ciclista);
    int dorsal = getNumeroDorsal(ciclista);
    int[] tiempos = getTiemposCiclista(ciclista);
    ciclistas.add(new Ciclista(nombre, dorsal, tiempos));
  }

  private static String getNombreCiclista(String ciclista) {
    return ciclista.substring(1, ciclista.indexOf("\","));  // límite nombre
  }

  private static int getNumeroDorsal(String ciclista) {
    int indiceInicioDorsal = ciclista.indexOf("\",") + 2;
    int indiceFinDorsal = ciclista.indexOf(",", indiceInicioDorsal);
    return Integer.valueOf(ciclista.substring(indiceInicioDorsal, indiceFinDorsal));
  }

  private static int[] getTiemposCiclista(String ciclista) {
    String[] camposCiclista = ciclista.split(",");
    int primerIndiceEtapas = camposCiclista.length - NUM_ETAPAS;
    int[] tiempos = new int[NUM_ETAPAS];
    for (int i = primerIndiceEtapas; i < camposCiclista.length; i++) {
      tiempos[i - primerIndiceEtapas] = Integer.valueOf(camposCiclista[i]);
    }
    return tiempos;
  }

  public Ciclista ganadorVuelta() {
    return (ciclistas.isEmpty()) ? null : Collections.max(ciclistas);
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
    String tabla = String.format("%3d. %-20s ", ciclista.getDorsal(), ciclista.getNombre());
    for (int etapa = 1; etapa <= NUM_ETAPAS; etapa++) {
      tabla += String.format("%,6d ", ciclista.getTiempoEtapa(etapa));
    }
    tabla += "| " + tiempoFormateado(ciclista.getTiempoTotal()) + "\n";
    return tabla;
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
    var fichero = new PrintWriter(nombreFichero); 
    fichero.println("Etapa,Dorsal,Nombre,Tiempo");
    for (int etapa = 1; etapa <= NUM_ETAPAS; etapa++) {
      Ciclista ganador = ganadorEtapa(etapa);
      fichero.println(etapa + "," + ganador.getDorsal() + ",\"" 
                    + ganador.getNombre() + "\",\"" 
                    + CiclistasVuelta.tiempoFormateado(ganador.getTiempoEtapa(etapa)) + "\"");
    }
    fichero.close();
  }

}
