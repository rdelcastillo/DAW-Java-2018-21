package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

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
  // a demás de los intentosQueQuedan que te quedan (tienes 10 intentosQueQuedan para acertarlo).
  // El programa termina cuando se acierta el número (además te dice en cuantos
  // intentosQueQuedan lo has acertado), si se llega al limite de intentosQueQuedan te muestra el
  // número que había generado.
  // ################################################################################
  // Análisis
  // Tenemos que generar un número aleatorio (función Aleatorio) del 1 al 100.
  // Necesitamos un contador para contar los 10 intentosQueQuedan. Al principio vale 10 y
  // irá decrementando.
  // Mientras no acierte el número y me queden intentosQueQuedan:
  // Leo un número
  // Lo comparo con el número generado (digo si es mayor o menor)
  // Pido otro numero
  // Puedo terminar el bucle por dos razones: si he adivinado el numero (he ganado)
  // y muestro los intentosQueQuedan que he necesitado.
  // sino he perdido, he utilizado los 10 intentosQueQuedan y muestro el número generado.
  // Datos de entrada: número pedido al usuario.
  // Información de salida: Has ganado y los intentosQueQuedan, o has perdido y el número.
  // Variables: num_screto, n, intentosQueQuedan (entero)
  // ################################################################################
  // Diseño
  // 1.- Genero un numero aleatorio del 1 al 100 (numSecreto)
  // 2.- intentosQueQuedan = 10
  // 3.- Leer num
  // 4.- Mientras num<> numSecreto y intentosQueQuedan>1
  // 5.- Si num_screto>num -> Escribir "Muy bajo"
  // 6.- Si num_screto<num -> Escribir "Muy alto"
  // 7.- intentosQueQuedan=intentosQueQuedan-1
  // 8.- Escribir intentosQueQuedan
  // 9.- Leer num
  // 10.- Si num_secreo=num -> Escribir "Has ganado", intentosQueQuedan
  // 11.- SiNo -> Escribir "Has perdido, numSecreto
  // ################################################################################

  static final int INTENTOS_MAXIMOS = 10;
  
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int intentosQueQuedan;
    int n;
    int numSecreto = (int) (Math.random()*100 + 1);

    // Proceso
    System.out.print("Adivine el número (de 1 a 100): ");
    n = s.nextInt();

    for (intentosQueQuedan=INTENTOS_MAXIMOS-1 ; numSecreto!=n && intentosQueQuedan>0; 
         intentosQueQuedan--) {
      if (n < numSecreto) {
        System.out.println(n + " es menor que el número a adivinar");
      } else {
        System.out.println(n + " es mayor que el número a adivinar");
      }
      System.out.println("Te quedan " + intentosQueQuedan + " intentos.");
      System.out.print("Dame otro número (de 1 a 100): ");
      n = s.nextInt();
    }

    // Mostramos resultado
    if (numSecreto==n) {
      System.out.println("Exacto! Usted adivinó en "+(INTENTOS_MAXIMOS-intentosQueQuedan)+" intentos.");
    } else {
      System.out.println("Has agotado el número máximo de intentos. El número a adivinar era: " + numSecreto);
    }
  }


}

