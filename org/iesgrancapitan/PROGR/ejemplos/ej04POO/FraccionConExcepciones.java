package org.iesgrancapitan.PROGR.ejemplos.ej04POO;

/**
 * clase Fraccion de forma que podamos hacer las siguientes operaciones:
 * 
 * Contruir un objeto Fraccion pasándole el numerador y el denominador.
 * Obtener la fracción como cadena de caracteres.
 * Obtener y modificar numerador y denominador. No se puede dividir por cero.
 * Obtener resultado de la fracción (número real).
 * Multiplicar la fracción por un número (el resultado es otro objeto fracción).
 * Multiplicar, sumar y restar fracciones (el resultado es otro objeto fracción).
 * Simplificar la fracción (cambia el objeto actual).
 *
 * Si el denominador es cero lanzaremos una excepción (no marcada).
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class FraccionConExcepciones implements Comparable<FraccionConExcepciones>, Cloneable {
  
  private int numerador;
  private int denominador;
 
  /**
   * Constructor.
   * 
   * No vamos a permitir como denominador cero.
   * 
   * @param numerador
   * @param denominador
   */
  public FraccionConExcepciones(int numerador, int denominador) {
    this.numerador = numerador;
    this.setDenominador(denominador);
  }
  
  public int getNumerador() {
    return numerador;
  }

  public void setNumerador(int numerador) {
    this.numerador = numerador;
  }

  public int getDenominador() {
    return denominador;
  }

  public void setDenominador(int denominador) {
    if (denominador == 0) {
      throw new ArithmeticException("Denominador cero");
    }
    this.denominador = denominador;
  }

  @Override
  public String toString() {
    return this.numerador + "/" + this.denominador;
  }
  
  @Override
  public int compareTo(FraccionConExcepciones o) {
    return this.numerador*o.denominador - o.numerador*this.denominador;
  }
  
  @Override
  public FraccionConExcepciones clone() {
    return new FraccionConExcepciones(this.numerador,this.denominador);
  }
  
  @Override
  public int hashCode() {   // tiene en cuenta que dos fracciones equivalentes son iguales
    final int prime = 31;
    int result = 1;
    int mcd = FraccionConExcepciones.maximoComunDivisor(numerador, denominador);  // para simplificar numerador y denominador
    result = prime * result + denominador/mcd;
    result = prime * result + numerador/mcd;
    return result;
  }

  @Override
  public boolean equals(Object obj) {   // tiene en cuenta que dos fracciones equivalentes son iguales
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FraccionConExcepciones other = (FraccionConExcepciones) obj;
    other.simplificar();    // simplifico para poder comparar fracciones equivalentes
    FraccionConExcepciones copiaSimplificada = this.clone();
    copiaSimplificada.simplificar();
    if (copiaSimplificada.denominador != other.denominador)
      return false;
    if (copiaSimplificada.numerador != other.numerador)
      return false;
    return true;
  }

  public double resultado() {
    return (double) this.numerador / this.denominador;
  }
  
  public FraccionConExcepciones multiplicar(int n) {
    return new FraccionConExcepciones(this.numerador * n, this.denominador);
  }
  
  public FraccionConExcepciones multiplicar(FraccionConExcepciones f) {
    return new FraccionConExcepciones(this.numerador * f.getNumerador(), this.denominador * f.getDenominador());
  }
  
  public FraccionConExcepciones sumar(FraccionConExcepciones f) {
    return new FraccionConExcepciones(this.numerador*f.getDenominador() + f.getNumerador()*this.denominador,
                        this.denominador*f.getDenominador());
  }
  
  public FraccionConExcepciones restar(FraccionConExcepciones f) {
    return this.sumar(f.multiplicar(-1));
  }
  
  /**
   * Simplifica la fracción diviendo numerador y denominador por su MCD.
   */
  public void simplificar() {
    int mcd = FraccionConExcepciones.maximoComunDivisor(this.numerador, this.denominador);
    
    // Simplifico
    this.numerador /= mcd;
    this.denominador /= mcd;
  }
  
  /**
   * @param a
   * @param b
   * @return MCD(a,b)
   */
  public static int maximoComunDivisor(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    
    while (b > 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

}
