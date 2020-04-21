package com.shsr.objectvo.hangyiyun.vo.order;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetails {
    private Long id;

    private Long orderId;

    private Long goodsId;

    private String goodsName;

    private String goodsThumbnail;

    private String specAttr;

    private String orderDetailsCode;

    private BigDecimal price;

    private Integer amount;

    private BigDecimal discountRate;

    @ApiModelProperty("小计")
    private BigDecimal subtotal;
    @ApiModelProperty("是否改价：0否，1是")
    private int isChangePrice;
    private Date createAt;

    private Date updateAt;
    @ApiModelProperty("一级分销金")
    private BigDecimal distributionRatio1;
    @ApiModelProperty("二级分销金")
    private BigDecimal distributionRatio2;
    @ApiModelProperty("三级分销金")
    private BigDecimal distributionRatio3;

    public BigDecimal getDistributionRatio1() {
        return distributionRatio1;
    }

    public void setDistributionRatio1(BigDecimal distributionRatio1) {
        this.distributionRatio1 = distributionRatio1;
    }

    public BigDecimal getDistributionRatio2() {
        return distributionRatio2;
    }

    public void setDistributionRatio2(BigDecimal distributionRatio2) {
        this.distributionRatio2 = distributionRatio2;
    }

    public BigDecimal getDistributionRatio3() {
        return distributionRatio3;
    }

    public void setDistributionRatio3(BigDecimal distributionRatio3) {
        this.distributionRatio3 = distributionRatio3;
    }

    public String getGoodsThumbnail() {
        return goodsThumbnail;
    }

    public void setGoodsThumbnail(String goodsThumbnail) {
        this.goodsThumbnail = goodsThumbnail;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public int getIsChangePrice() {
        return isChangePrice;
    }

    public void setIsChangePrice(int isChangePrice) {
        this.isChangePrice = isChangePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getSpecAttr() {
        return specAttr;
    }

    public void setSpecAttr(String specAttr) {
        this.specAttr = specAttr == null ? null : specAttr.trim();
    }

    public String getOrderDetailsCode() {
        return orderDetailsCode;
    }

    public void setOrderDetailsCode(String orderDetailsCode) {
        this.orderDetailsCode = orderDetailsCode == null ? null : orderDetailsCode.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
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