package com.shsr.objectvo.vo.good;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: slmall-parent
 * @description: 商品基础信息类
 * @author: JayLee
 * @create: 2018-10-09 14:51
 **/
public class GoodsInfoBaseVO {
    //商品ID
    private Long id;
    //商城编码
    private String mallCode;
    //商品编码
    private String code;
    //商品名称
    private String name;
    //商品副标题
    private String subtitle;
    //商品简称
    private String abbr;
    //商品单位
    private String unit;
    //序号
    private Integer sort;
    //关键字
    private String keyword;
    //商品分类ID
    private Long categoryId;
    //商品属性
    private List<String> attributes;
    //当前价
    private BigDecimal priceCurrent;
    //原价
    private BigDecimal price;
    //成本价
    private BigDecimal priceCost;
    //定金
    private BigDecimal priceHandsel;
    //销量
    private Integer sales;
    //包邮金额即满额包邮金额；空或0默认为不参与满额包邮
    private BigDecimal priceStamp;
    //邮费
    private BigDecimal postage;
    //是否支持开发票
    private Boolean isInvoice;
    //默认标签：1：正品保证；2：7天无理由退换货；3：保修；
    private List<String> tagsDefault;
    //自定义标签ID；
    private List<String> tageCustomIds;
    //是否支持退换货
    private Boolean isRejected;
    //是否开店产品
    private Boolean isShopGoods;
    //是否搜索隐藏
    private Boolean isHideSearching;
    //商品状态（上架，下架）
    private String status;
    //商品图片
    private List<String> photos;
    //开团价格
    private BigDecimal priceGroup;
    //已成团数
    private Integer overallNumber;
    //开团人数
    private Integer groupNumber;
    //组团限时
    private Integer timeLimitHour;
    //是否可单独购买
    private Boolean isSinglePurchase;
    //是否拼团首页显示
    private Boolean isShowGroupShoppingHomePage;
    //购买次数限制
    private Integer buyCount;

    //商品封面图
    private String thumb;

    private Integer goodsType;

    public BigDecimal getPriceHandsel() {
        return priceHandsel;
    }

    public void setPriceHandsel(BigDecimal priceHandsel) {
        this.priceHandsel = priceHandsel;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public BigDecimal getPriceGroup() {
        return priceGroup;
    }

    public void setPriceGroup(BigDecimal priceGroup) {
        this.priceGroup = priceGroup;
    }

    public Integer getOverallNumber() {
        return overallNumber;
    }

    public void setOverallNumber(Integer overallNumber) {
        this.overallNumber = overallNumber;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Integer getTimeLimitHour() {
        return timeLimitHour;
    }

    public void setTimeLimitHour(Integer timeLimitHour) {
        this.timeLimitHour = timeLimitHour;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Boolean getIsSinglePurchase() {
        return isSinglePurchase;
    }

    public void setIsSinglePurchase(Boolean singlePurchase) {
        isSinglePurchase = singlePurchase;
    }

    public Boolean getIsShowGroupShoppingHomePage() {
        return isShowGroupShoppingHomePage;
    }

    public void setIsShowGroupShoppingHomePage(Boolean showGroupShoppingHomePage) {
        isShowGroupShoppingHomePage = showGroupShoppingHomePage;
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
        this.mallCode = mallCode;
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public BigDecimal getPriceCurrent() {
        return priceCurrent;
    }

    public void setPriceCurrent(BigDecimal priceCurrent) {
        this.priceCurrent = priceCurrent;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceCost() {
        return priceCost;
    }

    public void setPriceCost(BigDecimal priceCost) {
        this.priceCost = priceCost;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public BigDecimal getPriceStamp() {
        return priceStamp;
    }

    public void setPriceStamp(BigDecimal priceStamp) {
        this.priceStamp = priceStamp;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public Boolean getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(Boolean isInvoice) {
        this.isInvoice = isInvoice;
    }

    public List<String> getTagsDefault() {
        return tagsDefault;
    }

    public void setTagsDefault(List<String> tagsDefault) {
        this.tagsDefault = tagsDefault;
    }

    public List<String> getTageCustomIds() {
        return tageCustomIds;
    }

    public void setTageCustomIds(List<String> tageCustomIds) {
        this.tageCustomIds = tageCustomIds;
    }

    public Boolean getIsRejected() {
        return isRejected;
    }

    public void setIsRejected(Boolean isRejected) {
        this.isRejected = isRejected;
    }

    public Boolean getIsShopGoods() {
        return isShopGoods;
    }

    public void setIsShopGoods(Boolean isShopGoods) {
        this.isShopGoods = isShopGoods;
    }

    public Boolean getIsHideSearching() {
        return isHideSearching;
    }

    public void setIsHideSearching(Boolean isHideSearching) {
        this.isHideSearching = isHideSearching;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
