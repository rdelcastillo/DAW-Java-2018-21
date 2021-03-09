package org.iesgrancapitan.PROGR.ejemplos.agenda;

/**
 * Esta clase es un contenedor de contactos (objetos Contact) que deriva de ArrayList<Contact>.
 * 
 * Añadiremos al comportamiento de ArrayList métodos para guardar y recuperar los datos en 
 * ficheros de los siguientes tipos:
 * 
 * - Binario (guardamos y recuperamos el objeto directamente). Para que esto funcione neesitamos
 *   poner un serialVersionUID.
 * - CVS.
 * - XML.
 * - JSON.
 * 
 * @author Rafael del Castillo
 */

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Clase para gestionar una agenda.
 *  
 *  Esta clase deriva de ArrayList<Contact> y añade:
 *  
 *  • Alta de contacto. 
    • Baja de contacto. 
    • Busca un contacto. Devuelve el contacto que coincida con la búsqueda, en caso de no encontrar coincidencia se devuelve un valor nulo.
    • Reduce el tamaño de la agenda. Cambia el número máximo de contactos a otro valor inferior a 100, si se diera un valor mayor lanza una excepción, si reducimos el tamaño de la agenda a un valor inferior al número de contactos que hay lanza una excepción.
    • Exporta a fichero CSV. Lanza una excepción si no podemos escribir en el fichero.
    • Importa de fichero CSV. Cada contacto importado llama al método que da de alta. Lanza una excepción si no podemos leer del fichero.

El control del tamaño de la agenda se hace sobre esta clase.

Una agenda está formada por una colección de de contactos, que a su vez son objetos de la clase Contacto. 
 */

import java.util.ArrayList;
import java.util.Collections;

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
    var file = Files.newBufferedWriter(Paths.get(fileName), StandardOpenOption.CREATE);

    saveHeadCSV(file);
    for (Contact contact: this) {
      saveContactCSV(contact, file);
    }
    file.close();
  }

  private void saveHeadCSV(BufferedWriter file) throws IOException {
    file.write("Name,Surnames,Address,Email,Phone");
    file.newLine();
  }

  private void saveContactCSV(Contact contact, BufferedWriter file) throws IOException {
    file.write("\"" + contact.getName() + "\",");
    file.write("\"" + contact.getSurnames() + "\",");
    file.write("\"" + contact.getAddress() + "\",");
    file.write("\"" + contact.getEmail() + "\",");
    file.write("\"" + contact.getPhone() + "\""); 
    file.newLine();
  }
  
  /**
   * Guarda la agenda como fichero XML.
   */
  public void saveXML(String fileName) throws IOException {
    var file = Files.newBufferedWriter(Paths.get(fileName), StandardOpenOption.CREATE);

    saveRootXML(file);
    for (Contact contact: this) {
      saveContactXML(contact, file);
    }
    saveEndRoot(file);
    file.close();
  }

  private void saveRootXML(BufferedWriter file) throws IOException {
    file.write("<AddressBook>");
    file.newLine();
  }
  
  private void saveEndRoot(BufferedWriter file) throws IOException {
    file.write("</AddressBook>");
    file.newLine();
  }
  
  private void saveContactXML(Contact contact, BufferedWriter file) throws IOException {
    file.write("\t<Contact>"); 
    file.newLine();
    
    saveAttributeXML("Name", contact.getName(), file);
    saveAttributeXML("Surnames", contact.getSurnames(), file);
    saveAttributeXML("Address", contact.getAddress(), file);
    saveAttributeXML("Email", contact.getEmail(), file);
    saveAttributeXML("Phone", contact.getPhone(), file);
    
    file.write("\t</Contact>");
    file.newLine();
  }
  
  private void saveAttributeXML(String attr, String value, BufferedWriter file) throws IOException {
    file.write("\t\t<" + attr + ">");
    file.newLine();
    file.write("\t\t\t" + value);
    file.newLine();
    file.write("\t\t</" + attr + ">");
    file.newLine();
  }

  @Override
  public String toString() {
    AddressBook addressBook = (AddressBook) this.clone();
    String toString = "[\n";
    
    Collections.sort(addressBook);
    for (Contact c: addressBook) {
      toString += "[ " + c.getName() + ", " + c.getSurnames() + ", " + c.getAddress()
               + ", " + c.getEmail() + ", " + c.getPhone() + "],\n";    
    }
    toString += "]";
    return toString;
  }
  
}
