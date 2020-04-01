package com.shsr.objectvo.vo.good;

/**
 * @program: slmall-parent
 * @description: 商品信息详情VO类
 * @author: JayLee
 * @create: 2018-10-15 18:52
 **/
public class GoodsInfoDetailsVO {
    //商品详情
    private String details;
    //购买需知
    private String buyNotes;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? "" : details;
    }

    public String getBuyNotes() {
        return buyNotes;
    }

    public void setBuyNotes(String buyNotes) {
        this.buyNotes = buyNotes == null ? "" : buyNotes;
    }
}
