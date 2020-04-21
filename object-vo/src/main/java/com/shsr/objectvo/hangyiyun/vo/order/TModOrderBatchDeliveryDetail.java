package com.shsr.objectvo.hangyiyun.vo.order;


public class TModOrderBatchDeliveryDetail {

  private long id;
  private String orderCode;
  private long fileId;
  private String courierCode;
  private String expressName;
  private String fileOrderStatus;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }


  public long getFileId() {
    return fileId;
  }

  public void setFileId(long fileId) {
    this.fileId = fileId;
  }


  public String getCourierCode() {
    return courierCode;
  }

  public void setCourierCode(String courierCode) {
    this.courierCode = courierCode;
  }


  public String getExpressName() {
    return expressName;
  }

  public void setExpressName(String expressName) {
    this.expressName = expressName;
  }


  public String getFileOrderStatus() {
    return fileOrderStatus;
  }

  public void setFileOrderStatus(String fileOrderStatus) {
    this.fileOrderStatus = fileOrderStatus;
  }

}
