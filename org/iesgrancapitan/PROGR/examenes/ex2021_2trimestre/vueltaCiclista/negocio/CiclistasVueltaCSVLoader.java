package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.vueltaCiclista.negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class CiclistasVueltaCSVLoader {

  private static final String CABECERA = "Nombre,Dorsal,Etapa1,Etapa2,Etapa3,Etapa4,Etapa5";
  
  private List<Ciclista> ciclistas;
  private BufferedReader fichero;

  CiclistasVueltaCSVLoader(List<Ciclista> ciclistas) {
    this.ciclistas = ciclistas;
  }

  void carga(String nombreFichero) throws IOException, CiclistasVueltaCSVException {
    fichero = Files.newBufferedReader(Paths.get(nombreFichero));
    validaCabecera();

    String ciclista;
    while ((ciclista=fichero.readLine()) != null) {
      validaCiclista(ciclista);
      addCiclista(ciclista);
    }

    fichero.close();
    Collections.sort(ciclistas);   
  }

  private void validaCabecera() throws CiclistasVueltaCSVException, IOException {
    String cabecera = fichero.readLine();
    if (! CABECERA.equalsIgnoreCase(cabecera)) {
      throw new CiclistasVueltaCSVException("Cabecera del CSV Errónea: " + cabecera);
    }
  }

  private static void validaCiclista(String ciclista) throws CiclistasVueltaCSVException {
    // ¿El nombre del ciclista está encerrado entre comillas?
    if (! ciclista.startsWith("\"")) {
      throw new CiclistasVueltaCSVException("Nombre del ciclista no empieza con \": " + ciclista);
    }
    int posFinNombre = ciclista.indexOf("\",", 1);
    if (posFinNombre == -1) {
      throw new CiclistasVueltaCSVException("Nombre del ciclista no termina con \": " + ciclista);
    }

    // ¿Resto de campos son la cantidad correcta y numéricos?
    String dorsalYEtapas = ciclista.substring(posFinNombre + 2);
    validaDorsalYEtapas(dorsalYEtapas);

  }
  
  private static void validaDorsalYEtapas(String dorsalYEtapas) throws CiclistasVueltaCSVException {
    String[] campos = dorsalYEtapas.split(","); 
    int numCamposEsperado = CABECERA.split(",").length - 1;
    if (campos.length != numCamposEsperado) {
      throw new CiclistasVueltaCSVException("Número de campos del CSV incorrecto en línea con: " + dorsalYEtapas);
    }
    // ¿Son los campos numéricos?
    for (String num: campos) {
      validaCampoNumerico(num);
    }
  }

  private static void validaCampoNumerico(String num) throws CiclistasVueltaCSVException {
    for (char d: num.toCharArray()) {
      if (! Character.isDigit(d)) {
        throw new CiclistasVueltaCSVException(num + " no es numérico.");
      }
    }
  }

  private void addCiclista(String ciclista) {
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
    int primerIndiceEtapas = camposCiclista.length - CiclistasVuelta.NUM_ETAPAS;
    int[] tiempos = new int[CiclistasVuelta.NUM_ETAPAS];
    for (int i = primerIndiceEtapas; i < camposCiclista.length; i++) {
      tiempos[i - primerIndiceEtapas] = Integer.valueOf(camposCiclista[i]);
    }
    return tiempos;
  }

}
