package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.service.NameGenerationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {

    @Autowired
    private NameGenerationService nameGenerationService;


    final Logger logger = LoggerFactory.getLogger(CounterController.class);

    /**
     * 获取姓名
     * @return API response json
     */
    @GetMapping(value = "/api/getName")
    ApiResponse get(String surName,int sexType,int count) {
        logger.info("/api/count get request,surName:{},sexType:{},count:{}",surName,sexType,count);
        //int sexType = 2; //1:男孩 2:女孩
        List<String> names = nameGenerationService.getName(surName,sexType,count);
        for (int i = 0; i <names.size() ; i++) {
            //List<String> names = nameGenerationService.getName(surName,sexType,i);
            System.out.println("随机生成的第"+(i+1)+"个姓名为：" + names.get(i));
        }
        //String name = "凉凉夜色";
        return ApiResponse.ok(names);
    }

}
