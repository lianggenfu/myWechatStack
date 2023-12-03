package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.MovieFileMapper;
import com.tencent.wxcloudrun.model.MovieFile;
import com.tencent.wxcloudrun.service.MovieFileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class MovieFileServiceImpl implements MovieFileService{

    @Autowired
    private MovieFileMapper movieFileMapper;

    @Override
    public int insert(MovieFile movieFile) {
        return movieFileMapper.insert(movieFile);
    }

    @Override
    public List<MovieFile> selectListByMovieName(String movieName) {
        if(StringUtils.isBlank(movieName)){
            return null;
        }
        String str = new StringBuffer("%").append(movieName).append("%").toString();
        return movieFileMapper.selectListByMovieName(str);
    }

    @Override
    public List<MovieFile> selectListByGroups(Set<String> groups) {
        return null;
    }

    @Override
    public MovieFile selectItemByMovieNo(String movieNo) {
        return null;
    }

    @Override
    public int update(MovieFile model) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
