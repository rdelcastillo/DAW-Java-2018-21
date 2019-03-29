package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

/**
 * Implementación de la clase Fracción.
 * 
 * @author Rafael del Castillo
 */

public class Fraccion implements Comparable<Fraccion> {
  private int num;      // numerador
  private int den;      // denominador

  /**
   * Constructor de la Fracción.
   * @param x numerador de la fracción.
   * @param y denominador de la fracción, debe ser mayor que cero.
   */
  public Fraccion(int x, int y) {
    setNum(x);
    setDen(y);
  }

  /**
   * @return numerador de la fracción.
   */
  public int getNum() {
    return num;
  }

  /**
   * Asigna numerador a la fracción.
   * @param num numerador de la fracción.
   */
  public void setNum(int num) {
    this.num = num;
  }

  /**
   * @return denominador de la fracción.
   */
  public int getDen() {
    return den;
  }

  /**
   * Asigna denominador a la fracción.
   * @param den denominador de la fracción. Debe ser mayor o igual que cero.
   * @throws ArithmeticException
   */
  public void setDen(int den) throws ArithmeticException {
    if (den == 0) {
      throw new ArithmeticException();
    }
    this.den = den;
  }

  /**
   * Suma fracciones.
   * @param a primer sumando.
   * @param b segundo sumando.
   * @return suma de las fracciones.
   */
  public static Fraccion sumar(Fraccion a, Fraccion b) {
    Fraccion f = new Fraccion(a.num * b.den + b.num * a.den, a.den * b.den);
    f.simplifica();
    return f;
  }
  
  /**
   * Suma una fracción con un entero.
   * @param a primer sumando.
   * @param b segundo sumando.
   * @return suma.
   */
  public static Fraccion sumar(Fraccion a, int b) {
    return sumar(a, new Fraccion(b, 1));
  }
  
  /**
   * Suma un entero con una fracción.
   * @param a primer sumando.
   * @param b segundo sumando.
   * @return suma.
   */
  public static Fraccion sumar(int a, Fraccion b) {
    return sumar(b, a);
  }
  
  /**
   * Incrementa el objeto Fracción actual.
   * @param a fracción a incrementar.
   */
  public void incrementa(Fraccion a) {
    Fraccion f = sumar(this, a);
    this.num = f.num;
    this.den = f.den;
  }
  
  /**
   * Incrementa el objeto Fracción actual.
   * @param a entero a incrementar.
   */
  public void incrementa(int a) {
    incrementa(new Fraccion(a, 1));
  }
  
  /**
   * Resta fracciones.
   * @param a minuendo.
   * @param b sustraendo.
   * @return resta de las fracciones
   */
  public static Fraccion restar(Fraccion a, Fraccion b) {
    Fraccion f = new Fraccion(a.num * b.den - b.num * a.den, a.den * b.den);
    f.simplifica();
    return f;
  }
  
  /**
   * Resta a una fracción un entero.
   * @param a minuendo.
   * @param b sustraendo.
   * @return resta.
   */
  public static Fraccion restar(Fraccion a, int b) {
    return restar(a, new Fraccion(b, 1));
  }
  
  /**
   * Resta a un entero una fracción.
   * @param a minuendo.
   * @param b sustraendo.
   * @return resta.
   */
  public static Fraccion restar(int a, Fraccion b) {
    return restar(new Fraccion(a, 1), b);
  }
  
  /**
   * Decrementa el objeto Fracción actual.
   * @param a fracción a decrementar.
   */
  
  public void decrementa(Fraccion a) {
    Fraccion f = restar(this, a);
    this.num = f.num;
    this.den = f.den;
  }
  
  /**
   * Decrementa el objeto Fracción actual.
   * @param a entero a decrementar.
   */
  
  public void decrementa(int a) {
    Fraccion f = restar(this, a);
    this.num = f.num;
    this.den = f.den;
  }
  
