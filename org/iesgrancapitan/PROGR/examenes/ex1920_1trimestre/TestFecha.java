package org.iesgrancapitan.PROGR.examenes.ex1920_1trimestre;

import java.util.Scanner;

import org.iesgrancapitan.PROGR.examenes.ex1920_1trimestre.tiempo.Fecha;

/**
 * Prueba funciones de Fecha.java.
 * 
 * @author Rafael del Castillo
 *
 */

public class TestFecha {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    // Testeamos funciones fecha correcta
    String[] fechas = {  "20191215", // correcto
                         "20181111", // correcto
                         "dfdfdw",   // incorrecto
                         "AAAAMMDD", // incorrecto
                         "20181242", // incorrecto (diciembre no tiene 42 días)
                         "20010229", // incorrecto (no es bisiesto)
                         "20000229"  // correcto (fue bisiesto)
    };
    for (String f:fechas) {
      System.out.print("La fecha " + f + " tiene un formato ");
      if (Fecha.fechaCorrecta(f)) {
        System.out.println("CORRECTO");
      } else {
        System.out.println("INCORRECTO");
      }
    }  
    System.out.println();
        
    
    // Testeamos suma y resta de días
    String fecha1 = "20160228";
    String fecha2 = "20160301";
    String fecha3 = "20170228";
    String fecha4 = "20170301";
    System.out.println("Si sumamos un día a '" + Fecha.fechaFormateada(fecha1) + "' obtenemos: " +
                        Fecha.fechaMas1Dia(fecha1));
    System.out.println("Si restamos un día a '" + Fecha.fechaFormateada(fecha2) + "' obtenemos: " +
                        Fecha.fechaMenos1Dia(fecha2));
    System.out.println("Si sumamos un día a '" + Fecha.fechaFormateada(fecha3) + "' obtenemos: " +
                        Fecha.fechaMas1Dia(fecha3));
    System.out.println("Si restamos un día a '" + Fecha.fechaFormateada(fecha4) + "' obtenemos: " +
                        Fecha.fechaMenos1Dia(fecha4));
    System.out.println();
    
    System.out.print("¿Cuantos días quieres sumar a " + Fecha.fechaFormateada(fecha1) + "? ");
    int suma = s.nextInt();
    System.out.println("La fecha resultante es " + Fecha.fechaMasNDias(fecha1, suma));
    System.out.println();
    
    System.out.print("¿Cuantos días quieres restar a " + Fecha.fechaFormateada(fecha1) + "? ");
    int resta = s.nextInt();
    System.out.println("La fecha resultante es " + Fecha.fechaMenosNDias(fecha1, resta));
    System.out.println();
    
    // Testeamos comparaciones de fechas
    fecha2 = "20160120";
    fecha3 = "20190101";
    System.out.println("El resultado de comparar '" + Fecha.fechaFormateada(fecha1) + "' con '" +
                        Fecha.fechaFormateada(fecha2) + "' es " + Fecha.comparaFechas(fecha1, fecha2));
    System.out.println("El resultado de comparar '" + Fecha.fechaFormateada(fecha1) + "' con '" +
                        Fecha.fechaFormateada(fecha3) + "' es " + Fecha.comparaFechas(fecha1, fecha3));
    System.out.println("El resultado de comparar '" + Fecha.fechaFormateada(fecha3) + "' con '" +
                        Fecha.fechaFormateada(fecha2) + "' es " + Fecha.comparaFechas(fecha3, fecha2));
    System.out.println("El resultado de comparar '" + Fecha.fechaFormateada(fecha3) + "' con '" +
                        Fecha.fechaFormateada(fecha3) + "' es " + Fecha.comparaFechas(fecha3, fecha3));
  }
  
}
