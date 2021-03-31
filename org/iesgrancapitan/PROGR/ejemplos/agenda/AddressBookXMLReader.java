package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import static org.iesgrancapitan.PROGR.ejemplos.agenda.AddressBookXML.*;

/**
 * Esta clase representa objetos cuya función es cargar un AddressBook de un XML.
 * 
 * @author Rafael del Castillo.
 */

class AddressBookXMLReader {
    
  private AddressBook addressBook;
  private Document xml;
  
  AddressBookXMLReader() {
    this.addressBook = new AddressBook();
  }
  
  AddressBookXMLReader(AddressBook addressBook) {
    this.addressBook = addressBook;
  }
  
  AddressBook getAddressBook() {
    return addressBook;
  }

  /**
   * Rellena el xml a partir del fichero CSV.
   */
  void load(String fileName) throws IOException, AddressBookXMLException {
    try { 
      loadDocumentXML(fileName);
      NodeList contacts = xml.getElementsByTagName(CONTACT);
      for (int i = 0; i < contacts.getLength(); i++) {
        Contact contact = newContact(contacts.item(i));
        addressBook.add(contact);
      }
      
    } catch (ParserConfigurationException | SAXException | ContactErrorException e) {
      throw new AddressBookXMLException("Error al cargar XML: " + e.getMessage());
    } 
  }

  private void loadDocumentXML(String fileName) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    xml = builder.parse(new File(fileName));
    xml.getDocumentElement().normalize();
  }

  private static Contact newContact(Node itemContact) {
    String name = loadFieldContact(NAME, itemContact);
    String surnames = loadFieldContact(SURNAMES, itemContact);
    String address = loadFieldContact(ADDRESS, itemContact);
    String email = loadFieldContact(EMAIL, itemContact);
    String phone = loadFieldContact(PHONE, itemContact);
    return Contact.of(name, surnames, address, email, phone);
  }

  private static String loadFieldContact(String field, Node itemContact) {
    Element elementContact = (Element) itemContact;
    String textField = elementContact.getElementsByTagName(field).item(0).getTextContent();
    return textField;
  }

}
