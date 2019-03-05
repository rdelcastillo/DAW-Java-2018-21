package org.iesgrancapitan.PROGR.Java.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej01AdivinaNumeroConFor {

  // ################################################################################
  // Crea una aplicación que permita adivinar un número. La aplicación genera un
  // número aleatorio del 1 al 100. A continuación va pidiendo números y va
  // respondiendo si el número a adivinar es mayor o menor que el introducido,
  // a demás de los intentos que te quedan (tienes 10 intentos para acertarlo).
  // El programa termina cuando se acierta el número (además te dice en cuantos
  // intentos lo has acertado), si se llega al limite de intentos te muestra el
  // número que había generado.
  // ################################################################################
  // Análisis
  // Tenemos que generar un número aleatorio (función Aleatorio) del 1 al 100.
  // Necesitamos un contador para contar los 10 intentos. Al principio vale 10 y
  // irá decrementando.
  // Mientras no acierte el número y me queden intentos:
  // Leo un número
  // Lo comparo con el número generado (digo si es mayor o menor)
  // Pido otro numero
  // Puedo terminar el bucle por dos razones: si he adivinado el numero (he ganado)
  // y muestro los intentos que he necesitado.
  // sino he perdido, he utilizado los 10 intentos y muestro el número generado.
  // Datos de entrada: número pedido al usuario.
  // Información de salida: Has ganado y los intentos, o has perdido y el número.
  // Variables: num_screto, num_ingresado, intentos (entero)
  // ################################################################################
  // Diseño
  // 1.- Genero un numero aleatorio del 1 al 100 (num_secreto)
  // 2.- intentos = 10
  // 3.- Leer num
  // 4.- Mientras num<> num_secreto y intentos>1
  // 5.- Si num_screto>num -> Escribir "Muy bajo"
  // 6.- Si num_screto<num -> Escribir "Muy alto"
  // 7.- intentos=intentos-1
  // 8.- Escribir intentos
  // 9.- Leer num
  // 10.- Si num_secreo=num -> Escribir "Has ganado", intentos
  // 11.- SiNo -> Escribir "Has perdido, num_secreto
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int intentos = 10;
    int num_ingresado;
    int num_secreto = (int) (Math.random()*100 + 1);

    System.out.print("Adivine el número (de 1 a 100): ");
    num_ingresado = s.nextInt();

    for (;num_secreto!=num_ingresado && intentos>1;) {
      if (num_secreto>num_ingresado) {
        System.out.println("Muy bajo");
      } else {
        System.out.println("Muy alto");
      }
      intentos = intentos-1;
      System.out.println("Le quedan "+intentos+" intentos:");
      System.out.print("Deme otro número (de 1 a 100): ");
      num_ingresado = s.nextInt();
    }

    if (num_secreto==num_ingresado) {
      System.out.println("Exacto! Usted adivino en "+(11-intentos)+" intentos.");
    } else {
      System.out.println("El numero era: "+num_secreto);
    }
  }


}

