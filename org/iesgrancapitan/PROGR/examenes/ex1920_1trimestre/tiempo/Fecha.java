package org.iesgrancapitan.PROGR.examenes.ex1920_1trimestre.tiempo;

/** 
 * Colección de funciones para manejar fechas en cadenas de caracteres.
 *
 * El formato de la cadena es: AAAAMMDD.
 * Ejemplo: El 15 de diciembre de 2019 sería: "20191215"
 * 
 * Colección de funciones:
 * 
 * 1. fechaCorrecta: dice si la fecha que se pasa como parámetro es correcta.
 * 
 * 2. fechaMas1Dia: suma un día a la fecha que se pasa como parámetro y lo devuelve.
 * 
 * 3. fechaMasNDias: suma una serie de días a la fecha que se pasa como parámetro y lo devuelve.
 * 
 * 4. fechaMenos1Dia: resta un día a la fecha que se pasa como parámetro y lo devuelve.
 * 
 * 5. fechaMenosNDias: resta una serie de días a la fecha que se pasa como parámetro y lo devuelve.
 * 
 * 6. esBisiesto: dice si la fecha que se pasa como parámetro es bisiesto.
 * 
 * 7. comparaFechas: recibe dos fechas y devuelve un valor negativo si la 1ª es anterior a la
 *    segunda, cero si son iguales, y un valor positivo si la 1ª es posterior a la segunda.
 * 
 * 8. fechaFormateada: recibe un fecha y devuelve una cadena con el formato:
 *    DD de {MES} de AAAA     (Ejemplo: "15 de Diciembre de 2019")
 *     
 * 9. anyo, mes, dia, nombreMes: recibe un fecha y devuelve esos valores.
 * 
 * @author Rafael del Castillo
 *
 */

public class Fecha {
    
  /**
   * Dice si la fecha que se pasa como parámetro es correcta.
   *
   * @param fecha
   * @return verdadero o falso.
   */
  public static boolean fechaCorrecta(String fecha) {
    // tiene que tener longitud 8
    if (fecha.length() != 8) {
      return false;
    }
    // todos sus caracteres tienen que ser dígitos
    for (int i=0; i<fecha.length(); i++) {
      char c = fecha.charAt(i);
      if (c < '0' || c > '9') {
        return false;
      }
    }
    // El mes tiene que estar entre 1 y 12
    int mes = mes(fecha);
    if (mes < 1 || mes > 12) {
      return false;
    }
    // El día tiene que ser correcto. El 29 de febrero es un caso especial
    // Si es año bisiesto el nº de días de febrero es 29.
    // Llamo a una función que me actualiza el nº de días de febrero si es bisiesto
    int[] diasMesEsteAño = diasMesAño(fecha);
    int dia = dia(fecha);
    return (dia>0 && dia<=diasMesEsteAño[mes-1]); // restamos 1 al mes para que esté entre 0 y 11
  }
  
  /**
   * Suma50enteros un día a la fecha que se pasa como parámetro y la devuelve.
   * 
   * @param fecha
   * @return nuevo fecha
   */
  public static String fechaMas1Dia(String fecha) {
    int dia = dia(fecha);
    int mes = mes(fecha);
    int anyo = año(fecha);
    int[] diasMesEsteAño = diasMesAño(fecha);
    
    // aumentamos el día
    int ultimoDiaMes = diasMesEsteAño[mes-1]; 
    dia++;
    if (dia > ultimoDiaMes) {   // mes siguiente si no es 29/2 y bisiesto
      // mes siguiente
      dia = 1;
      mes++;
      if (mes>12) { // nos pasamos de diciembre, año siguiente
        mes = 1;
        anyo++;
      }
    }
    return fecha(dia, mes, anyo);
  }
  
  /**
   * Suma50enteros una serie de días a la fecha que se pasa como parámetro y la devuelve.
   * 
   * @param fecha
   * @param dias
   * @return nueva fecha
   */
  public static String fechaMasNDias(String fecha, int dias) {
    String fecha2 = fecha;
    if (dias>=0) {
      for (int i=1; i<=dias; i++) {
        fecha2 = fechaMas1Dia(fecha2);
      }
    } else {
      for (int i=1; i<=Math.abs(dias); i++) {
        fecha2 = fechaMenos1Dia(fecha2);
      }
    }
    return fecha2;
  }
  
