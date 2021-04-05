package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.calificaciones.negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class CalificacionesCSVLoader {

  private static final String CABECERA = "Nombre,Nota1,Nota2,Nota3,Nota4,Nota5";
  private List<Estudiante> estudiantes;
  private BufferedReader fichero;

  public CalificacionesCSVLoader(List<Estudiante> estudiantes) {
    this.estudiantes = estudiantes;
  }

  public void carga(String nombreFichero) throws IOException, CSVEstudiantesException {
    fichero = Files.newBufferedReader(Paths.get(nombreFichero));
    validaCabecera();

    String estudiante;
    while ((estudiante=fichero.readLine()) != null) {
      validaEstudiante(estudiante);
      addEstudiante(estudiante);
    }

    fichero.close();
    Collections.sort(estudiantes);
  }

  private void validaCabecera() throws IOException, CSVEstudiantesException {
    String cabecera = fichero.readLine();
    if (! CABECERA.equalsIgnoreCase(cabecera)) {
      throw new CSVEstudiantesException("Cabecera del CSV Errónea: " + cabecera);
    }
  }

  private static void validaEstudiante(String estudiante) throws CSVEstudiantesException {
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
    int numCamposEsperado = CABECERA.split(",").length - 1;
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

  private void addEstudiante(String estudiante) {
    String nombre = getNombreEstudiante(estudiante);
    int[] notas = getNotasEstudiante(estudiante);
    estudiantes.add(new Estudiante(nombre, notas));
  }

  private static String getNombreEstudiante(String estudiante) {
    return estudiante.substring(1, estudiante.indexOf("\","));  // límite nombre
  }

  private static int[] getNotasEstudiante(String estudiante) {
    String[] camposEstudiante = estudiante.split(",");
    int primerIndiceNotas = camposEstudiante.length - Calificaciones.NUM_NOTAS;
    int[] notas = new int[Calificaciones.NUM_NOTAS];
    for (int i = primerIndiceNotas; i < camposEstudiante.length; i++) {
      notas[i - primerIndiceNotas] = Integer.valueOf(camposEstudiante[i]);
    }
    return notas;
  }

}
