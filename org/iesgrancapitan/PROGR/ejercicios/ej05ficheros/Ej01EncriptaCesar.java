package org.iesgrancapitan.PROGR.ejercicios.ej05ficheros;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Programa que encripta un fichero que le pasamos como parámetro y almacena el resultado en otro, 
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
 * Para encriptar usamos el método César, necesitaremos una clave que hay que pedir al usuario.
 * 
 */

public class Ej01EncriptaCesar {

  private static final String LETRAS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZÁÉÍÓÚÜ";
  private static final int ERROR_ARGS = 1;
  private static final int ERROR_LECTURA = 2;
  private static final int ERROR_ESCRITURA = 3;

  public static void main(String[] args) {
    validarArgumentos(args);
    
    String origen = args[0];
    List<String> lineas = getLineasFichero(origen);
    
    String destino = getFicheroDestino(args);
    int clave = getClave();

    crearFicheroEncriptado(destino, lineas, clave);
  }

  private static void validarArgumentos(String[] args) {
    if (args.length < 1 || args.length > 2) {
      finalizarConError("Número de argumentos erróneo.", ERROR_ARGS);
    }
  }
  
  private static List<String> getLineasFichero(String fichero) {
    List<String> lineas = null;
    try {
      lineas = Files.readAllLines(Paths.get(fichero));
    } catch (IOException e) {
      finalizarConError("No puedo abrir " + fichero, ERROR_LECTURA);
    }
    return lineas;
  }

  private static String getFicheroDestino(String[] args) {
    if (args.length == 2) {
      return args[1];
    }
    validarSobreescritura(args[0]);
    return args[0];
  }

  private static void validarSobreescritura(String fichero) {
    System.out.println("Tenga en cuenta que este proceso sobreescribirá " + fichero 
        + " y perderá la información contenida en el mismo.\n");

    Scanner s = new Scanner(System.in);
    String respuesta;
    do {
      System.out.print("¿Está seguro/a? (S/N) ");
      respuesta = s.nextLine().toUpperCase();
    } while (!respuesta.equals("S") && !respuesta.equals("N"));

    if (respuesta.equals("N")) {
      System.out.println("Proceso cancelado.");
      System.exit(0);
    }
  }

  private static int getClave() {
    Scanner s = new Scanner(System.in);
    int clave;

    do {
      System.out.print("Desplazamiento (positivo) para la encriptación usando César: ");
      clave = s.nextInt();
    } while (clave <= 0); 
    
    return clave;
  }

  private static void crearFicheroEncriptado(String destino, List<String> lineas, int clave) {
    try (var ficheroEncriptado = new PrintWriter(destino)) {
      for (String linea: lineas) {
        String cadenaEncriptada = getCadenaEncriptada(linea, clave);
        ficheroEncriptado.println(cadenaEncriptada);
      }
      System.out.println("Creado fichero encriptado: " + destino);

    } catch (IOException e) {
      finalizarConError("Error al escribir en " + destino, ERROR_ESCRITURA);
    }
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
    int posicionCaracterDesplazado = (posicionCaracter + desplazamiento) % letras.length();
    return letras.charAt(posicionCaracterDesplazado);
  }

  private static void finalizarConError(String mensajeError, int codigoError) {
    System.err.println(mensajeError);
    System.exit(codigoError);
  }

}
