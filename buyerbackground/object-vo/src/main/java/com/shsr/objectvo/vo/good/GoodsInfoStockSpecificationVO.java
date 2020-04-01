package com.shsr.objectvo.vo.good;

import java.util.List;

/**
 * @program: slmall-parent
 * @description: 商品信息库存规格VO类
 * @author: JayLee
 * @create: 2018-10-17 19:03
 **/
public class GoodsInfoStockSpecificationVO {
    //库存
    private Integer stock;
    //是否显示库存
    private Boolean isShowStock;
    //减库存的类型
    private String inventoryReductionType;
    //是否开启规格
    private Boolean isUseSpecification;
    //规格
    private List<GoodsInfoSpecificationVO> goodsInfoSpecificationVOs;
    //规格属性
    private List<GoodsInfoSpecificationAttributeVO> goodsInfoSpecificationAttributeVOs;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getIsShowStock() {
        return isShowStock;
    }

    public void setIsShowStock(Boolean isShowStock) {
        this.isShowStock = isShowStock;
    }

    public String getInventoryReductionType() {
        return inventoryReductionType;
    }

    public void setInventoryReductionType(String inventoryReductionType) {
        this.inventoryReductionType = inventoryReductionType;
    }

    public Boolean getIsUseSpecification() {
        return isUseSpecification;
    }

    public void setIsUseSpecification(Boolean isUseSpecification) {
        this.isUseSpecification = isUseSpecification;
    }

    public List<GoodsInfoSpecificationVO> getGoodsInfoSpecificationVOs() {
        return goodsInfoSpecificationVOs;
    }

    public void setGoodsInfoSpecificationVOs(List<GoodsInfoSpecificationVO> goodsInfoSpecificationVOs) {
        this.goodsInfoSpecificationVOs = goodsInfoSpecificationVOs;
    }

    public List<GoodsInfoSpecificationAttributeVO> getGoodsInfoSpecificationAttributeVOs() {
        return goodsInfoSpecificationAttributeVOs;
    }

    public void setGoodsInfoSpecificationAttributeVOs(List<GoodsInfoSpecificationAttributeVO> goodsInfoSpecificationAttributeVOs) {
        this.goodsInfoSpecificationAttributeVOs = goodsInfoSpecificationAttributeVOs;
    }
}
