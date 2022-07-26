package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class TextMessage {

    private String FromUserName;
    private String ToUserName;
    private String MsgType;
    private Long CreateTime;
    private String Content;
}
