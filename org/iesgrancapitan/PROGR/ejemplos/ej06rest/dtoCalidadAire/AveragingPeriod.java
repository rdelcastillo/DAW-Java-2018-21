package org.iesgrancapitan.PROGR.ejemplos.ej06rest.dtoCalidadAire;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class AveragingPeriod {

  @SerializedName("value")
  @Expose
  private int value;
  @SerializedName("unit")
  @Expose
  private String unit;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(AveragingPeriod.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("value");
    sb.append('=');
    sb.append(this.value);
    sb.append(',');
    sb.append("unit");
    sb.append('=');
    sb.append(((this.unit == null)?"<null>":this.unit));
    sb.append(',');
    if (sb.charAt((sb.length()- 1)) == ',') {
      sb.setCharAt((sb.length()- 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}