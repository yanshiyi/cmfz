package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Permission;

import java.util.List;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-12 20:55:22
 **/
public interface PermissionDAO {
    public List<Permission> selectPermissionByMgrName(String mgrName);

}
