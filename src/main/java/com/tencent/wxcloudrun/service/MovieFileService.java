package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.MovieFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface MovieFileService {

    int insert(MovieFile movieFile);

    List<MovieFile> selectListByMovieName(@Param("movieName") String movieName);

    List<MovieFile> selectListByGroups(@Param("groups") Set<String> groups);

    MovieFile selectItemByMovieNo(@Param("movieNo") String movieNo);

    int update(MovieFile model);

    int delete(@Param("id") int id);
}
