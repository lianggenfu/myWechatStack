package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.NameModel;
import com.tencent.wxcloudrun.service.NameService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NameServiceImpl implements NameService {
    @Override
    public NameModel selectByName(int id) {
        return null;
    }

    @Override
    public NameModel selectByName(String name) {
        return null;
    }

    @Override
    public List<NameModel> selectByKey(String key) {
        return null;
    }

    @Override
    public int insert(NameModel nameModel) {
        return 0;
    }

    @Override
    public int update(NameModel nameModel) {
        return 0;
    }

    @Override
    public int delete(NameModel nameModel) {
        return 0;
    }
}
