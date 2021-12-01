package org.iesgrancapitan.PROGR.ejemplos.secuenciales;
/**
*
* Ejemplo de uso de ++ y --
*
* @author Rafael del Castillo
*/

public class EjemploMasMas {
  public static void main(String[] args) {
    int n1=10;
    int n2;

    System.out.println("Valor de 'n1': " + n1 +"\n");

    System.out.println("Ahora ejecutaremos 'n1++' y n2=n1 (Pulsa Intro)");
    System.console().readLine(); //Esperar a pulsar Intro
    n1++;
    n2=n1;
    System.out.println("Valor de 'n1' y 'n2': " + n1 +" " + n2 +"\n");

    System.out.println("Ahora muestro el resultado de la expresión 'n1++' (Pulsa Intro)");
    System.console().readLine(); //Esperar a pulsar Intro
    System.out.println("Valor de '++n1': " + ++n1 + "\n");
    System.out.println("Valor de 'n1': " + n1 +"\n");

    System.out.println("Ahora muestro el resultado de la expresión 'n1++' (Pulsa Intro)");
    System.console().readLine(); //Esperar a pulsar Intro
    System.out.println("Valor de 'n1++': " + n1++ + "\n");
    System.out.println("Valor de 'n1': " + n1 +"\n");
  }
}
