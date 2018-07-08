package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDAO;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-06 09:40:15
 **/
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDAO pictureDAO;

    /**
     *@Description
     *@Author Mr.Yan
     *@Time  2018/7/6 9:45
     *@Param []
     *@Return java.util.Map<java.lang.String,java.lang.Object>
     *@Exception
     **/
    public Map<String, Object> queryAllPicture(Integer page,Integer rows) {
            List<Picture> pictures = pictureDAO.selectAllPicture((page-1)*rows,rows);
            Integer count=pictureDAO.count();
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("total",count);
            map.put("rows",pictures);
            return map;
    }

    public Picture queryPictureByPictureId(String pictureId){
        return pictureDAO.selectPicture(pictureId);
    }

    public int addPicture(Picture picture) {
        picture.setPictureDate(new Date());
        picture.setPictureId(UUID.randomUUID().toString().replace("-",""));
        picture.setPicturePath(picture.getPictureName());
        return pictureDAO.insertPicture(picture);
    }

    public int modifyPicture(Picture picture) {
        return pictureDAO.updatePicture(picture);
    }

}
