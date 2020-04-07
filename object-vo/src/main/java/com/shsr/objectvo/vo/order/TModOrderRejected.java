package com.shsr.objectvo.vo.order;


public class TModOrderRejected {

  private long id;
  private String orderRejectedCode;
  private String courierCode;
  private String expressName;
  private long orderId;
  private double rejectedAmount;
  private long isPacking;
  private long isAttach;
  private long isGoods;
  private String rejectedReason;
  private String rejectedExplain;
  private String paths;
  private long rejectedType;
  private java.sql.Timestamp createAt;
  private java.sql.Timestamp updateAt;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getOrderRejectedCode() {
    return orderRejectedCode;
  }

  public void setOrderRejectedCode(String orderRejectedCode) {
    this.orderRejectedCode = orderRejectedCode;
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


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public double getRejectedAmount() {
    return rejectedAmount;
  }

  public void setRejectedAmount(double rejectedAmount) {
    this.rejectedAmount = rejectedAmount;
  }


  public long getIsPacking() {
    return isPacking;
  }

  public void setIsPacking(long isPacking) {
    this.isPacking = isPacking;
  }


  public long getIsAttach() {
    return isAttach;
  }

  public void setIsAttach(long isAttach) {
    this.isAttach = isAttach;
  }


  public long getIsGoods() {
    return isGoods;
  }

  public void setIsGoods(long isGoods) {
    this.isGoods = isGoods;
  }


  public String getRejectedReason() {
    return rejectedReason;
  }

  public void setRejectedReason(String rejectedReason) {
    this.rejectedReason = rejectedReason;
  }


  public String getRejectedExplain() {
    return rejectedExplain;
  }

  public void setRejectedExplain(String rejectedExplain) {
    this.rejectedExplain = rejectedExplain;
  }


  public String getPaths() {
    return paths;
  }

  public void setPaths(String paths) {
    this.paths = paths;
  }


  public long getRejectedType() {
    return rejectedType;
  }

  public void setRejectedType(long rejectedType) {
    this.rejectedType = rejectedType;
  }


  public java.sql.Timestamp getCreateAt() {
    return createAt;
  }

  public void setCreateAt(java.sql.Timestamp createAt) {
    this.createAt = createAt;
  }


  public java.sql.Timestamp getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(java.sql.Timestamp updateAt) {
    this.updateAt = updateAt;
  }

}
