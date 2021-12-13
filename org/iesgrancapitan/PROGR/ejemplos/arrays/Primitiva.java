package org.iesgrancapitan.PROGR.ejemplos.arrays;

/**
 * Este programa genera una jugada de lotería primitiva. 
 * Para ello tenemos que generar ocho números (seis + complementario + reintegro).
 * 
 * Algoritmo:
 * 
 * TOTAL_NUMEROS_A_GENERAR <-- 8
 * numerosGenerados <-- 0
 * números <- {0,0,0,0,0,0,0,0}
 * MIENTRAS numerosGenerados < TOTAL_NUMEROS_A_GENERAR
 *     candidato <-- ALEATORIO(1,49)
 *     seHaGenerado <-- FALSO
 *     PARA i <-- 0 HASTA numerosGenerados-1
 *         SI números[i] == candidato
 *             seHaGenerado <-- VERDADERO
 *             SALIR_PARA
 *         FIN-SI
 *     FIN-PARA
 *     SI NO seHaGenerado
 *         números[numerosGenerados] <-- candidato
 *         numerosGenerados <-- numerosGenerados + 1
 *     FIN-SI
 * FIN-MIENTRAS
 * IMPRIME_PRIMITIVA
 * 
 * @author Rafael del Castillo Gomariz
 *
 */
public class Primitiva {

  private static final int TOTAL_NUMBERS_TO_GENERATE = 8;
  private static final int MAX_NUMBER = 49;
  
  public static void main(String[] args) {    
    int[] numbers = new int[TOTAL_NUMBERS_TO_GENERATE];
    int numbersGenerated = 0;
    
    while (numbersGenerated < TOTAL_NUMBERS_TO_GENERATE) {
      int candidate = (int) (1 + Math.random()*MAX_NUMBER);  // generamos número entre 1 y 49

      // comprobamos si ese número ha sido ya generado 
      boolean theNumberHasBeenGenerated = false;
      for (int i=0; i < numbersGenerated; i++) {
        if (numbers[i] == candidate) {
          theNumberHasBeenGenerated = true;
          break;
        }
      }

      // si el número no ha sido generado lo añadimos
      if (! theNumberHasBeenGenerated) {
        numbers[numbersGenerated] = candidate;
        numbersGenerated++;
      }
    }
    
    // imprimimos el boleto
    System.out.print("Números de la primitiva: ");
    for (int number: numbers) {
      System.out.print(number + " ");
    }
  }

}
