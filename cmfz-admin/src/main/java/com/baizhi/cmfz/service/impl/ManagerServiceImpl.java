package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDAO;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 管理员Service接口实现类
 * @Author Mr.Yan
 * @Time 2018-07-05 10:52:45
 **/
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerDAO managerDAO;

    /**
     *@Description
     *@Author Mr.Yan
     *@Time  2018/7/5 10:54
     *@Param [manager]
     *@Return com.baizhi.cmfz.entity.Manager
     *@Exception
     **/
    @Override
    public Manager queryManagerByName(String mgrName) {
        return managerDAO.selectManagerByName(mgrName);
    }
}
