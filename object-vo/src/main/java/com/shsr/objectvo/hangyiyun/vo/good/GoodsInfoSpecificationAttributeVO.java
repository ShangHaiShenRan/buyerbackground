package com.shsr.objectvo.hangyiyun.vo.good;

import java.math.BigDecimal;

/**
 * @program: slmall-parent
 * @description: 商品信息规格项属性VO类
 * @author: JayLee
 * @create: 2018-10-18 15:12
 **/
public class GoodsInfoSpecificationAttributeVO {
    //规格属性名称（如：华为P10-64G-电信，红色-24号）
    private String levelPath;
    //规格库存
    private Integer stock;
    //当前价
    private BigDecimal price;
    //原价
    private BigDecimal priceOriginal;
    //成本价
    private BigDecimal priceCost;

    public String getLevelPath() {
        return levelPath;
    }

    public void setLevelPath(String levelPath) {
        this.levelPath = levelPath;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceOriginal() {
        return priceOriginal;
    }

    public void setPriceOriginal(BigDecimal priceOriginal) {
        this.priceOriginal = priceOriginal;
    }

    public BigDecimal getPriceCost() {
        return priceCost;
    }

    public void setPriceCost(BigDecimal priceCost) {
        this.priceCost = priceCost;
    }
}
