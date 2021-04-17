package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

import java.util.Scanner;

/**
 * Test de la clase Tiempo.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class TestTiempo {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Pido t1
    System.out.print("Introduce un instante temporal en horas, minutos y segundos: ");
    int h = sc.nextInt();
    int m = sc.nextInt();
    int s = sc.nextInt();    
    
    Tiempo t1 = new Tiempo(h, m, s);
    Tiempo t2 = new Tiempo(5, 100, -5);
    
    // Probamos impresión
    System.out.println("Tiempo 1: " + t1.toString());
    System.out.println("Tiempo 2: " + t2 + "\n");
    
    // Probamos suma y resta
    Tiempo suma = t1.sumar(t2);
    System.out.println(t1 + " + " + t2 + " : " + suma);
    System.out.println(t1 + " - " + t2 + " : " + t1.restar(t2) + "\n");
    
    // Probamos suma y resta de segundos
    System.out.print(t1 + " + 22 segundos = ");
    t1.sumaSegundos(22);
    System.out.println(t1);
    
    System.out.print(t1 + " - 22 segundos = ");
    t1.restaSegundos(22);
    System.out.println(t1 + "\n");
    
    // Probamos suma y resta de minutos
    System.out.print(t1 + " + 102 minutos = ");
    t1.sumaMinutos(102);
    System.out.println(t1);
    
    System.out.print(t1 + " - 102 minutos = ");
    t1.restaMinutos(102);
    System.out.println(t1 + "\n");
    
    // Probamos suma y resta de horas
    System.out.print(t1 + " + 5 horas = ");
    t1.sumaHoras(5);
    System.out.println(t1);
    
    System.out.print(t1 + " - 5 horas = ");
    t1.restaHoras(5);
    System.out.println(t1 + "\n");
    
  }

}
