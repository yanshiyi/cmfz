package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-10 12:06:43
 **/
public interface LogDAO {
    public List<Log> selectAllLog(@Param("page") Integer page,@Param("rows") Integer rows);

    public int count();

    public int insertLog(Log log);
}
