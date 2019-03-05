package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej05Login {

  // ################################################################################
  // Escribe un programa que pida un nombre de usuario y una contraseña
  // y si se ha introducido "pepe" y "asdasd" se indica "Has entrado al sistema",
  // sino se da un error.
  // ################################################################################
  // Análisis
  // Pedimos por teclado nombre y contraseña
  // si coinciden con las correctas indicamos que se ha entrado en el sistema.
  // en caso contrario indicamos que el nombre o la clave son incorrectas
  // Datos de entrada: usuario, password (cadena)
  // Información de salida: Mensajes de acierto o error.
  // Variables: usuario, password (cadena)
  // ################################################################################
  // Diseño
  // 1. Leer el usuario
  // 2. Leer el password
  // 3. Si el usuario es igual a "pepe" y el password es igual a "asdasd"
  // escribir "Has entrado en el sistema"
  // 4. En caso contrario mostrar el mensaje "Usuario/password incorrecto"
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String password;
    String usuario;

    System.out.print("Introduce el usuario: ");
    usuario = s.nextLine();
    System.out.print("Introduce el password: ");
    password = s.nextLine();

    if (usuario.equals("pepe") && password.equals("asdasd")) {
      System.out.println("Has entrado al sistema");
    } else {
      System.out.println("Usuario/password incorrecto");
    }
  }


}

