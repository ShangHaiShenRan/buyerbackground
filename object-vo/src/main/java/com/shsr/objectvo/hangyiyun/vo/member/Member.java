package com.shsr.objectvo.hangyiyun.vo.member;

import java.math.BigDecimal;
import java.util.Date;

public class Member {
    private Long id;

    private String mallCode;

    private String shopName;

    private String realName;

    private String wechatNickname;

    private String phone;

    private Long distributorLevelId;

    private Integer level;

    private Long memberLevelId;

    private Date registerTime;

    private Date memberAuditTime;

    private Date auditTimeDistributor;

    private Long tagGroupId;

    private String headPhotoUrl;

    private String unionid;

    private Integer integral;

    private BigDecimal balance;

    private Integer openShopGoodsQuantity;

    private Double openShopGoodsAmount;

    private Integer shopGoodsQuantirty;

    private BigDecimal shopGoodsAmount;

    private BigDecimal shopGoodsAmountOfMonth;

    private BigDecimal distributorTeamGoodsAmount;

    private Integer teamTotalPeopleDistribution;

    private Integer teamTotalPeople;

    private BigDecimal commissionTotal;

    private BigDecimal commissionPaid;

    private Byte status;

    private Boolean isDistributor;

    private Byte statusDistributor;

    private Integer inviterId;

    private Boolean isModifyVipInviter;

    private Date lastLoginTime;

    private String lastLoginIp;

    private Integer loginCount;

    private Date birthday;

    private String address;

    private Date createAt;

    private Date updateAt;


    private Integer nextDistributorNum;  //下级分销商数
    private String inviterName;

    //伪字段
    private String tagsName;  //会员标签组名称
    private String levelName; //会员等级名称

    private String teamName;

    //
    private Integer levelValue; //分销商的等级值

    private String mallName;

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }


    public Integer getNextDistributorNum() {
        return nextDistributorNum;
    }

    public String getInviterName() {
        return inviterName;
    }

    public void setInviterName(String inviterName) {
        this.inviterName = inviterName;
    }

    public void setNextDistributorNum(Integer nextDistributorNum) {
        this.nextDistributorNum = nextDistributorNum;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
        this.mallCode = mallCode == null ? null : mallCode.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getWechatNickname() {
        return wechatNickname;
    }

    public void setWechatNickname(String wechatNickname) {
        this.wechatNickname = wechatNickname == null ? null : wechatNickname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getDistributorLevelId() {
        return distributorLevelId;
    }

    public void setDistributorLevelId(Long distributorLevelId) {
        this.distributorLevelId = distributorLevelId;
    }

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getMemberAuditTime() {
        return memberAuditTime;
    }

    public void setMemberAuditTime(Date memberAuditTime) {
        this.memberAuditTime = memberAuditTime;
    }

    public Date getAuditTimeDistributor() {
        return auditTimeDistributor;
    }

    public void setAuditTimeDistributor(Date auditTimeDistributor) {
        this.auditTimeDistributor = auditTimeDistributor;
    }

    public Long getTagGroupId() {
        return tagGroupId;
    }

    public void setTagGroupId(Long tagGroupId) {
        this.tagGroupId = tagGroupId;
    }

    public String getHeadPhotoUrl() {
        return headPhotoUrl;
    }

    public void setHeadPhotoUrl(String headPhotoUrl) {
        this.headPhotoUrl = headPhotoUrl == null ? null : headPhotoUrl.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getOpenShopGoodsQuantity() {
        return openShopGoodsQuantity;
    }

    public void setOpenShopGoodsQuantity(Integer openShopGoodsQuantity) {
        this.openShopGoodsQuantity = openShopGoodsQuantity;
    }

    public Double getOpenShopGoodsAmount() {
        return openShopGoodsAmount;
    }

    public void setOpenShopGoodsAmount(Double openShopGoodsAmount) {
        this.openShopGoodsAmount = openShopGoodsAmount;
    }

    public Integer getShopGoodsQuantirty() {
        return shopGoodsQuantirty;
    }

    public void setShopGoodsQuantirty(Integer shopGoodsQuantirty) {
        this.shopGoodsQuantirty = shopGoodsQuantirty;
    }

    public BigDecimal getShopGoodsAmount() {
        return shopGoodsAmount;
    }

    public void setShopGoodsAmount(BigDecimal shopGoodsAmount) {
        this.shopGoodsAmount = shopGoodsAmount;
    }

    public BigDecimal getShopGoodsAmountOfMonth() {
        return shopGoodsAmountOfMonth;
    }

    public void setShopGoodsAmountOfMonth(BigDecimal shopGoodsAmountOfMonth) {
        this.shopGoodsAmountOfMonth = shopGoodsAmountOfMonth;
    }

    public BigDecimal getDistributorTeamGoodsAmount() {
        return distributorTeamGoodsAmount;
    }

    public void setDistributorTeamGoodsAmount(BigDecimal distributorTeamGoodsAmount) {
        this.distributorTeamGoodsAmount = distributorTeamGoodsAmount;
    }

    public Integer getTeamTotalPeopleDistribution() {
        return teamTotalPeopleDistribution;
    }

    public void setTeamTotalPeopleDistribution(Integer teamTotalPeopleDistribution) {
        this.teamTotalPeopleDistribution = teamTotalPeopleDistribution;
    }

    public Integer getTeamTotalPeople() {
        return teamTotalPeople;
    }

    public void setTeamTotalPeople(Integer teamTotalPeople) {
        this.teamTotalPeople = teamTotalPeople;
    }

    public BigDecimal getCommissionTotal() {
        return commissionTotal;
    }

    public void setCommissionTotal(BigDecimal commissionTotal) {
        this.commissionTotal = commissionTotal;
    }

    public BigDecimal getCommissionPaid() {
        return commissionPaid;
    }

    public void setCommissionPaid(BigDecimal commissionPaid) {
        this.commissionPaid = commissionPaid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getIsDistributor() {
        return isDistributor;
    }

    public void setIsDistributor(Boolean isDistributor) {
        this.isDistributor = isDistributor;
    }

    public Byte getStatusDistributor() {
        return statusDistributor;
    }

    public void setStatusDistributor(Byte statusDistributor) {
        this.statusDistributor = statusDistributor;
    }

    public Integer getInviterId() {
        return inviterId;
    }

    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
    }

    public Boolean getIsModifyVipInviter() {
        return isModifyVipInviter;
    }

    public void setIsModifyVipInviter(Boolean isModifyVipInviter) {
        this.isModifyVipInviter = isModifyVipInviter;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getTagsName() {
        return tagsName;
    }

    public void setTagsName(String tagsName) {
        this.tagsName = tagsName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(Integer levelValue) {
        this.levelValue = levelValue;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}