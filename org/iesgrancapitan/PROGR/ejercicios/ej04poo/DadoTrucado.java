package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

/**
 * Dado trucado, para que los dados generados puedan pasar por un dado trucado 
 * hacemos que la clase derive de Dado.
 * 
 * En el estado tendremos los siguientes datos:
 * 
 * - Cara del dado trucado (distinto del atributo de la superclase).
 * 
 * - Vector que indicará qué valores del dado "trucamos" y su probabilidad de aparición:
 *      * Si en una posición hay una probabilidad menor que cero, ese valor no lo "trucamos".
 *      * Otro probabilidad positiva indica que "trucamos" ese valor.
 *      
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

public class DadoTrucado extends Dado {

  private static final int NUMERO_CARAS_DADO = 6;
  
  private int cara;
  private double[] probabilidades;
  private double probabilidadCaraSinTrucar = 0;

  public DadoTrucado() {}   // no sería necesario ponerlo

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
    
    // Si es el primer valor a trucar damos valor a los atributamos de probabilidades
    if (estaSinTrucar()) {
      generarProbabilidades(cara, probabilidad);
      return true;
    }
    
    // Si ya estaba creado comprobamos si la suma de probabilidades anteriores, con esta, 
    // no es > 1
    if (getSumaProbabilidades(cara, probabilidad) <= 1) { 
      setProbabilidadCaraTrucada(cara, probabilidad);
      return true;
    }
    
    return false;   // no se puede trucar si llegamos aquí
  }

  private boolean estaSinTrucar() {
    return this.probabilidades == null;
  }

  private boolean esProbabilidadCorrecta(double probabilidad) {
    return probabilidad >= 0 && probabilidad <= 1;
  }

  private boolean esCaraCorrecta(int cara) {
    return cara > 0 && cara <= NUMERO_CARAS_DADO;
  }

  /**
   * Creamos el array de probabilidades y calculamos la probabilidad de una 
   * cara sin trucar.
   * @param cara
   * @param probabilidad
   */
  private void generarProbabilidades(int cara, double probabilidad) {
    this.probabilidades = new double[NUMERO_CARAS_DADO];
    for (int i = 0; i < NUMERO_CARAS_DADO; i++) {
      this.probabilidades[i] = -1;
    }
    setProbabilidadCaraTrucada(cara, probabilidad);
  }
  
  private void setProbabilidadCaraTrucada(int cara, double probabilidad) {
    this.probabilidades[cara-1] = probabilidad;
    setProbabilidadCaraSinTrucar();
  }

  /**
   * Para conocer la probabilidad de una cara no trucada tengo que saber cuantos números 
   * hay trucados y la suma de sus probabilidades. 
   */
  private void setProbabilidadCaraSinTrucar() {
    int carasSinTrucar = getCarasSinTrucar();
    this.probabilidadCaraSinTrucar = (carasSinTrucar > 0) 
        ? (1-getSumaVectorProbabilidades()) / carasSinTrucar : 0;
  }
  
  private int getCarasSinTrucar() {
    int carasSinTrucar = 0;
    for (int cara = 1; cara <= NUMERO_CARAS_DADO; cara++) {
      if (! esCaraTrucada(cara)) {
        carasSinTrucar++;
      }
    }
    return carasSinTrucar;
  }
  
  /**
   * Comprobamos si las probabilidades son correctas para trucar la cara del dado.
   * @param cara
   * @param probabilidad
   * @return si es posible trucar.
   */
  private double getSumaProbabilidades(int cara, double probabilidad) {
    if (esCaraTrucada(cara)) { // cara ya trucada de antes, hay que evitar que se sume de más
      return probabilidad + getSumaVectorProbabilidades() - this.probabilidades[cara-1];
    } else {
      return probabilidad + getSumaVectorProbabilidades();
    }
  }

  private boolean esCaraTrucada(int cara) {
    return this.probabilidades[cara-1] >= 0;
  }
  
  private double getSumaVectorProbabilidades() {
    double suma = 0;
    for (double p: this.probabilidades) {
      if (p >= 0) {
        suma += p;
      }
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
    // Me quedo con la cara del dado cuya probabilidad de aparición, sumada a las anteriores, 
    // supere un valor aleatorio entre 0 y 1
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
    return (esCaraTrucada(cara)) 
        ? this.probabilidades[cara-1] : this.probabilidadCaraSinTrucar;
  }

}