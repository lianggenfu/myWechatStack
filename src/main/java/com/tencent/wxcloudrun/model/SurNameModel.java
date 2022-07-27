package com.tencent.wxcloudrun.model;

/*
* 姓氏类
* */

import lombok.Data;

@Data
public class SurNameModel {

    private int id;

    private String surName;

    private String matching;

    private int sexType;

    private String desc;
}
