package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.calificaciones.negocio;

/**
 * Clase Estudiante para el examen del 2º trimestre del curso 2020/21.
 * 
 * Ver Calificaciones2021.java
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Estudiante implements Comparable<Estudiante> {

  private static final int NO_REALIZADO = -1;
  
  private String nombre;
  private int[] notas = new int[Calificaciones.NUM_NOTAS];

  public Estudiante(String nombre) {
    this.nombre = nombre;
    for (int i = 1; i <= Calificaciones.NUM_NOTAS; i++) {
      setNota(i, NO_REALIZADO);
    }
  }

  public Estudiante(String nombre, int[] notas) {
    this.nombre = nombre;
    this.notas = notas;
  }

  public String getNombre() {
    return nombre;
  }

  public int getNota(int ejercicio) {
    if (ejercicio < 1 || ejercicio > Calificaciones.NUM_NOTAS) {
      throw new ErrorEstudianteException("Número de ejercio erróneo: " + ejercicio);
    }
    return notas[ejercicio-1];
  }
  
  public void setNota(int ejercicio, int nota) {
    if (nota < NO_REALIZADO || nota > 10) {
      throw new ErrorEstudianteException("Valor de nota erróneo: " + nota);
    }
    notas[ejercicio - 1] = nota;
  }
  
  public boolean haRealizadoEjercicio(int ejercicio) {
    return (getNota(ejercicio) != NO_REALIZADO);
  }

  public double getMedia() {
    double suma = 0;
    for (int ejercicio = 1; ejercicio <= Calificaciones.NUM_NOTAS; ejercicio++) {
      if (! haRealizadoEjercicio(ejercicio)) {
        return 0;   // no ha hecho todo, la media es 0
      }
      suma += getNota(ejercicio);
    }
    return suma / Calificaciones.NUM_NOTAS;
  }

  @Override
  public int compareTo(Estudiante o) {
    return this.nombre.compareTo(o.nombre);
  }


}
