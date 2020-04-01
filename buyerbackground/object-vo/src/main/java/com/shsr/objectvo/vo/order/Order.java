package com.shsr.objectvo.vo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel("订单实体")
public class Order {

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("商城编码")
    private String mallCode;
    @ApiModelProperty("是否分销订单  0：否；1：是；默认为1")
    private Boolean isDistributionOrder;
    @ApiModelProperty("订单编号")
    private String orderCode;
    @ApiModelProperty("快递单号")
    private String courierCode;
    @ApiModelProperty("商品数量")
    private Integer goodsAmount;
    @ApiModelProperty("订单应付款")
    private BigDecimal payableAmount;
    @ApiModelProperty("折扣金额")
    private BigDecimal discountAmount;
    @ApiModelProperty("折扣率")
    private BigDecimal discountRate;
    @ApiModelProperty("订单实付款")
    private BigDecimal paidAmount;
    @ApiModelProperty("付款方式   1：微信支付；2：支付宝支付；默认为1")
    private Byte paymentWay;
    @ApiModelProperty("支付流水号")
    private String paymentSerialNumber;
    @ApiModelProperty("优惠券ID")
    private Long couponId;
    @ApiModelProperty("优惠券名称")
    private String couponName;
    @ApiModelProperty("优惠券抵扣金额")
    private BigDecimal couponDeductionAmount;
    @ApiModelProperty("分销商ID")
    private Long distributiorId;
    @ApiModelProperty("分销商名称")
    private String distributorName;
    @ApiModelProperty("买家会员id")
    private Long buyerMemberId;
    @ApiModelProperty("买家姓名")
    private String buyerName;
    @ApiModelProperty("买家留言")
    private String buyerMessage;
    @ApiModelProperty("付款人姓名")
    private String payerName;
    @ApiModelProperty("配送方式   1：送货上门；2：客户自提；默认为1")
    private Byte shippingWay;
    @ApiModelProperty("快递名称")
    private String expressName;
    @ApiModelProperty("运费金额")
    private BigDecimal freightAmount;
    @ApiModelProperty("收货人姓名")
    private String consigneeName;
    @ApiModelProperty("收货人电话")
    private String consigneePhone;
    @ApiModelProperty("收货地址")
    private String consigneeAddress;
    @ApiModelProperty("省编码")
    private String proviceCode;
    @ApiModelProperty("配送城市code")
    private String cityCode;
    @ApiModelProperty("区县code")
    private String countyCode;
    @ApiModelProperty("下单时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date orderTime;
    @ApiModelProperty("付款时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date payTime;
    @ApiModelProperty("发货时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date deliveryTime;
    @ApiModelProperty("完成时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date finishTime;
    @ApiModelProperty("订单状态\n" +
            "            1：已提交（未付款）；\n" +
            "            2：已关闭（超过付款时间）\n" +
            "            3：已付款（未发货）；\n" +
            "            4：已发货（未签收）；\n" +
            "            5：已签收（未评价）；\n" +
            "            6：已完成（已评价）；\n" +
            "            7：申请退款（未确认）；\n" +
            "            8：已退款（已确认）；\n" +
            "            9：已删除；'")
    private Byte orderStatus;

    private Byte rejectedStatus;
    @ApiModelProperty("备注")
    private String note;
    @ApiModelProperty("更新时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
    @ApiModelProperty("创建时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @ApiModelProperty("退货/取消理由")
    private String reason;
    @ApiModelProperty("订单商品列表")
    private List<OrderDetails> goodsList;
    @ApiModelProperty("分销商等级")
    private Integer memberLevel;
    @ApiModelProperty("订单优惠活动")
    private List<OrderActive> orderActive;

    private Integer  pageSize;

    private Integer pageNum;

    private String selectTime;

    private String  startTime;

    private  String endTime;

    private String selectDetail;

    private String details;

    private  String goodsName;

    private  String specAttr;

    private BigDecimal price;

    private BigDecimal amount;

    private BigDecimal distributionRatio1;

    private BigDecimal distributionRatio2;

    private BigDecimal distributionRatio3;

    private String orderStatusName;

    private  String isDistributionOrderName;

    private  String paymentWayName;

    private  String shippingWayName;

    private String cityName;

    private  String detailAddress;

    private String mallName;

    public Byte getRejectedStatus() {
        return rejectedStatus;
    }

    public void setRejectedStatus(Byte rejectedStatus) {
        this.rejectedStatus = rejectedStatus;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSpecAttr() {
        return specAttr;
    }

    public void setSpecAttr(String specAttr) {
        this.specAttr = specAttr;
    }

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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getSelectTime() {
        return selectTime;
    }

    public void setSelectTime(String selectTime) {
        this.selectTime = selectTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSelectDetail() {
        return selectDetail;
    }

    public void setSelectDetail(String selectDetail) {
        this.selectDetail = selectDetail;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<OrderActive> getOrderActive() {
        return orderActive;
    }

    public void setOrderActive(List<OrderActive> orderActive) {
        this.orderActive = orderActive;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getProviceCode() {
        return proviceCode;
    }

    public void setProviceCode(String proviceCode) {
        this.proviceCode = proviceCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public List<OrderDetails> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderDetails> goodsList) {
        this.goodsList = goodsList;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMallCode() {
        return mallCode;
    }

    public void setMallCode(String mallCode) {
        this.mallCode = mallCode;
    }

    public Boolean getDistributionOrder() {
        return isDistributionOrder;
    }

    public void setDistributionOrder(Boolean distributionOrder) {
        isDistributionOrder = distributionOrder;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCourierCode() {
        return courierCode;
    }

    public void setCourierCode(String courierCode) {
        this.courierCode = courierCode;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Byte getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(Byte paymentWay) {
        this.paymentWay = paymentWay;
    }

    public String getPaymentSerialNumber() {
        return paymentSerialNumber;
    }

    public void setPaymentSerialNumber(String paymentSerialNumber) {
        this.paymentSerialNumber = paymentSerialNumber;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public BigDecimal getCouponDeductionAmount() {
        return couponDeductionAmount;
    }

    public void setCouponDeductionAmount(BigDecimal couponDeductionAmount) {
        this.couponDeductionAmount = couponDeductionAmount;
    }

    public Long getDistributiorId() {
        return distributiorId;
    }

    public void setDistributiorId(Long distributiorId) {
        this.distributiorId = distributiorId;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public Long getBuyerMemberId() {
        return buyerMemberId;
    }

    public void setBuyerMemberId(Long buyerMemberId) {
        this.buyerMemberId = buyerMemberId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public Byte getShippingWay() {
        return shippingWay;
    }

    public void setShippingWay(Byte shippingWay) {
        this.shippingWay = shippingWay;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public String getIsDistributionOrderName() {
        return isDistributionOrderName;
    }

    public void setIsDistributionOrderName(String isDistributionOrderName) {
        this.isDistributionOrderName = isDistributionOrderName;
    }

    public String getPaymentWayName() {
        return paymentWayName;
    }

    public void setPaymentWayName(String paymentWayName) {
        this.paymentWayName = paymentWayName;
    }

    public String getShippingWayName() {
        return shippingWayName;
    }

    public void setShippingWayName(String shippingWayName) {
        this.shippingWayName = shippingWayName;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", mallCode='" + mallCode + '\'' +
                ", isDistributionOrder=" + isDistributionOrder +
                ", orderCode='" + orderCode + '\'' +
                ", courierCode='" + courierCode + '\'' +
                ", goodsAmount=" + goodsAmount +
                ", payableAmount=" + payableAmount +
                ", discountAmount=" + discountAmount +
                ", discountRate=" + discountRate +
                ", paidAmount=" + paidAmount +
                ", paymentWay=" + paymentWay +
                ", paymentSerialNumber='" + paymentSerialNumber + '\'' +
                ", couponId=" + couponId +
                ", couponName='" + couponName + '\'' +
                ", couponDeductionAmount=" + couponDeductionAmount +
                ", distributiorId=" + distributiorId +
                ", distributorName='" + distributorName + '\'' +
                ", buyerMemberId=" + buyerMemberId +
                ", buyerName='" + buyerName + '\'' +
                ", buyerMessage='" + buyerMessage + '\'' +
                ", payerName='" + payerName + '\'' +
                ", shippingWay=" + shippingWay +
                ", expressName='" + expressName + '\'' +
                ", freightAmount=" + freightAmount +
                ", consigneeName='" + consigneeName + '\'' +
                ", consigneePhone='" + consigneePhone + '\'' +
                ", consigneeAddress='" + consigneeAddress + '\'' +
                ", proviceCode='" + proviceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", countyCode='" + countyCode + '\'' +
                ", orderTime=" + orderTime +
                ", payTime=" + payTime +
                ", deliveryTime=" + deliveryTime +
                ", finishTime=" + finishTime +
                ", orderStatus=" + orderStatus +
                ", rejectedStatus=" + rejectedStatus +
                ", note='" + note + '\'' +
                ", updateAt=" + updateAt +
                ", createAt=" + createAt +
                ", reason='" + reason + '\'' +
                ", goodsList=" + goodsList +
                ", memberLevel=" + memberLevel +
                ", orderActive=" + orderActive +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", selectTime='" + selectTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", selectDetail='" + selectDetail + '\'' +
                ", details='" + details + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specAttr='" + specAttr + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", distributionRatio1=" + distributionRatio1 +
                ", distributionRatio2=" + distributionRatio2 +
                ", distributionRatio3=" + distributionRatio3 +
                ", orderStatusName='" + orderStatusName + '\'' +
                ", isDistributionOrderName='" + isDistributionOrderName + '\'' +
                ", paymentWayName='" + paymentWayName + '\'' +
                ", shippingWayName='" + shippingWayName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", mallName='" + mallName + '\'' +
                '}';
    }
}