package com.shsr.objectvo.vo.order;


public class TModOrderDetailes5 {

  private long id;
  private long orderId;
  private long goodsId;
  private String goodsName;
  private String goodsThumbnail;
  private String specAttr;
  private long specAttrId;
  private String orderDetailsCode;
  private double price;
  private long amount;
  private long rejectedAmount;
  private double discountRate;
  private double distributionRatio1;
  private double distributionRatio2;
  private double distributionRatio3;
  private java.sql.Timestamp createAt;
  private java.sql.Timestamp updateAt;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public String getGoodsThumbnail() {
    return goodsThumbnail;
  }

  public void setGoodsThumbnail(String goodsThumbnail) {
    this.goodsThumbnail = goodsThumbnail;
  }


  public String getSpecAttr() {
    return specAttr;
  }

  public void setSpecAttr(String specAttr) {
    this.specAttr = specAttr;
  }


  public long getSpecAttrId() {
    return specAttrId;
  }

  public void setSpecAttrId(long specAttrId) {
    this.specAttrId = specAttrId;
  }


  public String getOrderDetailsCode() {
    return orderDetailsCode;
  }

  public void setOrderDetailsCode(String orderDetailsCode) {
    this.orderDetailsCode = orderDetailsCode;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }


  public long getRejectedAmount() {
    return rejectedAmount;
  }

  public void setRejectedAmount(long rejectedAmount) {
    this.rejectedAmount = rejectedAmount;
  }


  public double getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(double discountRate) {
    this.discountRate = discountRate;
  }


  public double getDistributionRatio1() {
    return distributionRatio1;
  }

  public void setDistributionRatio1(double distributionRatio1) {
    this.distributionRatio1 = distributionRatio1;
  }


  public double getDistributionRatio2() {
    return distributionRatio2;
  }

  public void setDistributionRatio2(double distributionRatio2) {
    this.distributionRatio2 = distributionRatio2;
  }


  public double getDistributionRatio3() {
    return distributionRatio3;
  }

  public void setDistributionRatio3(double distributionRatio3) {
    this.distributionRatio3 = distributionRatio3;
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
