package org.iesgrancapitan.PROGR.examenes.ex2021_1trimestre;

import java.util.Scanner;

/**
 * Guardamos en un array de 15 × 5 elementos la calificación obtenida por 15 estudiantes 
 * (a los que conocemos por su número de lista) en la evaluación de 5 ejercicios entregados
 *  semanalmente (cuando un ejercicio no se ha entregado, la calificación es −1). 
 *  
 *  También guardamos en otro array los nombres de los 15 estudiantes, inicializa este 
 *  array con los valores que quieras.
 *  
 *  El programa muestre y ejecute el siguiente menú:
 *  
 *  1. Generar aleatoriamente las calificaciones (enteros entre -1 y 10).
 *  2. Mostrar el número de ejercicios entregados por un estudiante.
 *  3. Mostrar la media de los ejercicios entregados por un estudiante (si los entregó 
 *  todos; en caso contrario, la media es 0).
 *  4. Mostrar la cantidad de estudiantes que han entregado todos los ejercicios y tienen 
 *  una media superior o igual a un 5.
 *  5. Mostrar el número de estudiantes que han presentado un ejercicio dado.
 *  6. Dado el número de un ejercicio, mostrar la nota media obtenida por los estudiantes 
 *  que lo presentaron.
 *  7. Dado el número de un ejercicio, mostrar la nota más alta obtenida.
 *  8. Dado el número de un ejercicio, mostrar la nota más baja obtenida.
 *  9. Mostrar la relación de estudiantes y sus notas.
 *  10. Finalizar.
 *  
 *  A tener en cuenta:
 *  - Cuando una opción necesite saber a qué estudiante nos referimos damos su número 
 *  (empezamos en 1) y al mostrar el resultado tiene que salir este número y su nombre.
 *  - Si el array de calificaciones no se ha generado no funcionan las demás opciones.
 *  - Si se da una opción equivocada en el menú se muestra un error.
 *  
 *  Para este programa tienes que hacer y usar (como mínimo) las siguientes funciones:
 *  
 *  - Dado el número de un estudiante, devolver el número de ejercicios entregados.
 *  - Dado el número de un estudiante, devolver la media sobre los ejercicios entregados, 
 *  si los entregó todos; en caso contrario, la media es 0.
 *  - Devolver el número de todos los estudiantes que han entregado todos los ejercicios y 
 *  tienen una media superior a un valor pasado a la función como parámetro.
 *  - Dado el número de un ejercicio, devolver el número de estudiantes que lo han presentado.
 *  - Dado el número de un ejercicio, devolver la nota media obtenida por los estudiantes que
 *  lo presentaron.
 *  - Dado el número de un ejercicio, devolver la nota más alta obtenida.
 *  Dado el número de un ejercicio, devolver la nota más baja obtenida (sin contar -1).
 *  
 * @author Rafael del Castillo Gomariz
 *
 */

public class MenuEjerciciosAlumnado {
  
  final static public int NUM_NOTAS = 5;
  final static public int NUM_ESTUDIANTES = 15;

  public static void main(String[] args) {
    String [] estudiantes = new String[NUM_ESTUDIANTES];
    int[][] notas = new int[NUM_ESTUDIANTES][NUM_NOTAS];
    int opcion;
    boolean continuar = true;
    boolean datosGenerados = false;
    
    // Inicializamos el array de estudiantes
    for (int i = 0; i < estudiantes.length; i++) {
      estudiantes[i] = "Estudiante " + (i+1);
    }
    
    // Proceso
    do {
      opcion = menu();
      switch (opcion) {
        case 1: // generamos las calificaciones
          generaCalificaciones(notas);
          datosGenerados = true;
          break;
        case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
          if (datosGenerados) {    // si se han las calificaciones
            switch (opcion) {
              case 2:
                mostrarEjerciciosEntregados(estudiante(), notas, estudiantes);
                break;
              case 3:
                mostrarMediaEjercicios(estudiante(), notas, estudiantes);
                break;
              case 4:
                System.out.println(numeroEstudiantesEntregaTodoConNotaMayor(5, notas) + " estudiantes.\n");
                break;
              case 5:
                System.out.println(numeroEstudiantesPresentaEjercicio(ejercicio(), notas) + " estudiantes.\n");
                break;
              case 6:
                System.out.println("La media es " + mediaEjercicio(ejercicio(), notas) + "\n");
                break;
              case 7:
                System.out.println("La máxima nota es " + maximoEjercicio(ejercicio(), notas) + "\n");
                break;
              case 8:
                System.out.println("La mínima nota es " + minimoEjercicio(ejercicio(), notas) + "\n");
                break;
              case 9:
                mostrarNotas(notas, estudiantes);
            }
          } else {
            System.out.println("Primero debe generar las calificaciones.\n");
          }
          break;
        case 10:
          continuar = false;
          break;
        default:
          System.out.println("Opción incorrecta\n");
      }
    } while (continuar);
    System.out.println("¡Adiós!");
  }

