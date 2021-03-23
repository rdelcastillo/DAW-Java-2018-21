package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.negocio;

@SuppressWarnings("serial")
public class ErrorEstudianteException extends IllegalArgumentException {

  public ErrorEstudianteException(String mensaje) {
    super(mensaje);
  }

}
