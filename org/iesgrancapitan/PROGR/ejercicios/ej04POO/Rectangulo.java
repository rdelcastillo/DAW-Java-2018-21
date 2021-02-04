package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

/**
 * Clase que represente objetos de tipo Rectángulo, de forma que:
 * 
 * En el estado de cada objeto guardemos el ancho y el alto del mismo. Usaremos estos datos para construirlo.
 * 
 * Las acciones que podemos realizar con objetos de esta clase son: 
 * 
 * - Cálculo del perímetro.
 * - Cálculo del área.
 * - Modificar alto y ancho.
 * - Dibujarlo (con *).
 * - Compararlo con otros.
 * - Devolver una copia del mismo en otro objeto (clonarlo).
 * - Transformar su estado a una cadena (toString()).
 * 
 * En esta versión ignoramos la posibilidad de dimensiones menor o igual a cero.
 * 
 * Versión 1.0.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Rectangulo implements Comparable<Rectangulo>, Cloneable {
  
  private int anchura;
  private int altura;
  
  /**
   * Constructor de la clase. No vamos a permitir dimensiones negativas.
   */
  public Rectangulo(int anchura, int altura) {
    this.anchura = anchura;
    this.altura = altura;
  }

  public int getAnchura() {
    return anchura;
  }

  public void setAnchura(int anchura) {
    this.anchura = anchura;
  }

  public int getAltura() {
    return altura;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  @Override
  public int compareTo(Rectangulo otro) {
    return this.getArea() - otro.getArea();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + altura;
    result = prime * result + anchura;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Rectangulo other = (Rectangulo) obj;
    if (altura != other.altura)
      return false;
    if (anchura != other.anchura)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Rectangulo [ancho=" + anchura + ", alto=" + altura + "]";
  }
  
  @Override
  public Rectangulo clone() {
      return new Rectangulo(this.anchura, this.altura);
  }

  public int getPerimetro() {
    return 2 * (this.anchura + this.altura);
  }
  
  public int getArea() {
    return this.anchura * this.altura;
  }
  
  /**
   * Dibuja el rectángulo.
   */
  public void dibujar() {
    String bordeRectangulo = "**".repeat(this.anchura);
    String centroRectangulo = "**";
    
    if (this.anchura > 1) {
      centroRectangulo += "  ".repeat(this.anchura - 2) + "**";
    }
    
    // Línea superior
    System.out.println(bordeRectangulo);
    
    // Parte central
    for (int i = 2; i < this.altura; i++) {
      System.out.println(centroRectangulo);
    }
    
    // Línea final
    if (this.altura >= 2) {
      System.out.println(bordeRectangulo);
    }

  }
}
