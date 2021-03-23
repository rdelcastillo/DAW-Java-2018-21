package org.iesgrancapitan.PROGR.ejercicios.ej05ficheros;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Programa que desencripta un fichero que le pasamos como parámetro y almacena el resultado en otro, 
 * que también pasamos como parámetro, de manera que:
 * 
 * - Si el programa no recibe uno o dos parámetros termina con un error 1.
 * - Si el programa recibe un solo parámetro guardará la información encriptada en el mismo archivo 
 *   del que lee, pero antes advertirá al usuario de que machacará el archivo origen, dando opción a
 *   que la operación no se haga.
 * - Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina con un mensaje
 *   de error y código 2.
 * - Si en el fichero destino no se puede escribir (da error al abrirlo como escritura) el programa termina
 *   con un mensaje de error y código 3.
 *   
 * Para desencriptar usamos el método César, necesitaremos una clave que hay que pedir al usuario.
 * 
 * Fíjate que este programa usa gran parte de los métodos del ejercicio que encripta, ¿qué se te ocurre
 * hacer para que no sea necesario duplicar los métodos?
 * 
 */

public class EncriptacionCesar {

  private static final String LETRAS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZÁÉÍÓÚÜ";

  /**
   * Encripta (o desencripta si clave es negativa) un fichero.
   * @param origen fichero a encriptar
   * @param destino fichero donde guardar la encriptación 
   * @param clave desplazamiento César
   * @throws IOException
   */
  public static void encriptar(String origen, String destino, int clave) throws IOException {
    List<String> lineas = Files.readAllLines(Paths.get(origen));
    var ficheroEncriptado = new PrintWriter(destino);

    for (String linea: lineas) {
      String cadenaEncriptada = getCadenaEncriptada(linea, clave);
      ficheroEncriptado.println(cadenaEncriptada);
    }
  }
  
  public static void desencriptar(String origen, String destino, int clave) throws IOException {
    encriptar(origen, destino, -1 * clave);
  }

  private static String getCadenaEncriptada(String cadena, int desplazamiento) {
    String cadenaEncriptada = "";
    for (char ch: cadena.toCharArray()) {
      cadenaEncriptada += getCaracterEncriptado(ch, desplazamiento);
    }
    return cadenaEncriptada;
  }

  private static char getCaracterEncriptado(char ch, int desplazamiento) {
    return (Character.isLetter(ch)) ? getCaracterDesplazado(ch, desplazamiento) : ch;
  }

  private static char getCaracterDesplazado(char ch, int desplazamiento) {
    String letras = (Character.isUpperCase(ch)) ? LETRAS : LETRAS.toLowerCase();
    int posicionCaracter = letras.indexOf(ch);
    int posicionCaracterDesplazado = (posicionCaracter - desplazamiento) % letras.length();
    if (posicionCaracterDesplazado < 0) {
      posicionCaracterDesplazado = letras.length() - posicionCaracterDesplazado;
    }
    return letras.charAt(posicionCaracterDesplazado);
  }

}
