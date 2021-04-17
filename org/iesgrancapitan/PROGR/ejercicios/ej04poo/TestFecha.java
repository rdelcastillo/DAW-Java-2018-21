package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

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
    Fecha f3 = f1.clone();
    Fecha f4 = f1;
    
    // Inicio
    System.out.println("Momento inicial:");
    System.out.println("Fecha1: " + f1);
    System.out.println("Fecha2: " + f2);
    System.out.println("Fecha3: " + f3);
    System.out.println("Fecha4: " + f4 + "\n");
    
    // Cambiamos f3 ¿qué pasa con f1?
    f3.setDia(12);
    System.out.println("Asignamos 12 al día de Fecha3: " + f3);
    System.out.println("Fecha1: " + f1 + "\n");
    
    // Cambiamos f4 ¿qué pasa con f1?
    f4.setAnyo(2019);
    System.out.println("Asignamos 2019 al año de Fecha4: " + f4);
    System.out.println("Fecha1: " + f1 + "\n");
    
    // Comparamos
    System.out.println("Comparamos Fecha1 (" + f1 + ") y Fecha2 (" + f2 + ") " + f1.compareTo(f2));
    System.out.println("Comparamos Fecha3 (" + f3 + ") y Fecha1 (" + f1 + ") " + f3.compareTo(f1) + "\n");
    System.out.println("¿'" + f1 + "' es igual a '" + f4 + "'? " + f1.equals(f4));
    System.out.println("¿'" + f2 + "' a '" + f3 +"'? " + f2.equals(f3) + "\n");
    
    // Sumamos y restamos
    System.out.print("Sumamos 50 días a Fecha1 (" + f1 + ") y se lo asignamos a Fecha2: ");
    f1.sumarDias(50);
    f2 = f1.clone();
    System.out.println(f2);
    f2.restarDias(50);
    System.out.println("Y Fecha2 sin esos 50 días es Fecha1: " + f2);
  }

}
