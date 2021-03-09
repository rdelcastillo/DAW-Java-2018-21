package org.iesgrancapitan.PROGR.ejemplos.agenda;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
  Contact contact;

  @BeforeEach
  void setUp() throws Exception {
    //contact = new Contact("Fulanito", "de los Palotes", "Calle Turquesa 25", "contacto@correo.es", "034-612345678");
    contact = new Contact("Fulanito", "de los Palotes", "Calle Turquesa 25", "contacto@correo.es");
  }

  @Test
  void testSetName1() {
    String name = "@@@";
    Exception exception = assertThrows(ContactErrorException.class, () -> contact.setName(name));
    assertEquals(name + " es un nombre erróneo", exception.getMessage());
  }
  
  @Test
  void testSetName2() {
    String name = " Pepe";
    Exception exception = assertThrows(ContactErrorException.class, () -> contact.setName(name));
    assertEquals(name + " es un nombre erróneo", exception.getMessage());
  }
  
  @Test
  void testSetName3() {
    String name = "Juan Antonio";
    contact.setName(name);
    assertEquals(name, contact.getName());
  }
  
  @Test
  void testSetSurnames1() {
    String surnames = "Pérez_Laporta";
    Exception exception = assertThrows(ContactErrorException.class, () -> contact.setSurnames(surnames));
    assertEquals(surnames + " son unos apellidos erróneos", exception.getMessage());
  }
  
  @Test
  void testSetSurnames2() {
    String surnames = "Pérez Laporta ";
    Exception exception = assertThrows(ContactErrorException.class, () -> contact.setSurnames(surnames));
    assertEquals(surnames + " son unos apellidos erróneos", exception.getMessage());
  }
  
  @Test
  void testSetSurnames3() {
    String surnames = "Pérez-Laporta";
    contact.setSurnames(surnames);
    assertEquals(surnames, contact.getSurnames());
  }

  @Test
  void testSetAddress() {
    String address = "";
    Exception exception = assertThrows(ContactErrorException.class, () -> contact.setAddress(address));
    assertEquals(address + " es una dirección errónea", exception.getMessage());
  }

  @Test
  void testSetPhone1() {
    String phone = "034-A12345678";
    Exception exception = assertThrows(ContactErrorException.class, () -> contact.setPhone(phone));
    assertEquals(phone + " es un teléfono erróneo", exception.getMessage());
  }
  
  @Test
  void testSetPhone2() {
    String phone = "637773325";
    contact.setPhone(phone);
    assertEquals(phone, contact.getPhone());
  }

  @Test
  void testSetEmail1() {
    String email = "contactoARROBAmicorreo.net";
    Exception exception = assertThrows(ContactErrorException.class, () -> contact.setEmail(email));
    assertEquals(email + " es un correo electrónico erróneo", exception.getMessage());
  }
  
  @Test
  void testSetEmail2() {
    String email = "contacto@_micorreo.net";
    Exception exception = assertThrows(ContactErrorException.class, () -> contact.setEmail(email));
    assertEquals(email + " es un correo electrónico erróneo", exception.getMessage());
  }
  
  @Test
  void testSetEmail3() {
    String email = "contacto@micorreo.net";
    contact.setEmail(email);
    assertEquals(email, contact.getEmail());
  }

}
