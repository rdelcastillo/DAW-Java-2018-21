package org.iesgrancapitan.PROGR.ejercicios.ej03funciones;

import java.util.Scanner;
import org.iesgrancapitan.PROGR.ejercicios.ej03funciones.matematicas.FuncionesEj1a14;

/**
 * Crea una función con la siguiente cabecera:
 * 
 * public static String convierteEnPalotes(int n)
 * 
 * Esta función convierte el número n al sistema de palotes y lo devuelve en una
 * cadena de caracteres. 
 * 
 * Por ejemplo, el 470213 en decimal es el
 * | | | | - | | | | | | | - - | | - | - | | | en el sistema de palotes. 
 * 
 * Utiliza esta función en un programa para comprobar que funciona bien. 
 * Desde la función no se debe mostrar nada por pantalla, solo se debe usar print 
 * desde el programa principal.
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios" (edición 2029) de 
 * Luis José Sánchez González.
 * 
 * Nota1: normalmente pongo los nombres de variables y funciones en inglés, esta vez haré 
 * una excepción ya que el enunciado del ejercicio pide la función en castellano.
 * 
 * Nota2: se puede ver una versión sin funciones de este programa en este repositorio y un
 * vídeo en https://youtu.be/7RXfkXbssY8
 * 
 * Nota3: usaremos funciones ya creadas en ejercicios anteriores.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Ej35Palotes {

  public static void main(String[] args) {
    int n = pideEnteroPositivo();
    System.out.println(n + " en el sistema de palotes es " + convierteEnPalotes(n));
  }

  public static int pideEnteroPositivo() {
    Scanner s = new Scanner(System.in);
    System.out.print("Dame un número positivo y lo convertiré al sistema de palotes: ");
    int n = s.nextInt();
    if (n < 0) {
      System.err.println("El número debe ser >= 0");
      System.exit(1);
    }
    return n;
  }
  
  public static String convierteEnPalotes(int n) {
    String numeroEnPalotes = "";
    for (int pos = 0; pos < FuncionesEj1a14.digitos(n); pos++) {
      numeroEnPalotes += "| ".repeat(FuncionesEj1a14.digitoN(n, pos)) + "- ";
    }
    numeroEnPalotes = numeroEnPalotes.substring(0, numeroEnPalotes.length()-2);  // quitamos último "- "
    return numeroEnPalotes;
  }

}
