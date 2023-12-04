package com.tencent.wxcloudrun.controller;


import com.alibaba.fastjson.JSON;
import com.tencent.wxcloudrun.utils.HttpClientPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LotteryController {


    final Logger logger = LoggerFactory.getLogger(LotteryController.class);


    public static void main(String[] args) {
        String url  = "https://webapi.sporttery.cn/gateway/lottery/getHistoryPageListV1.qry?gameNo=85&provinceId=0&pageSize=5&isVerify=1&pageNo=1";

        try {
            String result = HttpClientPool.getHttpClient().get(url);

            Map<String,Object> objectMap = JSON.parseObject(result);


            Object jsonObject = objectMap.get("value");

            String valueJsonStr = (String) objectMap.get("value");
            Map<String,Object> listMap = (Map<String, Object>) JSON.toJSON(valueJsonStr);
            System.out.println("111");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
