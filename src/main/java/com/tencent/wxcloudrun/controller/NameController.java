package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.NamerRequest;
import com.tencent.wxcloudrun.service.NameGenerationService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping(value = "/api/getName")
    ApiResponse get(@RequestBody NamerRequest request) {
        logger.info("/api/count get request,surName:{},sexType:{},count:{}",request.getSurName(),request.getSexType(),request.getNumber());
        String surName = request.getSurName();
        String sexType = request.getSexType();
        ApiResponse apiResponse = ApiResponse.error("");
        if(StringUtils.isBlank(surName)){
            apiResponse.setErrorMsg("姓不能为空!");
            apiResponse.setCode(-120001);
            return apiResponse;
        }
        if(StringUtils.isBlank(sexType)){
            apiResponse.setErrorMsg("性别不能为空!");
            apiResponse.setCode(-120002);
            return apiResponse;
        }else if(!sexType.equals("男") && !sexType.equals("女")){
            apiResponse.setErrorMsg("性别输入不合法!");
            apiResponse.setCode(-120003);
            return apiResponse;
        }
        int sexTypeInt = sexType.equals("男")?1:2; //1:男孩 2:女孩
        List<String> names = nameGenerationService.getName(surName,sexTypeInt,request.getNumber());
        for (int i = 0; i <names.size() ; i++) {
            //System.out.println("随机生成的第"+(i+1)+"个姓名为：" + names.get(i));
        }
        //String name = "凉凉夜色";
        return ApiResponse.ok(names);
    }

}
