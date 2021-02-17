package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

/**
 * Probamos la clase Menu.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class TestMenu {

  public static void main(String[] args) {
    
    int opcion;
    //MenuSimple menu = new MenuSimple("Opción 1", "Opción 2", "Opción 3", "Opción 4", "Finalizar");
    Menu menu = new Menu("Menú de opciones", 
                         "Opción 1", "Opción 2", "Opción 3", "Opción 4", "Finalizar");
    
    do {
      opcion = menu.elegir();
      
      switch (opcion) {
        case 1: case 2: case 3: case 4:
          System.out.println("He escogido la opción " + opcion +".\n");
          break;
        case 5:
          System.out.println("Terminamos...");
      }
    } while (opcion != 5);
  }

}
