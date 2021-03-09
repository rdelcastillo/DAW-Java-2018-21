package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


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

@SuppressWarnings("serial")
public class AddressBook extends ArrayList<Contact> {
  
  public void save(String fileName) throws FileNotFoundException, IOException {
    var file = new ObjectOutputStream(new FileOutputStream(fileName));
    file.writeObject(this);
    file.close();
  }
  
  static public AddressBook load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
    var file = new ObjectInputStream(new FileInputStream(fileName));
    AddressBook addressBook = (AddressBook) file.readObject();
    file.close();
    return addressBook;
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
