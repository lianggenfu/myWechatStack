package com.tencent.wxcloudrun.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface NameGenerationService {


    public List<String> getName(String surName, int sexType, int number);


}
