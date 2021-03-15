package org.iesgrancapitan.PROGR.ejemplos.ej05Ficheros;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Ejemplo de lectura de un fichero XML de artículos.
 * 
 * El formato de un archivo será:
 * 
 * <Almacén>
 *  <Artículo código = 'valor numérico'>
 *      <Descripción>
 *          ...
 *      </Descripción>
 *      <Precio>
 *          ...
 *      </Precio>
 *      <Unidades>
 *          ...
 *      </Unidades>
 *      ...
 *  </Artículo>
 * </Almacén>
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class LecturaFicheroXML2 {

  public static void main(String[] args) {

    try {

      Document document = DocumentBuilderFactory.newInstance()  // factory
          .newDocumentBuilder()                                 // builder
          .parse(new File("agenda.xml"));
      
      Element raiz = document.getDocumentElement();
      raiz.normalize();

      // Accedemos a la lista de nodos Artículo
      NodeList nodosArticulo = raiz.getChildNodes();

      // Recorremos los nodos Artículo 
      for (int i = 0; i < nodosArticulo.getLength(); i++) {
        Node nodo = nodosArticulo.item(i);  // Nodo Artículo

        if (nodo.getNodeType() == Node.ELEMENT_NODE) { // Compruebo si el nodo es un elemento
          imprimeNodo(nodo);

          // Obtengo sus hijos
          NodeList hijos = nodo.getChildNodes();
          
          for (int j = 0; j < hijos.getLength(); j++) { // Recorro sus hijos
            Node hijo = hijos.item(j);  // Obtengo al hijo actual

            if (hijo.getNodeType() == Node.ELEMENT_NODE) {
              imprimeElemento((Element) hijo);
            }

          }
          System.out.println("------");
        }

      }

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void imprimeNodo(Node nodo) {
    System.out.print(nodo.getNodeName());
    if (nodo.hasAttributes()) {
      for (int i = 0; i < nodo.getAttributes().getLength(); i++) {
        System.out.println(" " + nodo.getAttributes().item(i));
      }
    }
    System.out.println();
  }

  private static void imprimeElemento(Node nodo) {
    Element e = (Element) nodo; // Lo transformo a Element
    System.out.println(e.getTagName());
    System.out.println(e.getTextContent());
  }
}