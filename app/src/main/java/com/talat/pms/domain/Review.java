package com.talat.pms.domain;

public class Review {
  private int no;
  private String review;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getReview() {
    return review;
  }
  public void setReview(String review) {
    this.review = review;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + no;
    result = prime * result + ((review == null) ? 0 : review.hashCode());
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
    Review other = (Review) obj;
    if (no != other.no)
      return false;
    if (review == null) {
      if (other.review != null)
        return false;
    } else if (!review.equals(other.review))
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "Review [no=" + no + ", review=" + review + "]";
  }


}
