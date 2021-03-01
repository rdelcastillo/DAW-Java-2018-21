package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

/**
 * Los objetos de la clase Fecha son fechas de tiempo y se crean de la forma:
 * 
 * Fecha f = Fecha(1, 10, 2020);
 * 
 * donde los parámetros que se le pasan al constructor son el día, el mes y el año respectivamente. 
 * Si la fecha creada es incorrecta mostraremos un mensaje de error en la salida estándar de errores 
 * (lo ideal sería lanzar una excepción, ya lo haremos cuando se vea en clase).
 * 
 * Comportamiento:
 * 
 * - Saber si la fecha almacenada es correcta.
 * - Sumar y restar días a la fecha.
 * - Comparar la fecha almacenada con otra, el método devolverá un valor negativo si la fecha almacenada es ANTERIOR a la otra, 
 *   0 si son IGUALES y un valor positivo si es POSTERIOR.
 * - Saber si el año de la fecha almacenada es bisiesto.
 * - El método toString() devuelve una cadena con el formato "<día del mes> de <nombre del mes> de <año>".
 * 
 * Las opciones a partir de la segunda, solo se realizarán si la fecha almacenada es correcta, en caso de no serlo, se dará un aviso, 
 * por la salida estándar de errores, de que la operación no se puede realizar.
 * 
 * Versión 2.0:
 * 
 * - Implementar las interfaces Comparable y Cloneable.
 * - Crear equals() y hashCode().
 * - Hacer un método para restar fechas.
 * - Va a cambiar los nombres de los métodos a verbos en infinitivo.
 * - Corrección de errores menores.
 * 
 * Las anteriores versiones pueden verse desde GitHub buscando por el tag.
 * 
 * @author Rafael del Castillo
 *
 */

public class Fecha implements Comparable<Fecha>, Cloneable {
  private int dia;
  private int mes;
  private int anyo;

  /**
   * Constructor de la clase.
   * @param dia
   * @param mes
   * @param anyo
   */
  public Fecha(int dia, int mes, int anyo) {
    this.dia = dia;
    this.mes = mes;
    this.anyo = anyo;

    // ¿fecha correcta?
    if (! this.esCorrecta()) {
      System.err.println("Construcción de fecha incorrecta");
    }
  }

  // Getters y Setters

  public int getDia() {
    return dia;
  }

  public void setDia(int dia) {
    this.dia = dia;

    // ¿fecha correcta?
    if (! this.esCorrecta()) {
      System.err.println("Construcción de fecha incorrecta");
    }
  }

  public int getMes() {
    return mes;
  }

  public void setMes(int mes) {
    this.mes = mes;

    // ¿fecha correcta?
    if (! this.esCorrecta()) {
      System.err.println("Construcción de fecha incorrecta");
    } 
  }

  public int getAnyo() {
    return anyo;
  }

  public void setAnyo(int anyo) {
    this.anyo = anyo;

    // ¿fecha correcta?
    if (! this.esCorrecta()) {
      System.err.println("Construcción de fecha incorrecta");
    }
  }

  // Resto de métodos

  /**
   * @return Nombre del mes del objeto.
   */
  public String getNombreMes() {
    String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
        "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
    
    if (this.mes > 0 && this.mes <= 12) {    // ¿mes correcto?
      return meses[this.mes-1];
    } else {
      return "MES_INCORRECTO";
    }
  }

  /**
   * Clona el objeto actual.
   * 
   * @return Copia del objeto actual
   */
  public Fecha clone() {
    return new Fecha(this.dia, this.mes, this.anyo);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + anyo;
    result = prime * result + dia;
    result = prime * result + mes;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Fecha other = (Fecha) obj;
    if (anyo != other.anyo)
      return false;
    if (dia != other.dia)
      return false;
    if (mes != other.mes)
      return false;
    return true;
  }

  /**
   * Suma un día a la fecha almacenada.
   * 
   */
  private void sumar1Dia() {
    
    if (! this.esCorrecta()) {    // solo operamos si la fecha es correcta
      System.err.println("No se puede operar con una fecha incorrecta");
      return;
    }

    // aumentamos el día
    this.dia++;
    if (this.dia > diasMes(this.mes, this.anyo)) {
      // mes siguiente
      this.dia = 1;
      this.mes++;
      if (this.mes>12) { // nos pasamos de diciembre, año siguiente
        this.mes = 1;
        this.anyo++;
      }
    }
  }

