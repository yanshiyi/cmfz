package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Picture;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-06 09:38:48
 **/
public interface GuruService {

    public Map<String,Object> queryAllGuru(Integer page, Integer rows);

    public Integer addGuru(Guru guru);

    public Integer modifyGuru(Guru guru);

    public Integer addGurus(List<Guru> gurus);

    public List<Guru> queryAll();

    public Map<String,Object> queryGuruByKey(String name,String value,Integer page, Integer rows);

    public List<Guru> queryGuruIdAndName();
}
