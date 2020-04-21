package com.shsr.objectvo.hangyiyun.vo.company;

import lombok.Data;

import java.util.Date;

@Data
public class Enterprise {
    private String phone;
    private String password;
    private String companyName;
    private String userCode;
    private String platformCode;
    private int origin;
    private int registerType;
    private int merchantType;
    private Date timestamp;
    private String companyCode;
}
