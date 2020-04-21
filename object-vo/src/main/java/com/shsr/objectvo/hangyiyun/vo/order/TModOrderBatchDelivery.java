package com.shsr.objectvo.hangyiyun.vo.order;


public class TModOrderBatchDelivery {

  private long id;
  private String mallCode;
  private String fileName;
  private String fileUrl;
  private String fileStatus;
  private java.sql.Timestamp fileCreatTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMallCode() {
    return mallCode;
  }

  public void setMallCode(String mallCode) {
    this.mallCode = mallCode;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }


  public String getFileStatus() {
    return fileStatus;
  }

  public void setFileStatus(String fileStatus) {
    this.fileStatus = fileStatus;
  }


  public java.sql.Timestamp getFileCreatTime() {
    return fileCreatTime;
  }

  public void setFileCreatTime(java.sql.Timestamp fileCreatTime) {
    this.fileCreatTime = fileCreatTime;
  }

}
