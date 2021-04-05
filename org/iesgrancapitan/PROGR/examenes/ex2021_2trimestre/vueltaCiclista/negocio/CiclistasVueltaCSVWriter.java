package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.vueltaCiclista.negocio;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CiclistasVueltaCSVWriter {
  
  private static final String CABECERA = "Etapa,Dorsal,Nombre,Tiempo";
  
  CiclistasVuelta ciclistasVuelta;
  PrintWriter fichero;

  CiclistasVueltaCSVWriter(CiclistasVuelta ciclistasVuelta) {
    this.ciclistasVuelta = ciclistasVuelta;
  }

  void guarda(String nombreFichero) throws FileNotFoundException {
    fichero = new PrintWriter(nombreFichero); 
    fichero.println(CABECERA);
    for (int etapa = 1; etapa <= CiclistasVuelta.NUM_ETAPAS; etapa++) {
      Ciclista ganador = ciclistasVuelta.ganadorEtapa(etapa);
      guardaGanadorEtapa(ganador, etapa);
    }
    fichero.close();
    
  }

  private void guardaGanadorEtapa(Ciclista ganador, int etapa) {
    fichero.println(etapa + "," + ganador.getDorsal() + ",\"" 
                  + ganador.getNombre() + "\",\"" 
                  + CiclistasVuelta.tiempoFormateado(ganador.getTiempoEtapa(etapa)) + "\"");
  }

}
