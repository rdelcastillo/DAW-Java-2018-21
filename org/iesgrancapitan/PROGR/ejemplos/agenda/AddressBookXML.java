package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.io.IOException;

/**
 * Clase común para valores estáticos de las clases que trabajan con XML.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

class AddressBookXML {

  static final String CONTACT = "Contact";
  static final String ADDRESS_BOOK = "AddressBook";
  static final String PHONE = "Phone";
  static final String EMAIL = "Email";
  static final String ADDRESS = "Address";
  static final String SURNAMES = "Surnames";
  static final String NAME = "Name";
  
  static void save(AddressBook addressBook, String fileName) throws IOException, AddressBookXMLException {
    var writer = new AddressBookXMLWriter(addressBook);
    writer.save(fileName);
  }

  static AddressBook load(String fileName) throws IOException, AddressBookXMLException {
    var reader = new AddressBookXMLLoader();
    reader.load(fileName);
    return reader.getAddressBook();
  }
}
