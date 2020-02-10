/**
 * 
 */
package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

/**
 * Test clase Fecha.
 * 
 * @author rafa
 *
 */
public class TestFecha {

  public static void main(String[] args) {
    Fecha f1 = new Fecha(10, 2, 2020);
    Fecha f2 = new Fecha(29, 2, 2020);
    Fecha f3 = f1.clona();
    Fecha f4 = f1;
    
    // Inicio
    System.out.println("Momento inicial:");
    System.out.println("Fecha1 " + f1);
    System.out.println("Fecha2 " + f2);
    System.out.println("Fecha3 " + f3);
    System.out.println("Fecha4 " + f4);
    
    // Cambiamos f3 ¿qué pasa con f1?
    f3.setDia(12);
    System.out.println("\nAsignamos 12 al día de Fecha3:");
    System.out.println("Fecha1 " + f1);
    System.out.println("Fecha3 " + f3);
    
    // Cambiamos f4 ¿qué pasa con f1?
    f4.setAnyo(2019);
    System.out.println("\nAsignamos 2019 al año de Fecha4:");
    System.out.println("Fecha1 " + f1);
    System.out.println("Fecha4 " + f4);
    
    // Comparamos
    System.out.println();
    System.out.println("Comparamos f1 y f2 " + f1.compareTo(f2));
    System.out.println("Comparamos f3 y f1 " + f3.compareTo(f1));
    System.out.println("¿f1 es igual f4? ¿y f2 a f3? " + f1.equals(f4) + " " + f2.equals(f3));
    
    // Sumamos y restamos
  }

}
