package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej05Intervalo {

  // ################################################################################
  // Escribe un programa que pida el limite inferior y superior de un intervalo.
  // Si el límite inferior es mayor que el superior lo tiene que volver a pedir.
  // A continuación se van introduciendo números hasta que introduzcamos el 0.
  // Cuando termine el programa dará las siguientes informaciones:
  // * La suma de los números que están dentro del intervalo (intervalo abierto).
  // * Cuantos números están fuera del intervalo.
  // * He informa si hemos introducido algún número igual a los límites del intervalo.
  // ################################################################################
  // Análisis
  // Pedimos un intervalo (límite inferior y superior)
  // Nos tenemos que asegurar que el límite inferior sea menor que el superior.
  // Se van pidiendo números hasta que se introduzca el 0.
  // Si el numero pertenece al intervalo -> lo voy sumando (necesito un acumulador)
  // Si el número no pertenece al intervalo, lo cuento (necesito un contador)
  // Si el número es igual a algún límite, lo índico (necesito un indicador)
  // Al final muestro la suma de los números que pertenecen al intervalo.
  // Muestro el contador de número que no pertenecen al intervalo.
  // Indico si hemos introducido un número igual a algún límite
  // Datos de entrada:límite superior e inferior del intervalo y números.
  // Información de salida:La suma de los que pertenecen al intervalo,
  // el contador de los números que no pertenecen al intervalo
  // indico si un número ha sido igual a algún intervalo
  // Variables:limInf, limSup, num, sumaDentroIntervalo, contFueraIntervalo (entero)
  // igualLimites (Lógico)
  // ################################################################################
  // Diseño
  // 1.- Inicializo el acumulador, el contador y el indicado
  // 2.-Repetir -> ller limInf y limSup hasta que limInf<limSup
  // 3.-Leer num
  // 4.- Mientras num sea distinto de 0
  // 5.-Si num pertenece al intervalo -> acumula la suma
  // 6.-Sino -> incremento contador
  // 7.- Si es igual a algún intervalo -> Lo indico (indicador a Verdadero)
  // 8.- Leer num
  // 9.-Muestro la suma de los números pertenecientes al intervalo
  // 10.-Muestro el contador de números no pertenecientes al intervalo
  // 11.- Si el indicador = Verdadero -> Muestro "Un número = a intervalo"
  // 12.- SiNo -> Muestro "No has introducido un número igual al intervalo
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in); // leer entradas del usuario
    int contFueraIntervalo = 0;         // contador números fuera del intervalo
    boolean igualLimites = false;       // si se ha introducido un límite
    int limInf;                         // límite inferior del intervalo
    int limSup;                         // límite superior del intervalo
    int num;                            // número introducido por el/la usuario/a
    int sumaDentroIntervalo = 0;        // sumatorio números dentro del intervalo

    // Pido los límites y me aseguro que el limInf es menor que el limSup
    do {
      System.out.print("Introduce el límite inferior del intervalo: ");
      limInf = s.nextInt();
      System.out.print("Introduce el límite superior del intervalo: ");
      limSup = s.nextInt();
      if (limInf>limSup) {
        System.out.println("ERROR: El límite inferior debe ser menor que el superior.");
      }
    } while (limInf>limSup);

    // Proceso
    System.out.print("Introduce un número (0, para salir): ");
    num = s.nextInt();
    while (num!=0) {
      if (num>limInf && num<limSup) { // Pertenece al intervalo
        sumaDentroIntervalo += num;
      } else { // No pertenece al intervalo
        contFueraIntervalo++;
        // Número igual a alguno de los límites
        if (num==limInf || num==limSup) {
          igualLimites = true;
        }
      }
      System.out.print("Introduce un número (0, para salir): ");
      num = s.nextInt();
    }

    // Resultados
    System.out.println("\nRESULTADOS:");
    System.out.println("La suma de los número dentro del intervalo es " + sumaDentroIntervalo);
    System.out.println("La cantidad de números fuera del intervalo es " + contFueraIntervalo);
    if (igualLimites) {
      System.out.println("Se ha introducido algún número igual a los límites del intervalo.");
    } else {
      System.out.println("No se ha introducido ningún número igual a los límites del intervalo.");
    }
  }


}

