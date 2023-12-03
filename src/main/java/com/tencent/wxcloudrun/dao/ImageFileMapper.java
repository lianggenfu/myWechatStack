package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.ImageFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageFileMapper {


    List<ImageFile> selectListByMovieNo(@Param("movieNo") String movieNo);

    ImageFile selectItemByMovieNo(@Param("movieNo") String movieNo);

}
