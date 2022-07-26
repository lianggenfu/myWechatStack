package com.tencent.wxcloudrun.service;

import javax.servlet.http.HttpServletRequest;

public interface MessageService {

    String newMessageRequest(HttpServletRequest request);
}