  /**
   * Imprime el menú y devuelve la opción escogida.
   * 
   * @param a Número a.
   * @param b Número b.
   * @param numerosIntroducidos verdadero si a y b han sido introducidos.
   * @return opción escogida.
   */
  public static int menu() {
    int opcion;
    
    // escribo el menú
    System.out.println("Menú de opciones");
    System.out.println("----------------");
    System.out.println("1. Generar aleatoriamente las calificaciones.\n"
        + "2. Mostrar el número de ejercicios entregados por un estudiante.\n"
        + "3. Mostrar la media de los ejercicios entregados por un estudiante.\n"
        + "4. Mostrar la cantidad de estudiantes que han entregado todos los ejercicios y tienen una media >= 5.\n"
        + "5. Mostrar el número de estudiantes que han presentado un ejercicio dado.\n"
        + "6. Dado el número de un ejercicio, mostrar la nota media obtenida por los estudiantes que lo presentaron.\n"
        + "7. Dado el número de un ejercicio, mostrar la nota más alta obtenida.\n"
        + "8. Dado el número de un ejercicio, mostrar la nota más baja obtenida.\n"
        + "9. Mostrar la relación de estudiantes y sus notas.\n"
        + "10. Finalizar.");
   
    // leo la opción
    Scanner s = new Scanner(System.in);
    System.out.print("\nIntroduce una opción: ");
    opcion = s.nextInt();
    
    // acabo
    System.out.println("\n");
    return opcion;
  }

