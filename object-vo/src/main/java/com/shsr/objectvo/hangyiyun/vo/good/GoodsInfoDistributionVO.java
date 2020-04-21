package com.shsr.objectvo.hangyiyun.vo.good;

import java.util.List;

/**
 * @program: slmall-parent
 * @description: 商品信息分销VO类
 * @author: JayLee
 * @create: 2018-10-16 14:14
 **/
public class GoodsInfoDistributionVO {
    //是否参与分销
    private Boolean isJoinDistribution;
    //是否启用独立佣金分配
    private Boolean isIndependentCommissions;
    //佣金分配类型
    private String commissionsType;

    private List<GoodsInfoDistributionSettingVO> goodsInfoDistributionSettingVOs;

    public Boolean getIsJoinDistribution() {
        return isJoinDistribution;
    }

    public void setIsJoinDistribution(Boolean isJoinDistribution) {
        this.isJoinDistribution = isJoinDistribution;
    }

    public Boolean getIsIndependentCommissions() {
        return isIndependentCommissions;
    }

    public void setIsIndependentCommissions(Boolean isIndependentCommissions) {
        this.isIndependentCommissions = isIndependentCommissions;
    }

    public String getCommissionsType() {
        return commissionsType;
    }

    public void setCommissionsType(String commissionsType) {
        this.commissionsType = commissionsType;
    }

    public List<GoodsInfoDistributionSettingVO> getGoodsInfoDistributionSettingVOs() {
        return goodsInfoDistributionSettingVOs;
    }

    public void setGoodsInfoDistributionSettingVOs(List<GoodsInfoDistributionSettingVO> goodsInfoDistributionSettingVOs) {
        this.goodsInfoDistributionSettingVOs = goodsInfoDistributionSettingVOs;
    }
}
