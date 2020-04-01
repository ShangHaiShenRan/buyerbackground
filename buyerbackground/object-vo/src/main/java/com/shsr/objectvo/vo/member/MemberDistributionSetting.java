package com.shsr.objectvo.vo.member;

import java.util.Date;

public class MemberDistributionSetting {
    private Long id;

    private String mallCode;

    private String fenxiaoshangRename;

    private String fenxiaoRename;

    private Integer profitsMaxLevel;

    private Date createAt;

    private Date updateAt;

    public String getMallCode() {
        return mallCode;
    }

    public void setMallCode(String mallCode) {
        this.mallCode = mallCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFenxiaoshangRename() {
        return fenxiaoshangRename;
    }

    public void setFenxiaoshangRename(String fenxiaoshangRename) {
        this.fenxiaoshangRename = fenxiaoshangRename == null ? null : fenxiaoshangRename.trim();
    }

    public String getFenxiaoRename() {
        return fenxiaoRename;
    }

    public void setFenxiaoRename(String fenxiaoRename) {
        this.fenxiaoRename = fenxiaoRename == null ? null : fenxiaoRename.trim();
    }

    public Integer getProfitsMaxLevel() {
        return profitsMaxLevel;
    }

    public void setProfitsMaxLevel(Integer profitsMaxLevel) {
        this.profitsMaxLevel = profitsMaxLevel;
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
}