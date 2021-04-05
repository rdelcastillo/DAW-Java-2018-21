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

  private String nombre;
  private int[] notas = new int[Calificaciones.NUM_NOTAS];

  public Estudiante(String nombre) {
    this.nombre = nombre;
    for (int i = 1; i < Calificaciones.NUM_NOTAS; i++) {
      setNota(i, -1);
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
    return notas[ejercicio-1];
  }
  
  public void setNota(int ejercicio, int nota) {
    if (nota < -1 || nota > 10) {
      throw new ErrorEstudianteException("Valor de nota erróneo: " + nota);
    }
    notas[ejercicio - 1] = nota;
  }
  
  public boolean haRealizadoEjercicio(int ejercicio) {
    return (getNota(ejercicio) != -1);
  }

  public double getMedia() {
    double suma = 0;
    for (int nota: notas) {
      if (nota > -1) {  // ha realizado el ejercicio
        suma += nota;
      } else {
        return 0;       // no ha hecho todo, la media es 0
      }
    }
    return suma / Calificaciones.NUM_NOTAS;
  }

  @Override
  public int compareTo(Estudiante o) {
    return this.nombre.compareTo(o.nombre);
  }


}
