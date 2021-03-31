package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Esta clase representa objetos cuya función es escribir un AddressBook en un CSV.
 * 
 * @author Rafael del Castillo.
 */

class AddressBookCSVWriter {

  private AddressBook addressBook;
  private PrintWriter file;


  AddressBookCSVWriter(AddressBook addressBook) {
    this.addressBook = addressBook;
  }

  void saveFile(String fileName) throws IOException {
    file = new PrintWriter(fileName);
    file.println(AddressBookCSV.HEAD);
    for (Contact contact: addressBook) {
      saveContact(contact);
    }
    file.close();
  }

  private void saveContact(Contact contact) throws IOException {
    file.print("\"" + contact.getName() + "\",");
    file.print("\"" + contact.getSurnames() + "\",");
    file.print("\"" + contact.getAddress() + "\",");
    file.print("\"" + contact.getEmail() + "\",");
    file.print("\"" + contact.getPhone() + "\""); 
    file.println();
  }

}
