package org.iesgrancapitan.PROGR.ejemplos.bdatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ej01Sqlite {

  public static void main(String[] args) {
    try {
      
      // 1. Crear conexión
      Connection conexion = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
      
      // 2. Crear objeto Statement
      Statement stament = conexion.createStatement();
      
      // 3. Ejecutar SQL
      ResultSet resultset = stament.executeQuery("SELECT * FROM contactos");
      
      // 4. Recorrer ResultSet
      while (resultset.next()) {
        System.out.println( resultset.getString("nombre") + "\t" + 
                            resultset.getInt("telefono") + "\t" +
                            resultset.getString("email"));
      }
      
    } catch (SQLException e) {
      System.out.println("Error en la conexión de la base de datos");
      e.printStackTrace();
    }

  }

}
