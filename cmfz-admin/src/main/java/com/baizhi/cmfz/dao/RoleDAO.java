package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Role;

import java.util.List;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-12 20:55:22
 **/
public interface RoleDAO {
    public List<Role> selectRoleByMgrName(String mgrName);

}
