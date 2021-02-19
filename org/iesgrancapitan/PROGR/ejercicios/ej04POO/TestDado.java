package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

/**
 * Prueba de la clase Dado.
 * 
 * Tiramos un dado 1000 veces y analizamos los resultados.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class TestDado {

  static final int TIRADAS = 1000;

  public static void main(String[] args) {

    int[] ocurrenciasDado1 = {0,0,0,0,0,0};
    int[] ocurrenciasDado2 = {0,0,0,0,0,0};
    int[] ocurrenciasDado3 = {0,0,0,0,0,0};
    Dado dado1 = new Dado();
    Dado dado2 = new DadoTrucado();
    Dado dado3 = new DadoTrucadoConHashMap();

    // trucamos valores 1, 5 y 6
    DadoTrucado dado2Trucado = (DadoTrucado) dado2;  // También: ((DadoTrucado) dado2).trucarValor(3,0.3)
    dado2Trucado.trucar(5, 0.3);
    dado2Trucado.trucar(6, 0.4);
    dado2Trucado.trucar(1, 0.01);

    // trucamos valores 2 y 5
    ((DadoTrucadoConHashMap) dado3).trucar(2, 0.35);
    ((DadoTrucadoConHashMap) dado3).trucar(5, 0.45);

    for (int i = 1; i <= TIRADAS; i++) {
      tirarDado(ocurrenciasDado1, dado1);
      tirarDado(ocurrenciasDado2, dado2);
      tirarDado(ocurrenciasDado3, dado3);
    }  
    mostrarResultados(ocurrenciasDado1, ocurrenciasDado2, ocurrenciasDado3);
  }

  private static void mostrarResultados(int[] ocurrenciasDado1, int[] ocurrenciasDado2, int[] ocurrenciasDado3) {
    System.out.println("Resultados después de tirar los dados " + TIRADAS + " veces:\n");
    System.out.println("\tDado1\t\t\tDado2\t\t\tDado3");
    for (int tirada = 1; tirada <= 6; tirada++) {
      System.out.printf("Cara %d:\t", tirada); 
      mostrarOcurrencias(ocurrenciasDado1, tirada);
      mostrarOcurrencias(ocurrenciasDado2, tirada);
      mostrarOcurrencias(ocurrenciasDado3, tirada);
      System.out.println();
    }
  }

  private static void tirarDado(int[] ocurrenciasDado, Dado dado) {
    dado.tirar(); 
    ++ocurrenciasDado[dado.getCara()-1];
  }
  
  private static void mostrarOcurrencias(int[] ocurrenciasDado1, int tirada) {
    System.out.printf("%3d veces - ", ocurrenciasDado1[tirada-1]); 
    System.out.printf("%5.2f%%\t", (double) 100*ocurrenciasDado1[tirada-1]/TIRADAS);
  }

}
