package org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.presentacion;

/**
 * Examen 2º trimestre del curso 2020/21.
 * 
 * Tenemos guardado en un fichero CSV las calificaciones (enteras) obtenidas por unos estudiantes
 * en la evaluación de 5 ejercicios entregados semanalmente (cuando un ejercicio no se ha entregado,
 * la calificación es −1). 
 * 
 * Haz un programa en Java que muestre y ejecute el siguiente menú:
 * 
 * 1. Cargar en memoria (arraylist) los datos de un fichero CSV y ordenarlos por el nombre del estudiante.
 * 2. Mostrar la cantidad de estudiantes que han entregado todos los ejercicios y tienen una media superior
 *    o igual a un 5.
 * 3. Mostrar el número de estudiantes que han presentado un ejercicio dado.
 * 4. Dado el número de un ejercicio, mostrar la nota media obtenida por los estudiantes que lo presentaron.
 * 5. Dado el número de un ejercicio, mostrar la nota más alta obtenida y quién (quienes) la obtuvo (obtuvieron).
 * 6. Mostrar la media más alta y quién (quienes) la obtuvo (obtuvieron). Para que la media sea distinta de 0 
 *    tiene que haber entregado TODOS los ejercicios.
 * 7. Mostrar la relación de estudiantes y sus notas.
 * 8. Guardar en un fichero XML las calificaciones de cada estudiante y su media.
 * 9. Finalizar.
 * 
 * A tener en cuenta:
 * 
 * - Si no se ha cargado en memoria los datos del fichero no funcionan las demás opciones.
 * - Cuando una opción necesite saber a qué ejercicio nos referimos damos su número (empezamos en 1).
 * - La media de un estudiante es 0 si no se han entregado todos los ejercicios.
 * - Usa un clase para los datos del estudiante y otra para gestionar el menú.
 * - Si los ficheros dan errores al abrirlos adviértelo al usuario y que el programa continúe.
 * - Recuerda todo lo que hemos visto en clase acerca de la legibilidad y refactorización.
 * 
 * @author Rafael del Castillo
 */

import java.io.IOException;
import java.util.Scanner;
import org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.negocio.Calificaciones;
import org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.negocio.Estudiante;
import org.iesgrancapitan.PROGR.ejemplos.agenda.AddressBookXMLException;
import org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.negocio.CSVEstudiantesException;
import org.iesgrancapitan.PROGR.examenes.ex2021_2trimestre.utiles.Menu;

public class Calificaciones2021 {

  private static Calificaciones estudiantes = new Calificaciones();

  public static void main(String[] args) {
    Menu menu = new Menu("CALIFICACIONES", 
        "Cargar datos de un CSV",
        "Mostrar número de estudiantes con todo entregado y media >= 5",
        "Mostrar número de estudiantes que han presentado un ejercicio dado",
        "Mostrar nota media de los estudiantes que presentaron un ejercicio",
        "Mostrar la nota más alta obtenida en un ejercicio",
        "Mostrar la nota media más alta",
        "Mostrar calificaciones",
        "Guardar notas en XML",
        "Finalizar.");

    while (true) {
      int opcion = menu.elegir();
      switch (opcion) {
        case 1: 
          cargaNotasCSV(); break;
        case 2: case 3: case 4: case 5: case 6: case 7: case 8:
          if (! estudiantes.isEmpty()) {
            switch (opcion) {
              case 2: muestraNumeroEstudiantesEntregaTodoConNotaMayor5(); break;
              case 3: muestraNumeroEstudiantesPresentaEjercicio(); break;
              case 4: muestraNotaMediaEjercicio(); break;
              case 5: muestraNotaMasAltaEjercicio(); break;
              case 6: muestraNotaMasAlta(); break;
              case 7: muestraNotas(); break;
              case 8: guardaNotasXML(); break;
            }
          } else {
            System.out.println("Primero debe cargar los datos...\n");
          }
          break;
        default: 
          System.out.println("Adiós!!!");
          System.exit(0);
      }
    }

  }

