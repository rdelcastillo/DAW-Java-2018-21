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
 * Se utilizaría de la siguiente manera:
 * 
 * quita_comentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO
 * 
 * Por ejemplo:
 * 
 * quita_comentarios hola.java holav2.java
 * 
 * crea un fichero con nombre holav2.java que contiene el código de hola.java pero sin los comentarios.
 * 
 * @author rafa
 * 
 * Excepcionalmente el nombre de este programa no usa camelCase por imposición de quien lo encargó.
 *
 */

public class quita_comentarios {

  public static void main(String[] args) {
    
    // ¿Número de parámetros correcto?
    if (args.length != 2) {
      System.err.println("Error en el número de parámetros"); // mensaje a la salida de error
      System.exit(1);
    }
    
    // Averiguamos fichero origen y destino
    String ficheroOrigen = args[0];
    String ficheroDestino = args[1];
        
    // Proceso
    try {
      BufferedReader bOrigen = new BufferedReader(new FileReader(ficheroOrigen));       // Abrimos fichero origen
      BufferedWriter bDestino = new BufferedWriter(new FileWriter(ficheroDestino));     // Abrimos fichero destino
      
      boolean estoyEnUnBloqueDeComentarios = false;     // necesaria para detectar bloques /* ... */
      
      // Leo cada línea del fichero origen y si no es un comentario la escribo en el destino
      String linea = bOrigen.readLine();
      while (linea != null) {
        if (estoyEnUnBloqueDeComentarios) { 
          // Estoy dentro de un bloque /* ... */
          // solo tengo que comprobar si el bloque finaliza por acabar la línea con "*/"
          // no escribo nada en el fichero de salida en cualquier caso
          if (linea.trim().endsWith("*/")) {
            estoyEnUnBloqueDeComentarios = false;
          }
        } else if (linea.trim().startsWith("/*")) {     // ¿empieza un bloque de comentarios?
          estoyEnUnBloqueDeComentarios = true;          // activo el indicador del bloque /*...*/
        } else {
          // el único comentario posible aquí es con //
          // lo eliminamos y escribimos en el fichero si la línea no queda vacía
          boolean escribeLinea = true;
          if (linea.contains("//")) {     // ¿hay comentario con //?
            int dondeEmpiezaBarra2 = linea.indexOf("//");
            linea = linea.substring(0, dondeEmpiezaBarra2);
            // si la línea contiene únicamente espacios o está vacía, no la escribo
            if (linea.trim().equals("")) {
              escribeLinea = false;
            }
          }
          // escribimos línea sin comentarios
          if (escribeLinea) {
            bDestino.write(linea);
            bDestino.newLine();     // añado salto de línea
          }
        }
        // leo siguiente línea (o el <EOF>)
        linea = bOrigen.readLine();
      }
      
      // Finalizo y cierro archivos
      bOrigen.close();
      bDestino.close();
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
