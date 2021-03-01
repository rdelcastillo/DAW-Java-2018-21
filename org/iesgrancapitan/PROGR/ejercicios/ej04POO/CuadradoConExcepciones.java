package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

/**
 * Clase Cuadrado a partir de la clase Rectángulo.
 * 
 * Lanzaremos una excepción (no marcada) cuando intentemos usar los métodos de la clase
 * Rectángulo que puedan alterar la base o la altura (dejaría de ser cuadrado).
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CuadradoConExcepciones extends Rectangulo {

  public CuadradoConExcepciones(int lado) {
    super(lado, lado);
  }
  
  public int getLado() {            // podemos devolver la anchura o la altura, valen lo mismo.
    return this.getAltura();
  }
  
  public void setLado(int lado) {   // deben cambiar la altura y la anchura desde la superclase
    super.setAltura(lado);
    super.setAnchura(lado);
  }
  
  /**
   * Es un error cambiar la altura, es un cuadrado, por lo que lanzamos una excepción "unchecked".
   * No es obligatorio indicar en la cabecera del método el "throws", lo hacemos para una
   * mayor comprensión y legibilidad.
   */
  @Override
  public void setAltura(int altura) throws CuadradoIncorrectoException {
    throw new CuadradoIncorrectoException("No se puede cambiar la altura del cuadrado");
  }
  
  /**
   * Es un error cambiar la anchura, es un cuadrado, por lo que lanzamos una excepción "unchecked".
   * No es obligatorio indicar en la cabecera del método el "throws", lo hacemos para una
   * mayor comprensión y legibilidad.
   */
  @Override
  public void setAnchura(int anchura) throws CuadradoIncorrectoException { 
    throw new CuadradoIncorrectoException("No se puede cambiar la anchura del cuadrado");
  }

  @Override
  public String toString() {
    return "Cuadrado [lado=" + getLado() + "]";
  }

}
