package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
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

public class LecturaFicheroXML {

  public static void main(String[] args) {
    List<Articulo> articulos = new ArrayList<>();

    try {
      // Creamos documento XML
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(new File("almacen.xml"));  // este objeto hará todo el trabajo
      
      document.getDocumentElement() // Accede al nodo raíz del documento
              .normalize();         // Elimina nodos vacíos y combina adyacentes en caso de que los hubiera

      // Accedemos a la lista de nodos Artículo
      NodeList nodosArticulo = document.getElementsByTagName("Artículo");

      // Recorremos los nodos Artículo 
      for (int i = 0; i < nodosArticulo.getLength(); i++) {

        // Nodo Artículo 
        Node nodo = nodosArticulo.item(i);
        Element articulo = (Element) nodo;

        // Campos del artículo (teniendo en cuenta que conocemos la estructura y etiquetas utilizadas)
        int codigo = Integer.parseInt(articulo.getAttribute("código"));
        String descripcion = articulo.getElementsByTagName("Descripción").item(0).getTextContent();
        double precio = Double.parseDouble(articulo.getElementsByTagName("Precio").item(0).getTextContent());
        int unidades = Integer.parseInt(articulo.getElementsByTagName("Unidades").item(0).getTextContent());

        // Añadimos a la lista
        articulos.add(new Articulo(codigo, descripcion, precio, unidades));
      }
      System.out.println(articulos);
      
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}