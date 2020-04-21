package com.shsr.objectvo.hangyiyun.vo.good;

/**
 * @program: slmall-parent
 * @description: 商品信息规格项VO类
 * @author: JayLee
 * @create: 2018-10-18 15:17
 **/
public class GoodsInfoSpecificationItemVO {
    //规格项名称
    private String name;
    //规格项图片路径
    private String imgUrl;
    //规格项图片显示路径（包含http://地址）
    private String displayUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }
}
