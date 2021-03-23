package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.negocio;

/**
 * Clase Calificaciones para el examen del 2º trimestre del curso 2020/21.
 * 
 * Ver Calificaciones2021.java
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.iesgrancapitan.PROGR.ejemplos.agenda.AddressBookXMLException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Calificaciones {

  public static final int NUM_NOTAS = 5;
  private static final String CABECERA_CSV = "Nombre,Nota1,Nota2,Nota3,Nota4,Nota5";

  List<Estudiante> estudiantes = new ArrayList<>();

  public boolean isEmpty() {
    return estudiantes.isEmpty();
  }

  public void cargaCSV(String nombreFichero) throws IOException, CSVEstudiantesException {
    var fichero = Files.newBufferedReader(Paths.get(nombreFichero));
    validaCabeceraCSV(fichero);

    String estudiante;
    while ((estudiante=fichero.readLine()) != null) {
      validaEstudianteCSV(estudiante);
      addEstudianteCSV(estudiante);
    }

    fichero.close();
    Collections.sort(estudiantes);
  }

  private static void validaCabeceraCSV(BufferedReader fichero) throws IOException, CSVEstudiantesException {
    String cabecera = fichero.readLine();
    if (! cabecera.equalsIgnoreCase(CABECERA_CSV)) {
      throw new CSVEstudiantesException("Cabecera del CSV Errónea: " + cabecera);
    }
  }

  private static void validaEstudianteCSV(String estudiante) throws CSVEstudiantesException {
    // ¿El nombre del estudiante está encerrado entre comillas?
    if (! estudiante.startsWith("\"")) {
      throw new CSVEstudiantesException("Nombre del estudiante no empieza con \": " + estudiante);
    }

    int posFinNombre = estudiante.indexOf("\",", 1);
    if (posFinNombre == -1) {
      throw new CSVEstudiantesException("Nombre del estudiante no termina con \": " + estudiante);
    }

    // ¿Resto de campos (notas) son la cantidad correcta y numéricos?
    String notas = estudiante.substring(posFinNombre + 2);
    validaNotas(notas);

  }
  private static void validaNotas(String notas) throws CSVEstudiantesException {
    String[] campos = notas.split(","); 
    int numCamposEsperado = CABECERA_CSV.split(",").length - 1;
    if (campos.length != numCamposEsperado) {
      throw new CSVEstudiantesException("Número de campos del CSV incorrecto en línea con: " + notas);
    }
    // ¿Son los campos numéricos?
    for (String num: campos) {
      if (! esEntero(num)) {
        throw new CSVEstudiantesException(num + " no es numérico.");
      }
    }
  }

  private static boolean esEntero(String cadena) {
    try {
      Integer.parseInt(cadena);
      return true;
    } catch (NumberFormatException e){
      return false;
    }
  }

  private void addEstudianteCSV(String estudiante) {
    String nombre = getNombreEstudiante(estudiante);
    int[] notas = getNotasEstudiante(estudiante);
    estudiantes.add(new Estudiante(nombre, notas));
  }

  private static String getNombreEstudiante(String estudiante) {
    return estudiante.substring(1, estudiante.indexOf("\","));  // límite nombre
  }

  private static int[] getNotasEstudiante(String estudiante) {
    String[] camposEstudiante = estudiante.split(",");
    int primerIndiceNotas = camposEstudiante.length - NUM_NOTAS;
    int[] notas = new int[NUM_NOTAS];
    for (int i = primerIndiceNotas; i < camposEstudiante.length; i++) {
      notas[i - primerIndiceNotas] = Integer.valueOf(camposEstudiante[i]);
    }
    return notas;
  }

  public int size() {
    return estudiantes.size();
  }

  /**
   * Devuelve estudiante nº i. Empezamos a contar desde 1
   */
  public Estudiante getEstudiante(int i) {
    return estudiantes.get(i - 1);
  }

  public int getNumeroEntregasEjercicio(int ejercicio) {
    int n = 0;
    for (Estudiante e: estudiantes) {
      if (e.haRealizadoEjercicio(ejercicio)) {
        n++;
      }
    }
    return n;
  }

  public int getNumeroEstudiantesNotaMayorIgual(int nota) {
    int n = 0;
    for (Estudiante e: estudiantes) {
      if (e.getMedia() >= nota) {
        n++;
      }
    }
    return n;
  }

  public double getMediaEjercicio(int ejercicio) {
    double sumaNotas = 0;
    double entregas = 0;
    for (Estudiante e: estudiantes) {
      if (e.haRealizadoEjercicio(ejercicio)) {
        entregas++;
        sumaNotas += e.getNota(ejercicio);
      }
    }
    return (entregas > 0) ? sumaNotas/entregas : 0;
  }

  public int getNotaMaximaEjercicio(int ejercicio) {
    int notaMaxima = Integer.MIN_VALUE;
    for (Estudiante e: estudiantes) {
      if (e.getNota(ejercicio) > notaMaxima) {
        notaMaxima = e.getNota(ejercicio);
      }
    }
    return notaMaxima;
  }
  
  public double getNotaMaxima() {
    double notaMaxima = 0;
    for (Estudiante e: estudiantes) {
      double mediaNotas = e.getMedia();
      if (mediaNotas > notaMaxima) {
        notaMaxima = mediaNotas;
      }
    }
    return notaMaxima;
  }

  /**
   * Guarda las notas como fichero XML.
   * @throws AddressBookXMLException, IOException 
   */
  public void guardaXML(String nombreFichero) throws IOException, AddressBookXMLException {
    try {   
      Document xml = creaDocumentXML();
      guardaRaizXML(xml);
      for (Estudiante estudiante : estudiantes) {
        guardaEstudianteXML(estudiante, xml);
      }
      guardaFicheroXML(xml, nombreFichero);

    } catch (ParserConfigurationException | TransformerException e) {
      throw new AddressBookXMLException("Error al generar XML: " + e.getMessage());
    }
  }

  private Document creaDocumentXML() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.newDocument();
    return document;
  }

  private void guardaRaizXML(Document xml) {
    Element raiz = xml.createElement("Calificaciones");
    xml.appendChild(raiz);
  }

  private void guardaEstudianteXML(Estudiante estudiante, Document xml) {
    Element raiz = xml.getDocumentElement();

    Element estudianteElement = xml.createElement("Estudiante");
    raiz.appendChild(estudianteElement);

    guardaCampoEstudianteXML("Nombre", estudiante.getNombre(), estudianteElement);
    for (int nota = 1; nota <= NUM_NOTAS; nota++) {
      guardaCampoEstudianteXML("Nota" + nota, String.valueOf(estudiante.getNota(nota)), estudianteElement);
    }
    guardaCampoEstudianteXML("Media", String.valueOf(estudiante.getMedia()), estudianteElement);
  }

  private void guardaCampoEstudianteXML(String campo, String valor, Element estudianteElement) {
    Document xml = estudianteElement.getOwnerDocument();
    Element attrElement = xml.createElement(campo);
    attrElement.appendChild(xml.createTextNode(valor));
    estudianteElement.appendChild(attrElement);
  }

  private void guardaFicheroXML(Document xml, String fileName) throws IOException, TransformerException {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    DOMSource xmlSource = new DOMSource(xml);
    StreamResult output = new StreamResult(new FileWriter(fileName));
    transformer.transform(xmlSource, output);
  }

  
  public String toString() {
    String toString = cabeceraToString() + "\n";
    for (int i = 0; i < estudiantes.size(); i++) {
      toString += String.format("%2d. ", i+1) + estudianteToString(estudiantes.get(i)) +"\n";      
    }
    return toString;
  }

  private String cabeceraToString() {
    int lenEstudiante = 25;
    int lenNota = 3;
    int lenMedia = 5;

    String cabecera = " ".repeat(lenEstudiante);   
    for (int nota = 1; nota <= NUM_NOTAS; nota++) {
      cabecera += String.format("%2d ", nota);
    }
    cabecera += "MEDIA\n";
    cabecera += " ".repeat(lenEstudiante) + "-".repeat(NUM_NOTAS*lenNota + lenMedia);

    return cabecera;
  }

  private String estudianteToString(Estudiante e) {
    String estudiante = String.format("%-20s ", e.getNombre());
    for (int nota = 1; nota <= NUM_NOTAS; nota++) {
      estudiante += String.format("%2d ", e.getNota(nota));
    }
    estudiante += String.format("%5.2f", e.getMedia());
    return estudiante;
  }

}
