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
        return collectionMapper.selectByUserId(userId);
    }

    @Override
    public int insert(CollectionModel collectionModel) {
        return collectionMapper.insert(collectionModel);
    }

    @Override
    public int update(CollectionModel collectionModel) {
        return collectionMapper.update(collectionModel);
    }


    @Override
    public int delete(int id) {
        return collectionMapper.delete(id);
    }
}
