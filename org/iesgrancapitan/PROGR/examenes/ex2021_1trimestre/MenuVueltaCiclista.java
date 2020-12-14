package org.iesgrancapitan.PROGR.examenes.ex2021_1trimestre;

/**
 * Guardamos en un array de 15x5 los tiempos de cada ciclista y etapa para los participantes en la 
 * última vuelta ciclista local. 
 * 
 * En este array tenemos una fila por cada ciclista en el mismo orden con que aparecen en otro array 
 * de ciclistas. Cada fila tiene el tiempo en segundos invertido en cada una de las 5 etapas de la carrera.
 * 
 * El array de ciclistas tiene una fila por cada ciclista con el dorsal (entero) de cada uno de ellos 
 * y tenemos otro array con los nombres de esos ciclistas (inicializa este array con los valores que quieras.
 * 
 * Ejemplo:
 * 
 * ciclistas = {3, 6, 10, 15, 16, 18, 21, 24, 28, 32, 33, 35, 37, 39, 44}
 * nombresCiclistas = {“Bernard Hinoult”, “Laurent Fignon”, “Miguel Indurain”, …}
 * tiempos = {{15342, 16891, 14321, 13233, 14444},
 *            {17342, 16391, 13321, 16233, 14664},
 *              …
 *            {15522, 18891, 17321, 14233, 16844}}
 *            
 * Haz un programa en Java que muestre y ejecute el siguiente menú:
 * 
 *  1. Generar aleatoriamente los tiempos (enteros entre 10000 y 19999) y dorsales (enteros entre 1 y 99, 
 *  no pueden repetirse).
 *  2. Mostrar ganador de la vuelta (dorsal, nombre del ciclista y tiempo total en HH:MM:SS).
 *  3. Mostrar ganador de una etapa (dorsal, nombre del ciclista y tiempo en HH:MM:SS).
 *  4. Mostrar ganador de cada una de las etapas (etapa, dorsal, nombre del ciclista y tiempo en HH:MM:SS).
 *  5. Mostrar la tabla de tiempos (dorsal, nombre del ciclista, tiempos por etapa y tiempo total).
 *  6. Finalizar.
 *  
 *  A tener en cuenta:
 *  
 *   - Si el array de tiempos y dorsales no se ha generado no funcionan las demás opciones.
 *   - Cuando una opción necesite saber a qué etapa nos referimos damos su número (empezamos en 1).
 *   - Si se da una opción equivocada en el menú se muestra un error.
 */

import java.util.Scanner;

public class MenuVueltaCiclista {
  
  final static public int NUM_ETAPAS = 5;
  final static public int NUM_CICLISTAS = 15;
  final static public int TIEMPO_MIN = 10000;
  final static public int TIEMPO_MAX = 19999;
  final static public int DORSAL_MIN = 1;
  final static public int DORSAL_MAX = 99;

  public static void main(String[] args) {
    String [] nombresCiclistas = new String[NUM_CICLISTAS];
    int[] ciclistas = new int[NUM_CICLISTAS];
    int[][] etapas = new int[NUM_CICLISTAS][NUM_ETAPAS];
    int opcion;
    boolean continuar = true;
    boolean datosGenerados = false;
    
    // Inicializamos el array de estudiantes
    for (int i = 0; i < nombresCiclistas.length; i++) {
      nombresCiclistas[i] = "Ciclista nº " + (i+1);
    }
    
    // Proceso
    do {
      opcion = menu();
      switch (opcion) {
        case 1: // generamos los tiempos y dorsales
          generaDatos(etapas, ciclistas);
          datosGenerados = true;
          break;
        case 2: case 3: case 4: case 5: 
          if (datosGenerados) {    // si se han los tiempos y dorsales
            switch (opcion) {
              case 2:
                mostrarGanadorVuelta(etapas, ciclistas, nombresCiclistas);
                break;
              case 3:
                mostrarGanadorEtapa(etapas, ciclistas, nombresCiclistas);
                break;
              case 4:
                mostrarGanadoresEtapas(etapas, ciclistas, nombresCiclistas);
                break;
              case 5:
                mostrarTiempos(etapas, ciclistas, nombresCiclistas);
            }
          } else {
            System.out.println("Primero debe generar los tiempos y dorsales.\n");
          }
          break;
        case 6:
          continuar = false;
          break;
        default:
          System.out.println("Opción incorrecta\n");
      }
    } while (continuar);
    System.out.println("¡Adiós!");
  }

