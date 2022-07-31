package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.WeChatSessionMapper;
import com.tencent.wxcloudrun.model.WeChatSession;
import com.tencent.wxcloudrun.service.WeChatSessionService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeChatSessionServiceImpl implements WeChatSessionService {

    final Logger logger = LoggerFactory.getLogger(WeChatSessionServiceImpl.class);

    @Autowired
    private WeChatSessionMapper weChatSessionMapper;

    /*
    * 新增会话
    * */
    @Override
    public int addSession(WeChatSession weChatSession) {
        if(StringUtils.isBlank(weChatSession.getUserId())){
            logger.error("用户名不能为空!!");
            return -1;
        }
        WeChatSession session = weChatSessionMapper.querySessionByUserId(weChatSession.getUserId());
        int retCode = -1;
        if(null == session){
            retCode = weChatSessionMapper.addSession(weChatSession);
        }else{
            retCode = weChatSessionMapper.updateSessionByUserId(weChatSession);
        }
        return retCode;
    }

    /*
    * 删除会话
    *
    * */
    @Override
    public int deleteSessionByUserId(String userId) {
        int retCode = weChatSessionMapper.deleteSessionByUserId(userId);
        if(retCode<0){
            logger.error("删除会话失败!!");
        }
        return 0;
    }
}
