package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej14PrecioUva {

  // ################################################################################
  // La asociación de vinicultores tiene como política fijar un precio inicial
  // al kilo de uva, la cual se clasifica en tipos A y B,  y además en tamaños 1 y 2.
  // Cuando se realiza la venta del producto, ésta es de un solo tipo y tamaño,
  // se requiere determinar cuánto recibirá un productor por la uva que entrega en un
  // embarque, considerando lo siguiente:
  // si es de tipo A, se le cargan 20 céntimos al precio inicial cuando es
  // de tamaño 1; y 30 céntimos si es de tamaño 2.
  // Si es de tipo B, se rebajan 30 céntimos cuando es de tamaño 1, y 50 céntimos
  // cuando es de tamaño 2.
  // Realice un algoritmo para determinar la ganancia obtenida.
  // ################################################################################
  // Análisis
  // El precio final de la uva se calcula multiplicando los kilos recogidos
  // por el precio de cada kilo. El precio por kilo se calcula a partir de un precio
  // inicial sumando o restando una cantidad determinada según el tamaño
  // y el tipo de la uva.
  // Datos de entrada: tipo,tamaño (carácter),
  // precio inicial en céntimos y kilos (entero)
  // Información de salida: Precio final en euros (real) o mensaje de error
  // Variables: precioInicial (entero), kilos (entero), tamano (carácter),
  // tipo (carácter), precio_final (real)
  // ################################################################################
  // Diseño
  // 1.Leer precioInicial,kilos
  // 2. Leer tipo
  // 3. Si tipo no es "A" o "B" devolver mensaje de error.
  // 4. Leer el tamaño
  // 5. Si el tamaño no es "1" o "2" devolver mensaje d error.
  // 6. Si tipo es "A" y tamaño es "1" sumo a precio_inical 20 céntimos.
  // 7. Si tipo es "A" y tamaño es "2" sumo a precio_inical 30 céntimos.
  // 8. Si tipo es "B" y tamaño es "1" resto a precio_inical 20 céntimos.
  // 9. Si tipo es "B" y tamaño es "2" resto a precio_inical 30 céntimos.
  // 10. El precio_final = precioInicial * kilos
  // 11. Muestro precio final/100 euros
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int kilos;
    double precioFinal;
    double precioInicial;
    String tamano;
    String tipo;

    // Pedimos datos
    System.out.print("Introduce el precio inicial por kilos de la UVA (centimos): ");
    precioInicial = s.nextDouble();
    System.out.print("Introduce cuantos kilos has vendido: ");
    kilos = s.nextInt();
    s.nextLine();
    System.out.print("Introduce el tipo de la UVA (A/B): ");
    tipo = s.nextLine();

    // Proceso
    if (!tipo.toUpperCase().equals("A") && !tipo.toUpperCase().equals("B")) {
      System.out.println("Tipo incorrecto");
    } else {
      System.out.print("Introduce el tamaño de la UVA (1/2):");
      tamano = s.nextLine();
      if (!tamano.equals("1")&!tamano.equals("2")) {
        System.out.println("Tamaño incorrecto");
      } else {
        if (tipo.toUpperCase().equals("A")) {
          if (tamano.equals("1")) {
            precioInicial = precioInicial+20;
          } else {
            precioInicial = precioInicial+30;
          }
        } else {
          if (tamano.equals("1")) {
            precioInicial = precioInicial-20;
          } else {
            precioInicial = precioInicial-30;
          }
        }
        precioFinal = precioInicial*kilos;
        System.out.println("La ganancia es "+precioFinal/100+" euros.");
      }
    }
  }


}

