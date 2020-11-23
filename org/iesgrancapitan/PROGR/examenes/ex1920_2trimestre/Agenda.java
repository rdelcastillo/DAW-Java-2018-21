package org.iesgrancapitan.PROGR.examenes.ex1920_2trimestre;

/**
 * Clase para gestionar una agenda de un máximo de 100 contactos.
 * 
 * Un contacto está definido por:
 *  • Nombre. Será válido cuando esté compuesto por letras y espacios (solo en medio) y no haya 
 *    otro con el mismo nombre.
 *  • Teléfono. Será válido si está compuesto por nueve dígitos, el primero empieza por 6, 7 ó 9.
 *  • Dirección. No se valida, puede estar vacía.
 *  • Correo electrónico. Si existe hay que validarlo.
 *  
 *  El comportamiento de esta clase es el siguiente:
 *  
 *  • Tiene dos constructores:
 *      ◦ El primero sin parámetros, simplemente crea una agenda vacía.
 *      ◦ El segundo recibe un fichero CSV con información de contactos.
 *  • Alta de contacto. Añade un contacto a la agenda. Lanza una excepción si se sobrepasa el 
 *    máximo de contactos (100). 
    • Baja de contacto. Lanza una excepción si el contacto a borrar no existe.
    • Busca un contacto. Devuelve el contacto que coincida con la búsqueda, en caso de no encontrar coincidencia se devuelve un valor nulo.
    • Reduce el tamaño de la agenda. Cambia el número máximo de contactos a otro valor inferior a 100, si se diera un valor mayor lanza una excepción, si reducimos el tamaño de la agenda a un valor inferior al número de contactos que hay lanza una excepción.
    • Exporta a fichero CSV. Lanza una excepción si no podemos escribir en el fichero.
    • Importa de fichero CSV. Cada contacto importado llama al método que da de alta. Lanza una excepción si no podemos leer del fichero.

El control del tamaño de la agenda se hace sobre esta clase.

Una agenda está formada por una colección de de contactos, que a su vez son objetos de la clase Contacto. 
 */

import java.util.ArrayList;

public class Agenda {
  private static final int MAXIMO_CONTACTOS = 100;      // Máximo tamaño agenda
  
  private ArrayList <Contacto> agenda = new ArrayList<Contacto>();
  private int maximoContactos = MAXIMO_CONTACTOS;
  
  

}
