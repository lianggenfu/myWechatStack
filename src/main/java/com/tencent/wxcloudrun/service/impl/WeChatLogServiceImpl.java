package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.WeChatLogMapper;
import com.tencent.wxcloudrun.model.WeChatLog;
import com.tencent.wxcloudrun.service.WeChatLogService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeChatLogServiceImpl implements WeChatLogService {

    final Logger logger = LoggerFactory.getLogger(WeChatLogServiceImpl.class);


    @Autowired
    private WeChatLogMapper weChatLogMapper;

    /*
    * 新增对话日志
    *
    * */

    @Override
    public void addLog(WeChatLog weChatLog) {
        int retCode = -1;
        if(StringUtils.isNotBlank(weChatLog.getUserId())
        && StringUtils.isNotBlank(weChatLog.getContext())){
            retCode = weChatLogMapper.insert(weChatLog);
        }
        if(retCode<0){
            logger.error("addLog exception ,weChatLog:{}",weChatLog);
        }
    }
}
