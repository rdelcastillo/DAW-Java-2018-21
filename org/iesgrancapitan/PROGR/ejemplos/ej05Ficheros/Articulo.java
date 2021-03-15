package org.iesgrancapitan.PROGR.ejemplos.ej05Ficheros;

public class Articulo {
  /**
   * @param codigo
   * @param descripcion
   * @param precio
   * @param unidades
   */

  private int codigo;
  private String descripcion;
  private double precio;
  private int unidades;
  
  public Articulo(int codigo, String descripcion, double precio, int unidades) {
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.precio = precio;
    this.unidades = unidades;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }
  
  public String getDescripcion() {
    return descripcion;
  }
  
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
  public double getPrecio() {
    return precio;
  }
  
  public void setPrecio(double precio) {
    this.precio = precio;
  }
  
  public int getUnidades() {
    return unidades;
  }
  
  public void setUnidades(int unidades) {
    this.unidades = unidades;
  }

  @Override
  public String toString() {
    return "Articulo [codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio
        + ", unidades=" + unidades + "]";
  }

}
