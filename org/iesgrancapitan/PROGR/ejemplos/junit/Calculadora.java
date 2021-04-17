package org.iesgrancapitan.PROGR.ejemplos.junit;

public class Calculadora {
  int resultado;

  public Calculadora()
  {
    resultado=0;	
  }

  public int sumar(int valor)
  {
    resultado += valor;
    return resultado;
  }

  public int restar(int valor)
  {
    resultado -= valor;
    return resultado;
  }

  public int getResultado()
  {
    return resultado;
  }
}
