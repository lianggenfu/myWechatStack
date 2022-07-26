package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.service.WxService;
import com.tencent.wxcloudrun.utils.WechatPublicUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class WeChatController {

    final Logger logger = LoggerFactory.getLogger(WeChatController.class);

    @Autowired
    private WxService wxService;

    @GetMapping(value = "/api/wx/get")
    ApiResponse get() {
        System.out.println("get");
        logger.info("get request print!");
        return ApiResponse.ok();
    }

    @PostMapping(value = "/api/wx/post")
    ApiResponse post() {
        System.out.println("post");
        logger.info("post request print!");
        return ApiResponse.ok();
    }

    @RequestMapping(value = "/api/wx/signature",method = RequestMethod.POST,produces = {"application/xml; charset=UTF-8"})
    @ResponseBody
    public void wechatEvent(HttpServletRequest request, HttpServletResponse response){
        logger.info("---------------------接收微信推送事件---------------------");
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        wxService.handleEvent(request,response);
    }

    @GetMapping("/check/signature")
    @ResponseBody
    public String wechatCheckSignature(HttpServletRequest request) {
        logger.error("-------------------服务器配置|进行签名检测------------------------");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echoStr = request.getParameter("echostr");
        String token = "token";
        boolean checkSignature = WechatPublicUtils.checkSignature(signature, timestamp, nonce, token);
        if (checkSignature) {
            return echoStr;
        }
        return null;
    }
}
