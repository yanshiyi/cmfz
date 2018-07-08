package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-06 09:29:46
 **/
public interface PictureDAO {
    /**
     *@Description
     *@Author Mr.Yan
     *@Time  2018/7/6 9:30
     *@Param []
     *@Return java.util.List<com.baizhi.cmfz.entity.Picture>
     *@Exception
     **/
    public List<Picture> selectAllPicture(@Param("page") Integer page, @Param("rows") Integer rows);

    public Picture selectPicture(String pictureId);

    public Integer count();

    public int insertPicture(Picture picture);

    public int updatePicture(Picture picture);
}
