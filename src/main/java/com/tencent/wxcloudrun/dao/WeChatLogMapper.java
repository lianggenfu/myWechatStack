package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.WeChatLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeChatLogMapper {

    int insert(WeChatLog model);

}
