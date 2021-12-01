package org.iesgrancapitan.PROGR.ejemplos.expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Una vez que vemos la forma de ver si una cadena cumple el patrón, podemos querer extraer parte de ese patrón, 
 * por ejemplo, las cifras de la fecha (día, mes y año). 
 * 
 * Nuevamente las expresiones regulares de java nos ayudan. Cambiemos el ejemplo. Queremos extraer los sumandos 
 * y el resultado de una cadena así "xxxx+yyyy=zzzzz" donde x, y y z representan dígitos y pueden ser en cualquier número.
 * 
 * Con \d+ indicamos uno o más dígitos. La expresión regular para ver si una cadena cumple ese patrón puede ser \d+\+\d+=\d+". 
 * Puesto que el + tiene un sentido especial en los patrones -indica uno o más-, para ver si hay un "+" en la cadena, 
 * tenemos que "escaparlo", por eso el \ delante.
 * 
 * Las partes que queramos extraer, debemos meterlas entre paréntesis. 
 * 
 * Así, la expresión regular quedaría "(\d+)\+(\d+)=(\d+)".
 * 
 * Fuente: http://chuwiki.chuidiang.org/index.php?title=Expresiones_Regulares_en_Java
 *
 */

public class ExpresionesRegulares2 {
  
  public static void main(String[] args) {
    // La cadena a analizar
    String cadena = "23+12=35";

    // Obtenemos un Pattern con la expresión regular "compilada"
    Pattern patron = Pattern.compile("(\\d+)\\+(\\d+)=(\\d+)");
    
    // y de él un Matcher (un "encajador"), para extraer los trozos de interés.
    Matcher matcher = patron.matcher(cadena);

    // Buscamos las partes (si existen)
    if (matcher.find()) {     // También que Matcher busque los trozos.
      // Va devolviendo los trozos. El primer paréntesis es el 1,
      // el segundo el 2 y el tercero el 3
      System.out.println(matcher.group(1));
      System.out.println(matcher.group(2));
      System.out.println(matcher.group(3));
      System.out.println();
      // Puedo acceder también así
      for (int i=1; i<=matcher.groupCount(); i++) {
        System.out.println(matcher.group(i));
      }
    }
    
    // La salida de este programa es
    // 23
    // 12
    // 35
  }

}
