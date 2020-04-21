package com.shsr.objectvo.hangyiyun.vo.member;

import java.math.BigDecimal;
import java.util.Date;

public class DistributorLevel {

    private Long id;

    private Integer searchLevel;



    private String mallCode;

    private String levelName;

    private Integer levelValue;

    private BigDecimal commissionRateLevel1;

    private BigDecimal commissionRateLevel2;

    private BigDecimal commissionRateLevel3;

    private String nextLevelTerm;

    private Boolean isEnabled;

    private Date createAt;

    private Date updateAt;

    private String searchLevelName;

    public String getSearchLevelName() {
        return searchLevelName;
    }

    public void setSearchLevelName(String searchLevelName) {
        this.searchLevelName = searchLevelName;
    }

    public Integer getSearchLevel() {
        return searchLevel;
    }

    public void setSearchLevel(Integer searchLevel) {
        this.searchLevel = searchLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMallCode() {
        return mallCode;
    }

    public void setMallCode(String mallCode) {
        this.mallCode = mallCode == null ? null : mallCode.trim();
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public Integer getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(Integer levelValue) {
        this.levelValue = levelValue;
    }

    public BigDecimal getCommissionRateLevel1() {
        return commissionRateLevel1;
    }

    public void setCommissionRateLevel1(BigDecimal commissionRateLevel1) {
        this.commissionRateLevel1 = commissionRateLevel1;
    }

    public BigDecimal getCommissionRateLevel2() {
        return commissionRateLevel2;
    }

    public void setCommissionRateLevel2(BigDecimal commissionRateLevel2) {
        this.commissionRateLevel2 = commissionRateLevel2;
    }

    public BigDecimal getCommissionRateLevel3() {
        return commissionRateLevel3;
    }

    public void setCommissionRateLevel3(BigDecimal commissionRateLevel3) {
        this.commissionRateLevel3 = commissionRateLevel3;
    }

    public String getNextLevelTerm() {
        return nextLevelTerm;
    }

    public void setNextLevelTerm(String nextLevelTerm) {
        this.nextLevelTerm = nextLevelTerm == null ? null : nextLevelTerm.trim();
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "DistributorLevel{" +
                "id=" + id +
                ", mallCode='" + mallCode + '\'' +
                ", levelName='" + levelName + '\'' +
                ", levelValue=" + levelValue +
                ", commissionRateLevel1=" + commissionRateLevel1 +
                ", commissionRateLevel2=" + commissionRateLevel2 +
                ", commissionRateLevel3=" + commissionRateLevel3 +
                ", nextLevelTerm='" + nextLevelTerm + '\'' +
                ", isEnabled=" + isEnabled +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}