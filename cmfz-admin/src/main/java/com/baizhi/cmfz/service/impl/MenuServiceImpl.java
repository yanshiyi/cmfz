package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDAO;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-05 17:16:27
 **/
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO menuDAO;

    /**
     *@Description
     *@Author Mr.Yan
     *@Time  2018/7/5 17:17
     *@Param []
     *@Return java.util.List<com.baizhi.cmfz.entity.Menu>
     *@Exception
     **/
    public List<Menu> queryAllMenu() {
        return menuDAO.selectAllMenu();
    }
}