  /**
   * Muestra el menú y devuelve la opción elegida.
   * @return opción
   */
  public static int menu() {
    int opcion;
    
    // escribo el menú
    System.out.println("Menú de opciones");
    System.out.println("----------------");
    System.out.println("1. Generar aleatoriamente los tiempos y dorsales.\n"
        + "2. Mostrar ganador de la vuelta.\n"
        + "3. Mostrar ganador de una etapa.\n"
        + "4. Mostrar ganador de cada una de las etapas.\n"
        + "5. Mostrar la tabla de tiempos.\n"
        + "6. Finalizar.");
   
    // leo la opción
    Scanner s = new Scanner(System.in);
    System.out.print("\nIntroduce una opción: ");
    opcion = s.nextInt();
    
    // acabo
    System.out.println("\n");
    return opcion;
  }

  /**
   * Genera los tiempos y dorsales aleatoriamente.
   * 
   * @param etapas
   * @param ciclistas 
   */
  public static void generaDatos(int[][] etapas, int[] ciclistas) {
    boolean[] dorsalGenerado = new boolean[DORSAL_MAX - DORSAL_MIN + 1];  // para controlar repeticiones dorsales
    
    // inicializamos a falso los testigos de los dorsales
    for (int i = 0; i < dorsalGenerado.length; i++) {
      dorsalGenerado[i] = false;
    }
    
    // generamos datos
    for (int i = 0; i < NUM_CICLISTAS; i++) {
      
      // dorsal ciclista
      int dorsal;
      do {
        dorsal = DORSAL_MIN + (int) (Math.random() * (DORSAL_MAX - DORSAL_MIN + 1));
      } while (dorsalGenerado[dorsal - DORSAL_MIN]);
      dorsalGenerado[dorsal - DORSAL_MIN] = true;   // marcamos como generado
      ciclistas[i] = dorsal;
      
      // etapas
      for (int j = 0; j < NUM_ETAPAS; j++) {
        etapas[i][j] = TIEMPO_MIN + (int) (Math.random() * (TIEMPO_MAX - TIEMPO_MIN + 1));
      }
    }
  }
  
  /**
   * Muestra el ganador de la vuelta
   * @param etapas
   * @param ciclistas
   * @param nombresCiclistas
   */
  public static void mostrarGanadorVuelta(int[][] etapas, int[] ciclistas, String[] nombresCiclistas) {
    
    // buscamos ganador
    int ganador = ganadorVuelta(etapas);
        
    // Mostramos ganador
    System.out.printf("\nGanador de la vuelta: dorsal %2d - %s con tiempo %s\n\n", 
                        ciclistas[ganador], nombresCiclistas[ganador], 
                        tiempo(tiempoTotal(etapas, ganador)));
    
  }

  /**
   * Muestra el ganador de una etapa.
   * @param etapas
   * @param ciclistas
   * @param nombresCiclistas
   */
  public static void mostrarGanadorEtapa(int[][] etapas, int[] ciclistas, String[] nombresCiclistas) {
    Scanner s = new Scanner(System.in);
    int etapa;
    
    // Pedimos la etapa hasta que esté correcta
    do {
      System.out.print("Dame un número de etapa (entre 1 y " + NUM_ETAPAS + "): ");
      etapa = s.nextInt();
    } while (etapa < 1 || etapa > NUM_ETAPAS);
    
    // buscamos ganador
    int ganador = ganadorEtapa(etapas, etapa);
    
    // Mostramos ganador
    System.out.printf("\nGanador de la etapa %d: dorsal %2d - %s con tiempo %s\n\n", 
                        etapa, ciclistas[ganador], nombresCiclistas[ganador], 
                        tiempo(etapas[ganador][etapa-1]));

  }

