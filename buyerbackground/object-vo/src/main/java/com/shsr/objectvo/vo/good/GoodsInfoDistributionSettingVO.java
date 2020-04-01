package com.shsr.objectvo.vo.good;


/**
 * @program: slmall-parent
 * @description: 商品信息分销设置VO类
 * @author: JayLee
 * @create: 2018-10-16 09:55
 **/
public class GoodsInfoDistributionSettingVO {
    //分销等级ID
    private Long distributionLevelId;
    //一级分销金额
    private String distributionRatio1;
    //二级分销金额
    private String distributionRatio2;
    //三级分销金额
    private String distributionRatio3;

    public Long getDistributionLevelId() {
        return distributionLevelId;
    }

    public void setDistributionLevelId(Long distributionLevelId) {
        this.distributionLevelId = distributionLevelId;
    }

    public String getDistributionRatio1() {
        return distributionRatio1;
    }

    public void setDistributionRatio1(String distributionRatio1) {
        this.distributionRatio1 = distributionRatio1;
    }

    public String getDistributionRatio2() {
        return distributionRatio2;
    }

    public void setDistributionRatio2(String distributionRatio2) {
        this.distributionRatio2 = distributionRatio2;
    }

    public String getDistributionRatio3() {
        return distributionRatio3;
    }

    public void setDistributionRatio3(String distributionRatio3) {
        this.distributionRatio3 = distributionRatio3;
    }
}
