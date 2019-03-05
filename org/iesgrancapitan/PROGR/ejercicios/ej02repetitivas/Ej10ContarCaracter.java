package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej10ContarCaracter {

  // ################################################################################
  // Pide una cadena y un carácter por teclado (valida que sea un carácter)
  // y muestra cuantas veces aparece el carácter en la cadena.
  // ################################################################################
  // Análisis
  // Leo una cadena y un carácter (tengo que asegurarme que es un sólo carácter,
  // es decir hasta que la longitud sea 1). Recorro la cadena y compara cada uno de
  // sus caracteres con el carácter introducido, si es igual lo cuento.
  // Datos de entrada: Cadena y carácter
  // Información de salida: Número de veces que aparece el carácter en la cadena.
  // Variables: cad, car (caracter), posicion, cont (entero)
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String cadena;
    String caracter;
    int cont = 0;
    int posicion;

    // Leemos datos
    System.out.print("Introduce una cadena: ");
    cadena = s.nextLine();
    do {
      System.out.print("Introduce un carácter: ");
      caracter = s.nextLine();
    } while (caracter.length()!=1);

    // Proceso
    for (posicion=0; posicion<=cadena.length()-1; posicion++) {
      if (cadena.substring(posicion,posicion+1).equals(caracter)) {
        cont++;
      }
    }
    System.out.println("En la cadena \""+cadena+"\" aparece "+cont+" veces el carácter '"+caracter+"'.");
  }


}

