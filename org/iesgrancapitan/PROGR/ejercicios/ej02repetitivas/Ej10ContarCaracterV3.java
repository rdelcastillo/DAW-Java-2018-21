package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocadenao por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej10ContarCaracterV3 {

  // ################################################################################
  // Pide una cadenaena y un caracterácter por teclado (valida que sea un caracterácter)
  // y muestra cuantas veces aparece el caracterácter en la cadenaena.
  // ################################################################################
  // Análisis
  // Leo una cadenaena y un caracterácter (tengo que asegurarme que es un sólo caracterácter,
  // es decir hasta que la longitud sea 1). Recorro la cadenaena y compara cadenaa uno de
  // sus caracteracteres con el caracterácter introducido, si es igual lo cuento.
  // Datos de entrada: cadenaena y caracterácter
  // Información de salida: Número de veces que aparece el caracterácter en la cadenaena.
  // Variables: cadena, caracter (caracteracter), posicion, cont (entero)
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String cadena;
    String caracter;
    int cont = 0;

    // Leemos datos
    System.out.print("Introduce una cadena: ");
    cadena = s.nextLine();
    do {
      System.out.print("Introduce un carácter: ");
      caracter = s.nextLine();
    } while (caracter.length()!=1);

    // Proceso
    for (char c: cadena.toCharArray()) {
      if (c==caracter.charAt(0)) {
        cont++;
      }
    }
    System.out.println("En la cadena \""+cadena+"\" aparece "+cont+" veces el carácter '"+caracter+"'.");
  }


}

