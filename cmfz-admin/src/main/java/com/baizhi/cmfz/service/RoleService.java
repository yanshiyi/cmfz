package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Role;

import java.util.List;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-12 21:35:42
 **/
public interface RoleService {
    public List<Role> queryRoleByMgrName(String mgrName);
}
