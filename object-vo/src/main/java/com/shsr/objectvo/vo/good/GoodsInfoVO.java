package com.shsr.objectvo.vo.good;

import java.util.List;

/**
 * @program: slmall-parent
 * @description: 商品信息VO实体类
 * @author: JayLee
 * @create: 2018-10-07 14:32
 **/
public class GoodsInfoVO {
    //商品基础信息
    private GoodsInfoBaseVO goodsInfoBaseVO;
    //商品购买权限信息
    private GoodsInfoBuyPermissionVO goodsInfoBuyPermissionVO;
    //商品参数信息
    private List<GoodsInfoParamVO> goodsInfoParamVOs;
    //自定义参数
    private List<GoodsInfoColumnVO> goodsInfoColumnVOs;
    //商品详情信息
    private GoodsInfoDetailsVO goodsInfoDetailsVO;
    //商品分销信息
    private GoodsInfoDistributionVO goodsInfoDistributionVO;
    //商品素材信息
    private GoodsInfoShareMaterialVO goodsInfoShareMaterialVO;
    //门店商品的分销信息
    private GoodsInfoStroePermissionVO goodsInfoStroePermissionVO;

    public GoodsInfoBaseVO getGoodsInfoBaseVO() {
        return goodsInfoBaseVO;
    }

    private GoodsInfoStockSpecificationVO goodsInfoStockSpecificationVO;

    public void setGoodsInfoBaseVO(GoodsInfoBaseVO goodsInfoBaseVO) {
        this.goodsInfoBaseVO = goodsInfoBaseVO;
    }

    public GoodsInfoBuyPermissionVO getGoodsInfoBuyPermissionVO() {
        return goodsInfoBuyPermissionVO;
    }

    public void setGoodsInfoBuyPermissionVO(GoodsInfoBuyPermissionVO goodsInfoBuyPermissionVO) {
        this.goodsInfoBuyPermissionVO = goodsInfoBuyPermissionVO;
    }

    public List<GoodsInfoParamVO> getGoodsInfoParamVOs() {
        return goodsInfoParamVOs;
    }

    public void setGoodsInfoParamVOs(List<GoodsInfoParamVO> goodsInfoParamVOs) {
        this.goodsInfoParamVOs = goodsInfoParamVOs;
    }

    public GoodsInfoShareMaterialVO getGoodsInfoShareMaterialVO() {
        return goodsInfoShareMaterialVO;
    }

    public void setGoodsInfoShareMaterialVO(GoodsInfoShareMaterialVO goodsInfoShareMaterialVO) {
        this.goodsInfoShareMaterialVO = goodsInfoShareMaterialVO;
    }

    public GoodsInfoDetailsVO getGoodsInfoDetailsVO() {
        return goodsInfoDetailsVO;
    }

    public void setGoodsInfoDetailsVO(GoodsInfoDetailsVO goodsInfoDetailsVO) {
        this.goodsInfoDetailsVO = goodsInfoDetailsVO;
    }

    public GoodsInfoDistributionVO getGoodsInfoDistributionVO() {
        return goodsInfoDistributionVO;
    }

    public void setGoodsInfoDistributionVO(GoodsInfoDistributionVO goodsInfoDistributionVO) {
        this.goodsInfoDistributionVO = goodsInfoDistributionVO;
    }

    public GoodsInfoStockSpecificationVO getGoodsInfoStockSpecificationVO() {
        return goodsInfoStockSpecificationVO;
    }

    public void setGoodsInfoStockSpecificationVO(GoodsInfoStockSpecificationVO goodsInfoStockSpecificationVO) {
        this.goodsInfoStockSpecificationVO = goodsInfoStockSpecificationVO;
    }

    public List<GoodsInfoColumnVO> getGoodsInfoColumnVOs() {
        return goodsInfoColumnVOs;
    }

    public void setGoodsInfoColumnVOs(List<GoodsInfoColumnVO> goodsInfoColumnVOs) {
        this.goodsInfoColumnVOs = goodsInfoColumnVOs;
    }

    public GoodsInfoStroePermissionVO getGoodsInfoStroePermissionVO() {
        return goodsInfoStroePermissionVO;
    }

    public void setGoodsInfoStroePermissionVO(GoodsInfoStroePermissionVO goodsInfoStroePermissionVO) {
        this.goodsInfoStroePermissionVO = goodsInfoStroePermissionVO;
    }
}
