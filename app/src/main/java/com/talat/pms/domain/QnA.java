package com.talat.pms.domain;

public class QnA {
  private int no;
  private String typeTitle;

  @Override
  public String toString() {
    return "QnA [no=" + no + ", typeTitle=" + typeTitle + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTypeTitle() {
    return typeTitle;
  }
  public void setTypeTitle(String typeTitle) {
    this.typeTitle = typeTitle;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + no;
    result = prime * result + ((typeTitle == null) ? 0 : typeTitle.hashCode());
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
    QnA other = (QnA) obj;
    if (no != other.no)
      return false;
    if (typeTitle == null) {
      if (other.typeTitle != null)
        return false;
    } else if (!typeTitle.equals(other.typeTitle))
      return false;
    return true;
  }
}
