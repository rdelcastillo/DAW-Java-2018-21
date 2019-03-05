package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

public class Ej07Prestamo {

  // ################################################################################
  // Una persona adquirió un producto para pagar en 20 meses. El primer mes pagó 10
  // euros, el segundo 20 euros, el tercero 40 euros y así sucesivamente.
  // Realizar un algoritmo para determinar cuánto debe pagar mensualmente y el total
  // de lo que pagó después de los 20 meses.
  // ################################################################################
  // Análisis
  // Tenemos que ir acumulando lo valores de un serie geométrica. La serie está
  // formada por 20 cantidades a pagar que se van multiplicando por 2.
  // Datos de entrada: Nada
  // Información de salida: El pago acumulado
  // Variables: Pago, pagoAcumulado (real), mes (entero)
  // ################################################################################
  // Diseño
  // 1.- Inicializo las variables -> pagoAcumulado<-20; pago<-10
  // 2.- Desde el mes 1 hasta el 20
  // 3.- Acumulo el pago
  // 4.- Doblo el pago
  // 5.- Muestro el pago acumulado
  // ################################################################################

  public static void main(String args[]) {
    int pago = 10;
    int pagoAcumulado = 0;

    for (int mes=1; mes<=20; mes++) {
      // Pago mensual
      System.out.printf("Mes %2d paga %7d euros\n",mes,pago);
      // Cálculos
      pagoAcumulado += pago;
      pago *= 2;
    }
    System.out.printf("Al final de los 20 meses tuvo que pagar: %8d euros\n",pagoAcumulado);
  }


}

