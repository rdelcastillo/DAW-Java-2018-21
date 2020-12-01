package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

import java.util.Scanner;

/**
 * Programa que sea capaz de insertar un dígito dentro de un número
 * indicando la posición. El nuevo dígito se colocará en la posición indicada y el
 * resto de dígitos se desplazará hacia la derecha. 
 * 
 * Las posiciones se cuentan de izquierda a derecha empezando por el 1. 
 *  
 * Ejemplo:
 * Por favor, introduzca un número entero positivo: 406783
 * Introduzca la posición donde quiere insertar: 3
 * Introduzca el dígito que quiere insertar: 5
 * El número resultante es 4056783.
 * 
 * Ejercicio 44 de "Aprende Java con Ejercicios" (Ed.2019) de Luis José Sánchez González.
 * 
 * En esta versión no usamos el tipo String.
 * 
 * @author Rafael del Castillo
 *
 */

public class Ej18InsertaDigito {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.println("Inserción de dígitos");
    System.out.println("--------------------");
    
    // --------------------------------------------------------------------------------------
    // Pedimos datos, si hay errores terminamos con códigos de error distintos para cada caso
    // --------------------------------------------------------------------------------------
    
    // número introducido
    System.out.print("Por favor, introduzca un número entero positivo: ");  
    long numeroIntroducido = s.nextLong();
    
    // ¿hay error?
    if (numeroIntroducido <= 0) {   
      System.err.println(numeroIntroducido + " no es un entero positivo.");
      System.exit(1); 
    }
    
    // posición
    System.out.print("Introduzca la posición donde quiere insertar: ");     
    int posicion = s.nextInt();
    
    // ¿hay error?
    if (posicion <= 0) {    
      System.err.println("La posición del dígito a insertar tiene que ser mayor que cero.");
      System.exit(2);
    }
    if (Math.pow(10, posicion-1) > numeroIntroducido) {   
      System.err.println(posicion + " es mayor que el número de dígitos que hay.");
      System.exit(3);
    }
    
    // dígito a insertar
    System.out.print("Introduzca el dígito que quiere insertar: ");     
    int digito = s.nextInt();
    
    // ¿hay error?
    if (digito < 0 || digito > 9) {
      System.err.println(digito + " no es un dígito.");
      System.exit(4);
    }
    
    // --------
    // Cálculos
    // --------
    
    // longitud del número introducido
    int longitud = 0;
    long aux = numeroIntroducido;
    
    do {
      aux /= 10;
      longitud++;
    } while (aux > 0);
    
    // potencia de 10 necesaria para separar los dígitos antes y después del dígito a insertar
    long potencia10 = (long)(Math.pow(10, longitud - posicion + 1));
    
    // parte izquierda con el dígito a insertar pegado
    long parteIzquierda = numeroIntroducido / potencia10;
    parteIzquierda = parteIzquierda * 10 + digito;
    
    // parte derecha
    long parteDerecha = numeroIntroducido % potencia10;

    // ---------
    // Resultado
    // ---------
    long resultado = parteIzquierda * potencia10 + parteDerecha;
    System.out.print("El número resultante es " + resultado + ".");

  }

}
