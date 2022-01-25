package org.iesgrancapitan.PROGR.ejemplos.poo;

public class JuegoAdivina {
  
  private int guess;
  private int tries;
  
  public JuegoAdivina() {
    guess = 1 + (int) (Math.random()*10);
  }
  
  public boolean check(int n) {
    tries++;
    return (n == guess);
  }

  public int getTries() {
    return tries;
  }

}
