package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.CollectionModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollectionMapper {

    int insert(CollectionModel model);

    List<CollectionModel> selectByUserId(@Param("userId") String userId);

    int update(CollectionModel model);

    int delete(@Param("id") int id);
}