  /**
   * Genera las calificaciones aleatoriamente.
   * 
   * @param notas
   */
  public static void generaCalificaciones(int[][] notas) {
    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
      for (int j = 0; j < NUM_NOTAS; j++) {
        notas[i][j] = -1 + (int) (Math.random()*12);
      }
    }
  }
  
  /** Pide un número de ejercicio y l odevuelve.
   * 
   * @return ejercicio
   */
  public static int ejercicio() {
    int ejercicio;
    Scanner s = new Scanner(System.in);
    
    // pedimos número de ejercicio hasta que esté correcto
    do {
      System.out.print("Dame un número de ejercicio (entre 1 y " + NUM_NOTAS + "): ");
      ejercicio = s.nextInt();
    } while (ejercicio < 1 || ejercicio > NUM_NOTAS);
    
    System.out.println();
    return ejercicio;
  }
  
  /**
   * Pide un número de estudiante y lo devuelve.
   * 
   * @return estudiante
   */
  public static int estudiante() {
    int estudiante;
    Scanner s = new Scanner(System.in);
    
    // pedimos número de estudiante hasta que esté correcto
    do {
      System.out.print("Dame un número de estudiante (entre 1 y " + NUM_ESTUDIANTES + "): ");
      estudiante = s.nextInt();
    } while (estudiante < 1 || estudiante > NUM_ESTUDIANTES);
    
    System.out.println();
    return estudiante;
  }

  /**
   * Muestra los ejercicios entregados por un estudiante.
   * 
   * @param estudiante
   * @param notas
   * @param estudiantes
   */
  public static void mostrarEjerciciosEntregados(int estudiante, int[][] notas, String[] estudiantes) {
    System.out.println(estudiantes[estudiante-1] + " ha entregado " + 
                        ejerciciosEntregados(estudiante, notas) + " ejercicios.\n");
  }
  
  /**
   * Devuelve el número de ejercicios entregados por un estudiante.
   * @param estudiante
   * @param notas
   * @return
   */
  public static int ejerciciosEntregados(int estudiante, int[][] notas) {
    int entregados = 0;
    
    for (int nota: notas[estudiante-1]) {
      if (nota > -1) {
        entregados++;
      }
    }
    return entregados;
  }

  /**
   * Muestra la media de los ejercicios entregados, si los entregó todos; en caso contrario, la media es 0.
   * 
   * @param estudiante
   * @param notas
   * @param estudiantes
   */
  public static void mostrarMediaEjercicios(int estudiante, int[][] notas, String[] estudiantes) {
    System.out.println(estudiantes[estudiante-1] + " tiene una media de " + 
        mediaEjercicios(estudiante, notas) + ".\n");
  }

  /**
   * Devuelve la media sobre los ejercicios entregados, si los entregó todos; en caso contrario, 
   * la media es 0.
   * 
   * @param estudiante
   * @param notas
   * @return media
   */
  public static double mediaEjercicios(int estudiante, int[][] notas) {
    double suma = 0;
    
    for (int nota: notas[estudiante-1]) {
      if (nota > -1) {  // ha realizado el ejercicio
        suma += nota;
      } else {
        suma = 0;   // no ha hecho todo, la media es 0
        break;
      }
    }
    return suma / NUM_NOTAS;
  }

  /**
   * Devuelve el número de estudiantes que han realizado un ejercicio.
   * 
   * @param ejercicio
   * @return número de estudiantes.
   */
  public static int numeroEstudiantesPresentaEjercicio(int ejercicio, int[][] notas) {
    int n = 0;
    
    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
      if (notas[i][ejercicio-1] > -1) {
        n++;
      }
    }
    return n;
  }

  /**
   * Devuelve la media de un ejercicio contando solo a quienes lo presentaron
   * @param ejercicio
   * @param notas
   * @return media
   */
  public static double mediaEjercicio(int ejercicio, int[][] notas) {
    double suma = 0;
    int numEstudiantes = 0;
    
    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
      if (notas[i][ejercicio-1] > -1) {
        suma += notas[i][ejercicio-1];
        numEstudiantes++;
      }
    }
    return suma / numEstudiantes;
  }

  /**
   * Devuelve la máxima calificación de un ejercicio.
   * @param ejercicio
   * @param notas
   * @return máxima calificación
   */
  public static int maximoEjercicio(int ejercicio, int[][] notas) {
    int maximo = Integer.MIN_VALUE;
    
    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
      if (notas[i][ejercicio-1] > maximo) {
        maximo = notas[i][ejercicio-1];
      }
    }
    return maximo;
  }

  /**
   * Devuelve la mínima calificación de un ejercicio.
   * @param ejercicio
   * @param notas
   * @return
   */
  public static int minimoEjercicio(int ejercicio, int[][] notas) {
    int minimo = Integer.MAX_VALUE;
    
    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
      if (notas[i][ejercicio-1] < minimo) {
        minimo = notas[i][ejercicio-1];
      }
    }
    return minimo;
  }

  /**
   * Devuelve el número de estudiantes con todo entregado y nota mayor o igual que nota.
   * 
   * @param nota
   * @param notas
   * @return
   */
  public static int numeroEstudiantesEntregaTodoConNotaMayor(int nota, int[][] notas) {
    int n = 0;
    
    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
      // compruebo para cada estudiante que entrega todo 
      boolean entregaTodo = true;
      double suma = 0;
      for (int j = 0; j < NUM_NOTAS; j++) {
        if (notas[i][j] > -1) {
          suma += notas[i][j];
        } else {    // este ejercicio no lo ha entregado, acabo
          entregaTodo = false;
          break;
        }
      }
      // si ha entregado todo compruebo que la media sea mayor que nota, entonces contabilizo
      if (entregaTodo && (suma / NUM_NOTAS) >= nota) {
        n++;
      }
    }
    
    return n;
  }

  public static void mostrarNotas(int[][] notas, String[] estudiantes) {
    // cabecera
    System.out.print(" ".repeat(25));   // blancos iniciales
    for (int nota = 1; nota <= NUM_NOTAS; nota++) {
      System.out.printf("%2d ", nota);
    }
    System.out.println("\n" + " ".repeat(25) + "-".repeat(NUM_NOTAS * 3));
    
    // estudiantes
    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
      System.out.printf("%2d. %-20s ", i+1, estudiantes[i]);
      for (int j = 0; j < NUM_NOTAS; j++) {
        System.out.printf("%2d ", notas[i][j]);
      }
      System.out.println();
    }
    System.out.println();
    
  }

}
