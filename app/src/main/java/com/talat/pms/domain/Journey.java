package com.talat.pms.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Journey{
  private int jno;
  private Member driver;
  private String departure;
  private List<Route> routes;
  private String arrival;
  private Date journeyDate;
  private Time journeyTime;
  private int seatPassenger;
  private int seatRear;
  private int pet;
  private int fee;
  private String content;

  @Override
  public String toString() {
    return "Journey [jno=" + jno + ", driver=" + driver + ", departure=" + departure + ", routes="
        + routes + ", arrival=" + arrival + ", journeyDate=" + journeyDate + ", journeyTime="
        + journeyTime + ", seatPassenger=" + seatPassenger + ", seatRear=" + seatRear + ", pet="
        + pet + ", fee=" + fee + ", content=" + content + "]";
  }
  public int getJno() {
    return jno;
  }
  public void setJno(int jno) {
    this.jno = jno;
  }
  public Member getDriver() {
    return driver;
  }
  public void setDriver(Member driver) {
    this.driver = driver;
  }
  public String getDeparture() {
    return departure;
  }
  public void setDeparture(String departure) {
    this.departure = departure;
  }
  public List<Route> getRoutes() {
    return routes;
  }
  public void setRoutes(List<Route> routes) {
    this.routes = routes;
  }
  public String getArrival() {
    return arrival;
  }
  public void setArrival(String arrival) {
    this.arrival = arrival;
  }
  public Date getJourneyDate() {
    return journeyDate;
  }
  public void setJourneyDate(Date journeyDate) {
    this.journeyDate = journeyDate;
  }
  public Time getJourneyTime() {
    return journeyTime;
  }
  public void setJourneyTime(Time journeyTime) {
    this.journeyTime = journeyTime;
  }
  public int getSeatPassenger() {
    return seatPassenger;
  }
  public void setSeatPassenger(int seatPassenger) {
    this.seatPassenger = seatPassenger;
  }
  public int getSeatRear() {
    return seatRear;
  }
  public void setSeatRear(int seatRear) {
    this.seatRear = seatRear;
  }
  public int getPet() {
    return pet;
  }
  public void setPet(int pet) {
    this.pet = pet;
  }
  public int getFee() {
    return fee;
  }
  public void setFee(int fee) {
    this.fee = fee;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
    result = prime * result + ((content == null) ? 0 : content.hashCode());
    result = prime * result + ((departure == null) ? 0 : departure.hashCode());
    result = prime * result + ((driver == null) ? 0 : driver.hashCode());
    result = prime * result + fee;
    result = prime * result + jno;
    result = prime * result + ((journeyDate == null) ? 0 : journeyDate.hashCode());
    result = prime * result + ((journeyTime == null) ? 0 : journeyTime.hashCode());
    result = prime * result + pet;
    result = prime * result + ((routes == null) ? 0 : routes.hashCode());
    result = prime * result + seatPassenger;
    result = prime * result + seatRear;
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
    Journey other = (Journey) obj;
    if (arrival == null) {
      if (other.arrival != null)
        return false;
    } else if (!arrival.equals(other.arrival))
      return false;
    if (content == null) {
      if (other.content != null)
        return false;
    } else if (!content.equals(other.content))
      return false;
    if (departure == null) {
      if (other.departure != null)
        return false;
    } else if (!departure.equals(other.departure))
      return false;
    if (driver == null) {
      if (other.driver != null)
        return false;
    } else if (!driver.equals(other.driver))
      return false;
    if (fee != other.fee)
      return false;
    if (jno != other.jno)
      return false;
    if (journeyDate == null) {
      if (other.journeyDate != null)
        return false;
    } else if (!journeyDate.equals(other.journeyDate))
      return false;
    if (journeyTime == null) {
      if (other.journeyTime != null)
        return false;
    } else if (!journeyTime.equals(other.journeyTime))
      return false;
    if (pet != other.pet)
      return false;
    if (routes == null) {
      if (other.routes != null)
        return false;
    } else if (!routes.equals(other.routes))
      return false;
    if (seatPassenger != other.seatPassenger)
      return false;
    if (seatRear != other.seatRear)
      return false;
    return true;
  }



}