package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

import java.util.HashMap;
import java.util.Map;

/**
 * Dado trucado, para que los dados generados puedan pasar por un dado trucado 
 * hacemos que la clase derive de Dado.
 * 
 * En el estado tendremos los siguientes datos:
 * 
 * - Valor del dado trucado (distinto del atributo de la superclase).
 * - HashMap con los valores del dado que "trucamos" y su probabilidad de aparición.
 * - Probabilidad de la cara sin trucar. Aunque se puede calcular con una función, lo ponemos como método
 *   porque la función tiene que recorrer el vector y hacer cálculos que llevan tiempo. Además así se facilita 
 *   la lectura.
 *      
 * En este código hay comentarios que resultarías redundantes para programadores formados
 * ya que el código es lo suficientemente explicatico, pero como el objetivo es didáctico
 * he considerado oportuno que estén.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class DadoTrucadoConHashMap extends Dado {

  private static final int NUMERO_CARAS_DADO = 6;
  
  private int cara;
  private Map<Integer, Double> carasTrucadas = new HashMap<>();
  private double probabilidadCaraSinTrucar = 0;

  /**
   * Cambia la probabilidad de aparición de uno de los valores del dado.
   * @param cara cara del dado a trucar (entre 1 y 6).
   * @param probabilidad entre 0 y 1. La suma de probabilidades de los valores trucados debe ser inferior a 1.
   * @return éxito de la operación.
   */
  public boolean trucar(int cara, double probabilidad) {
    // ¿Parámetros correctos?
    if (! esCaraCorrecta(cara) || ! esProbabilidadCorrecta(probabilidad)) {   
      return false;
    }
    // Comprobamos si la suma de probabilidades anteriores, con esta, no es > 1
    if (getSumaProbabilidadesCarasTrucadas(cara, probabilidad) <= 1) { 
      setProbabilidadCaraTrucada(cara, probabilidad);
      return true;
    }
    return false;   // no se puede trucar si llegamos aquí
  }

  private void setProbabilidadCaraTrucada(int cara, double probabilidad) {
    this.carasTrucadas.put(cara, probabilidad);
    setProbabilidadCaraSinTrucar(); // hay que recalcular
  }

  private boolean estaSinTrucar() {
    return this.carasTrucadas == null || this.carasTrucadas.size() == 0;
  }

  private boolean esProbabilidadCorrecta(double probabilidad) {
    return probabilidad >= 0 && probabilidad <= 1;
  }

  private boolean esCaraCorrecta(int cara) {
    return cara > 0 && cara <= NUMERO_CARAS_DADO;
  }

  /**
   * Para conocer la probabilidad de una cara no trucada tengo que saber cuantos números 
   * hay trucados y la suma de sus probabilidades. Si están todas trucadas es 0.
   */
  private void setProbabilidadCaraSinTrucar() {
    int carasSinTrucar = NUMERO_CARAS_DADO - this.carasTrucadas.size();
    this.probabilidadCaraSinTrucar = (carasSinTrucar > 0 
        ? ((1 - getSumaProbabilidadesCarasTrucadas()) / carasSinTrucar) : 0);
  }
  
  /**
   * @param cara
   * @param probabilidad
   * @return suma de las probilidades trucadas incluyendo la cara pasada como parámetro. 
   */
  private double getSumaProbabilidadesCarasTrucadas(int cara, double probabilidad) {
    double suma = probabilidad + getSumaProbabilidadesCarasTrucadas();
    
    // Si la cara estaba trucada de antes evitamos que se sume de más
    if (this.carasTrucadas.containsKey(cara)) { 
      suma -= this.carasTrucadas.get(cara);
    } 
    return suma;
  }

  private double getSumaProbabilidadesCarasTrucadas() {
    double suma = 0;
    for (int cara: this.carasTrucadas.keySet()) {
      suma += this.carasTrucadas.get(cara);
    }
    return suma;
  }

  @Override
  public int getCara() {
    return this.cara;
  }

  @Override
  public int tirar() {
    if (estaSinTrucar()) {  // se comporta como un dado normal
      this.cara = super.tirar();
      return this.cara;
    }

    this.cara = getTiradaTrucada();
    return this.cara;
  }

  private int getTiradaTrucada() {
    // Me quedo con la cara del dado cuya probabilidad de aparición, 
    // sumada a las anteriores, supere un valor aleatorio entre 0 y 1
    double aleatorio = Math.random();   
    double sumaProbabilidades = 0;
    
    int cara = 0;
    do {
      ++cara;
      sumaProbabilidades += getProbabilidadCara(cara);
    } while (sumaProbabilidades < aleatorio && cara < NUMERO_CARAS_DADO);
    
    return cara;
  }
  
  private double getProbabilidadCara(int cara) {
    return (this.carasTrucadas.containsKey(cara) 
        ? this.carasTrucadas.get(cara) : this.probabilidadCaraSinTrucar);
  }

}