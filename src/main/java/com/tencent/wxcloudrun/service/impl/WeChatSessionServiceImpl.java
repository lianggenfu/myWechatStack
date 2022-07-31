package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.WeChatSession;
import com.tencent.wxcloudrun.service.WeChatSessionService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class WeChatSessionServiceImpl implements WeChatSessionService {

    @Override
    public void addSession(WeChatSession weChatSession) {

    }

    @Override
    public int querySessionByUserId(String userId) {
        return 0;
    }

    @Override
    public int updateSessionByUserId(WeChatSession userId) {
        return 0;
    }

    @Override
    public int deleteSessionByUserId(String userId) {
        return 0;
    }
}
