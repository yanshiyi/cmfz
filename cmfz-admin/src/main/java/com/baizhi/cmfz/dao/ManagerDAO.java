package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-05 10:44:48
 **/
public interface ManagerDAO {

    /**
     *@Description  通过管理员名字查询管理员
     *@Author Mr.Yan
     *@Time  2018/7/5 10:50
     *@Param [mgrName]
     *@Return com.baizhi.cmfz.entity.Manager
     *@Exception
     **/
    public Manager selectManagerByName(String mgrName);
}
