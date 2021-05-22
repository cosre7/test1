package com.talat.pms.domain;

import java.math.BigDecimal;
import java.sql.Time;

public class Route {
  private int rno;
  private int jno;
  private int spotOrder;
  private BigDecimal latitude;
  private BigDecimal longitude;  
  private String spotName;
  private Time spotTime;

  @Override
  public String toString() {
    return "Route [rno=" + rno + ", jno=" + jno + ", spotOrder=" + spotOrder + ", latitude="
        + latitude + ", longitude=" + longitude + ", spotName=" + spotName + ", spotTime="
        + spotTime + "]";
  }
  public int getRno() {
    return rno;
  }
  public void setRno(int rno) {
    this.rno = rno;
  }
  public int getJno() {
    return jno;
  }
  public void setJno(int jno) {
    this.jno = jno;
  }
  public int getSpotOrder() {
    return spotOrder;
  }
  public void setSpotOrder(int spotOrder) {
    this.spotOrder = spotOrder;
  }
  public BigDecimal getLatitude() {
    return latitude;
  }
  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }
  public BigDecimal getLongitude() {
    return longitude;
  }
  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }
  public String getSpotName() {
    return spotName;
  }
  public void setSpotName(String spotName) {
    this.spotName = spotName;
  }
  public Time getSpotTime() {
    return spotTime;
  }
  public void setSpotTime(Time spotTime) {
    this.spotTime = spotTime;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + jno;
    result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
    result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
    result = prime * result + rno;
    result = prime * result + ((spotName == null) ? 0 : spotName.hashCode());
    result = prime * result + spotOrder;
    result = prime * result + ((spotTime == null) ? 0 : spotTime.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Route other = (Route) obj;
    if (jno != other.jno)
      return false;
    if (latitude == null) {
      if (other.latitude != null)
        return false;
    } else if (!latitude.equals(other.latitude))
      return false;
    if (longitude == null) {
      if (other.longitude != null)
        return false;
    } else if (!longitude.equals(other.longitude))
      return false;
    if (rno != other.rno)
      return false;
    if (spotName == null) {
      if (other.spotName != null)
        return false;
    } else if (!spotName.equals(other.spotName))
      return false;
    if (spotOrder != other.spotOrder)
      return false;
    if (spotTime == null) {
      if (other.spotTime != null)
        return false;
    } else if (!spotTime.equals(other.spotTime))
      return false;
    return true;
  }

}