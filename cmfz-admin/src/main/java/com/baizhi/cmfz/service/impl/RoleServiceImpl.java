package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.RoleDAO;
import com.baizhi.cmfz.entity.Role;
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
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<Role> queryRoleByMgrName(String mgrName) {
        return roleDAO.selectRoleByMgrName(mgrName);
    }
}
