package org.iesgrancapitan.PROGR.ejercicios.ej03funciones.matematicas;

/**
 * <p>Biblioteca de funciones matemáticas.</p>
 * <ol>
 * <li>esCapicua: Devuelve verdadero si el número que se pasa como parámetro es capicúa y falso en
 * caso contrario.</li>
 * 
 * <li>esPrimo: Devuelve verdadero si el número que se pasa como parámetro es primo y falso en caso
 * contrario.</li>
 * 
 * <li>siguientePrimo: Devuelve el menor primo que es mayor al número que se pasa como parámetro.</li>
 * 
 * <li>potencia: Dada una base y un exponente devuelve la potencia.</li>
 * 
 * <li>digitos: Cuenta el número de dígitos de un número entero.</li>
 * 
 * <li>voltea: Le da la vuelta a un número.</li>
 * 
 * <li>digitoN: Devuelve el dígito que está en la posición n de un número entero. Se empieza contando
 * por el 0 y de izquierda a derecha.</li>
 * 
 * <li>posicionDeDigito: Da la posición de la primera ocurrencia de un dígito dentro de un número
 * entero. Si no se encuentra, devuelve -1.</li>
 * 
 * <li>quitaPorDetras: Le quita a un número n dígitos por detrás (por la derecha).</li>
 * 
 * <li>quitaPorDelante: Le quita a un número n dígitos por delante (por la izquierda).</li>
 * 
 * <li>pegaPorDetras: Añade un dígito a un número por detrás.</li>
 * 
 * <li>pegaPorDelante: Añade un dígito a un número por delante.</li>
 * 
 * <li>trozoDeNumero: Toma como parámetros las posiciones inicial y final dentro de un número y
 * devuelve el trozo correspondiente.</li>
 * 
 * <li>juntaNumeros: Pega dos números para formar uno.</li>
 * </ol>
 * <p>Ejercicios del libro "Aprende Java con Ejercicios. Edición 2019".</p>
 * 
 * @author Clase 1ºDAW IES Gran Capitán, curso 2019/20.
 *
 */
public class FuncionesEj1a14 {

  /**
   * Devuelve verdadero si el número que se pasa como parámetro es primo y falso en caso contrario.
   * 
   * @param numero número a comprobar
   * @return verdadero o falso
   */
  public static boolean esPrimo(int numero) {
    // casos triviales
    if (numero == 2) { // 2 es primo
      return true;
    } else if (numero <= 1 || numero % 2 == 0) { // par no es primo
      return false;
    }
    // proceso normal
    for (int i = 3; i <= Math.sqrt(numero); i += 2) {
      if (numero % i == 0) {
        return false;
      }
    }
    return true; // si llego aquí el número es primo
  }

  /**
   * Devuelve el menor primo que es mayor al número que se pasa como parámetro.
   * 
   * @param numero número a comprobar
   * @return primo
   */
  public static int siguientePrimo(int numero) {
    int primoSiguiente = numero + 1; // candidato a primo siguiente
    while (!esPrimo(primoSiguiente)) { // proceso para encontrar el primo siguiente
      primoSiguiente++;
    }
    return primoSiguiente;
  }
  
  /**
   * Dada una base y un exponente devuelve la potencia.
   * @param base
   * @param exponente
   * @return base ** exponente
   */
  public static double potencia(double base, int exponente) {
    double resultado = 1;
    for (int n = 1; n <= Math.abs(exponente); n++) {
      resultado *= base;
    }
    return (exponente >= 0) ? resultado: 1/resultado;
  }

  /**
   * Cuenta el número de dígitos de un número entero.
   * 
   * @param n
   * @return número de digitos de num
   */
  public static int digitos(int numero) {
    int digitos = 0;
    int n = numero;    // podríamos haber usado numero, pero no es conveniente
    do {
      digitos++;
      n = n / 10;
    } while (n != 0);
    return digitos;
  }
  
  /**
   * Le quita a un número n dígitos por detrás (por la derecha).
   * @param numero número al que hay que quitar los dígitos.
   * @param digitosAQuitar número de dígitos a quitar por detrás.
   * @return número después de haberle quitado por detrás los dígitos.
   */
  public static int quitaPorDetras(int numero, int digitosAQuitar) {
    return numero / (int) potencia(10, digitosAQuitar);
  }
  
  /**
   * Le quita a un número n dígitos por delante (por la izquierda).
   * @param numero número al que hay que quitar los dígitos.
   * @param digitosAQuitar número de dígitos a quitar por delante.
   * @return número después de haberle quitado por delante los dígitos.
   */
  public static int quitaPorDelante(int numero, int digitosAQuitar) {
    return numero % (int) potencia(10, digitos(numero)-digitosAQuitar);
  }
  
  /**
   * Toma como parámetros las posiciones inicial y final dentro de un número y devuelve el trozo correspondiente.
   * @param numero
   * @param inicio
   * @param fin
   * @return número troceado
   */
  public static int trozoDeNumero(int numero, int inicio, int fin) {
    int numeroSinTrozoFinal = quitaPorDetras(numero, digitos(numero)-fin);
    int numeroTroceado = quitaPorDelante(numeroSinTrozoFinal, inicio);
    return numeroTroceado;
  }
  
  /**
   * Devuelve el dígito que está en la posición n de un número entero. Se empieza contando por el 0 y de izquierda a derecha.
   * @param numero
   * @param posicion
   * @return
   */
  public static int digitoN(int numero, int posicion) {
    return trozoDeNumero(numero, posicion, posicion+1);
  }
  
  /**
   * Da la posición de la primera ocurrencia de un dígito dentro de un número entero. Si no se encuentra, devuelve -1.
   * @param numero
   * @param digito
   * @return posición del dígito, -1 si no se encuentra.
   */
  public static int posicionDeDigito(int numero, int digito) {
    for (int posicion = 0; posicion < digitos(numero); posicion++) {
      if (digitoN(numero, posicion) == digito) {
        return posicion;
      }
    }
    return -1;
  }
  
  /**
   * Añade un dígito a un número por detrás.
   * @param numero
   * @param digito 
   * @return número resultado.
   */
  public static int pegaPorDetras(int numero, int digito) {
    return numero * 10 + digito;
  }
  
  /**
   * Añade un dígito a un número por delante.
   * @param numero
   * @param digito 
   * @return número resultado.
   */
  public static int pegaPorDelante(int numero, int digito) {
    return digito * (int) potencia(10, digitos(numero)) + numero;
  }
  
  /**
   * Pega dos números para formar uno.
   * @param numero1
   * @param numero2
   * @return número resultado de unir los dos números.
   */
  public static int juntaNumeros(int numero1, int numero2) {
    int numeroResultado = numero1;
    for (int posicion = 0; posicion < digitos(numero2); posicion++) {
      numeroResultado = pegaPorDetras(numeroResultado, digitoN(numero2, posicion));
    }
    return numeroResultado;
  }
  
  /**
   * Le da la vuelta a un número.
   * 
   * @param numero número a voltear
   * @return número volteado
   */
  public static int voltea(int numero) {
    int numeroVolteado = digitoN(numero, digitos(numero)-1);
    for (int posicion = digitos(numero)-2; posicion >= 0; posicion--) {
      numeroVolteado = pegaPorDetras(numeroVolteado, digitoN(numero, posicion));
    }
    return numeroVolteado;
  }
  
  /**
   * Devuelve verdadero si el número que se pasa como parámetro es capicúa y falso en caso contrario.
   * @param numero
   * @return true si es capicúa, falso en caso contrario.
   */
  public static boolean esCapicua(int numero) {
    return numero == voltea(numero);
  }
 
}
