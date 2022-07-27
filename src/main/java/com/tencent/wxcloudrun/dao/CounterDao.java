package com.tencent.wxcloudrun.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CounterDao {


    @Select("select count(1) from t_count where id = #{id}")
    int selectCount(@Param("id") int id);

}
