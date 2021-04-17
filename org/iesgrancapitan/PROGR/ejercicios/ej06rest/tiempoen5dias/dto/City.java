package org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias.dto;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class City {

  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("coord")
  @Expose
  private Coord coord;
  @SerializedName("country")
  @Expose
  private String country;
  @SerializedName("population")
  @Expose
  private int population;
  @SerializedName("timezone")
  @Expose
  private int timezone;
  @SerializedName("sunrise")
  @Expose
  private int sunrise;
  @SerializedName("sunset")
  @Expose
  private int sunset;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Coord getCoord() {
    return coord;
  }

  public void setCoord(Coord coord) {
    this.coord = coord;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public int getTimezone() {
    return timezone;
  }

  public void setTimezone(int timezone) {
    this.timezone = timezone;
  }

  public int getSunrise() {
    return sunrise;
  }

  public void setSunrise(int sunrise) {
    this.sunrise = sunrise;
  }

  public int getSunset() {
    return sunset;
  }

  public void setSunset(int sunset) {
    this.sunset = sunset;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(City.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("id");
    sb.append('=');
    sb.append(this.id);
    sb.append(',');
    sb.append("name");
    sb.append('=');
    sb.append(((this.name == null) ? "<null>" : this.name));
    sb.append(',');
    sb.append("coord");
    sb.append('=');
    sb.append(((this.coord == null) ? "<null>" : this.coord));
    sb.append(',');
    sb.append("country");
    sb.append('=');
    sb.append(((this.country == null) ? "<null>" : this.country));
    sb.append(',');
    sb.append("population");
    sb.append('=');
    sb.append(this.population);
    sb.append(',');
    sb.append("timezone");
    sb.append('=');
    sb.append(this.timezone);
    sb.append(',');
    sb.append("sunrise");
    sb.append('=');
    sb.append(this.sunrise);
    sb.append(',');
    sb.append("sunset");
    sb.append('=');
    sb.append(this.sunset);
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
