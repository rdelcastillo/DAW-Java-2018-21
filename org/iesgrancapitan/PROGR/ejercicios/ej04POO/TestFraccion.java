package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

import java.util.Scanner;

/**
 * Test de la clase Fracción.
 * 
 * @author rafa
 *
 */
public class TestFraccion {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    Fraccion x = new Fraccion(1, 3);
    Fraccion y = new Fraccion(7, 2);

    // Escribimos las dos fracciones
    System.out.println("Fracción 1: " + x + " con numerador " + x.getNumerador()
                                          + " y denominador " + x.getDenominador());
    System.out.println("Fracción 2: " + y + " con numerador " + y.getNumerador() 
                                          + " y denominador " + y.getDenominador() + "\n");
    
    // Cambiamos la primera fracción
    System.out.print("Nuevo numerador y denominador para " + x + ": ");
    x.setNumerador(s.nextInt());
    x.setDenominador(s.nextInt());
    System.out.println("Nueva fracción: " + x);
    x.simplifica();
    System.out.println("Simplificada..: " + x + "\n");
    
    // Probamos resultado
    System.out.println(x + " = " + x.resultado());
    System.out.println(y + " = " + y.resultado());
    System.out.println();

    System.out.println("Probamos operaciones aritméticas:");
    System.out.println(x + " + " + y + " = " + x.sumar(y));
    System.out.println();

    System.out.println(x + " - " + y + " = " + x.restar(y));
    System.out.println();

    System.out.println(x + " * " + y + " = " + x.multiplicar(y));
    System.out.println();

    System.out.println("Probamos multiplicación y división escalar:");
    System.out.println(x + " * 2 = " + x.multiplicar(2));
    System.out.println();
    
    System.out.println("Probamos el máximo común divisor de 45 y 75: " + Fraccion.maximoComunDivisor(45, 75));

    System.out.println("Probamos operaciones relacionales:");
    Fraccion x2 = new Fraccion(x.getNumerador(), x.getDenominador());
    Fraccion x3 = new Fraccion(2*x.getNumerador(), 2*x.getDenominador());     //x y x3 son equivalentes
    System.out.println(x + " == " + x2 + " es " + (x == x2));
    System.out.println(x + ".compareTo(" + y + ") es " + x.compareTo(y));
    System.out.println(y + ".compareTo(" + x + ") es " + y.compareTo(x));
    System.out.println(x + ".compareTo(" + x2 + ") es " + x.compareTo(x2));
    System.out.println(x + ".compareTo(" + x3 + ") es " + x.compareTo(x3));
    System.out.println();
  }

}
