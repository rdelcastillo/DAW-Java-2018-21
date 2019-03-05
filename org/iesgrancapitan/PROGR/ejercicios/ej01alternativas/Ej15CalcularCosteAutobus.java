package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej15CalcularCosteAutobus {

  // ################################################################################
  // El director de una escuela está organizando un viaje de estudios, y requiere
  // determinar cuánto debe cobrar a cada alumno y cuánto debe pagar a la compañía de
  // viajes por el servicio. La forma de cobrar es la siguiente:
  // si son 100 alumnos o más, el costo por cada alumno es de 65 euros;
  // de 50 a 99 alumnos, el costo es de 70 euros, de 30 a 49, de 95 euros,
  // y si son menos de 30, el costo de la renta del autobús es de 4000 euros,
  // sin importar el número de alumnos.
  // Realice un algoritmo que permita determinar el pago a la compañía de autobuses
  // y lo que debe pagar cada alumno por el viaje.
  // ################################################################################
  // Análisis
  // El precio final del autobús depende del número de alumnos que participan.
  // Si son 100 o más alumnos cada alumno paga 65 euros.
  // Si son entre 50 y 99 alumnos, cada alumno paga 70 euros.
  // Si son entre 30 y 49 alumnos, cada alumno paga 95.
  // El precio del autobús será lo que paga cada alumno * el número de alumnos.
  // Si son menor de 30 alumnos, el autobús vale 4000 euros,
  // divido por el número de alumnos sabemos cuanto paga cada uno.
  // Datos de entrada: número de alumnos (entero)
  // Información de salida: Precio del autobús (entero), precio por alumno (real)
  // Variables: numAlumnos (entero), costeAutobus (entero), costePorAlumno (real)
  // ################################################################################
  // Diseño
  // 1. Leer número de alumnos
  // 2. Si el número>=100 coste por alumno = 65
  // 3. Si el número>=50 y <=99 coste por alumno = 70
  // 4. Si el número>=30 y <=49 coste por alumno = 95
  // 5. Si el número<30 coste por alumno = 4000 / número de alumnos
  // 6. Si el número de alumnos > 0 (valor correcto) calculo
  // costeAutobus=número alumnos * coste por alumno
  // y muestro costeAutobus coste por alumnos.
  // 7. Si el número de alumno <= 0 mostrar mensaje de error
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int costeAutobus;
    double costePorAlumno=0;
    int numAlumnos;

    // Pedimos datos
    System.out.print("¿Cuántos alumnos participan en la actividad?: ");
    numAlumnos = s.nextInt();

    // Proceso
    if (numAlumnos>=100) {
      costePorAlumno = 65;
    }
    else if (numAlumnos>=50) {
      costePorAlumno = 70;
    }
    else if (numAlumnos>=30) {
      costePorAlumno = 95;
    }
    else if (numAlumnos>0) {
      costePorAlumno = 4000.0/numAlumnos;
    }
    if (numAlumnos>0) {
      costeAutobus = (int) (numAlumnos*costePorAlumno);
      System.out.println("El coste por alumno es "+costePorAlumno+" euros.");
      System.out.println("El coste del autobús es "+costeAutobus+" euros.");
    } else {
      System.out.println("El número de alumnos debe ser un valor positivo.");
    }
  }


}

