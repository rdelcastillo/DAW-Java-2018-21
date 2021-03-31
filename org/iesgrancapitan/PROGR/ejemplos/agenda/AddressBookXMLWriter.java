package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.io.FileWriter;
import java.io.IOException;
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
import static org.iesgrancapitan.PROGR.ejemplos.agenda.AddressBookXML.*;

/**
 * Esta clase representa objetos cuya función es escribir un AddressBook en un XML.
 * 
 * @author Rafael del Castillo.
 */

class AddressBookXMLWriter {
  
  private AddressBook addressBook;
  Document xml;
  
  AddressBookXMLWriter(AddressBook addressBook) {
    this.addressBook = addressBook;
  }
  
  /**
   * Guarda la agenda como XML
   */
  void save(String fileName) throws AddressBookXMLException, IOException {
    try {   
      createDocumentXML();
      saveRoot();
      for (Contact contact : addressBook) {
        saveContact(contact);
      }
      saveFileXML(fileName);

    } catch (ParserConfigurationException | TransformerException e) {
      throw new AddressBookXMLException("Error al generar XML: " + e.getMessage());
    }
  }

  private void createDocumentXML() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    xml = builder.newDocument();
  }

  private void saveRoot() {
    Element root = xml.createElement(ADDRESS_BOOK);
    xml.appendChild(root);
  }

  private void saveContact(Contact contact) {
    Element root = xml.getDocumentElement();

    Element contactElement = xml.createElement(CONTACT);
    root.appendChild(contactElement);

    saveFieldContact(NAME, contact.getName(), contactElement);
    saveFieldContact(SURNAMES, contact.getSurnames(), contactElement);
    saveFieldContact(ADDRESS, contact.getAddress(), contactElement);
    saveFieldContact(EMAIL, contact.getEmail(), contactElement);
    saveFieldContact(PHONE, contact.getPhone(), contactElement);
  }

  private void saveFieldContact(String attr, String value, Element contactElement) {
    Element attrElement = xml.createElement(attr);
    attrElement.appendChild(xml.createTextNode(value));
    contactElement.appendChild(attrElement);
  }

  private void saveFileXML(String fileName) throws IOException, TransformerException {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    DOMSource xmlSource = new DOMSource(xml);
    StreamResult output = new StreamResult(new FileWriter(fileName));
    transformer.transform(xmlSource, output);
  }
  
}