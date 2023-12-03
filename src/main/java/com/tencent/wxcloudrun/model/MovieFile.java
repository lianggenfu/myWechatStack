package com.tencent.wxcloudrun.model;

import java.util.List;
import java.util.Set;

public class MovieFile {

    public int id;
    public String movieName;
    public int movieSize; //文件大小  mb
    public double movieSizeGb; //文件大小 GB
    public String movieNo; //编号
    public Set<String> groups;
    public boolean isMosaic; //有码
    public String filePath; //文件目录
    public String absolutePath;//绝对路径
    public List<ImageFile> imageFileList; //精选图
    public ImageFile coverImage; //封面图
    public Set<String> actors; //演员
}
