package org.iesgrancapitan.PROGR.examenes.ex1920_2trimestre;

import java.util.regex.Pattern;

/**
 * Esta clase tiene tres constructores:
 * 
 * - El primero recibe un nombre y un teléfono.
 * - El segundo los datos anteriores y además una dirección.
 * - El tercero los datos anteriores y además un correo electrónico.
 * 
 * Los datos los validamos mediante expresiones regulares, si alguno es inválido lanzamos una 
 * excepción.
 * 
 * @author rafa
 *
 */

public class Contacto {
  
  // patrones expresiones regulares
  static private final String NOMBRE = "^[A-ZÁÉÍÓÚ][A-ZÑa-zñÁÉÍÓÚÜáéíóúü]+( [A-ZÑa-zñÁÉÍÓÚÜáéíóúü]+)+$";
  static private final String TELEFONO = "^[679][0-9]{8}$";
  static private final String EMAIL = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";
  
  // atributos
  private String nombre;
  private String direccion;
  private String telefono;
  private String email;
  
  // Constructores
  
  public Contacto(String nombre, String direccion, String telefono, String email) throws ContactoErrorException {
    setNombre(nombre);
    setDireccion(direccion);
    setTelefono(telefono);
    setEmail(email);
  }

  public Contacto(String nombre, String direccion) throws ContactoErrorException {
    setNombre(nombre);
    setDireccion(direccion);
  }
  
  public Contacto(String nombre, String direccion, String email) throws ContactoErrorException {
    setNombre(nombre);
    setDireccion(direccion);
    this.email = email;
  }
  
  // Getters y Setters

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) throws ContactoErrorException {
    if (!Pattern.matches(NOMBRE, nombre)) {
      throw new ContactoErrorException(nombre + "es un nombre erróneo");
    }
    this.nombre = nombre;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) throws ContactoErrorException {
     this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) throws ContactoErrorException {
    if (!Pattern.matches(TELEFONO, telefono)) {
      throw new ContactoErrorException(telefono + "es un teléfono erróneo");
    }
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) throws ContactoErrorException {
    if (!Pattern.matches(EMAIL, email)) {
      throw new ContactoErrorException(email + "es un correo electrónico erróneo");
    }
    this.email = email;
  }

  @Override
  public String toString() {
    return "Contacto [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + "]";
  }
  
}
