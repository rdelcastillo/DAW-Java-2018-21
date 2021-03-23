package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.negocio;

import java.util.Arrays;

public class Ciclista implements Comparable<Ciclista> {

  private String nombre;
  private int dorsal;
  private int[] tiempos = new int[CiclistasVuelta.NUM_ETAPAS];

  public Ciclista(String nombre, int dorsal, int[] tiempos) {
    this.nombre = nombre;
    this.dorsal = dorsal;
    this.tiempos = tiempos;
  }

  public String getNombre() {
    return nombre;
  }

  public int getDorsal() {
    return dorsal;
  }
  
  public int getTiempoEtapa(int etapa) {
    if (etapa < 1 || etapa > CiclistasVuelta.NUM_ETAPAS) {
      throw new ErrorCiclistaException("Número de etapa " + etapa + " inexistente.");
    }
    return tiempos[etapa - 1];
  }
  
  public int getTiempoTotal() {
    int total = 0;
    for (int t: tiempos) {
      total += t;
    }
    return total;
  }

  @Override
  public String toString() {
    return "Ciclista [" + (nombre != null ? "nombre=" + nombre + ", " : "") + "dorsal=" + dorsal
        + ", " + (tiempos != null ? "tiempos=" + Arrays.toString(tiempos) : "") + "]";
  }

  @Override
  public int compareTo(Ciclista o) {
    return this.getTiempoTotal() - o.getTiempoTotal();
  }

}
