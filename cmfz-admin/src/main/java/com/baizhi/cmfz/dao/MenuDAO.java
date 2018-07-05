package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-05 14:25:19
 **/
public interface MenuDAO {

    /**
     *@Description 查询所有菜单项及其子菜单项
     *@Author Mr.Yan
     *@Time  2018/7/5 14:28
     *@Param
     *@Return java.util.List<com.baizhi.cmfz.entity.Menu>
     *@Exception
     **/
    public List<Menu> selectAllMenu();

}