  /**
   * Suma una serie de días a la fecha almacenada.
   * 
   * @param dias
   */
  public void sumarDias(int dias) {
    
    if (! this.esCorrecta()) {      // solo operamos si la fecha es correcta
      System.err.println("No se puede operar con una fecha incorrecta");
      return;
    }
    
    if (dias>=0) {                  // si los días son + sumo, sino resto
      for (int i=1; i<=dias; i++) {
        this.sumar1Dia();
      }
    } else {
      for (int i=1; i<=Math.abs(dias); i++) {
        this.restar1Dia();
      }
    }
  }

  /**
   * Resta un día a la fecha almacenada.
   * 
   */
  public void restar1Dia() {
    
    if (! this.esCorrecta()) {    // solo operamos si la fecha es correcta
      System.err.println("No se puede operar con una fecha incorrecta");
      return;
    }
    
    // disminuimos el día
    dia--;
    if (dia == 0) { // mes anterior y último día de mes
      mes--;
      if (mes == 0) { // 31 de diciembre del año anterior
        mes = 12;
        anyo--;
        if (anyo == 0) { // no puede haber año 0
          anyo = -1;
        }
      } 
      dia = diasMes(mes, anyo); // último día del mes anterior
    }
  }

  /**
   * Resta una serie de días a la fecha almacenada.
   * 
   * @param dias
   */
  public void restarDias(int dias) {
    
    if (! this.esCorrecta()) {          // solo operamos si la fecha es correcta
      System.err.println("No se puede operar con una fecha incorrecta");
      return;
    }
    
    if (dias>=0) {
      for (int i=1; i<=dias; i++) {     // si los días son + resto, sino sumo
        this.restar1Dia();
      }
    } else {
      for (int i=1; i<=Math.abs(dias); i++) {
        this.sumar1Dia();
      }
    }
  }

  /**
   * Comprueba si la fecha almacenada es correcta.
   * @return true / false
   */
  public boolean esCorrecta() {
    // año correcto
    if (this.anyo == 0) {
      return false;
    }
    // mes correcto
    if (this.mes < 1 || this.mes > 12) {
      return false;
    }
    // día correcto
    return this.dia > 0 && this.dia <= diasMes(this.mes, this.anyo);
  }

  /**
   * Compara dos fechas.
   * 
   * @param fecha2
   * @return <0 si fecha1<fecha2, 0 si fecha1==fecha2, >0 si fecha1>fecha2
   */
  public int compareTo(Fecha fecha2) {
    // solo operamos si la fecha es correcta
    if (! this.esCorrecta()) {    
      System.err.println("No se puede operar con una fecha incorrecta");
      return 0;
    }
    
    int f1 = this.anyo*10000 + this.mes*100 + this.dia;
    int f2 = fecha2.anyo*10000 + fecha2.mes*100 + fecha2.dia;
    return f1-f2;
  }
  
  /**
   * @param fecha2
   * @return true si las fechas coinciden
   */
  public boolean esIgual(Fecha fecha2) {
    return this.dia == fecha2.dia && this.mes == fecha2.mes && this.anyo == fecha2.anyo;
  }

  @Override
  public String toString() {
    return this.dia + " de " + this.getNombreMes() + " de " + this.anyo;
  }

  // Métodos estáticos

  public static boolean esBisiesto(int anyo) {
    return anyo%400==0 || (anyo%4==0 && anyo%100!=0);
  }

  /**
   * @param mes
   * @param anyo
   * @return Días del mes actual
   */
  public static int diasMes(int mes, int anyo) {
    int[] diasMes_ = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if (esBisiesto(anyo)) {
      diasMes_[1] = 29;
    }
    return diasMes_[mes - 1];
  }
  
  /**
   * @param fecha1
   * @param fecha2
   * @return Número de días (con signo) entre fecha1 y fecha2.
   */
  public static int restar(Fecha fecha1, Fecha fecha2) {
    int dias = 0;
    Fecha f1 = fecha1.clone(); // primera fecha ¡no se puede igualar!
    
    // sumamos o restamos días hasta que f1 llegue a fecha2
    if (fecha1.compareTo(fecha2) < 0) {             // los días serán negativos ya que fecha1 < fecha2
      for (; f1.compareTo(fecha2) < 0; dias--) {   
        f1.sumar1Dia();
      }
    } else {                                        // los días serán positivos ya que fecha1 >= fecha2
      for (; f1.compareTo(fecha2) > 0; dias++) {    // los días serán negativos ya que fecha1 < fecha2
        f1.restar1Dia();
      }
    }
    
    return dias;
  }

}
