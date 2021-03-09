package org.iesgrancapitan.PROGR.ejemplos.agenda;

import java.util.regex.Pattern;

public class Patterns {
  
  static private final String NAME_PATTERN = getNamePattern();
  static private final String SURNAMES_PATTERN = getSurnamesPattern();
  static private final String PHONE_PATTERN = getPhonePattern();  
  static private final String EMAIL = getEmailPattern();
  static private final String ADDRESS = getAddressPattern();
  static private final String ALPHABETIC_UPPER = "A-ZÁÉÍÓÚÜÑ";
  static private final String ALPHABETIC = ALPHABETIC_UPPER + "a-záéíóúüñ";
  
  static public boolean isaName(String name) {
    return Pattern.matches(NAME_PATTERN, name);
  }
  
  static public boolean isaSurname(String surnames) {
    return Pattern.matches(SURNAMES_PATTERN, surnames);
  }
  
  static public boolean isanAddress(String address) {
    return Pattern.matches(ADDRESS, address);
  }
  
  static public boolean isaPhone(String phone) {
    return Pattern.matches(PHONE_PATTERN, phone);
  }
  
  static public boolean isanEmail(String email) {
    return Pattern.matches(EMAIL, email);
  }
  
  private static String getNamePattern() {
    return  "^[" + ALPHABETIC_UPPER + "]"   // empieza por un carácter alfabético mayúscula
          + "[" + ALPHABETIC + "]+"         // sigue por cualquier conjunto de carácteres alfabético
          + "( [" + ALPHABETIC + "]+)*$";   // a continuación caracteres alfabéticos separados por un espacio
  }
  
  private static String getSurnamesPattern() {
    return  "^[" + ALPHABETIC + "]+"            // empieza por un conjunto de carácteres alfabético
        + "([ \\-][" + ALPHABETIC + "]+)*$";    // a continuación caracteres alfabéticos separados por un espacio o guión
  }
  
  private static String getPhonePattern() {
    return "^[679][0-9]{8}$";
  }
  
  private static String getEmailPattern() {
    return "^[\\w-]+"           // inicio del email
         + "(\\.[\\w-]+)*"      // puede haber uno o más puntos seguidos
         + "@"
         + "[A-Za-z0-9]+"       // obligatorio después de @
         + "(\\.[A-Za-z0-9]+)*" // opcionalmente puede haber puntos seguidos
         + "(\\.[A-Za-z]{2,})"  // punto final y al menos dos caracteres alfabéticos
         + "$";
  }

  private static String getAddressPattern() {
    return "^[^\\s]+.*$";
  }
  
  

}
