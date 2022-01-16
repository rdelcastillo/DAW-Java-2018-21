package org.iesgrancapitan.PROGR.ejercicios.ej03funciones;

import org.iesgrancapitan.PROGR.ejercicios.ej03funciones.matematicas.FuncionesEj1a14;

/**
 * Probamos la clase de funciones de los ejercicios 1 a 14.
 * 
 * Para hacer las pruebas se usan funciones con varargs a las que les pasamos los parámetros 
 * de las funciones a evaluar.
 * 
 * @author rafa
 *
 */

public class PruebaFuncionesEjercicios1a14 {
  public static void main(String[] args) {
    pruebaEsPrimo(2, 4, 9, 17, -4, -17, 787);
    pruebaSiguientePrimo(2, 4, 9, 17, -4, -17);
    pruebaPotencia(new double[] {2,8}, new double[] {2,-1}, new double[] {158,0}, new double[] {0.5,-2});
    pruebaDigitos(200, 49, -9987, -17, 56, 11117);
    pruebaQuitaPorDetras(new int[] {158,1}, new int[] {-25687,2}, new int[] {389887,4});
    pruebaQuitaPorDelante(new int[] {158,1}, new int[] {-25687,2}, new int[] {389887,4});
    pruebaVoltea(2, 23, 327, 2098, -234);
    pruebaTrozoDeNumero(new int[] {158,0,2}, new int[] {5878,1,3}, new int[] {9958,2,4}, 
        new int[] {9944658,3,6}, new int[] {99333358,2,7});
    pruebaPegaPorDetras(new int[] {158,0}, new int[] {18,4}, new int[] {0,9});
    pruebaPegaPorDelante(new int[] {158,0}, new int[] {18,4}, new int[] {0,9});
    pruebaDigitoN(new int[] {158,0}, new int[] {798,1}, new int[] {986,2});
    pruebaPosicionDeDigito(new int[] {158,8}, new int[] {798,9}, new int[] {986,3});
    pruebaJuntaNumeros(new int[] {158,10}, new int[] {798,199}, new int[] {86,1873});
    pruebaEsCapicua(25, 313, 2222, 3223, -3883, 578);
  }

  private static void pruebaEsPrimo(int... parametros) {
    String nombreFuncion = "esPrimo";
    printFuncion(nombreFuncion);
    for (int n: parametros) {
      System.out.println(funcion(nombreFuncion, n) + " --> " + FuncionesEj1a14.esPrimo(n));
    }
  }

  private static void pruebaSiguientePrimo(int... parametros) {
    String nombreFuncion = "siguientePrimo";
    printFuncion(nombreFuncion);
    for (int n: parametros) {
      System.out.println(funcion(nombreFuncion, n) + " --> " + FuncionesEj1a14.siguientePrimo(n));
    }
  }
  
  private static void pruebaPotencia(double[]... conjuntoParametros) {
    String nombreFuncion = "potencia";
    printFuncion(nombreFuncion);
    for (double[] parametros : conjuntoParametros) {
      double base = parametros[0];
      int exponente = (int) parametros[1]; 
      System.out.println(nombreFuncion + "(" + base + ", " + exponente + ") --> " 
          + FuncionesEj1a14.potencia(base, exponente));
    }     
  }
  
  private static void pruebaDigitos(int... parametros) {
    String nombreFuncion = "digitos";
    printFuncion(nombreFuncion);
    for (int n: parametros) {
      System.out.println(funcion(nombreFuncion, n) + " --> " + FuncionesEj1a14.digitos(n));
    }    
  }

  private static void pruebaQuitaPorDetras(int[]... conjuntoParametros) {
    String nombreFuncion = "quitaPorDetras";
    printFuncion(nombreFuncion);
    for (int[] parametros : conjuntoParametros) {
      int numero = parametros[0];
      int digitosAQuitar = parametros[1];
      System.out.println(funcion(nombreFuncion, numero, digitosAQuitar) + " --> " 
          + FuncionesEj1a14.quitaPorDetras(numero, digitosAQuitar));
    }     
  }
  
