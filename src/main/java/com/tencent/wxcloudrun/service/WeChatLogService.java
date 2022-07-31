package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.WeChatLog;

public interface WeChatLogService {

    void addLog(WeChatLog weChatLog);  //新增日志
}
