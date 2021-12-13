package org.iesgrancapitan.PROGR.ejemplos.cadenas;

/**
 * Distintas operaciones que podemos hacer con cadenas de caracteres.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class OperacionesConCadenas {

  public static void main(String[] args) {
    String string1 = "Soy una cadena de caracteres";
    String string2 = "Soy otra cadena de caracteres";
    
    // Recorrer una cadena
    System.out.println("Recorro " + string1 + " a través de su índice");
    for (int i=0; i < string1.length(); i++) {
      System.out.println("Carácter " + i + "(usando charAt()): " + string1.charAt(i));
      System.out.println("Carácter " + i + "(usando substring):" + string1.substring(i, i+1));
      System.out.println("---");
    }
    
    System.out.println("Recorro " + string1 + " con un foreach como array de char");
    for (char ch: string1.toCharArray()) {
      System.out.println(ch);
    }
    System.out.println("---");
    
    // Comparar cadenas
    System.out.println("¿Es \"" + string1 + "\" igual a \"" + string2 + "\" " + string1.equals(string2));
    System.out.println("¿Es \"" + string1 + "\" menor que \"" + string2 + "\" " + (string1.compareTo(string2)<0));
    System.out.println("---");

    

  }

}
