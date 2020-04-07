package com.shsr.objectvo.vo.mall;


public class TMpfMallAdmin {

  private long id;
  private String mallCode;
  private String appCode;
  private String name;
  private String account;
  private String pwd;
  private long type;
  private long shippingWarehouseId;
  private long isEnabled;
  private java.sql.Timestamp createAt;
  private java.sql.Timestamp updateAt;


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


  public String getAppCode() {
    return appCode;
  }

  public void setAppCode(String appCode) {
    this.appCode = appCode;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getShippingWarehouseId() {
    return shippingWarehouseId;
  }

  public void setShippingWarehouseId(long shippingWarehouseId) {
    this.shippingWarehouseId = shippingWarehouseId;
  }


  public long getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(long isEnabled) {
    this.isEnabled = isEnabled;
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
