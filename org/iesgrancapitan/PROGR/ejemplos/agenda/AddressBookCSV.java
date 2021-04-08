package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.io.IOException;

/**
 * Clase común para valores y métodos estáticos de las clases que trabajan con CSV.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

class AddressBookCSV {
  
  static final String HEAD = "Name,Surnames,Address,Email,Phone";
  
  static void save(AddressBook addressBook, String fileName) throws IOException {
    var writer = new AddressBookCSVWriter(addressBook);
    writer.saveFile(fileName);
  }

  static AddressBook load(String fileName) throws IOException, AddressBookCSVException {
    var reader = new AddressBookCSVLoader();
    reader.load(fileName);
    return reader.getAddressBook();
  }

}
