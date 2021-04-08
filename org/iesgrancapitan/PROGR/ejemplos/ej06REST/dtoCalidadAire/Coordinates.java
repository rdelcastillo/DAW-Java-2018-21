package org.iesgrancapitan.PROGR.ejemplos.ej06REST.dtoCalidadAire;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Coordinates {

  @SerializedName("latitude")
  @Expose
  private double latitude;
  @SerializedName("longitude")
  @Expose
  private double longitude;

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Coordinates.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("latitude");
    sb.append('=');
    sb.append(this.latitude);
    sb.append(',');
    sb.append("longitude");
    sb.append('=');
    sb.append(this.longitude);
    sb.append(',');
    if (sb.charAt((sb.length()- 1)) == ',') {
      sb.setCharAt((sb.length()- 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
