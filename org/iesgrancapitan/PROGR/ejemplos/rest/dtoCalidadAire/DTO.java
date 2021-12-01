package org.iesgrancapitan.PROGR.ejemplos.rest.dtoCalidadAire;

import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class DTO {

  @SerializedName("meta")
  @Expose
  private Meta meta;
  @SerializedName("results")
  @Expose
  private List<Result> results = null;

  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  public List<Result> getResults() {
    return results;
  }

  public void setResults(List<Result> results) {
    this.results = results;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(DTO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("meta");
    sb.append('=');
    sb.append(((this.meta == null)?"<null>":this.meta));
    sb.append(',');
    sb.append("results");
    sb.append('=');
    sb.append(((this.results == null)?"<null>":this.results));
    sb.append(',');
    if (sb.charAt((sb.length()- 1)) == ',') {
      sb.setCharAt((sb.length()- 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
