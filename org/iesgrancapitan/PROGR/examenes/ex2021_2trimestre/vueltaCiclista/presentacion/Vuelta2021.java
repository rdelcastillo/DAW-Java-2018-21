package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.vueltaCiclista.presentacion;

/**
 * Tenemos guardados en un fichero CSV los nombres, dorsales y tiempos (en segundos) 
 * de las cinco etapas para los ciclistas participantes en la última vuelta ciclista local. 
 * 
 * Se pide un programa en Java que muestre y ejecute el siguiente menú:
 * 
 * 1. Cargar en memoria (arraylist) los datos de un fichero CSV y ordenarlos por el 
 *    tiempo total (primero el ciclista con menor tiempo).
 * 2. Mostrar ganador de la vuelta (dorsal, nombre del ciclista y tiempo total en HH:MM:SS).
 * 3. Mostrar ganador de una etapa (dorsal, nombre del ciclista y tiempo en HH:MM:SS).
 * 4. Mostrar ganador de cada una de las etapas (etapa, dorsal, nombre del ciclista y tiempo en HH:MM:SS).
 * 5. Guardar en un fichero CSV los datos de la opción anterior.
 * 6. Mostrar la tabla de tiempos (dorsal, nombre del ciclista, tiempos por etapa y tiempo total en HH:MM:SS).
 * 7. Finalizar.
 * 
 * A tener en cuenta:
 * 
 * - Si no se ha cargado en memoria los datos del fichero no funcionan las demás opciones.
 * - Cuando una opción necesite saber a qué etapa nos referimos damos su número (empezamos en 1).
 * - Usa un clase para los datos del ciclista y otra para gestionar el menú.
 * - Si los ficheros dan errores al abrirlos adviértelo al usuario y que el programa continúe.
 * - Recuerda todo lo que hemos visto en clase acerca de la legibilidad y refactorización.
 * - La comprobación de si el CSV está bien o mal déjalo para el final. Inicialmente suponed que el 
 *   formato del fichero pasado es correcto (usad el que os he puesto).
 *   
 *   @author Rafael del Castillo.
 *
 */

import java.io.IOException;
import java.util.Scanner;
import org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.utiles.Menu;
import org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.vueltaCiclista.negocio.CSVEtapasCiclistasException;
import org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.vueltaCiclista.negocio.Ciclista;
import org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.vueltaCiclista.negocio.CiclistasVuelta;

public class Vuelta2021 {
  
  private static CiclistasVuelta ciclistas = new CiclistasVuelta();

  public static void main(String[] args) {
    Menu menu = new Menu("VUELTA CICLISTA", 
        "Cargar datos etapas", "Mostrar ganador de la vuelta", "Mostrar ganador de una etapa",
        "Mostrar ganadores de cada etapa", "Guardar ganadores de cada etapa en un fichero CSV",
        "Mostrar tabla de tiempos", "Finalizar");

    while (true) {
      int opcion = menu.elegir();
      switch (opcion) {
        case 1: 
          cargaCiclistasCSV(); break;
        case 2: case 3: case 4: case 5: case 6:
          if (! ciclistas.isEmpty()) {
            switch (opcion) {
              case 2: muestraGanadorVuelta(); break;
              case 3: muestraGanadorEtapa(); break;
              case 4: muestraGanadoresEtapas(); break;
              case 5: guardaGanadoresEtapas(); break;
              case 6: muestraTablaTiempos(); break;
            }
          } else {
            System.out.println("Primero debe cargar los datos...\n");
          }
          break;
        default: 
          System.out.println("Adiós!!!");
          System.exit(0);
      }
    }

  }
  private static void cargaCiclistasCSV() {
    CiclistasVuelta ciclistasCopia = ciclistas;
    String nombreFichero = pideNombreFichero();

    try {
      ciclistas = new CiclistasVuelta();
      ciclistas.cargaCSV(nombreFichero);
      
    } catch (IOException | CSVEtapasCiclistasException e) {
      ciclistas = ciclistasCopia;
      System.err.println("Error al abrir " + nombreFichero + ": " + e.getMessage() + "\n");
    }
  }

  private static String pideNombreFichero() {
    Scanner s = new Scanner(System.in);
    System.out.print("Nombre del fichero: ");
    String nombreFichero = s.nextLine();
    System.out.println();
    return nombreFichero;
  }

  private static void muestraGanadorVuelta() {
    muestraDatosGanadorVuelta(ciclistas.ganadorVuelta());
  }
  
  private static void muestraDatosGanadorVuelta(Ciclista ganador) {
    System.out.println("Ganador de la vuelta: dorsal " + ganador.getDorsal() 
    + " - " + ganador.getNombre() + " con tiempo " 
    + CiclistasVuelta.tiempoFormateado(ganador.getTiempoTotal()));
    System.out.println();
  }

  private static void muestraGanadorEtapa() {
    int etapa = pideEtapa();
    Ciclista ganador = ciclistas.ganadorEtapa(etapa);
    muestraDatosGanadorEtapa(etapa, ganador);
  }

  private static void muestraDatosGanadorEtapa(int etapa, Ciclista ganador) {
    System.out.println("Ganador de la etapa: " + etapa + " dorsal " + ganador.getDorsal() 
                     + " - " + ganador.getNombre() + " con tiempo " 
                     + CiclistasVuelta.tiempoFormateado(ganador.getTiempoEtapa(etapa)));
    System.out.println();
  }
  
  private static int pideEtapa() {
    Scanner s = new Scanner(System.in);
    int etapa;
    do {
      System.out.print("Dame un número de etapa (entre 1 y " + CiclistasVuelta.NUM_ETAPAS + "): ");
      etapa = s.nextInt();
    } while (etapa < 1 || etapa > CiclistasVuelta.NUM_ETAPAS);
    return etapa;
  }

  private static void muestraGanadoresEtapas() {
    for (int etapa = 1; etapa <= CiclistasVuelta.NUM_ETAPAS; etapa++) {
      Ciclista ganador = ciclistas.ganadorEtapa(etapa);
      muestraDatosGanadorEtapa(etapa, ganador);
    }

  }
  private static void guardaGanadoresEtapas() {
    String nombreFichero = pideNombreFichero();
    try {
      ciclistas.guardaGanadoresEtapasCSV(nombreFichero);
    } catch (IOException e) {
      System.err.println("Error al escribir en el fichero");
    }
  }

  private static void muestraTablaTiempos() {
    System.out.println(ciclistas);
  }

}