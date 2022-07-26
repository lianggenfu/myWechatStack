package com.tencent.wxcloudrun.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface WxService {

    public void handleEvent(HttpServletRequest request, HttpServletResponse response);

}
