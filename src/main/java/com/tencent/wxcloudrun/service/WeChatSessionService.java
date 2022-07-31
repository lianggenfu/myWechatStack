package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.WeChatSession;

public interface WeChatSessionService {

    void addSession(WeChatSession weChatSession);  //用户会话记录

    int querySessionByUserId(String userId);  //查询用户会话记录

    int updateSessionByUserId(WeChatSession weChatSession);  //更新用户会话记录

    int deleteSessionByUserId(String userId);  //删除用户会话记录
}
