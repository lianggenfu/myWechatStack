package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeChatController {

    final Logger logger = LoggerFactory.getLogger(WeChatController.class);

    @GetMapping(value = "/api/wx/get")
    ApiResponse get() {
        System.out.println("get");
        logger.info("get request print!");
        return ApiResponse.ok();
    }

    @GetMapping(value = "/api/wx/post")
    ApiResponse post() {
        System.out.println("post");
        logger.info("post request print!");
        return ApiResponse.ok();
    }
}
