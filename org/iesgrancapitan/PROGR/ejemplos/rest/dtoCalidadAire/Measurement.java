package org.iesgrancapitan.PROGR.ejemplos.rest.dtoCalidadAire;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Measurement {

  @SerializedName("parameter")
  @Expose
  private String parameter;
  @SerializedName("value")
  @Expose
  private double value;
  @SerializedName("lastUpdated")
  @Expose
  private String lastUpdated;
  @SerializedName("unit")
  @Expose
  private String unit;
  @SerializedName("sourceName")
  @Expose
  private String sourceName;
  @SerializedName("averagingPeriod")
  @Expose
  private AveragingPeriod averagingPeriod;

  public String getParameter() {
    return parameter;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getSourceName() {
    return sourceName;
  }

  public void setSourceName(String sourceName) {
    this.sourceName = sourceName;
  }

  public AveragingPeriod getAveragingPeriod() {
    return averagingPeriod;
  }

  public void setAveragingPeriod(AveragingPeriod averagingPeriod) {
    this.averagingPeriod = averagingPeriod;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Measurement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("parameter");
    sb.append('=');
    sb.append(((this.parameter == null)?"<null>":this.parameter));
    sb.append(',');
    sb.append("value");
    sb.append('=');
    sb.append(this.value);
    sb.append(',');
    sb.append("lastUpdated");
    sb.append('=');
    sb.append(((this.lastUpdated == null)?"<null>":this.lastUpdated));
    sb.append(',');
    sb.append("unit");
    sb.append('=');
    sb.append(((this.unit == null)?"<null>":this.unit));
    sb.append(',');
    sb.append("sourceName");
    sb.append('=');
    sb.append(((this.sourceName == null)?"<null>":this.sourceName));
    sb.append(',');
    sb.append("averagingPeriod");
    sb.append('=');
    sb.append(((this.averagingPeriod == null)?"<null>":this.averagingPeriod));
    sb.append(',');
    if (sb.charAt((sb.length()- 1)) == ',') {
      sb.setCharAt((sb.length()- 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
