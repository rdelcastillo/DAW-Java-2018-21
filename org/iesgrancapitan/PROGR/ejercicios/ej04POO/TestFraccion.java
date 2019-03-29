package org.iesgrancapitan.PROGR.ejercicios.ej04POO;

/**
 * Test de la clase Fracción.
 * 
 * @author rafa
 *
 */
public class TestFraccion {

  public static void main(String[] args) {
    Fraccion x = new Fraccion(4, 5);
    Fraccion y = new Fraccion(7, 2);

    System.out.println(x + " = " + x.resultado());
    System.out.println(y + " = " + y.resultado());
    System.out.println();
    
    System.out.println("Probamos operaciones aritméticas:");
    System.out.println(x + " + " + y + " = " + Fraccion.sumar(x, y));
    System.out.println(x + " + 1 = " + Fraccion.sumar(x, 1));
    System.out.println("1 +" + x + " = " + Fraccion.sumar(1, x));
    System.out.println();
    System.out.println(x + " - " + y + " = " + Fraccion.restar(x, y));
    System.out.println(x + " - 1 = " + Fraccion.restar(x, 1));
    System.out.println("1 - " + x + " = " + Fraccion.restar(1, x));
    System.out.println();

    System.out.println(x + " * " + y + " = " + Fraccion.multiplicar(x, y));
    System.out.println(x + " / " + y + " = " + Fraccion.dividir(x, y));
    System.out.println();

    System.out.println("Probamos multiplicación y división escalar:");
    System.out.println(x + " * 2 = " + Fraccion.multiplicar(x, 2));
    System.out.println("2 * " + x + " = " + Fraccion.multiplicar(2, x));
    System.out.println(x + " / 2 = " + Fraccion.dividir(x, 2));
    System.out.println("2 / " + x + " = " + Fraccion.dividir(2, x));
    System.out.println();

    System.out.println("Probamos operaciones relacionales:");
    Fraccion x2 = new Fraccion(x.getNum(), x.getDen());
    Fraccion x3 = new Fraccion(2*x.getNum(), 2*x.getDen());     //x y x3 son equivalentes
    System.out.println(x + " == " + x2 + " es " + (x == x2));
    System.out.println(x + ".equals(" + x2 + ") es " + x.equals(x2));
    System.out.println(x + ".equals(" + x3 + ") es " + x.equals(x3));
    System.out.println(x + ".equals(" + y +  ") es " + x.equals(y));
    System.out.println(x + ".compareTo(" + y + ") es " + x.compareTo(y));
    System.out.println(y + ".compareTo(" + x + ") es " + y.compareTo(x));
    System.out.println(x + ".compareTo(" + x2 + ") es " + x.compareTo(x2));
    System.out.println(x + ".compareTo(" + x3 + ") es " + x.compareTo(x3));
    System.out.println();

    Fraccion c = new Fraccion(1,1);
    System.out.println(x + ".equals(1) es " + x.equals(1));
    System.out.println(c + ".equals(1) es " + c.equals(1));
    System.out.println(x + ".compareTo(1) es " + x.compareTo(1));
    System.out.println(c + ".compareTo(1) es " + c.compareTo(1));
    System.out.println();
    
    System.out.println("Modificamos la fracción " + x + ":");
    System.out.print("- Incrementamos 2/3: ");
    x.incrementa(new Fraccion(2,3));
    System.out.println(x);
    System.out.print("- Incrementamos 1:   ");
    x.incrementa(1);
    System.out.println(x);
    System.out.print("- Decrementamos 1:   ");
    x.decrementa(1);
    System.out.println(x);
    System.out.print("- Decrementamos 2/3: ");
    x.decrementa(new Fraccion(2,3));
    System.out.println(x);
    System.out.println();

    System.out.println("Modificamos la fracción " + y + ":");
    System.out.print("- Multiplicamosx2/3: ");
    y.multiplica(new Fraccion(2, 3));
    System.out.println(y);
    System.out.print("- Dividimos por 2/3: ");
    y.divide(new Fraccion(2, 3));
    System.out.println(y);
    System.out.print("- Multiplicamos x 3: ");
    y.multiplica(3);
    System.out.println(y);
    System.out.print("- Dividimos entre 3: ");
    y.divide(3);
    System.out.println(y);
    System.out.println();
    
    // Denominador 0
    System.out.println("Intentamos poner cero en el denominador de " + x);
    try {
      x.setDen(0);
    } catch (ArithmeticException e) {
      System.err.println("ERROR: No se puede poner cero en el denominador");
    }
    finally {
      System.out.println("Resultado: " + x);
    }
    System.out.println();
    
    System.out.println("Intentamos dividir "+ x + " entre cero");
    try {
      x.divide(0);
    } catch (ArithmeticException e) {
      System.err.println("ERROR: No se puede dividir por cero");
    }
    finally {
      System.out.println("Resultado: "+x);
    }
  }

}
