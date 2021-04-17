
package org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias.dto;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Main {

  @SerializedName("temp")
  @Expose
  private double temp;
  @SerializedName("feels_like")
  @Expose
  private double feelsLike;
  @SerializedName("temp_min")
  @Expose
  private double tempMin;
  @SerializedName("temp_max")
  @Expose
  private double tempMax;
  @SerializedName("pressure")
  @Expose
  private int pressure;
  @SerializedName("sea_level")
  @Expose
  private int seaLevel;
  @SerializedName("grnd_level")
  @Expose
  private int grndLevel;
  @SerializedName("humidity")
  @Expose
  private int humidity;
  @SerializedName("temp_kf")
  @Expose
  private double tempKf;

  public double getTemp() {
    return temp;
  }

  public void setTemp(double temp) {
    this.temp = temp;
  }

  public double getFeelsLike() {
    return feelsLike;
  }

  public void setFeelsLike(double feelsLike) {
    this.feelsLike = feelsLike;
  }

  public double getTempMin() {
    return tempMin;
  }

  public void setTempMin(double tempMin) {
    this.tempMin = tempMin;
  }

  public double getTempMax() {
    return tempMax;
  }

  public void setTempMax(double tempMax) {
    this.tempMax = tempMax;
  }

  public int getPressure() {
    return pressure;
  }

  public void setPressure(int pressure) {
    this.pressure = pressure;
  }

  public int getSeaLevel() {
    return seaLevel;
  }

  public void setSeaLevel(int seaLevel) {
    this.seaLevel = seaLevel;
  }

  public int getGrndLevel() {
    return grndLevel;
  }

  public void setGrndLevel(int grndLevel) {
    this.grndLevel = grndLevel;
  }

  public int getHumidity() {
    return humidity;
  }

  public void setHumidity(int humidity) {
    this.humidity = humidity;
  }

  public double getTempKf() {
    return tempKf;
  }

  public void setTempKf(double tempKf) {
    this.tempKf = tempKf;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Main.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("temp");
    sb.append('=');
    sb.append(this.temp);
    sb.append(',');
    sb.append("feelsLike");
    sb.append('=');
    sb.append(this.feelsLike);
    sb.append(',');
    sb.append("tempMin");
    sb.append('=');
    sb.append(this.tempMin);
    sb.append(',');
    sb.append("tempMax");
    sb.append('=');
    sb.append(this.tempMax);
    sb.append(',');
    sb.append("pressure");
    sb.append('=');
    sb.append(this.pressure);
    sb.append(',');
    sb.append("seaLevel");
    sb.append('=');
    sb.append(this.seaLevel);
    sb.append(',');
    sb.append("grndLevel");
    sb.append('=');
    sb.append(this.grndLevel);
    sb.append(',');
    sb.append("humidity");
    sb.append('=');
    sb.append(this.humidity);
    sb.append(',');
    sb.append("tempKf");
    sb.append('=');
    sb.append(this.tempKf);
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
