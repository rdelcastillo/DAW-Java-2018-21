package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

/**
 * Esta clase representa dados tradicionales.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Dado {
  
  private static final int NUMERO_CARAS_DADO = 6;
  
  private int cara;

  public Dado() {
    this.tirar();
  }
  
  public int getCara() {
    return cara;
  }

  public int tirar() {
    this.cara = 1 + (int) (Math.random() * NUMERO_CARAS_DADO);
    return this.cara;
  }

}
