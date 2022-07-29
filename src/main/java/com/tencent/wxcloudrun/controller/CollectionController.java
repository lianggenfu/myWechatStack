package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CollectionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectionController {

    final Logger logger = LoggerFactory.getLogger(CollectionController.class);

    /**
     * 获取姓名
     * @return API response json
     */
    @PostMapping(value = "/api/collect/insert")
    ApiResponse insert(@RequestBody CollectionRequest request) {
        //String surName = request.getSurName();



        return ApiResponse.ok();
    }

}
