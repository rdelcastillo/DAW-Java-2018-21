
package org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias.dto;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Wind {

  @SerializedName("speed")
  @Expose
  private double speed;
  @SerializedName("deg")
  @Expose
  private int deg;

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public int getDeg() {
    return deg;
  }

  public void setDeg(int deg) {
    this.deg = deg;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Wind.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("speed");
    sb.append('=');
    sb.append(this.speed);
    sb.append(',');
    sb.append("deg");
    sb.append('=');
    sb.append(this.deg);
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
