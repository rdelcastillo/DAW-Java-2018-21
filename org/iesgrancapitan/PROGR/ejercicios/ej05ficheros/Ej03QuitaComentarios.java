package org.iesgrancapitan.PROGR.ejercicios.ej05ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Programa que quita los comentarios de un programa de Java.
 * 
 * Recibirá como argumentos el nombre del fichero original y el del que guardará el programa sin comentarios.
 * 
 * En esta versión consideraremos que el programa es correcto sintácticamente y además:
 * 
 * - Que los comentarios de bloque ocupan varias líneas y no tienen instrucciones.
 * - No tenemos en cuenta la posibilidad de comentarios dentro de las comillas,
 * 
 * Hay casos en lo que no funciona bien, averigualos y corrígelos.
 * 
 * @author Rafael del Castillo
 * 
 */

public class Ej03QuitaComentarios {

  public static void main(String[] args) {

    // ¿Número de parámetros correcto?
    if (args.length != 2) {
      System.err.println("Error en el número de parámetros"); 
      System.exit(1);
    }

    // Proceso
    try {
      BufferedReader origen = new BufferedReader(new FileReader(args[0]));  // Abrimos fichero origen
      BufferedWriter destino = new BufferedWriter(new FileWriter(args[1])); // Abrimos fichero destino

      boolean estoyEnUnBloqueDeComentarios = false;     // necesaria para detectar bloques /* ... */
      String lineaLeida; 
      String lineaaEscribir;

      while ((lineaLeida=origen.readLine()) != null) {
        lineaaEscribir = lineaLeida;

        // ¿hay comentario de bloque multilínea?
        if (lineaLeida.contains("/*")) {
          estoyEnUnBloqueDeComentarios = true;

          // ¿hay comentario de línea?  
        } else if (lineaLeida.contains("//")) {
          int posComentario = lineaLeida.indexOf("//");
          lineaaEscribir = lineaLeida.substring(0, posComentario);
        }

        // si no estoy en un comentario de bloque escribo
        if (! estoyEnUnBloqueDeComentarios) {
          destino.write(lineaaEscribir);
          destino.newLine();
        }

        // ¿fin de comentario de bloque multilínea?
        if (lineaLeida.contains("*/")) {
          estoyEnUnBloqueDeComentarios = false;
        }
      }
      // Finalizo y cierro archivos
      origen.close();
      destino.close();
      System.out.println("Fin del proceso.");

    } catch (FileNotFoundException excp) {
      System.err.println("No se encuentra el archivo.");
      System.exit(1);
    } catch (IOException excp) {
      System.err.println("Error de entrada/salida al manejar el fichero");
      System.exit(2);
    }
  }
}
