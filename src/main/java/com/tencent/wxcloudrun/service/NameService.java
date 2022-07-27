package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.NameModel;


import java.util.List;

public interface NameService {


    /*
     * 通过id查询指定姓名
     * */
    NameModel selectByName(int id);

    /*
    * 通过name查询指定姓名
    * */
    NameModel selectByName(String name);

    /*
    * 通过key匹配名字
    * */
    List<NameModel> selectByKey(String key);

    /*
    * 插入
    * */
    int insert(NameModel nameModel);

    /*
     * 更新
     * */
    int update(NameModel nameModel);

    /*
     * 删除
     * */
    int delete(NameModel nameModel);
}