  /**
   * Multiplica fracciones.
   * @param a factor multiplicando.
   * @param b factor multiplicador.
   * @return producto de las fracciones.
   */
  public static Fraccion multiplicar(Fraccion a, Fraccion b) {
    Fraccion f = new Fraccion(a.num * b.num, a.den * b.den);
    f.simplifica();
    return f;
  }
  
  /**
   * Multiplicación escalar.
   * @param a factor multiplicando.
   * @param b factor multiplicador.
   * @return producto.
   */
  public static Fraccion multiplicar(Fraccion a, int b) {
    return multiplicar(a, new Fraccion(b, 1));
  }
  
  /**
   * Multiplicación escalar.
   * @param a factor multiplicando.
   * @param b factor multiplicador.
   * @return producto.
   */
  public static Fraccion multiplicar(int a, Fraccion b) {
    return multiplicar(b, a);
  }
  
  /**
   * Multiplica la fracción actual por la recibida como parámetro y actualiza numerador y denominador.
   * @param a fracción a multiplicar.
   */
  public void multiplica(Fraccion a) {
    Fraccion f = multiplicar(this, a);
    this.num = f.num;
    this.den = f.den;
  }
  
  /**
   * Multiplica la fracción actual por el entero recibido como parámetro y actualiza numerador y denominador.
   * @param a entero a multiplicar.
   */
  public void multiplica(int a) {
    Fraccion f = multiplicar(this, a);
    this.num = f.num;
    this.den = f.den;
  }

  /**
   * Divide fracciones.
   * @param a dividendo.
   * @param b divisor.
   * @return cociente de las fracciones.
   */
  public static Fraccion dividir(Fraccion a, Fraccion b) {
    Fraccion f = new Fraccion(a.num * b.den, a.den * b.num);
    f.simplifica();
    return f;
  }
  
  /**
   * División escalar.
   * @param a dividendo.
   * @param b divisor.
   * @return cociente.
   */
  public static Fraccion dividir(Fraccion a, int b) throws ArithmeticException {
    if (b == 0) {
      throw new ArithmeticException();
    }  
    return dividir(a, new Fraccion(b, 1));
  }
  
  /**
   * División escalar.
   * @param a dividendo.
   * @param b divisor.
   * @return cociente.
   */
  public static Fraccion dividir(int a, Fraccion b) { 
    return dividir(new Fraccion(a, 1), b);
  }
  
  /**
   * Divide el objeto Fracción actual por la fracción recibida como parámetro y actualiza numerador y denominador.
   * @param a
   */
  public void divide(Fraccion a) {
    Fraccion f = dividir(this, a);
    this.num = f.num;
    this.den = f.den;
  }

  /**
   * Divide el objeto Fracción actual por el entero recibido como parámetro y actualiza numerador y denominador.
   * @param a
   */
  public void divide(int a) {
    Fraccion f = dividir(this, a);
    this.num = f.num;
    this.den = f.den;
  }
  
  /**
   * Calcula el máximo común divisor de dos números.
   * @param m primer número.
   * @param n segundo número.
   * @return máximo común divisor.
   */
  private static int mcd(int m, int n) {
    int u = Math.abs(m);
    int v = Math.abs(n);
    if (v == 0) {
      return u;
    }
    int r;
    while (v != 0) {
      r = u % v;
      u = v;
      v = r;
    }
    return u;
  }

  /**
   * Simplifica la fracción.
   */
  public void simplifica() {
    int d = mcd(this.num, this.den);
    this.num /= d;
    this.den /= d;
  }

  /**
   * @return Resultado de dividir numerador entre denominador.
   */
  public double resultado() {
    return (double) this.num / this.den;
  }
  
  public String toString() {
    return this.num + "/" + this.den;
  }
  
  public boolean equals(Fraccion a) {
    return (this.num*a.den == this.den*a.num);   
  }
  
  public boolean equals(int a) {
    return equals(new Fraccion(a, 1));   
  }

  @Override
  public int compareTo(Fraccion a) {
    return (this.num*a.den - a.num*this.den);
  }
  
  public int compareTo(int a) {
    return this.compareTo(new Fraccion(a, 1));
  }
  
}
