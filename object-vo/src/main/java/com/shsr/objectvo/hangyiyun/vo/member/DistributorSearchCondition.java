package com.shsr.objectvo.hangyiyun.vo.member;

import java.util.Date;

public class DistributorSearchCondition {
    private String type;
    private String rank;
    private Integer pageNum;
    private Integer pageSize;
    private String inShopName;
    private String inTeamName;
    private Integer days;
    private Date inStartDate;
    private Date inEndDate;
    private Date lastDate;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getInShopName() {
        return inShopName;
    }

    public void setInShopName(String inShopName) {
        this.inShopName = inShopName;
    }

    public String getInTeamName() {
        return inTeamName;
    }

    public void setInTeamName(String inTeamName) {
        this.inTeamName = inTeamName;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getInStartDate() {
        return inStartDate;
    }

    public void setInStartDate(Date inStartDate) {
        this.inStartDate = inStartDate;
    }

    public Date getInEndDate() {
        return inEndDate;
    }

    public void setInEndDate(Date inEndDate) {
        this.inEndDate = inEndDate;
    }
}
