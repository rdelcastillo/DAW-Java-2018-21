package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

/**
 * Clase Cuadrado a partir de la clase Rectángulo.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Cuadrado extends Rectangulo {

  public Cuadrado(int lado) {
    super(lado, lado);
  }
  
  public int getLado() {            // podemos devolver la anchura o la altura, valen lo mismo.
    return this.getAltura();
  }
  
  public void setLado(int lado) {   // deben cambiar la altura y la anchura desde la superclase
    super.setAltura(lado);
    super.setAnchura(lado);
  }
  
  @Override
  public void setAltura(int altura) {   // si cambia la altura también la anchura
    this.setLado(altura);
  }
  
  @Override
  public void setAnchura(int anchura) { // si cambia la anchura también la altura
    this.setLado(anchura);
  }

  @Override
  public String toString() {
    return "Cuadrado [lado=" + getLado() + "]";
  }

}
