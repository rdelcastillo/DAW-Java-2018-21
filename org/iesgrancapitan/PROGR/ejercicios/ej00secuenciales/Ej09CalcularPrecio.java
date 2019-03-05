package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej09CalcularPrecio {

  // ################################################################################
  // Una tienda ofrece un descuento del 15% sobre el total de la compra y un cliente
  // desea saber cuanto deberá pagar finalmente por su compra.
  // ################################################################################
  // Análisis
  // Debemos preguntar cuanto dinero es la compra, calcular el 15% y restarlo al total.
  // Datos de entrada: precio (real).
  // Información de salida: precio final (real).
  // Variables: precio(real).
  // ################################################################################
  // Diseño
  // 1. Leer el precio
  // 2. Mostrar precio final: precio - 15% del precio
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double precio;

    System.out.println("Dime el precio:");
    precio = s.nextDouble();
    System.out.println("Precio final: "+(precio-precio*0.15));
  }


}

