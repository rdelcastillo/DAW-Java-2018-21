package org.iesgrancapitan.PROGR.ejemplos.expresionesregulares;

import java.util.regex.Pattern;

/**
 * Ejemplos con expresiones expresiones.
 * 
 * Fuente: http://chuwiki.chuidiang.org/index.php?title=Expresiones_Regulares_en_Java
 * 
 * @author rafa
 *
 */

public class ExpresionesRegulares1 {
  
  public static void main(String[] args) {
    
    /*
     * Expresión regular para fecha.
     * 
     * Imaginemos la fecha en formato dd/mm/yyyy. Son grupos de dos cifras separadas por barras. 
     * En una expresión regular \d representa una cifra. El día pueden ser una o dos cifras, 
     * es decir \d{1,2}, el mes igual y el año vamos a obligar que sean cuatro cifras exactamente \d{4}
     * 
     * Si queremos comprobar que una cadena leída por teclado cumple ese patrón, podemos usar la clase Pattern. 
     * A la clase Pattern le decimos el patrón que queremos que cumpla nuestra cadena y nos dice si la cumple o no.
     * 
     * El siguiente ejemplo comprueba si la cadena cumple con la expresión regular. Ten en cuenta que cuando en java 
     * metemos un caracter \ dentro de una cadena delimitada por "", debemos "escapar" esta \ con otra \, por ello todas 
     * nuestras \ en la expresión regular, se convierten en \\ en nuestro código java.
     */
    
    String patronFecha1 = "\\d{1,2}/\\d{1,2}/\\d{4}";

    // Lo siguiente encaja con el patrón
    prueba(patronFecha1, "55/12/2014");
    prueba(patronFecha1, "11/12/2014");
    prueba(patronFecha1, "1/12/2014");
    prueba(patronFecha1, "11/2/2014");    

    // Lo siguiente no encaja
    prueba(patronFecha1, "11/12/14");  // El año no tiene cuatro cifras
    prueba(patronFecha1, "11//2014");  // el mes no tiene una o dos cifras
    prueba(patronFecha1, "11/12/14perico");  // Sobra "perico"
    
    /*
     * Supongamos que queremos que el mes se exprese como "ene", "feb", "mar", ... en vez de como un número. 
     * Cuando hay varias posibles cadenas válidas, en la expresión regular se ponen entre paréntesis y separadas por |. 
     * Es decir, algo como esto (ene|feb|mar|abr|may|jun|jul|ago|sep|oct|nov|dic). 
     * 
     * Si además nos da igual mayúsculas o minúsculas, justo delante ponemos el flag de case insensitive (?i) 
     * (la 'i' es de ignore case)
     * 
     */
    
    String patronFecha2 = "\\d{1,2}/(?i)(ene|feb|mar|abr|may|jun|jul|ago|sep|oct|nov|dic)/\\d{4}";

    // Lo siguiente encaja con el patrón
    prueba(patronFecha2, "11/dic/2014");
    prueba(patronFecha2, "1/nov/2014");
    prueba(patronFecha2, "1/AGO/2014");   // Mes en mayúsculas
    prueba(patronFecha2, "21/Oct/2014");  // Primera letra del mes en mayúsculas.

    // Lo siguiente no encaja
    prueba(patronFecha2, "11/abc/2014");   // abc no es un mes
    prueba(patronFecha2, "11//2014");      // falta el mes
    prueba(patronFecha2, "11/jul/2014perico");   // sobra perico
    
    /*
     * Expresión regular para DNI.
     * 
     * El DNI (o NIF) lleva un número único y sirve para identificar a la persona. Este número son 8 cifras seguidas de una letra, 
     * que normalmente se escribe en mayúscula. Esta letra es una especie de checksum de las cifras anteriores.
     * 
     * Quedan excluidas las letras 'I', 'O' y 'U'. 
     * Las dos primeras por poder confundirse con uno y cero respectivamente. La tercera por algún extraño motivo.
     * 
     * Una expresión regular no va a realizar el checksum, pero sí nos puede ayudar a hacer una primera comprobación: 
     * 8 cifras y una letra mayúscula. La expresión regular puede ser así \d{8}[A-HJ-NP-TV-Z]
     * 
     */
    
    String patronDni = "\\d{8}[A-HJ-NP-TV-Z]";

    // Lo siguiente encaja con el patrón
    prueba(patronDni, "01234567C");

    // Lo siguiente no encaja
    prueba(patronDni, "01234567U");    // La U no es válida
    prueba(patronDni, "0123567X");     // No tiene 8 cifras
    
    /*
     * Expresión regular para email.
     * 
     * No existe una expresión regular para email que sea 100% fiable, hay muchos formatos válidos y muy complejos. 
     * 
     * Aquí vamos como una expresión regular más o menos sencilla: [^@]+@[^@]+\.[a-zA-Z]{2,}. 
     * 
     */
    
    String patronEmail = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";

    // Lo siguiente encaja con el patrón
    prueba(patronEmail, "a@b.com");
    prueba(patronEmail, "+++@+++.com");

    // Lo siguiente no encaja
    prueba(patronEmail, "@b.com");      // Falta el nombre
    prueba(patronEmail, "a@b.c");       // El dominio final debe tener al menos dos letras
    
  }

  /**
   * Prueba las expresiones regulares.
   * 
   * @param patron expresión regular.
   * @param cadena cadena de texto dónde comprobamos si el patrón encaja.
   */
  private static void prueba(String patron, String cadena) {
    System.out.print("Cadena: " + cadena + ".\t");
    System.out.print("Patrón expresión regular: /" + patron + "/\t");
    if (Pattern.matches(patron, cadena)) {
      System.out.println("ENCAJA.");
    } else {
      System.out.println("NO ENCAJA.");
    }
    System.out.println();
    
  }

}
