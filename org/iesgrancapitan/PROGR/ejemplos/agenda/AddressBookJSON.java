package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;

/**
 * Esta clase nos permite manipular JSON. 
 * 
 * Usa la librería GSON que es envuelta por esta clase.
 * Si alguna vez decidimos usar otra librería solo tenemos que cambiar esta clase.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class AddressBookJSON {

  /**
   * Crea un JSON de un addressBook y lo almacena en un fichero.
   */
  static void save(AddressBook addressBook, String fileName) throws IOException {
    Gson gson = new Gson();
    String json = gson.toJson(addressBook);
    Files.writeString(Paths.get(fileName), json);
  }

  /**
   * Devuelve un addressBook de un JSON almacenado en un fichero.
   */
  public static AddressBook load(String fileName) throws IOException, AddressBookJSONException {
    try {
      String json = Files.readString(Paths.get(fileName)); 
      Gson gson = new Gson();
      AddressBook addressBook = gson.fromJson(json, AddressBook.class);
      return addressBook;

    } catch (com.google.gson.JsonParseException e) {
      throw new AddressBookJSONException(e.getMessage());
    }
  }

}
