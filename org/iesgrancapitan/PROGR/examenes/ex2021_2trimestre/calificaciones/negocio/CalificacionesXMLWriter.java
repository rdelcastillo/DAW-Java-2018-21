package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.calificaciones.negocio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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

public class CalificacionesXMLWriter {

  private static final String ESTUDIANTE = "Estudiante";
  private static final String MEDIA = "Media";
  private static final String NOTA = "Nota";
  private static final String NOMBRE = "Nombre";
  private List<Estudiante> estudiantes;
  private Document xml;

  public CalificacionesXMLWriter(List<Estudiante> estudiantes) {
    this.estudiantes = estudiantes;
  }

  public void guarda(String nombreFichero) throws IOException, XMLCalificacionesException {
    try {   
      creaDocumentXML();
      guardaRaiz();
      for (Estudiante estudiante : estudiantes) {
        guardaEstudiante(estudiante);
      }
      guardaFicheroXML(nombreFichero);

    } catch (ParserConfigurationException | TransformerException e) {
      throw new XMLCalificacionesException("Error al generar XML: " + e.getMessage());
    }    
  }

  private void creaDocumentXML() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    xml = builder.newDocument();
  }

  private void guardaRaiz() {
    Element raiz = xml.createElement("CalificacionesPlantilla");
    xml.appendChild(raiz);
  }

  private void guardaEstudiante(Estudiante estudiante) {
    Element raiz = xml.getDocumentElement();

    Element estudianteElement = xml.createElement(ESTUDIANTE);
    raiz.appendChild(estudianteElement);

    estudianteElement.appendChild(getCampoEstudiante(NOMBRE, estudiante.getNombre()));
    for (int nota = 1; nota <= Calificaciones.NUM_NOTAS; nota++) {
      Element notaElement = getCampoEstudiante(NOTA + nota, String.valueOf(estudiante.getNota(nota)));
      estudianteElement.appendChild(notaElement);
    }
    estudianteElement.appendChild(getCampoEstudiante(MEDIA, String.valueOf(estudiante.getMedia())));
  }

  private Element getCampoEstudiante(String campo, String valor) {
    Element campoElement = xml.createElement(campo);
    campoElement.appendChild(xml.createTextNode(valor));
    return campoElement;
  }

  private void guardaFicheroXML(String fileName) throws IOException, TransformerException {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    DOMSource xmlSource = new DOMSource(xml);
    StreamResult output = new StreamResult(new FileWriter(fileName));
    transformer.transform(xmlSource, output);
  }

}
