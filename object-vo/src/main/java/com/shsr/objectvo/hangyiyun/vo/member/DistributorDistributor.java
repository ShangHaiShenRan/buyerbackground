package com.shsr.objectvo.hangyiyun.vo.member;

import java.math.BigDecimal;
import java.util.Date;

public class DistributorDistributor {
    private Long id;

    private Long memberId;

    private Long parentId;

    private Integer memberLevel;

    private Integer distributorLevelValue;

    private BigDecimal openShopGoodsAmount;

    private BigDecimal shopGoodsAmount;

    private Integer sellPeoples;

    private Integer sellDistributorPeoples;

    private Date createAt;

    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    public Integer getDistributorLevelValue() {
        return distributorLevelValue;
    }

    public void setDistributorLevelValue(Integer distributorLevelValue) {
        this.distributorLevelValue = distributorLevelValue;
    }

    public BigDecimal getOpenShopGoodsAmount() {
        return openShopGoodsAmount;
    }

    public void setOpenShopGoodsAmount(BigDecimal openShopGoodsAmount) {
        this.openShopGoodsAmount = openShopGoodsAmount;
    }

    public BigDecimal getShopGoodsAmount() {
        return shopGoodsAmount;
    }

    public void setShopGoodsAmount(BigDecimal shopGoodsAmount) {
        this.shopGoodsAmount = shopGoodsAmount;
    }

    public Integer getSellPeoples() {
        return sellPeoples;
    }

    public void setSellPeoples(Integer sellPeoples) {
        this.sellPeoples = sellPeoples;
    }

    public Integer getSellDistributorPeoples() {
        return sellDistributorPeoples;
    }

    public void setSellDistributorPeoples(Integer sellDistributorPeoples) {
        this.sellDistributorPeoples = sellDistributorPeoples;
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