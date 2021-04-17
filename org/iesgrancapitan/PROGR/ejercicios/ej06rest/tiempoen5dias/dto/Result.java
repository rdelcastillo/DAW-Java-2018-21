
package org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias.dto;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Result {

  @SerializedName("dt")
  @Expose
  private int dt;
  @SerializedName("main")
  @Expose
  private Main main;
  @SerializedName("weather")
  @Expose
  private java.util.List<Weather> weather = null;
  @SerializedName("clouds")
  @Expose
  private Clouds clouds;
  @SerializedName("wind")
  @Expose
  private Wind wind;
  @SerializedName("visibility")
  @Expose
  private int visibility;
  @SerializedName("pop")
  @Expose
  private double pop;
  @SerializedName("sys")
  @Expose
  private Sys sys;
  @SerializedName("dt_txt")
  @Expose
  private String dtTxt;
  @SerializedName("rain")
  @Expose
  private Rain rain;

  public int getDt() {
    return dt;
  }

  public void setDt(int dt) {
    this.dt = dt;
  }

  public Main getMain() {
    return main;
  }

  public void setMain(Main main) {
    this.main = main;
  }

  public java.util.List<Weather> getWeather() {
    return weather;
  }

  public void setWeather(java.util.List<Weather> weather) {
    this.weather = weather;
  }

  public Clouds getClouds() {
    return clouds;
  }

  public void setClouds(Clouds clouds) {
    this.clouds = clouds;
  }

  public Wind getWind() {
    return wind;
  }

  public void setWind(Wind wind) {
    this.wind = wind;
  }

  public int getVisibility() {
    return visibility;
  }

  public void setVisibility(int visibility) {
    this.visibility = visibility;
  }

  public double getPop() {
    return pop;
  }

  public void setPop(double pop) {
    this.pop = pop;
  }

  public Sys getSys() {
    return sys;
  }

  public void setSys(Sys sys) {
    this.sys = sys;
  }

  public String getDtTxt() {
    return dtTxt;
  }

  public void setDtTxt(String dtTxt) {
    this.dtTxt = dtTxt;
  }

  public Rain getRain() {
    return rain;
  }

  public void setRain(Rain rain) {
    this.rain = rain;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Result.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("dt");
    sb.append('=');
    sb.append(this.dt);
    sb.append(',');
    sb.append("main");
    sb.append('=');
    sb.append(((this.main == null) ? "<null>" : this.main));
    sb.append(',');
    sb.append("weather");
    sb.append('=');
    sb.append(((this.weather == null) ? "<null>" : this.weather));
    sb.append(',');
    sb.append("clouds");
    sb.append('=');
    sb.append(((this.clouds == null) ? "<null>" : this.clouds));
    sb.append(',');
    sb.append("wind");
    sb.append('=');
    sb.append(((this.wind == null) ? "<null>" : this.wind));
    sb.append(',');
    sb.append("visibility");
    sb.append('=');
    sb.append(this.visibility);
    sb.append(',');
    sb.append("pop");
    sb.append('=');
    sb.append(this.pop);
    sb.append(',');
    sb.append("sys");
    sb.append('=');
    sb.append(((this.sys == null) ? "<null>" : this.sys));
    sb.append(',');
    sb.append("dtTxt");
    sb.append('=');
    sb.append(((this.dtTxt == null) ? "<null>" : this.dtTxt));
    sb.append(',');
    sb.append("rain");
    sb.append('=');
    sb.append(((this.rain == null) ? "<null>" : this.rain));
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