  private static void cargaNotasCSV() {
    Calificaciones estudiantesCopia = estudiantes;
    String nombreFichero = pideNombreFichero();

    try {
      estudiantes = new Calificaciones();
      estudiantes.cargaCSV(nombreFichero);

    } catch (IOException | CSVEstudiantesException e) {
      estudiantes = estudiantesCopia;
      System.err.println("Error al abrir " + nombreFichero + ": " + e.getMessage() + "\n");
    }

  }

  private static void muestraNumeroEstudiantesEntregaTodoConNotaMayor5() {
    int n = estudiantes.getNumeroEstudiantesNotaMayorIgual(5);   
    System.out.println("El número de estudiantes con todos los ejercicios entregados "
        + "y una media de 5 ó mas es de " + n + "\n");
  }

  private static void muestraNumeroEstudiantesPresentaEjercicio() {
    int ejercicio = pideEjercicio();
    int entregas = estudiantes.getNumeroEntregasEjercicio(ejercicio);

    System.out.println("El número de estudiantes que ha presentado el ejercicio "
        + ejercicio + " ha sido " + entregas + "\n");
  }


  private static void muestraNotaMediaEjercicio() {
    int ejercicio = pideEjercicio();
    double media = estudiantes.getMediaEjercicio(ejercicio);

    System.out.println("La nota media de quienes han entregado el ejercio "
        + ejercicio + " es de " + media + "\n");
  }

  private static void muestraNotaMasAltaEjercicio() {
    int ejercicio = pideEjercicio();
    double notaMasAlta = estudiantes.getNotaMaximaEjercicio(ejercicio);

    System.out.println("La nota más alta del ejercicio " + ejercicio + " ha sido " + notaMasAlta
                     + " y la ha obtenido:");
    for (int i = 1; i <= estudiantes.size(); i++) {
      Estudiante e = estudiantes.getEstudiante(i);
      if (e.getNota(ejercicio) == notaMasAlta) {
        System.out.println(e.getNombre());
      }
    }
    System.out.println();
  }

  private static void muestraNotaMasAlta() {
    double notaMasAlta = estudiantes.getNotaMaxima();
    
    System.out.println("La nota más alta del ha sido " + notaMasAlta
                     + " y la ha obtenido:");
    for (int i = 1; i <= estudiantes.size(); i++) {
      Estudiante e = estudiantes.getEstudiante(i);
      if (e.getMedia() == notaMasAlta) {
        System.out.println(e.getNombre());
      }
    }
    System.out.println();
  }

  /** Pide un número de ejercicio y lo devuelve.
   */
  public static int pideEjercicio() {
    Scanner s = new Scanner(System.in);

    int ejercicio;    
    do {
      System.out.print("Dame un número de ejercicio (entre 1 y " + Calificaciones.NUM_NOTAS + "): ");
      ejercicio = s.nextInt();
    } while (ejercicio < 1 || ejercicio > Calificaciones.NUM_NOTAS);

    System.out.println();
    return ejercicio;
  }

 
  private static void muestraNotas() {
    System.out.println(estudiantes);
    System.out.println();
  }

  private static void guardaNotasXML() {
    String nombreFichero = pideNombreFichero();
    try {
      estudiantes.guardaXML(nombreFichero);
    } catch (IOException e) {
      System.err.println("Error al guardar " + nombreFichero + ": " + e.getMessage() + "\n");
    } catch (AddressBookXMLException e) {
      System.err.println("Error al generar XML: " + e.getMessage() + "\n");
    }

  }
  
  private static String pideNombreFichero() {
    Scanner s = new Scanner(System.in);
    System.out.print("Nombre del fichero: ");
    String nombreFichero = s.nextLine();
    System.out.println();
    return nombreFichero;
  }

}
