package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

/**
 * Clase Tiempo. 
 * 
 * Los objetos de la clase Tiempo son instantes de tiempo y se crean de la forma:
 * 
 * t = Tiempo(1, 20, 30)
 * 
 * donde los parámetros que se le pasan al constructor son las horas, los minutos y los segundos respectivamente. 
 * 
 * Estado: horas, minutos (0 a 59) y segundos (0 a 59) del instante temporal.
 * 
 * Comportamiento:
 * 
 * - Sumar y restar otro objeto de la clase Tiempo (el resultado es otro objeto).
 * - Sumar y restar segundos, minutos y/o horas (se cambia el objeto actual). 
 * - Devolver una cadena con el tiempo almacenado, ejemplo: si lo que hay es (10 35 5) la cadena será 10h 35m 5s.
 *  
 * @author Rafael del Castillo Gomariz
 *
 */

public class Tiempo {

  // atributos
  
  private int horas;
  private int minutos;
  private int segundos;
  
  // comportamiento
  
  /**
   * Constructor de la clase.
   * 
   * Consideraremos que nos pueden pasar valores negativos y minutos y segundos que no estén entre 0 y 59. 
   * Haremos los cálculos necesarios para que el estado que se crea no sea incorrecto.
   * 
   * @param horas
   * @param minutos
   * @param segundos
   */
  
  public Tiempo(int horas, int minutos, int segundos) {
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = segundos;
    this.normaliza();
  }

  // Getters y setters
  
  /**
   * @return the horas
   */
  public int getHoras() {
    return horas;
  }

  /**
   * Permitimos horas positivas y negativas, normalizaremos después para mantener consistencia.
   * 
   * @param horas the horas to set
   */
  public void setHoras(int horas) {
    this.horas = horas;
    this.normaliza();
  }

  /**
   * @return the minutos
   */
  public int getMinutos() {
    return minutos;
  }

  /**
   * Permitimos segundos fuera del rango [0,59], en ese caso normalizamos el estado del objeto.
   * 
   * @param minutos the minutos to set
   */
  public void setMinutos(int minutos) {
    this.minutos = minutos;
    this.normaliza();
  }
  
  /**
   * @return the segundos
   */
  public int getSegundos() {
    return segundos;
  }

  /**
   * Permitimos segundos fuera del rango [0,59], en ese caso normalizamos el estado del objeto.
   * 
   * @param segundos the segundos to set
   */
  public void setSegundos(int segundos) {
    this.segundos = segundos;
    this.normaliza();
  }

  // Resto de métodos
  
  /**
   * Suma50enteros a este objeto el que le pasamos como parámetro y lo devuelve
   * @param otro
   * @return
   */
  public Tiempo sumar(Tiempo otro) {
    return new Tiempo(this.horas + otro.horas, this.minutos + otro.minutos, 
                      this.segundos + otro.segundos);
  }
  
  /**
   * Resta a este objeto el que le pasamos como parámetro y lo devuelve
   * @param otro
   * @return
   */
  public Tiempo restar(Tiempo otro) {
    return new Tiempo(this.horas - otro.horas, this.minutos - otro.minutos, 
                      this.segundos - otro.segundos);
  }
  
  /**
   * Suma50enteros segundos a este objeto.
   * @param segundos
   */
  public void sumaSegundos(int segundos) {
    this.segundos += segundos;
    this.normaliza();
  }
  
  /**
   * Resta segundos a este objeto.
   * @param segundos
   */
  public void restaSegundos(int segundos) {
    this.sumaSegundos(-1 * segundos);
  }
  
  /**
   * Suma50enteros minutos a este objeto.
   * @param minutos
   */
  public void sumaMinutos(int minutos) {
    this.sumaSegundos(60 * minutos);
  }
  
  /**
   * Resta minutos a este objeto.
   * @param minutos
   */
  public void restaMinutos(int minutos) {
    this.sumaSegundos(-60 * minutos);
  }
  
  /**
   * Suma50enteros horas a este objeto.
   * @param horas
   */
  public void sumaHoras(int horas) {
    this.sumaSegundos(3600 * horas);
  }
  
  /**
   * Resta horas a este objeto.
   * @param horas
   */
  public void restaHoras(int horas) {
    this.sumaSegundos(-3600 * horas);
  }
  
  /**
   * Normaliza el estado del objeto haciendo que los valores de horas, minutos y segundos sean correctos.
   * Lo llamaremos después de cualquier operación que pueda dejar el estado incosistente.
   */
  private void normaliza() {
    int s = this.horas*3600 + this.minutos*60 + this.segundos; // segundos totales del instante temporal
    
    this.horas = s / 3600;
    this.minutos = (s % 3600) / 60;     // el resto nos da los segundos sobrantes, al dividirlo entre 60 tenemos los minutos
    this.segundos = (s % 3600) % 60;    // el resto de la operación anterior
  }

  @Override
  public String toString() {
    return this.horas + "h " + this.minutos + "m " + this.segundos + "s";
  }
}