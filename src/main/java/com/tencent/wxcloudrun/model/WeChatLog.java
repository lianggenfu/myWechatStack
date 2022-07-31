package com.tencent.wxcloudrun.model;

import lombok.Data;
/*
* 日志类
*
* */

@Data
public class WeChatLog {

    private int id;

    private String userId;  //用户id

    private String userName;  //用户名

    private String context;  //输入内容

    private String msgType; //消息类型

    private String event;  //事件


}
