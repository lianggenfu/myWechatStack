package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.ImageFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageFileService {

    List<ImageFile> selectListByMovieNo(@Param("movieNo") String movieNo);

    ImageFile selectItemByMovieNo(@Param("movieNo") String movieNo);
}
