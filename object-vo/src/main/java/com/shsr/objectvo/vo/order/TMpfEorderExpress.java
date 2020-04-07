package com.shsr.objectvo.vo.order;


public class TMpfEorderExpress {

  private long id;
  private String name;
  private String code;
  private long payType;
  private String monthCode;
  private java.sql.Timestamp createAt;
  private java.sql.Timestamp updateAt;
  private String customerName;
  private String customerPwd;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public long getPayType() {
    return payType;
  }

  public void setPayType(long payType) {
    this.payType = payType;
  }


  public String getMonthCode() {
    return monthCode;
  }

  public void setMonthCode(String monthCode) {
    this.monthCode = monthCode;
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


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  public String getCustomerPwd() {
    return customerPwd;
  }

  public void setCustomerPwd(String customerPwd) {
    this.customerPwd = customerPwd;
  }

}
