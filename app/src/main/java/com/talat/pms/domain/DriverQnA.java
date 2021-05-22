package com.talat.pms.domain;

import java.sql.Date;
import java.sql.Time;

public class DriverQnA {
  private int no;
  private int qnaTypeNo;
  //  private String qnaType;
  // 여정번호
  private Date date;
  private Time time;
  private Member writer;
  private int status;
  private String qContent;
  private String aContent;
  private String file;

  @Override
  public String toString() {
    return "DriverQnA [no=" + no + ", qnaTypeNo=" + qnaTypeNo + ", qnaType=" + ", date="
        + date + ", time=" + time + ", writer=" + writer + ", status=" + status + ", qContent="
        + qContent + ", aContent=" + aContent + ", file=" + file + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getQnaTypeNo() {
    return qnaTypeNo;
  }
  public void setQnaTypeNo(int qnaTypeNo) {
    this.qnaTypeNo = qnaTypeNo;
  }
  //  public String getQnaType() {
  //    return qnaType;
  //  }
  //  public void setQnaType(String qnaType) {
  //    this.qnaType = qnaType;
  //  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public Time getTime() {
    return time;
  }
  public void setTime(Time time) {
    this.time = time;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getqContent() {
    return qContent;
  }
  public void setqContent(String qContent) {
    this.qContent = qContent;
  }
  public String getaContent() {
    return aContent;
  }
  public void setaContent(String aContent) {
    this.aContent = aContent;
  }
  public String getFile() {
    return file;
  }
  public void setFile(String file) {
    this.file = file;
  }


}
