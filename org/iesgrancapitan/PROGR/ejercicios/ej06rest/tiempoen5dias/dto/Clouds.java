package org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias.dto;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Clouds {

  @SerializedName("all")
  @Expose
  private int all;

  public int getAll() {
    return all;
  }

  public void setAll(int all) {
    this.all = all;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Clouds.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("all");
    sb.append('=');
    sb.append(this.all);
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
