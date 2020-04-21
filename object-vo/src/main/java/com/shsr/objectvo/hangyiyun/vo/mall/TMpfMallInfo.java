package com.shsr.objectvo.hangyiyun.vo.mall;

/**
 * @Author wangcc
 * @Description将最后两个createAt 和 UpdateAt 字段的类型进行更改将 timestamp类型转化成string类型，原因前端返回的mall对象不能匹配
 * @Date 15:06 2020/4/7
 * @Param
 * @return
 **/
public class TMpfMallInfo {
  private long id;
  private String code;
  private String name;
  private String companyName;
  private String logo;
  private String note;
  private String legalPersonName;
  private String phone;
  private String qq;
  private String provinceCode;
  private String cityCode;
  private String districtCode;
  private String contactAddress;
  private String consumerWorkingTime;
  private Boolean isEnabled;
  private String createAt;
  private String updateAt;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }


  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }


  public String getLegalPersonName() {
    return legalPersonName;
  }

  public void setLegalPersonName(String legalPersonName) {
    this.legalPersonName = legalPersonName;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }


  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }


  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }


  public String getDistrictCode() {
    return districtCode;
  }

  public void setDistrictCode(String districtCode) {
    this.districtCode = districtCode;
  }


  public String getContactAddress() {
    return contactAddress;
  }

  public void setContactAddress(String contactAddress) {
    this.contactAddress = contactAddress;
  }


  public String getConsumerWorkingTime() {
    return consumerWorkingTime;
  }

  public void setConsumerWorkingTime(String consumerWorkingTime) {
    this.consumerWorkingTime = consumerWorkingTime;
  }


  public Boolean getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
  }


  public String getCreateAt() {
    return createAt;
  }

  public void setCreateAt(String createAt) {
    this.createAt = createAt;
  }


  public String getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(String updateAt) {
    this.updateAt = updateAt;
  }

}
