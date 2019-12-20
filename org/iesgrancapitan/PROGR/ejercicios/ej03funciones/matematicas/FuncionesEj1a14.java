package org.iesgrancapitan.PROGR.ejercicios.ej03funciones.matematicas;

/**
 * Biblioteca de funciones matemáticas que contiene:
 * 
 * 1. esCapicua: Devuelve verdadero si el número que se pasa como parámetro es capicúa 
 * y falso en caso contrario.
 * 
 * 2. esPrimo: Devuelve verdadero si el número que se pasa como parámetro es primo y 
 * falso en caso contrario.
 * 
 * 3. siguientePrimo: Devuelve el menor primo que es mayor al número que se pasa como 
 * parámetro.
 * 
 * 4. potencia: Dada una base y un exponente devuelve la potencia.
 * 
 * 5. digitos: Cuenta el número de dígitos de un número entero.
 * 
 * 6. voltea: Le da la vuelta a un número.
 * 
 * 7. digitoN: Devuelve el dígito que está en la posición n de un número entero. 
 * Se empieza contando por el 0 y de izquierda a derecha.
 * 
 * 8. posicionDeDigito: Da la posición de la primera ocurrencia de un dígito dentro 
 * de un número entero. Si no se encuentra, devuelve -1.
 * 
 * 9. quitaPorDetras: Le quita a un número n dígitos por detrás (por la derecha).
 * 
 * 10. quitaPorDelante: Le quita a un número n dígitos por delante (por la izquierda).
 * 
 * 11. pegaPorDetras: Añade un dígito a un número por detrás.
 * 
 * 12. pegaPorDelante: Añade un dígito a un número por delante.
 * 
 * 13. trozoDeNumero: Toma como parámetros las posiciones inicial y final dentro de un 
 * número y devuelve el trozo correspondiente.
 * 
 * 14. juntaNumeros: Pega dos números para formar uno.
 * 
 * Ejercicios del libro "Aprende Java con Ejercicios. Edición 2019".
 * 
 * @author Clase 1ºDAW IES Gran Capitán, curso 2019/20.
 *
 */
public class FuncionesEj1a14 {
  
  /**
   * Devuelve verdadero si el número que se pasa como parámetro es primo y falso en
   * caso contrario.
   * @param n número a comprobar
   * @return verdadero o falso
   */
  public static boolean esPrimo(int n) {
    boolean creoQueEsPrimo = true;
    
    // casos triviales 
    if (n==2) { // 2 es primo
      return true;
    } else if (n<=1 || n%2==0) { // par no es primo
      return false;
    }
    
    // proceso
    for (int i=3; i<=Math.sqrt(n) && creoQueEsPrimo; i+=2) {
      if (n%i == 0) {
        creoQueEsPrimo = false;
      }
    }

    // fin
    return creoQueEsPrimo;    
  }
  
  /**
   * Devuelve el menor primo que es mayor al número que se pasa como parámetro.
   * 
   * @param n número a comprobar
   * @return primo
   */
  public static int siguientePrimo(int n) {
    int primoSiguiente = n+1;   // candidato a primo siguiente
    
    // proceso para encontrar elprimo siguiente
    while (!esPrimo(primoSiguiente)) {
      primoSiguiente++;
    }
    
    // fin
    return primoSiguiente;
  }

  /**
   * Le da la vuelta a un número.
   * @param n número a voltear
   * @return número volteado
   */
  public static int voltea(int n) {
    String numero = Integer.toString(Math.abs(n));
    String volteado = "";

    // volteo la cadena numérica sin signo
    for (int i=numero.length()-1; i>=0; i--) {
      volteado += numero.substring(i,i+1);
    }
    
    // ahora tengo cuenta el signo para la devolución
    if (n>=0) {
      return Integer.parseInt(volteado);
    } else {
      return -1 * Integer.parseInt(volteado);
    }
  }
}
