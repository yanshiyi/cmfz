package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Permission;

import java.util.List;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-12 21:35:42
 **/
public interface PermissionService {
    public List<Permission> queryPermissionByMgrName(String mgrName);
}
