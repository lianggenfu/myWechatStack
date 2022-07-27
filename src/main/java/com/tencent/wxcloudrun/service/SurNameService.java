package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.model.SurNameModel;

public interface SurNameService {

    SurNameModel selectBySurName(String surName);

    int insert(SurNameModel surName);

    int update(SurNameModel surName);

    int delete(SurNameModel surName);
}
