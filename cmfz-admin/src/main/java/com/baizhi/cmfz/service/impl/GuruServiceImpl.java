package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDAO;
import com.baizhi.cmfz.dao.PictureDAO;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.GuruService;
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
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruDAO guruDAO;

    public Map<String, Object> queryAllGuru(Integer page, Integer rows) {
        List<Guru> gurus = guruDAO.selectAllGuru((page-1)*rows,rows);
        Integer count=guruDAO.count();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    public int addGuru(Guru guru) {
        return guruDAO.insertGuru(guru);
    }

    public int modifyGuru(Guru guru) {
        return guruDAO.updateGuru(guru);
    }

    public void addGurus(List<Guru> gurus){guruDAO.insertBatch(gurus);}

    public List<Guru> queryAll(){
        return guruDAO.selectAll();
    }

    public Map<String, Object> queryGuruByKey(String name, String value, Integer page, Integer rows) {
        List<Guru> gurus = guruDAO.selectAllGuruByKey(name,value,(page-1)*rows,rows);
        Integer count=guruDAO.countByKey(name,value);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",gurus);
        return map;
    }

    public List<Guru> queryGuruIdAndName() {
        return guruDAO.selectGuruIdAndName();
    }
}
