package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;

import java.util.Date;
import java.util.Calendar;

public class Ej21FechaHoy {

  @SuppressWarnings("deprecation")
  public static void main(String[] args) {
    Date hoy1 = new Date();
    System.out.println("Fecha: "+hoy1);
    // Método OBSOLETO
    System.out.println("Fecha: "+hoy1.getDate()+"/"+(1+hoy1.getMonth())+"/"+(hoy1.getYear()+1900));
    // Método ACTUAL
    Calendar hoy2 = Calendar.getInstance();
    System.out.println("Fecha: "+hoy2.get(Calendar.DAY_OF_MONTH)+"/"+(1+hoy2.get(Calendar.MONTH))+"/"+hoy2.get(Calendar.YEAR));
  }

}
