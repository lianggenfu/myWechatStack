package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CollectionRequest;
import com.tencent.wxcloudrun.model.CollectionModel;
import com.tencent.wxcloudrun.service.CollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectionController {

    final Logger logger = LoggerFactory.getLogger(CollectionController.class);

    @Autowired
    private CollectionService collectionService;

    /**
     * 获取姓名
     * @return API response json
     */
    @PostMapping(value = "/api/collect/insert")
    ApiResponse insert(@RequestBody CollectionRequest request) {
        CollectionModel collectionModel = new CollectionModel();
        //collectionModel.setId(request.getId());
        collectionModel.setUserId(request.getUserId());
        collectionModel.setNameId(request.getNameId());
        collectionModel.setFullName(request.getFullName());
        collectionModel.setDesc(request.getDesc());
        collectionService.insert(collectionModel);
        return ApiResponse.ok();
    }

    @PostMapping(value = "/api/collect/queryListByUserId")
    ApiResponse queryListByUserId(@RequestBody CollectionRequest request) {
        List<CollectionModel> collectionModelList = collectionService.selectByUserId(request.getUserId());
        return ApiResponse.ok(collectionModelList);
    }

}
