package org.iesgrancapitan.PROGR.ejemplos.agenda.test;

import java.io.IOException;
import java.util.Scanner;
import org.iesgrancapitan.PROGR.ejemplos.agenda.AddressBook;
import org.iesgrancapitan.PROGR.ejemplos.agenda.Contact;
import org.iesgrancapitan.PROGR.ejemplos.agenda.ContactErrorException;
import org.iesgrancapitan.PROGR.ejercicios.ej04POO.Menu;

public class Agenda {

  private static AddressBook agenda = new AddressBook();

  public static void main(String[] args) {
    Menu menu = new Menu("AGENDA", "Alta de contacto", "Baja de contacto", "Mostrar agenda", 
        "Guardar agenda", "Recuperar agenda (perdiendo datos actuales)", 
        "Exportar CSV", "Importar CSV", "Exportar XML", "Importar XML",
        "Salir");
    boolean continuar = true;

    do {
      switch (menu.elegir()) {
        case 1:
          alta();
          break;
        case 2:
          baja();
          break;
        case 3:
          mostrar();
          break;
        case 4:
          guardar();
          break;
        case 5:
          recuperar();
          break;
        case 6:
          exportarCSV();
          break;
        case 7:
          importarCSV();
          break;
        case 8:
          exportarXML();
          break;
        case 9:
          importarXML();
          break;
        default:
          continuar = false;
      } 
    } while (continuar);
  }

  private static void alta() {
    try {
      Contact contactoAlta = getContactoAlta();

      if (agenda.contains(contactoAlta)) {
        System.err.println("Ya existe ese contacto.\n");
        return;
      }

      agenda.add(contactoAlta);
      System.out.println("Contacto dado de alta.\n");

    } catch(ContactErrorException e) {
      System.err.println("Error en los datos: " + e.getMessage() + "\n");
    }
  } 

  private static Contact getContactoAlta() {
    Scanner s = new Scanner(System.in);

    System.out.println();
    System.out.print("Nombre del contacto a dar de alta...: ");
    String nombre = s.nextLine();
    System.out.print("Apellidos del contacto a dar de alta: ");
    String apellidos = s.nextLine();
    System.out.print("Dirección del contacto a dar de alta: ");
    String direccion = s.nextLine();
    System.out.print("Email del contacto a dar de alta....: ");
    String email = s.nextLine();
    if (email.isBlank()) {
      return new Contact(nombre, apellidos, direccion);
    }
    System.out.print("Teléfono del contacto a dar de alta.: ");
    String telefono = s.nextLine();
    return (telefono.isBlank()) ?
        new Contact(nombre, apellidos, direccion, email):
          new Contact(nombre, apellidos, direccion, email, telefono);
  }

  private static void baja() {
    try {
      if (agenda.remove(getContactoBaja())) {
        System.out.println("Contacto eliminado de la agenda.\n");
      } else {
        System.err.println("No existe el contacto en la agenda.\n");
      }
    } catch (ContactErrorException e) {
      System.err.println("Error en los datos: " + e.getMessage() + "\n");
    }
  }

  private static Contact getContactoBaja() {
    Scanner s = new Scanner(System.in);

    System.out.println();
    System.out.print("Nombre del contacto a dar de baja...: ");
    String nombre = s.nextLine(); 
    System.out.print("Apellidos del contacto a dar de baja: ");
    String apellidos = s.nextLine();

    return new Contact(nombre, apellidos, "Sin dirección");
  }   
  // Contactos de mi agenda


  private static void recuperar() {
    try {
      String fichero = pedirFichero("Nombre del fichero donde está guardada la agenda");
      agenda = AddressBook.load(fichero);

    } catch (ClassNotFoundException | IOException e) {
      System.err.println("No se ha podido recuperar la agenda.\n");
    }
  }

  private static void guardar() {
    try {
      String fichero = pedirFichero("Nombre del fichero donde guardar la agenda");
      agenda.save(fichero);

    } catch (IOException e) {
      System.err.println("No se ha podido guardar el fichero.\n");
    }
  }

  private static void exportarCSV() {
    try {
      String fichero = pedirFichero("Nombre del fichero donde exportar a CSV la agenda");
      agenda.saveCSV(fichero);

    } catch (IOException e) {
      System.err.println("No se ha podido exportar a CSV.\n");
    }
  }

  private static void importarCSV() {
    // TODO Auto-generated method stub

  }

  private static void exportarXML() {
    try {
      String fichero = pedirFichero("Nombre del fichero donde exportar a XML la agenda");
      agenda.saveXML(fichero);

    } catch (IOException e) {
      System.err.println("No se ha podido exportar a XML.\n");
    }

  }

  private static void importarXML() {
    // TODO Auto-generated method stub

  }


  private static void mostrar() {
    System.out.println(agenda + "\n");    
  }

  private static String pedirFichero(String mensaje) {
    Scanner s = new Scanner(System.in);
    System.out.print(mensaje +": ");
    return s.nextLine();
  }
}
