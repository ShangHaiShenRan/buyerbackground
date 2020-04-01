package com.shsr.objectvo.vo.order;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author zxp
 * @Title: OrderActive
 * @Description: TODO
 * @date 2018/10/8 0008
 */
public class OrderActive {

    private Long id;
    @ApiModelProperty("订单编码")
    private String orderCode;
    @ApiModelProperty("商城编码")
    private String mallCode;
    @ApiModelProperty("优惠活动名称")
    private String activeName;
    @ApiModelProperty("优惠活动金额")
    private BigDecimal activeAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getMallCode() {
        return mallCode;
    }

    public void setMallCode(String mallCode) {
        this.mallCode = mallCode;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public BigDecimal getActiveAmount() {
        return activeAmount;
    }

    public void setActiveAmount(BigDecimal activeAmount) {
        this.activeAmount = activeAmount;
    }
}