  /**
   * Resta un día a la fecha que se pasa como parámetro y la devuelve.
   * 
   * @param fecha
   * @return nuevo fecha
   */
  public static String fechaMenos1Dia(String fecha) {
    int dia = dia(fecha);
    int mes = mes(fecha);
    int anyo = año(fecha);
    int[] diasMesEsteAño = diasMesAño(fecha);
    
    // disminuimos el día
    dia--;
    if (dia==0) { // mes anterior y último día de mes
      mes--;
      if (mes == 0) { // 31 de diciembre del año anterior
        mes = 12;
        anyo--;
      } 
      dia = diasMesEsteAño[mes-1]; // último día del mes anterior
    }
    return fecha(dia, mes, anyo);
  }
  
  /**
   * Resta una serie de días a la fecha que se pasa como parámetro y la devuelve.
   * 
   * @param fecha
   * @param dias
   * @return nuevo fecha
   */
  public static String fechaMenosNDias(String fecha, int dias) {
    String fecha2 = fecha;
    if (dias>=0) {
      for (int i=1; i<=dias; i++) {
        fecha2 = fechaMenos1Dia(fecha2);
      }
    } else {
      for (int i=1; i<=Math.abs(dias); i++) {
        fecha2 = fechaMas1Dia(fecha2);
      }
    }
    return fecha2;
  }
  
  /**
   * Dice si la fecha que se pasa como parámetro es de un año bisiesto.
   * 
   * @param fecha
   * @return verdadero o falso
   */
  public static boolean esBisiesto(String fecha) {
    int año = año(fecha);
    return año%4==0 && (año%100!=0 || año%400==0);
  }
  
  /**
   * Recibe dos fechas y devuelve un valor negativo si la 1º es anterior a la 2º,
   * cero si son iguales, y un valor positivo si la 1º es posterior a la segunda.
   * 
   * @param fecha1
   * @param fecha2
   * @return entero negativo, cero o un entero positivo.
   */
  public static int comparaFechas(String fecha1, String fecha2) {
    return fecha1.compareTo(fecha2);
  }
  
  /**
   * Recibe un fecha y devuelve una cadena con el formato DD de {MES} de AAAA
   * (Ejemplo: "15 de Diciembre de 2019")
   * 
   * @param fecha
   * @return fecha formateada
   */
  public static String fechaFormateada(String fecha) {
    int dia = dia(fecha);
    int anyo = año(fecha);
    return String.valueOf(dia) + " de " + nombreMes(fecha) + " de " + String.valueOf(anyo);
  }
  
  /**
   * Devuelve el año de la fecha.
   * 
   * @param fecha
   * @return año
   */
  public static int año(String fecha) {
    return Integer.parseInt(fecha.substring(0,4));
  }
  
  /**
   * Devuelve el nombre del mes de la fecha.
   * 
   * @param fecha
   * @return nombre del mes
   */
  public static String nombreMes(String fecha) {
    String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
                      "Agosto", "Septiembre", "Noviembre", "Diciembre"}; 
    int mes = mes(fecha);
    return meses[mes-1];
  }
  
  /**
   * Devuelve el mes de la fecha.
   * 
   * @param fecha
   * @return mes
   */
  public static int mes(String fecha) {
    return Integer.parseInt(fecha.substring(4,6));
  }
  
  /**
   * Devuelve el día de la fecha.
   * 
   * @param fecha
   * @return día del mes
   */
  public static int dia(String fecha) {
    return Integer.parseInt(fecha.substring(6,8));
  }
  
  /**
   * Devuelve una cadena en formato AAAAMMDD
   * @param d día del mes
   * @param m día del año
   * @param a año
   * @return
   */
  public static String fecha(int d, int m, int a) {
    String dia=Integer.toString(d).trim();
    String mes=Integer.toString(m).trim();
    String anyo=Integer.toString(a).trim();
    // día
    if (dia.length()<2) {
      dia = "0"+dia;
    }
    // mes
    if (mes.length()<2) {
      mes = "0"+mes;
    }
    // año
    for (int i=anyo.length(); i<4; i++) {
      anyo = "0"+anyo;
    }
    return anyo + mes + dia;
  }
  
  /**
   * Esta función se usará para simplificar otras funciones que requieren saber
   * el número de días de cada mes y se complican al tener en cuenta el 29 de febrero
   * de los años bisiestos.
   * 
   * @param fecha
   * @return vector con los días de cada mes para el año de fecha_
   */
  public static int[] diasMesAño(String fecha) {
    int[] diasMesEsteAño = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if (esBisiesto(fecha)) {
      ++diasMesEsteAño[1]; // hay 29 días en febrero en este caso
    }
    return diasMesEsteAño;
  }
}
