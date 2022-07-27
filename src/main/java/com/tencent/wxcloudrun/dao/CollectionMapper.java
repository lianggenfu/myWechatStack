package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.CollectionModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollectionMapper {

    int insert(@Param("model") CollectionModel model);

    List<CollectionModel> queryUserCollectByUserId(@Param("userId") String userId);

    void upsertCount(@Param("model") CollectionModel model);

    void delete(@Param("model") CollectionModel model);
}