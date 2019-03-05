package org.iesgrancapitan.PROGR.Java.ejercicios.ej03funciones;
import java.util.Scanner;

/** 
 * Muestra en pantalla los N primeros números primos. Se pide por teclado la cantidad
 * de números primos que queremos mostrar.
 * 
 * <p>Análisis</p>
 * <p>Tengo que leer la cantidad de números primos que voy a mostrar. La cantidad debe
 * ser positivo. El primer número primo es el 2 (lo muestro) a partir de este son
 * todos impares. Voy probando desde el 3 todos los impares hasta que muestre la
 * cantidad que hemos indicados (necesito un contador).</p>
 * <p>Para comprobar si son primos, los voy dividiendo desde 3 hasta la raíz cuadrada
 * del número, si es divisible por algún número no es primo (necesito un indicador).
 * Datos de entrada: Cantidad de números a mostrar.
 * Información de salida: Los números primos indicados.</p>
 * <p>Variables: cantidadAMostrar, cant_mostradis, divisor (entero), esPrimo(lógico)</p>
 * 
 * <p>Diseño</p>
 * <ol>
 * <li>Leer cantidad de número primos a mostrar, debe ser positivo
 * <li>Muestro el primer número primo, el 2.
 * <li>Inicializo el contador de número mostrados a 1.
 * <li>Inicializo la variable donde guardo el número a probar -> num=3
 * <li>Mientras no haya mostrado la cantidad de número indicados
 * <li>Considero que es primo. Inicializo el indicador -> esPrimo=Verdadero
 * <li>desde el 3 hasta la raíz cuadrada del número
 * <li>Si es divisible -> Ya no es primo -> esPrimo=Falso
 * <li>Si es primo
 * <li>Incremento el contador de números mostrados
 * <li>Escribo el número primo
 * <li>Como son impares, incremento en 2 el número a probar
 * </ol>
 * 
 * @author Rafael del Castillo
 *
 */

public class Ej09Primos {

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int cantidadAMostrar;
    int cantidadMostrados;
    int num;

    // Pedimos datos
    do {
      System.out.print("Ingrese la cantidad de números primos a mostrar: ");
      cantidadAMostrar = s.nextInt();
    } while (cantidadAMostrar<=0);

    // Proceso

    // el primer primo es 2, los otros son todos impares...
    System.out.println("1: 2");
    cantidadMostrados = 1;
    // ...a partir de 3
    num = 3;
    while (cantidadMostrados < cantidadAMostrar) {
      // me muevo solo por los números impares
      if (esPrimo(num)) {
        cantidadMostrados++;
        System.out.println(cantidadMostrados+": "+num);
      }
      num += 2;
    }
  }

  /**
   * Comprueba si el parámetro que recibe es o no un número primo.
   * 
   * @param n número a comprobar
   * 
   * @return <code>True</code> si es primo<br />
   * <code>False</code> si no es primo
   * 
   */
  public static boolean esPrimo(int n) {
    boolean esprimo=true;
    for (int i=3; i<=Math.sqrt(n) && esprimo; i++) {
      esprimo=(n%i!=0);
    }
    return esprimo;
  }
}

