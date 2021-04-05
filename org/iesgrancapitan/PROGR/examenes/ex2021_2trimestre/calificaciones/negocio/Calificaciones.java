package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.calificaciones.negocio;

/**
 * Clase Calificaciones para el examen del 2º trimestre del curso 2020/21.
 * 
 * Ver Calificaciones2021.java
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calificaciones {

  public static final int NUM_NOTAS = 5;

  List<Estudiante> estudiantes = new ArrayList<>();

  public boolean isEmpty() {
    return estudiantes.isEmpty();
  }

  public void cargaCSV(String nombreFichero) throws IOException, CSVEstudiantesException {
    var reader = new CalificacionesCSVLoader(estudiantes);
    reader.carga(nombreFichero);
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
   * @throws XMLEstudiantesException 
   * @throws AddressBookXMLException, IOException 
   */
  public void guardaXML(String nombreFichero) throws IOException, XMLEstudiantesException {
    var writer = new CalificacionesXMLWriter(estudiantes);
    writer.guarda(nombreFichero);
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
