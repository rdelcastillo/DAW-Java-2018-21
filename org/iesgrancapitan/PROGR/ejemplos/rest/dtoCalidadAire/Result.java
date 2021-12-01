package org.iesgrancapitan.PROGR.ejemplos.rest.dtoCalidadAire;

import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Result {

  @SerializedName("location")
  @Expose
  private String location;
  @SerializedName("city")
  @Expose
  private String city;
  @SerializedName("country")
  @Expose
  private String country;
  @SerializedName("coordinates")
  @Expose
  private Coordinates coordinates;
  @SerializedName("measurements")
  @Expose
  private List<Measurement> measurements = null;

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public List<Measurement> getMeasurements() {
    return measurements;
  }

  public void setMeasurements(List<Measurement> measurements) {
    this.measurements = measurements;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("location");
    sb.append('=');
    sb.append(((this.location == null)?"<null>":this.location));
    sb.append(',');
    sb.append("city");
    sb.append('=');
    sb.append(((this.city == null)?"<null>":this.city));
    sb.append(',');
    sb.append("country");
    sb.append('=');
    sb.append(((this.country == null)?"<null>":this.country));
    sb.append(',');
    sb.append("coordinates");
    sb.append('=');
    sb.append(((this.coordinates == null)?"<null>":this.coordinates));
    sb.append(',');
    sb.append("measurements");
    sb.append('=');
    sb.append(((this.measurements == null)?"<null>":this.measurements));
    sb.append(',');
    if (sb.charAt((sb.length()- 1)) == ',') {
      sb.setCharAt((sb.length()- 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
