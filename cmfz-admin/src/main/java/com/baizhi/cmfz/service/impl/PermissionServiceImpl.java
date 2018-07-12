package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PermissionDAO;
import com.baizhi.cmfz.dao.RoleDAO;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.PermissionService;
import com.baizhi.cmfz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-12 21:36:32
 **/
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionDAO permissionDAO;

    @Override
    public List<Permission> queryPermissionByMgrName(String mgrName) {
        return permissionDAO.selectPermissionByMgrName(mgrName);
    }
}
