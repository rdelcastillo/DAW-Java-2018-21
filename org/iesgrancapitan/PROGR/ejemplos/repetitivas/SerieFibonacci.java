package org.iesgrancapitan.PROGR.ejemplos.repetitivas;

public class SerieFibonacci {
  
  static final int N = 10;

  public static void main(String[] args) {
    int last = 1;
    int penultimate = 0;
    
    System.out.print("0 1");
    for (int i=3; i<=N; i++) {
      int current = last + penultimate;
      System.out.print(" " + current);
      penultimate = last;
      last = current;
    }

  }

}
