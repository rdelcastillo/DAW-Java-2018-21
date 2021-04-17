
package org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias.dto;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Coord {

  @SerializedName("lat")
  @Expose
  private int lat;
  @SerializedName("lon")
  @Expose
  private double lon;

  public int getLat() {
    return lat;
  }

  public void setLat(int lat) {
    this.lat = lat;
  }

  public double getLon() {
    return lon;
  }

  public void setLon(double lon) {
    this.lon = lon;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Coord.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("lat");
    sb.append('=');
    sb.append(this.lat);
    sb.append(',');
    sb.append("lon");
    sb.append('=');
    sb.append(this.lon);
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
