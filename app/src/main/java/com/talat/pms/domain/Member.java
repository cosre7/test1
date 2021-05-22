package com.talat.pms.domain;

import java.sql.Date;

public class Member {
  private String mname;
  private String email;
  private String password;
  private String tel;
  private Date birth;
  private int mType;
  private int mno;
  private String nicName;
  private int gender;
  private String postNo;
  private String basicAddress;
  private String detailAddress;
  private String profile;
  private int preferenceGender;
  private Date registeredDate;
  private double starAverage;

  @Override
  public String toString() {
    return "Member [mno=" + mno + ", mname=" + mname + ", email=" + email + ", password=" + password
        + ", tel=" + tel + ", birth=" + birth + ", mType=" + mType + ", nicName=" + nicName
        + ", gender=" + gender + ", postNo=" + postNo + ", basicAddress=" + basicAddress
        + ", detailAddress=" + detailAddress + ", profile=" + profile + ", preferenceGender="
        + preferenceGender + ", registeredDate=" + registeredDate + ", starAverage=" + starAverage
        + "]";
  }

  public int getMno() {
    return mno;
  }

  public void setMno(int mno) {
    this.mno = mno;
  }

  public String getMname() {
    return mname;
  }

  public void setMname(String mname) {
    this.mname = mname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public int getmType() {
    return mType;
  }

  public void setmType(int mType) {
    this.mType = mType;
  }

  public String getNicName() {
    return nicName;
  }

  public void setNicName(String nicName) {
    this.nicName = nicName;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getPostNo() {
    return postNo;
  }

  public void setPostNo(String postNo) {
    this.postNo = postNo;
  }

  public String getBasicAddress() {
    return basicAddress;
  }

  public void setBasicAddress(String basicAddress) {
    this.basicAddress = basicAddress;
  }

  public String getDetailAddress() {
    return detailAddress;
  }

  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }

  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public int getPreferenceGender() {
    return preferenceGender;
  }

  public void setPreferenceGender(int preferenceGender) {
    this.preferenceGender = preferenceGender;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  public double getStarAverage() {
    return starAverage;
  }

  public void setStarAverage(double starAverage) {
    this.starAverage = starAverage;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((basicAddress == null) ? 0 : basicAddress.hashCode());
    result = prime * result + ((birth == null) ? 0 : birth.hashCode());
    result = prime * result + ((detailAddress == null) ? 0 : detailAddress.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + gender;
    result = prime * result + mType;
    result = prime * result + ((mname == null) ? 0 : mname.hashCode());
    result = prime * result + mno;
    result = prime * result + ((nicName == null) ? 0 : nicName.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((postNo == null) ? 0 : postNo.hashCode());
    result = prime * result + preferenceGender;
    result = prime * result + ((profile == null) ? 0 : profile.hashCode());
    result = prime * result + ((registeredDate == null) ? 0 : registeredDate.hashCode());
    long temp;
    temp = Double.doubleToLongBits(starAverage);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
    Member other = (Member) obj;
    if (basicAddress == null) {
      if (other.basicAddress != null)
        return false;
    } else if (!basicAddress.equals(other.basicAddress))
      return false;
    if (birth == null) {
      if (other.birth != null)
        return false;
    } else if (!birth.equals(other.birth))
      return false;
    if (detailAddress == null) {
      if (other.detailAddress != null)
        return false;
    } else if (!detailAddress.equals(other.detailAddress))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (gender != other.gender)
      return false;
    if (mType != other.mType)
      return false;
    if (mname == null) {
      if (other.mname != null)
        return false;
    } else if (!mname.equals(other.mname))
      return false;
    if (mno != other.mno)
      return false;
    if (nicName == null) {
      if (other.nicName != null)
        return false;
    } else if (!nicName.equals(other.nicName))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (postNo == null) {
      if (other.postNo != null)
        return false;
    } else if (!postNo.equals(other.postNo))
      return false;
    if (preferenceGender != other.preferenceGender)
      return false;
    if (profile == null) {
      if (other.profile != null)
        return false;
    } else if (!profile.equals(other.profile))
      return false;
    if (registeredDate == null) {
      if (other.registeredDate != null)
        return false;
    } else if (!registeredDate.equals(other.registeredDate))
      return false;
    if (Double.doubleToLongBits(starAverage) != Double.doubleToLongBits(other.starAverage))
      return false;
    if (tel == null) {
      if (other.tel != null)
        return false;
    } else if (!tel.equals(other.tel))
      return false;
    return true;
  }

}