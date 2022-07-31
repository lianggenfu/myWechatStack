package com.tencent.wxcloudrun.model;


import lombok.Data;

@Data
public class WeChatSession {

    private int id;

    private String userId;

    private String sessionId;  //会话类型

    private String isDeleted;

}
