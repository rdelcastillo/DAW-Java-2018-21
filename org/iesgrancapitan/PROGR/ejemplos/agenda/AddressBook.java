package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Agenda de contactos 2.0. Clase derivada de ArraList<Contact>
 * 
 * Además de los métodos de ArrayList para manejar una lista de objetos Contact
 * añadimos métodos para guardar y recuperar agendas almacenadas como objetos, 
 * CSV y XML. 
 * 
 * En la versión 1.0 solo exportábamos la agenda como objeto, en CSV y XML (sin
 * usar las clases de Java para XML, ahora se usan). 
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class AddressBook extends ArrayList<Contact> {

  private static final String CONTACT = "Contact";
  private static final String ADDRESS_BOOK = "AddressBook";
  private static final String PHONE = "Phone";
  private static final String EMAIL = "Email";
  private static final String ADDRESS = "Address";
  private static final String SURNAMES = "Surnames";
  private static final String NAME = "Name";
  private static final String CSV_HEAD = "Name,Surnames,Address,Email,Phone";
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
    file.write(CSV_HEAD);
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
   * Recupera la agenda de un fichero CSV y la devuelve como AddressBook.
   * @throws IOException 
   * @throws AddressBookCSVException 
   */
  static public AddressBook loadCSV(String fileName) throws IOException, AddressBookCSVException {
    var addressBook = new AddressBook();
    var file = Files.newBufferedReader(Paths.get(fileName));
    validateHeadCSV(file);

    String line;
    while ((line = file.readLine()) != null) {
      Contact contact = newContactCSV(line);
      addressBook.add(contact);
    }
    file.close();

    return addressBook;
  }

  private static void validateHeadCSV(BufferedReader file) throws IOException, AddressBookCSVException {
    String head = file.readLine().trim();
    if (! head.equalsIgnoreCase(CSV_HEAD)) {
      throw new AddressBookCSVException("Cabecera errónea en el CSV.");
    }
  }

  private static Contact newContactCSV(String line) throws AddressBookCSVException {
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
      contact = newContact(name, surnames, address, email, phone);
    } catch (ContactErrorException e) {
      throw new AddressBookCSVException(e.getMessage());
    }

    return contact;
  }

  private static void validateContactCSV(String line) throws AddressBookCSVException {
    int numFieldsLine = line.split("\",").length;   // solo las comas de separación de campos
    int numFieldsContact = CSV_HEAD.split(",").length;

    if (numFieldsLine != numFieldsContact) {
      throw new AddressBookCSVException(line + ": no es un formato válido para convertirlo en Contact.");
    }
  }

  /**
   * Guarda la agenda como fichero XML.
   * @throws AddressBookXMLException, IOException 
   */
  public void saveXML(String fileName) throws AddressBookXMLException, IOException {
    try {   
      Document xml = createDocumentXML();
      saveRootXML(xml);
      for (Contact contact : this) {
        saveContactXML(contact, xml);
      }
      saveFileXML(xml, fileName);
      
    } catch (ParserConfigurationException | TransformerException e) {
      throw new AddressBookXMLException("Error al generar XML: " + e.getMessage());
    }
  }

  private Document createDocumentXML() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.newDocument();
    return document;
  }

  private void saveRootXML(Document xml) {
    Element root = xml.createElement(ADDRESS_BOOK);
    xml.appendChild(root);
  }

  private void saveContactXML(Contact contact, Document xml) {
    Element root = xml.getDocumentElement();

    Element contactElement = xml.createElement(CONTACT);
    root.appendChild(contactElement);

    saveFieldContactXML(NAME, contact.getName(), contactElement);
    saveFieldContactXML(SURNAMES, contact.getSurnames(), contactElement);
    saveFieldContactXML(ADDRESS, contact.getAddress(), contactElement);
    saveFieldContactXML(EMAIL, contact.getEmail(), contactElement);
    saveFieldContactXML(PHONE, contact.getPhone(), contactElement);
  }

  private void saveFieldContactXML(String attr, String value, Element contactElement) {
    Document xml = contactElement.getOwnerDocument();
    Element attrElement = xml.createElement(attr);
    attrElement.appendChild(xml.createTextNode(value));
    contactElement.appendChild(attrElement);
  }

  private void saveFileXML(Document xml, String fileName) throws IOException, TransformerException {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    DOMSource xmlSource = new DOMSource(xml);
    StreamResult output = new StreamResult(new FileWriter(fileName));
    transformer.transform(xmlSource, output);
  }

  /**
   * Recupera la agenda de un fichero XML y la devuelve como AddressBook.
   * @throws IOException 
   * @throws AddressBookXMLException 
   * @throws AddressBookCSVException 
   */
  static public AddressBook loadXML(String fileName) throws IOException, AddressBookXMLException {
    var addressBook = new AddressBook();
    try { 
      Document xml = newDocumentXML(fileName);
      NodeList contacts = xml.getElementsByTagName(CONTACT);
      for (int i = 0; i < contacts.getLength(); i++) {
        Contact contact = newContactXML(contacts.item(i));
        addressBook.add(contact);
      }
    } catch (ParserConfigurationException | SAXException | ContactErrorException e) {
      throw new AddressBookXMLException("Error al cargar XML: " + e.getMessage());
    } 
    return addressBook;
  }

  private static Document newDocumentXML(String fileName) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new File(fileName));
    document.getDocumentElement().normalize();
    return document;
  }

  private static Contact newContactXML(Node itemContact) {
    String name = loadFieldContactXML(NAME, itemContact);
    String surnames = loadFieldContactXML(SURNAMES, itemContact);
    String address = loadFieldContactXML(ADDRESS, itemContact);
    String email = loadFieldContactXML(EMAIL, itemContact);
    String phone = loadFieldContactXML(PHONE, itemContact);
    return newContact(name, surnames, address, email, phone);
  }

  private static String loadFieldContactXML(String field, Node itemContact) {
    Element elementContact = (Element) itemContact;
    String textField = elementContact.getElementsByTagName(field).item(0).getTextContent();
    return textField;
  }

  private static Contact newContact(String name, String surnames, String address, String email,
      String phone) {
    Contact contact;
    contact = new Contact(name, surnames, address);
    if (! email.isBlank()) {
      contact.setEmail(email);
    }
    if (! phone.isBlank()) {
      contact.setPhone(phone);
    }
    return contact;
  }

  @Override
  public String toString() {
    AddressBook addressBook = (AddressBook) this.clone();
    String toString = ADDRESS_BOOK + " [\n";
    Collections.sort(addressBook);
    for (Contact c: addressBook) {
      toString += c + "\n";    
    }
    toString += "]";
    return toString;
  }

}
