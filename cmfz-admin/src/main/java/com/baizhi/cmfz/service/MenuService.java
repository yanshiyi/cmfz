package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * @Description 菜单service
 * @Author Mr.Yan
 * @Time 2018-07-05 14:43:04
 **/
public interface MenuService {

    /**
     *@Description
     *@Author Mr.Yan
     *@Time  2018/7/5 17:17
     *@Param []
     *@Return java.util.List<com.baizhi.cmfz.entity.Menu>
     *@Exception
     **/
    public List<Menu> queryAllMenu();

}
