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
 * Si la fecha a asignar es incorrecta lanzaremos una excepción (no marcada).
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

public class FechaConExcepciones implements Comparable<FechaConExcepciones>, Cloneable {

  private static final int MESES_ANYO = 12;

  private int dia;
  private int mes;
  private int anyo;

  public FechaConExcepciones(int dia, int mes, int anyo) {
    if (! esCorrecta(dia, mes, anyo)) {
      throw new FechaIncorrectaException("Fecha incorrecta.");
    }
    this.dia = dia;
    this.mes = mes;
    this.anyo = anyo;    
  }

  public int getDia() {
    return dia;
  }

  public void setDia(int dia) {
    if (! esCorrecta(dia, this.mes, this.anyo)) {   // ¿fecha correcta?
      throw new FechaIncorrectaException("Día incorrecto para la fecha.");
    } 
    this.dia = dia;
  }

  public int getMes() {
    return mes;
  }

  public void setMes(int mes) {
    if (! esCorrecta(this.dia, mes, this.anyo)) {   // ¿fecha correcta?
      throw new FechaIncorrectaException("Mes incorrecto para la fecha.");
    } 
    this.mes = mes;
  }

  public int getAnyo() {
    return anyo;
  }

  public void setAnyo(int anyo) {
    if (! esCorrecta(this.dia, this.mes, anyo)) {   // ¿fecha correcta?
      throw new FechaIncorrectaException("Año incorrecto para la fecha.");
    } 
    this.anyo = anyo;
  }

  public String getNombreMes() {
    String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
        "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    return meses[this.mes-1];
  }

  public FechaConExcepciones clone() {
    return new FechaConExcepciones(this.dia, this.mes, this.anyo);
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
    FechaConExcepciones other = (FechaConExcepciones) obj;
    if (anyo != other.anyo)
      return false;
    if (dia != other.dia)
      return false;
    if (mes != other.mes)
      return false;
    return true;
  }

  public void sumarDias(int dias) {
    if (dias >=0) {                  // si los días son + sumo, sino resto
      for (int i = 1; i <= dias; i++) {
        this.sumar1Dia();
      }
    } else {
      for (int i =1 ; i <= Math.abs(dias); i++) {
        this.restar1Dia();
      }
    }
  }

  private void sumar1Dia() {
    this.dia++;
    if (this.dia > diasMes(this.mes, this.anyo)) {
      // vamos al mes siguiente
      this.dia = 1;
      this.mes++;
      if (this.mes > MESES_ANYO) { // nos pasamos de diciembre, año siguiente
        this.mes = 1;
        this.anyo++;
      }
    }
  }

  public void restarDias(int dias) {
    if (dias >= 0) {
      for (int i = 1; i <= dias; i++) {     // si los días son + resto, sino sumo
        this.restar1Dia();
      }
    } else {
      for (int i = 1; i <= Math.abs(dias); i++) {
        this.sumar1Dia();
      }
    }
  }

  public void restar1Dia() {
    dia--;
    if (dia == 0) { // mes anterior y último día de mes
      mes--;
      if (mes == 0) { // 31 de diciembre del año anterior
        mes = MESES_ANYO;
        anyo--;
        if (anyo == 0) { // no puede haber año 0
          anyo--;
        }
      } 
      dia = diasMes(mes, anyo); // último día del mes anterior
    }
  }

  public int compareTo(FechaConExcepciones fecha2) {
    int f1 = this.anyo*10000 + this.mes*100 + this.dia;
    int f2 = fecha2.anyo*10000 + fecha2.mes*100 + fecha2.dia;
    return f1-f2;
  }

  @Override
  public String toString() {
    return this.dia + " de " + this.getNombreMes() + " de " + this.anyo;
  }

  private static boolean esCorrecta(int dia, int mes, int anyo) {
    return anyo != 0
        && mes > 0 && mes <= MESES_ANYO
        && dia > 0 && dia <= diasMes(mes, anyo);
  }

  public static boolean esBisiesto(int anyo) {
    return anyo%400==0 || (anyo%4==0 && anyo%100!=0);
  }

  public static int diasMes(int mes, int anyo) {
    int[] diasMes_ = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if (esBisiesto(anyo)) {
      diasMes_[1] = 29;
    }
    return diasMes_[mes - 1];
  }

  public static int restar(FechaConExcepciones fecha1, FechaConExcepciones fecha2) {
    int dias = 0;
    FechaConExcepciones f1 = fecha1.clone(); // primera fecha ¡no se puede igualar!

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
