package org.iesgrancapitan.PROGR.ejemplos.agenda;

/**
 * Un contacto está definido por:
 * 
 *  • Nombre. Será válido cuando esté compuesto por letras y opcionalmente espacios (solo en medio). 
 *  • Apellidos. Como lo anterior. Asumimos que dos contactos con el mismo nombre y apellidos
 *    son el mismo contacto.
 *  • Teléfono. Será válido si está compuesto por nueve dígitos, el primero empieza por 6, 7 ó 9.
 *  • Dirección. No se valida, puede estar vacía.
 *  • Correo electrónico. Si existe hay que validarlo.
 * 
 * Esta clase tiene tres constructores:
 * 
 * - El primero recibe un nombre, apellidos y un teléfono.
 * - El segundo los datos anteriores y además una dirección.
 * - El tercero los datos anteriores y además un correo electrónico.
 * 
 * Los datos los validamos mediante expresiones regulares, si alguno es inválido lanzamos una 
 * excepción.
 * 
 * @author Rafael del Castillo
 *
 */

import static org.iesgrancapitan.PROGR.ejemplos.agenda.Patterns.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Contact implements Comparable<Contact>, Serializable {

  private String name;
  private String surnames;
  private String address;
  private String phone;
  private String email;

  public Contact(String name, String surnames, String address) {
    setName(name);
    setSurnames(surnames);
    setAddress(address);
  }

  public Contact(String name, String surnames, String address, String email) {
    setName(name);
    setSurnames(surnames);
    setAddress(address);
    setEmail(email);  
  }

  public Contact(String name, String surnames, String address, String email, String phone) {
    setName(name);
    setSurnames(surnames);
    setAddress(address);
    setEmail(email);
    setPhone(phone);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (! isaName(name)) {
      throw new ContactErrorException(name + " es un nombre erróneo");
    }
    this.name = name;
  }
  
  public String getSurnames() {
    return surnames;
  }
  
  public String getFullName() {
    return name + " " + surnames;
  }
  
  public String getSurnamesName() {
    return surnames + " " + name;
  }
  
  public void setSurnames(String surnames) {
    if (! isaSurname(surnames)) {
      throw new ContactErrorException(surnames + " son unos apellidos erróneos");
    }
    this.surnames = surnames;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) throws ContactErrorException {
    if (! isanAddress(address)) {
      throw new ContactErrorException(address + " es una dirección errónea");
    }
    this.address = address;
  }

  public String getPhone() {
    return phone == null ? "" : phone;
  }

  public void setPhone(String phone) throws ContactErrorException {
    if (! isaPhone(phone)) {
      throw new ContactErrorException(phone + " es un teléfono erróneo");
    }
    this.phone = phone;
  }

  public String getEmail() {
    return email == null ? "" : email;
  }

  public void setEmail(String email) throws ContactErrorException {
    if (! isanEmail(email)) {
      throw new ContactErrorException(email + " es un correo electrónico erróneo");
    }
    this.email = email;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((surnames == null) ? 0 : surnames.hashCode());
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
    Contact other = (Contact) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (surnames == null) {
      if (other.surnames != null)
        return false;
    } else if (!surnames.equals(other.surnames))
      return false;
    return true;
  }

  @Override
  public int compareTo(Contact o) {
    return this.getSurnamesName().compareTo(o.getSurnamesName());
  }

  @Override
  public String toString() {
    return "Contact [" + (name != null ? "name=" + name + ", " : "")
        + (surnames != null ? "surnames=" + surnames + ", " : "")
        + (address != null ? "address=" + address + ", " : "")
        + (phone != null ? "phone=" + phone + ", " : "") + (email != null ? "email=" + email : "")
        + "]";
  }

  
}
