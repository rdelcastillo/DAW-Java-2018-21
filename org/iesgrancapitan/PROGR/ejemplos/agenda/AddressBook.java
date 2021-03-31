package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Agenda de contactos 3.0. Clase derivada de ArraList<Contact>
 * 
 * Además de los métodos de ArrayList para manejar una lista de objetos Contact
 * añadimos métodos para guardar y recuperar agendas almacenadas como objetos, 
 * CSV y XML. 
 * 
 * En esta versión hemos creado nuevas clases a las que se delegan responsabilidades
 * que tienen que ver con la persistencia de los datos (guardar y recuperar) para hacer
 * esta más manejable.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class AddressBook extends ArrayList<Contact> {

  private static final long serialVersionUID = 8404046781550997461L;

  /**
   * Guarda la agenda como objeto en un fichero.
   */
  public void save(String fileName) throws FileNotFoundException, IOException {
    var file = new ObjectOutputStream(new FileOutputStream(fileName));
    file.writeObject(this);
    file.close();
  }

  /**
   * Recupera la agenda de un objeto AddressBook de un fichero y lo devuelve.
   */
  static public AddressBook load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
    var file = new ObjectInputStream(new FileInputStream(fileName));
    AddressBook addressBook = (AddressBook) file.readObject();
    file.close();
    return addressBook;
  }

  /**
   * Guarda la agenda como fichero CSV.
   */
  public void saveCSV(String fileName) throws IOException {
    AddressBookCSV.save(this, fileName);
  }

  /**
   * Recupera la agenda de un fichero CSV y la devuelve como AddressBook.
   */
  static public AddressBook loadCSV(String fileName) throws IOException, AddressBookCSVException {
    var addressBook = AddressBookCSV.load(fileName);
    return addressBook;
  }

  /**
   * Guarda la agenda como fichero XML.
   */
  public void saveXML(String fileName) throws AddressBookXMLException, IOException {
    AddressBookXML.save(this, fileName);
  }

  /**
   * Recupera la agenda de un fichero XML y la devuelve como AddressBook.
   */
  static public AddressBook loadXML(String fileName) throws IOException, AddressBookXMLException {
    var addressBook = AddressBookXML.load(fileName);
    return addressBook;
  }

  /**
   * Guarda la agenda en un fichero JSON.
   */
  public void saveJSON(String fileName) throws IOException {
    AddressBookJSON.save(this, fileName);
  }

  /**
   * Recupera la agenda de un fichero JSON y la devuelve como AddressBook.
   */
  static public AddressBook loadJSON(String fileName) throws IOException, AddressBookJSONException {
    var addressBook = AddressBookJSON.load(fileName);
    return addressBook; 
  }

  @Override
  public String toString() {
    AddressBook addressBook = (AddressBook) this.clone();
    String toString = getClass().getSimpleName() + " [\n";
    Collections.sort(addressBook);
    for (Contact c: addressBook) {
      toString += c + "\n";    
    }
    toString += "]";
    return toString;
  }

}
