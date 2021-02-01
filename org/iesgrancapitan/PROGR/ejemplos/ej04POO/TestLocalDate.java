package org.iesgrancapitan.PROGR.ejemplos.ej04POO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/**
 * Prueba clase LocalDate.
 * 
 * @author rafa
 *
 */
public class TestLocalDate {

  public static void main(String[] args) {
    LocalDate f1 = LocalDate.now();
    LocalDate f2 = LocalDate.of(2020,2,29);
    LocalDate f3 = f1.plusDays(0);  // sumamos 0 días, misma fecha
    LocalDate f4 = f1;              // esta clase es inmutable
    
    // Inicio
    System.out.println("Momento inicial:");
    System.out.println("Fecha1: " + f1);
    System.out.println("Fecha2: " + f2);
    System.out.println("Fecha3: " + f3);
    System.out.println("Fecha4: " + f4.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n");
    
    // Cambiamos f3
    f3 = LocalDate.of(f3.getYear(), f3.getMonthValue(), 12);
    System.out.println("Asignamos 12 al día de Fecha3: " + f3);
     
    // Cambiamos f4 
    System.out.println("Restamos dos años a Fecha4: " + f4);
    f4 = f4.minusYears(2);
    System.out.println("Fecha4: " + f4 + "\n");
    
    // Comparamos
    System.out.println("Comparamos Fecha1 (" + f1 + ") y Fecha2 (" + f2 + ") " + f1.compareTo(f2));
    System.out.println("Comparamos Fecha3 (" + f3 + ") y Fecha1 (" + f1 + ") " + f3.compareTo(f1) + "\n");
    System.out.println("¿'" + f1 + "' es igual a '" + f4 + "'? " + f1.equals(f4));
    System.out.println("¿'" + f2 + "' es anterior a '" + f3 +"'? " + f2.isBefore(f3) + "\n");
    
    // Sumamos y restamos
    System.out.print("Sumamos 50 días a Fecha1 (" + f1 + ") y se lo asignamos a Fecha2: ");
    f2 = f1.plus(50, ChronoUnit.DAYS);
    System.out.println(f2.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    System.out.println("Y Fecha2 sin esos 50 días es Fecha1: " + f2.minusDays(50) + "\n");
    
    // Probamos la resta de fechas
    System.out.println("La diferencia entre " + f1 + " y " + f2 + " son " + ChronoUnit.DAYS.between(f1, f2) + " días.");
  }

}