  private static void pruebaQuitaPorDelante(int[]... conjuntoParametros) {
    String nombreFuncion = "quitaPorDelante";
    printFuncion(nombreFuncion);
    for (int[] parametros : conjuntoParametros) {
      int numero = parametros[0];
      int digitosAQuitar = parametros[1];
      System.out.println(funcion(nombreFuncion, numero, digitosAQuitar) + " --> " 
          + FuncionesEj1a14.quitaPorDelante(numero, digitosAQuitar));
    }     
  }
  
  private static void pruebaVoltea(int... parametros) {
    String nombreFuncion = "voltea";
    printFuncion(nombreFuncion);
    for (int n: parametros) {
      System.out.println(funcion(nombreFuncion, n) + " --> " + FuncionesEj1a14.voltea(n));
    }    
  }

  private static void pruebaTrozoDeNumero(int[]... conjuntoParametros) {
    String nombreFuncion = "trozoDeNumero";
    printFuncion(nombreFuncion);
    for (int[] parametros : conjuntoParametros) {
      int numero = parametros[0];
      int inicio = parametros[1];
      int fin = parametros[2];
      System.out.println(funcion(nombreFuncion, numero, inicio, fin) + " --> " + 
          FuncionesEj1a14.trozoDeNumero(numero, inicio, fin));
    }    
  }

  private static void pruebaPegaPorDetras(int[]... conjuntoParametros) {
    String nombreFuncion = "pegaPorDetras";
    printFuncion(nombreFuncion);
    for (int[] parametros : conjuntoParametros) {
      int numero = parametros[0];
      int digitoAPegar = parametros[1];
      System.out.println(funcion(nombreFuncion, numero, digitoAPegar) + " --> " 
          + FuncionesEj1a14.pegaPorDetras(numero, digitoAPegar));
    }
  }

  private static void pruebaPegaPorDelante(int[]... conjuntoParametros) {
    String nombreFuncion = "pegaPorDelante";
    printFuncion(nombreFuncion);
    for (int[] parametros : conjuntoParametros) {
      int numero = parametros[0];
      int digitoAPegar = parametros[1];
      System.out.println(funcion(nombreFuncion, numero, digitoAPegar) + " --> " 
          + FuncionesEj1a14.pegaPorDelante(numero, digitoAPegar));
    }
  }

  private static void pruebaDigitoN(int[]... conjuntoParametros) {
    String nombreFuncion = "digitoN";
    printFuncion(nombreFuncion);
    for (int[] parametros : conjuntoParametros) {
      int numero = parametros[0];
      int posicion = parametros[1];
      System.out.println(funcion(nombreFuncion, numero, posicion) + " --> " 
          + FuncionesEj1a14.digitoN(numero, posicion));
    }
  }

  private static void pruebaPosicionDeDigito(int[]... conjuntoParametros) {
    String nombreFuncion = "posicionDeDigito";
    printFuncion(nombreFuncion);
    for (int[] parametros : conjuntoParametros) {
      int numero = parametros[0];
      int digito = parametros[1];
      System.out.println(funcion(nombreFuncion, numero, digito) + " --> " 
          + FuncionesEj1a14.posicionDeDigito(numero, digito));
    }
  }

  private static void pruebaJuntaNumeros(int[]... conjuntoParametros) {
    String nombreFuncion = "juntaNumeros";
    printFuncion(nombreFuncion);
    for (int[] parametros : conjuntoParametros) {
      int numero1 = parametros[0];
      int numero2 = parametros[1];
      System.out.println(funcion(nombreFuncion, numero1, numero2) + " --> " 
          + FuncionesEj1a14.juntaNumeros(numero1, numero2));
    }
  }

  private static void pruebaEsCapicua(int... parametros) {
    String nombreFuncion = "esCapicua";
    printFuncion(nombreFuncion);
    for (int n: parametros) {
      System.out.println(funcion(nombreFuncion, n) + " --> " + FuncionesEj1a14.esCapicua(n));
    }  
  }
  
  public static void printFuncion(String funcion) {
    System.out.println("\nPrueba función " + funcion + "()");
    System.out.println("-".repeat(funcion.length() + 17));
  }

  private static String funcion(String nombreFuncion, int ... parametros) {
    String nombre = nombreFuncion + "(" + parametros[0];
    for (int i = 1; i < parametros.length; i++) {
      nombre += ", " + parametros[i];
    }
    nombre += ")";
    return nombre;
  }

}
