package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-10 12:49:32
 **/
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/getAllLog")
    @ResponseBody
    public Map<String,Object> getAllLog(Integer page, Integer rows){
        return logService.queryAllLog(page,rows);
    }

}
