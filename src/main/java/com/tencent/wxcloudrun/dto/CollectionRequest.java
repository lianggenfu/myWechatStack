package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class CollectionRequest {

    private int id;

    private String userId;

    private int nameId;

    private String fullName;

    private String desc;
}
