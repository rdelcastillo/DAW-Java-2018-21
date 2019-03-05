package org.iesgrancapitan.PROGR.Java.examenes.ex18_1trimestre;

/*
 * Impresión de la quiniela de la jornada de fútbol (15 partidos) después de conocer los resultados.
 * 
 * Para ello vamos a utilizar dos matrices:
 * 
 * - Equipos:   matriz de cadenas de caracteres donde guardamos en cada columna el nombre 
 *              de los equipos de cada partido. En la quiniela se indican 15 partidos.
 * - Resultados: matriz de enteros donde se indica el resultado. También tiene dos columnas, 
 *              en la primera se guarda el número de goles del equipo que está guardado en la 
 *              primera columna de la tabla anterior, y en la segunda los goles del otro equipo.
 *              
 * El programa ira pidiendo los nombres de los equipos de cada partido y el resultado del partido,
 * guardará los datos donde corresponda y a continuación imprimirá la quiniela de esa jornada 
 * llamando a una función que recibirá ambas matrices.
 * 
 */

import java.util.Scanner;

public class Ej2Quiniela {
  public static final int NPARTIDOS=15;
  
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String [][] equipos = new String[NPARTIDOS][2];
    int [][] resultados = new int[NPARTIDOS][2];
    
    // Pedir los resultados
    for (int i=0; i<equipos.length; i++) {
      System.out.println("Resultado del partido "+(i+1));
      System.out.println("--------------------------");
      // equipo de casa
      System.out.print("Equipo de casa.: ");
      equipos[i][0] = s.nextLine();
      System.out.print("Goles..........: ");
      resultados[i][0] = s.nextInt(); s.nextLine();
      // equipo de fuera
      System.out.print("Equipo de fuera: ");
      equipos[i][1] = s.nextLine();
      System.out.print("Goles..........: ");
      resultados[i][1] = s.nextInt(); s.nextLine();
      System.out.println();
    }
    
    // Impresión quiniela
    imprimeQuiniela(equipos,resultados);
  }
  
  public static void imprimeQuiniela(String[][] equipos, int[][] resultados) {
    System.out.println("Impresión quiniela la jornada");
    System.out.println("-----------------------------");
    for (int i=0; i<equipos.length; i++) {
      System.out.printf("%-20s - %-20s: ",equipos[i][0],equipos[i][1]);
      if (resultados[i][0] > resultados[i][1]) {
        System.out.println("1");
      }
      else if (resultados[i][0] < resultados[i][1]) { 
        System.out.println("2");
      }
      else {
        System.out.println("X");
      }
    }
  }

}
