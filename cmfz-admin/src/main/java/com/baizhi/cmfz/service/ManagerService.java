package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-05 10:49:24
 **/
public interface ManagerService {
    /**
     *@Description
     *@Author Mr.Yan
     *@Time  2018/7/5 10:51
     *@Param [manager]
     *@Return com.baizhi.cmfz.entity.Manager
     *@Exception
     **/
    public Manager login(Manager manager);
}
