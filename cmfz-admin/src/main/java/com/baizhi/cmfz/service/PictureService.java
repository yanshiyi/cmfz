package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.Map;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-06 09:38:48
 **/
public interface PictureService {

    /**
     *@Description
     *@Author Mr.Yan
     *@Time  2018/7/6 9:45
     *@Param []
     *@Return java.util.Map<java.lang.String,java.lang.Object>
     *@Exception
     **/
    public Map<String,Object> queryAllPicture(Integer page,Integer rows);

    public Integer addPicture(Picture picture);

    public Integer modifyPicture(Picture picture);

}
