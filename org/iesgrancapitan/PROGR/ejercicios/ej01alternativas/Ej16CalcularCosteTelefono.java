package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej16CalcularCosteTelefono {

  // ################################################################################
  // La política de cobro de una compañía telefónica es: cuando se realiza una
  // llamada, el cobro es por el tiempo que ésta dura, de tal forma que los primeros
  // cinco minutos cuestan 1 euro por minuto, los siguientes tres, 80 céntimos,
  // los siguientes dos minutos, 70 céntimos, y a partir del décimo minuto, 50 céntimos.
  // Además, se carga un impuesto de 3 % cuando es domingo, y si es otro día, en turno
  // de mañana, 15 %, y en turno de tarde, 10 %.
  // Realice un algoritmo para determinar cuánto debe pagar por cada concepto
  // una persona que realiza una llamada.
  // ################################################################################
  // Análisis
  // El precio final de la llamada depende del tiempo de la llamada.
  // Los primeros cinco minutos cuestan 1 euro por minuto.
  // Los siguientes 3 minutos, 80 céntimos.
  // Los siguientes 2 minutos, 70 céntimos.
  // A partir del minuto 10, 50 céntimos.
  // Además el coste depende del día u del turno, de esta manera:
  // Si la llamada es el domingo, se suma el 3% al precio final
  // Si la llamada es cualquier otro día por la mañana, se suma el 15% al precio final
  // Si la llamada es cualquier otro día por la tarde, se suma el 10% al precio final
  // Datos de entrada: tiempo de la llamada (entero),
  // si la llamada es en domingo (carácter), turno (carácter)
  // Información de salida: Precio de la llamada en euros (real)
  // Variables: tiempo (entero), esDomingo, turno (carácter), coste (entero)
  // ################################################################################
  // Diseño
  // 1. Leer tiempo
  // 2. Leer si la llamada es en domingo
  // 3. Si no es en domingo, leer el turno (Mañana o Tarde)
  // 4. Si tiempo <5 coste=tiempo*100
  // 5. Si tiempo<8 coste=(tiempo-5)*80 + 500 (el coste de los cinco primeros minutos)
  // 6. Si tiempo<10 coste=(tiempo-8)*70 + 240 (el coste desde el minuto 6 al 8) + 500
  // (el coste de los cinco primeros minutos)
  // 7. Si tiempo>10 coste=(tiempo-10)*50 + 140 (el coste desde el minuto 9 al 10) + 240
  // (el coste desde el minuto 6 al 8) + 500 (el coste de los cinco primeros minutos)
  // 8. Si la llamada es en domingo coste = coste + 3%
  // 9. Si la llamada es otro día por la mañana coste = coste + 15%
  // 10. Si la llamada es otro día por la mañana coste = coste + 10%
  // 11. Mostrar coste final en euros
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double coste; // centimos
    String esDomingo;
    int tiempo;
    String turno="";

    // Pedimos datos
    System.out.print("¿Cuánto tiempo es la llamada?: ");
    tiempo = s.nextInt(); s.nextLine(); // Metemos excepcionalmente dos instrucciones en la misma línea
    System.out.print("¿Es Domingo? (S/N): ");
    esDomingo = s.nextLine();
    if (esDomingo.toUpperCase().equals("N")) {
      System.out.print("¿Qué turno: Mañana o Tarde? (M/T)?: ");
      turno = s.nextLine();
    }

    // Proceso
    if (tiempo<=5) {
      coste = tiempo*100;
    } else if (tiempo<=8) {
      coste = (tiempo-5)*80+500;
    } else if (tiempo<=10) {
      coste = (tiempo-8)*70+240+500;
    } else {
      coste = (tiempo-10)*50+140+240+500;
    }
    // impuestos
    if (esDomingo.toUpperCase().equals("S")) {
      coste += coste*0.03;
    } else if (turno.toUpperCase().equals("M")) {
      coste += coste*0.15;
    } else {
      coste += coste*0.10;
    }
    System.out.println("El coste de la llamada: "+coste/100+" euros.");
  }


}

