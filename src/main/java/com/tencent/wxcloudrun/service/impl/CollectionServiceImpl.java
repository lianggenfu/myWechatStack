package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.CollectionMapper;
import com.tencent.wxcloudrun.model.CollectionModel;
import com.tencent.wxcloudrun.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public List<CollectionModel> selectByUserId(String userId) {
        return null;
    }

    @Override
    public int insert(CollectionModel collectionModel) {
        return 0;
    }

    @Override
    public int update(CollectionModel collectionModel) {
        return 0;
    }

    @Override
    public int delete(CollectionModel collectionModel) {
        return 0;
    }
}
