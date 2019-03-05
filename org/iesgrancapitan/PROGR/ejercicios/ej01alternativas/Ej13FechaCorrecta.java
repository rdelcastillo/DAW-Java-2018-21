package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej13FechaCorrecta {

  // ################################################################################
  // Escribe un programa que pida una fecha (día, mes y año) y diga si es correcta.
  // ################################################################################
  // Análisis
  // Pedir un día,mes y año y comprobar si corresponde a una fecha correcta.
  // Para que una fecha sea correcta:
  // * El día debe ser mayor que 1 y menor que los días que tiene el mes indicado.
  // * Los días del mes de febrero dependerán de si el año es bisiesto o no.
  // * El mes indicado debe ser mayor o igual que 1 y menor o igual a 12.
  // Datos de entrada: una fecha: día,mes y año (entero)
  // Información de salida: Si la fecha es correcta o no.
  // Variables: dia,mes,year (entero),
  // diasDelMes (entero) donde guardamos los días que tiene el mes indicado.
  // ################################################################################
  // Diseño
  // 1.Leer dia,mes,year
  // 2.Si el mes es 1,3,5,7,8,10,12 los diasDelMes=31
  // 3.Si el mes es 4,6,9,11 los diasDelMes=30
  // 4.Si el mes es 2: si el año es bisiesto, los diasDelMes=29
  // sino los diasDelMes=28
  // 5. Si hemos introducido otro número de mes, mostrar "Fecha incorrecta"
  // 6. Si el dia < 0 o > diasDelMes mostrar "Fecha incorrecta"
  // 7. En otro caso, mostrar "Fecha correcta"
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int dia;
    int diasDelMes=0; // necesario para no tener errores al compilar
    int mes;
    int year;
    boolean mesCorrecto=true;

    // Pedimos datos
    System.out.print("Introduce el dia: ");
    dia = s.nextInt();
    System.out.print("Introduce el mes: ");
    mes = s.nextInt();
    System.out.print("Introduce el año: ");
    year = s.nextInt();

    // Proceso
    switch (mes) {
      case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        diasDelMes = 31;
        break;
      case 4: case 6: case 9: case 11:
        diasDelMes = 30;
        break;
      case 2:
        if ((year%4==0 && !(year%100==0)) || year%400==0) {
          diasDelMes = 29;
        } else {
          diasDelMes = 28;
        }
        break;
      default:
        mesCorrecto=false;
    }
    if (!mesCorrecto || dia<0 || dia>diasDelMes) {
      System.out.println("Fecha incorrecta");
    } else {
      System.out.println("Fecha correcta");
    }
  }


}

