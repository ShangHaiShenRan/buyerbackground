package com.shsr.objectvo.vo.good;

import java.util.List;

/**
 * @program: slmall-parent
 * @description: 商品信息购买权限VO类
 * @author: JayLee
 * @create: 2018-10-11 16:00
 **/
public class GoodsInfoBuyPermissionVO {
    //单次最多购买量
    private Integer singleBuyMax;
    //单次最少购买量
    private Integer singleBuyMin;
    //最多购买量
    private Integer buyMax;
    //会员查看等级
    private List<String> memberLeveBrowsingPermission;
    //会员购买等级
    private List<String> memberLeveBuyPermission;
    //会员组查看等级
    private List<String> memberGroupLeveBrowsingPermission;
    //会员组购买等级
    private List<String> membeGrouprLeveBuyPermission;

    public Integer getSingleBuyMax() {
        return singleBuyMax;
    }

    public void setSingleBuyMax(Integer singleBuyMax) {
        this.singleBuyMax = singleBuyMax;
    }

    public Integer getSingleBuyMin() {
        return singleBuyMin;
    }

    public void setSingleBuyMin(Integer singleBuyMin) {
        this.singleBuyMin = singleBuyMin;
    }

    public Integer getBuyMax() {
        return buyMax;
    }

    public void setBuyMax(Integer buyMax) {
        this.buyMax = buyMax;
    }

    public List<String> getMemberLeveBrowsingPermission() {
        return memberLeveBrowsingPermission;
    }

    public void setMemberLeveBrowsingPermission(List<String> memberLeveBrowsingPermission) {
        this.memberLeveBrowsingPermission = memberLeveBrowsingPermission;
    }

    public List<String> getMemberLeveBuyPermission() {
        return memberLeveBuyPermission;
    }

    public void setMemberLeveBuyPermission(List<String> memberLeveBuyPermission) {
        this.memberLeveBuyPermission = memberLeveBuyPermission;
    }

    public List<String> getMemberGroupLeveBrowsingPermission() {
        return memberGroupLeveBrowsingPermission;
    }

    public void setMemberGroupLeveBrowsingPermission(List<String> memberGroupLeveBrowsingPermission) {
        this.memberGroupLeveBrowsingPermission = memberGroupLeveBrowsingPermission;
    }

    public List<String> getMembeGrouprLeveBuyPermission() {
        return membeGrouprLeveBuyPermission;
    }

    public void setMembeGrouprLeveBuyPermission(List<String> membeGrouprLeveBuyPermission) {
        this.membeGrouprLeveBuyPermission = membeGrouprLeveBuyPermission;
    }
}
