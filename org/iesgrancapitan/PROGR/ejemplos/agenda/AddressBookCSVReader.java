package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.iesgrancapitan.PROGR.ejemplos.agenda.AddressBookCSV.*;

/**
 * Esta clase representa objetos cuya función es cargar un AddressBook de un CSV.
 * 
 * @author Rafael del Castillo.
 */

class AddressBookCSVReader {
    
  private AddressBook addressBook;
  private BufferedReader file;
  
  AddressBookCSVReader() {
    this.addressBook = new AddressBook();
  }
  
  AddressBookCSVReader(AddressBook addressBook) {
    this.addressBook = addressBook;
  }
  
  AddressBook getAddressBook() {
    return addressBook;
  }

  /**
   * Rellena el addressBook a partir del fichero CSV.
   */
  void load(String fileName) throws IOException, AddressBookCSVException {
    file = Files.newBufferedReader(Paths.get(fileName));
    validateHead();

    String line;
    while ((line = file.readLine()) != null) {
      Contact contact = newContact(line);
      addressBook.add(contact);
    }
    file.close();
  }

  private void validateHead() throws IOException, AddressBookCSVException {
    String head = file.readLine().trim();
    if (! HEAD.equalsIgnoreCase(head)) {
      throw new AddressBookCSVException("Cabecera errónea en el CSV.");
    }
  }

  private static Contact newContact(String line) throws AddressBookCSVException {
    validateContactCSV(line);
    String[] fieldsContact = line.split("\","); // solo las comas de separación de campos

    // Extraemos los campos del contacto quitando las comillas de inicio y fin
    String name = fieldsContact[0].replace("\"", "");
    String surnames = fieldsContact[1].replace("\"", "");
    String address = fieldsContact[2].replace("\"", "");
    String email = fieldsContact[3].replace("\"", "");
    String phone = fieldsContact[4].replace("\"", "");

    Contact contact = null;
    try {
      contact = Contact.of(name, surnames, address, email, phone);
    } catch (ContactErrorException e) {
      throw new AddressBookCSVException(line + ": " + e.getMessage());
    }

    return contact;
  }

  private static void validateContactCSV(String line) throws AddressBookCSVException {
    int numFieldsLine = line.split("\",").length;   // solo las comas de separación de campos
    int numFieldsContact = HEAD.split(",").length;

    if (numFieldsLine != numFieldsContact) {
      throw new AddressBookCSVException(line + ": no es un formato válido para convertirlo en Contact.");
    }
  }

}
