package org.iesgrancapitan.PROGR.ejemplos.rest.dtoCalidadAire;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Meta {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("license")
  @Expose
  private String license;
  @SerializedName("website")
  @Expose
  private String website;
  @SerializedName("page")
  @Expose
  private int page;
  @SerializedName("limit")
  @Expose
  private int limit;
  @SerializedName("found")
  @Expose
  private int found;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getFound() {
    return found;
  }

  public void setFound(int found) {
    this.found = found;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Meta.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("name");
    sb.append('=');
    sb.append(((this.name == null)?"<null>":this.name));
    sb.append(',');
    sb.append("license");
    sb.append('=');
    sb.append(((this.license == null)?"<null>":this.license));
    sb.append(',');
    sb.append("website");
    sb.append('=');
    sb.append(((this.website == null)?"<null>":this.website));
    sb.append(',');
    sb.append("page");
    sb.append('=');
    sb.append(this.page);
    sb.append(',');
    sb.append("limit");
    sb.append('=');
    sb.append(this.limit);
    sb.append(',');
    sb.append("found");
    sb.append('=');
    sb.append(this.found);
    sb.append(',');
    if (sb.charAt((sb.length()- 1)) == ',') {
      sb.setCharAt((sb.length()- 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
