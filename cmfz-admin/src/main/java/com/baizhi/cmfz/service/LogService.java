package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.Map;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-10 12:16:17
 **/
public interface LogService {
    public Map<String,Object> queryAllLog(Integer page, Integer rows);

    public void addLog(Log log);
}