  /**
   * Devuelve la fila donde está el ganador de una etapa.
   * @param etapas
   * @param etapa
   * @return fila del ganador
   */
  public static int ganadorEtapa(int[][] etapas, int etapa) {
    int ganador = 0;    // buscamos al ciclista con tiempo mínimo en la etapa 
    for (int i = 1; i < NUM_CICLISTAS; i++) {
      if (etapas[i][etapa-1] < etapas[ganador][etapa-1]) {
        ganador = i;
      }
    }
    return ganador;
  }
  
  public static void mostrarGanadoresEtapas(int[][] etapas, int[] ciclistas, String[] nombresCiclistas) {
    
    for (int etapa = 1; etapa <= NUM_ETAPAS; etapa++) {
      // buscamos ganador
      int ganador = ganadorEtapa(etapas, etapa);
      
      // Mostramos ganador
      System.out.printf("Ganador de la etapa %2d: dorsal %2d - %-15s con tiempo %s\n", 
                          etapa, ciclistas[ganador], nombresCiclistas[ganador], 
                          tiempo(etapas[ganador][etapa-1]));
    }
    System.out.println("\n");
  }

  /**
   * Devuelve la fila donde está el ganador de la vuelta.
   * @param etapas
   * @return fila del ganador
   */
  public static int ganadorVuelta(int[][] etapas) {
    int ganador = 0;    // buscamos al ciclista con tiempo mínimo en la vuelta 
    for (int i = 1; i < NUM_CICLISTAS; i++) {
      if (tiempoTotal(etapas, i) < tiempoTotal(etapas, ganador)) {
        ganador = i;
      }
    }
    return ganador;
  }

  /**
   * Devuelve el tiempo total del ciclista pasado como parámetro.
   * @param etapas
   * @param ciclista
   * @return
   */
  public static int tiempoTotal(int[][] etapas, int ciclista) {
    int tiempo = 0;
    for (int t: etapas[ciclista]) {
      tiempo += t;
    }
    return tiempo;
  }
  
  /**
   * Devuelve una cadena con el tiempo al que equivale s en formato HH:MM:SS
   * @param s segundos
   * @return tiempo en formato HH:MM:SS
   */
  public static String tiempo(int s) {
    int horas = s / 3600;
    int segundos = s % 3600;
    int minutos = segundos / 60;
    segundos = segundos % 60;
    return String.format("%02d:%02d:%02d", horas, minutos, segundos);
  }
  
  /**
   * Muestra los tiempos de cada ciclista.
   * @param etapas
   * @param ciclistas
   * @param nombresCiclistas
   */
  public static void mostrarTiempos(int[][] etapas, int[] ciclistas, String[] nombresCiclistas) {
    // cabecera
    System.out.print(" ".repeat(25));   // blancos iniciales
    for (int etapa = 1; etapa <= NUM_ETAPAS; etapa++) {
      System.out.printf("%3d   ", etapa);
    }
    System.out.println("  TOTAL\n" + " ".repeat(25) + "-".repeat(NUM_ETAPAS*6 + 7));
    
    // ciclistas
    for (int i = 0; i < NUM_CICLISTAS; i++) {
      System.out.printf("%2d. %-20s ", ciclistas[i], nombresCiclistas[i]);
      for (int tiempo: etapas[i]) {
        System.out.printf("%5d ", tiempo);
      }
      System.out.printf("|%6d\n", tiempoTotal(etapas, i));
    }
    System.out.println();
    
  }

}
