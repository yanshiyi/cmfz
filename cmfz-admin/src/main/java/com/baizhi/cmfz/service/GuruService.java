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

    public int addGuru(Guru guru);

    public int modifyGuru(Guru guru);

    public void addGurus(List<Guru> gurus);

    public List<Guru> queryAll();

    public Map<String,Object> queryGuruByKey(String name,String value,Integer page, Integer rows);
}
