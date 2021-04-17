
package org.iesgrancapitan.PROGR.ejercicios.ej06rest.tiempoen5dias.dto;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Rain {

  @SerializedName("3h")
  @Expose
  private double _3h;

  public double get3h() {
    return _3h;
  }

  public void set3h(double _3h) {
    this._3h = _3h;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Rain.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("_3h");
    sb.append('=');
    sb.append(this._3h);
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
