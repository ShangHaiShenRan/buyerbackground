package com.shsr.objectvo.hangyiyun.vo.good;

import java.util.List;

/**
 * @program: slmall-parent
 * @description: 商品信息规格VO类
 * @author: JayLee
 * @create: 2018-10-17 19:16
 **/
public class GoodsInfoSpecificationVO {
    //规格名
    private String specName;
    //规格序号
    private Integer specSort;
    //规格项
    private List<GoodsInfoSpecificationItemVO> goodsInfoSpecificationItemVOs;

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getSpecSort() {
        return specSort;
    }

    public void setSpecSort(Integer specSort) {
        this.specSort = specSort;
    }

    public List<GoodsInfoSpecificationItemVO> getGoodsInfoSpecificationItemVOs() {
        return goodsInfoSpecificationItemVOs;
    }

    public void setGoodsInfoSpecificationItemVOs(List<GoodsInfoSpecificationItemVO> goodsInfoSpecificationItemVOs) {
        this.goodsInfoSpecificationItemVOs = goodsInfoSpecificationItemVOs;
    }
}
