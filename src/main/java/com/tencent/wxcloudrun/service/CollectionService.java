package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.model.CollectionModel;

import java.util.List;

public interface CollectionService {

    /*
    * 查看用户收集的列表
    * */
    List<CollectionModel> selectByUserId(String userId);


    /*
    * 插入用户收集表
    * */
    int insert(CollectionModel collectionModel);

    /*
     * 更新用户收集表
     * */
    int update(CollectionModel collectionModel);

    /*
     * 删除用户收集表
     * */
    int delete(int id);
}
