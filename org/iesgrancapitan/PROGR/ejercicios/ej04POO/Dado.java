package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

/**
 * Esta clase representa dados tradicionales.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Dado {
  
  private int cara;

  public Dado() {
    this.tirar();
  }
  
  public int getCara() {
    return cara;
  }

  public void tirar() {
    this.cara = 1 + (int) (Math.random() * 6);
  }

}
