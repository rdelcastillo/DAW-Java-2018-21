package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej08CalcularSueldo {

  // ################################################################################
  // Un vendedor recibe un sueldo base mas un 10% extra por comisión de sus ventas,
  // el vendedor desea saber cuanto dinero obtendrá por concepto de comisiones por
  // las tres ventas que realiza en el mes y el total que recibirá en el mes tomando
  // en cuenta su sueldo base y comisiones.
  // ################################################################################
  // Análisis
  // El vendedor tiene un sueldo base mas una comisión del 10% por cada venta.
  // Hace tres ventas.
  // Datos de entrada: sueldo base, las tres ventas (real).
  // Información de salida: comisiones y sueldo total (real).
  // Variables: sueldo_base, venta1, venta2, venta3, comision(real).
  // ################################################################################
  // Diseño
  // 1. Leer sueldo base
  // 2. Leer las tres ventas
  // 3. Calcular las comisiones. Suma50enteros del 10 % de cada venta.
  // 4. Mostrar comisión
  // 5. Mostrar sueldo total: sueldo_base+comisión
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double comision;
    double sueldo_base;
    double venta1;
    double venta2;
    double venta3;

    System.out.println("Dime el sueldo base:");
    sueldo_base = s.nextDouble();
    System.out.println("Dime precio de la venta 1:");
    venta1 = s.nextDouble();
    System.out.println("Dime precio de la venta 2:");
    venta2 = s.nextDouble();
    System.out.println("Dime precio de la venta 3:");
    venta3 = s.nextDouble();

    comision = venta1*0.1+venta2*0.1+venta3*0.1;

    System.out.println("Comisión por ventas: "+comision);
    System.out.println("Sueldo total: "+sueldo_base+comision);
  }


}

