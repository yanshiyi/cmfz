package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDAO;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-10 12:17:19
 **/
@Service
@Transactional
public class LogServiceImpl implements LogService{

    @Autowired
    private LogDAO logDAO;

    @Override
    public Map<String,Object> queryAllLog(Integer page, Integer rows) {
        List<Log> logs = logDAO.selectAllLog((page - 1) * rows, rows);
        Integer count=logDAO.count();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",logs);
        return map;
    }

    @Override
    public void addLog(Log log) {
        logDAO.insertLog(log);
    }
}
