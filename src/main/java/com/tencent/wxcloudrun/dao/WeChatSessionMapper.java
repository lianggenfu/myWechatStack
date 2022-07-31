package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.WeChatSession;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeChatSessionMapper {

    int addSession(WeChatSession session);

    WeChatSession querySessionByUserId(String userId);

    int updateSessionByUserId(WeChatSession session);

    int deleteSessionByUserId(String session);

}
