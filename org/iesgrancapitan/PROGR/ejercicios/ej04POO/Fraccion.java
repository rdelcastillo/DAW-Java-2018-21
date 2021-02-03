package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

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

 * @author Rafael del Castillo Gomariz
 *
 */

public class Fraccion implements Comparable<Fraccion>, Cloneable {
  
  // atributos
  
  private int numerador;
  private int denominador;
  
  //comportamiento
  
  /**
   * Constructor.
   * 
   * No vamos a permitir como denominador cero.
   * 
   * @param numerador
   * @param denominador
   */
  public Fraccion(int numerador, int denominador) {
    this.numerador = numerador;
    this.setDenominador(denominador);
  }
  
  // getters, setters y toString()

  /**
   * @return the numerador
   */
  public int getNumerador() {
    return numerador;
  }

  /**
   * @param numerador the numerador to set
   */
  public void setNumerador(int numerador) {
    this.numerador = numerador;
  }

  /**
   * @return the denominador
   */
  public int getDenominador() {
    return denominador;
  }

  /**
   * @param denominador the denominador to set
   */
  public void setDenominador(int denominador) {
    this.denominador = denominador;
    
    // si el denominador es 0 deberíamos lanzar una excepción
    // pero como aún no las hemos visto, vamos a mostrar un mensaje de error
    if (denominador == 0) {
      System.err.println("El estado del objeto es incorrecto al ser el denominador 0.");
    }
  }

  @Override
  public String toString() {
    return this.numerador + "/" + this.denominador;
  }
  
  @Override
  public int compareTo(Fraccion o) {
    return this.numerador*o.denominador - o.numerador*this.denominador;
  }
  
  @Override
  public Fraccion clone() {
    return new Fraccion(this.numerador,this.denominador);
  }
  
  @Override
  public int hashCode() {   // tiene en cuenta que dos fracciones equivalentes son iguales
    final int prime = 31;
    int result = 1;
    int mcd = Fraccion.maximoComunDivisor(numerador, denominador);  // para simplificar numerador y denominador
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
    Fraccion other = (Fraccion) obj;
    other.simplificar();    // simplifico para poder comparar fracciones equivalentes
    Fraccion copiaSimplificada = this.clone();
    copiaSimplificada.simplificar();
    if (copiaSimplificada.denominador != other.denominador)
      return false;
    if (copiaSimplificada.numerador != other.numerador)
      return false;
    return true;
  }

  
  //resto de métodos
  
  public double resultado() {
    return (double) this.numerador / this.denominador;
  }
  
  public Fraccion multiplicar(int n) {
    return new Fraccion(this.numerador * n, this.denominador);
  }
  
  public Fraccion multiplicar(Fraccion f) {
    return new Fraccion(this.numerador * f.getNumerador(), this.denominador * f.getDenominador());
  }
  
  public Fraccion sumar(Fraccion f) {
    return new Fraccion(this.numerador*f.getDenominador() + f.getNumerador()*this.denominador,
                        this.denominador*f.getDenominador());
  }
  
  public Fraccion restar(Fraccion f) {
    return this.sumar(f.multiplicar(-1));
  }
  
  /**
   * Me simplifica la fracción diviendo numerador y denominador por su MCD.
   */
  public void simplificar() {
    int mcd = Fraccion.maximoComunDivisor(this.numerador, this.denominador);
    
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
