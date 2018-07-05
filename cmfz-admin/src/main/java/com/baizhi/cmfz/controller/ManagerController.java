package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Description 管理员Controller
 * @Author Mr.Yan
 * @Time 2018-07-05 11:06:04
 **/
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public String login(String enCode, HttpSession session, Manager manager, Boolean rememberMe , HttpServletResponse response){
        String vcode = (String) session.getAttribute("vcode");
        if(vcode.equalsIgnoreCase(enCode)){
            Manager mgr = managerService.login(manager);
            if (mgr!=null) {
                if (rememberMe!=null&&rememberMe) {
                    Cookie cookie = null;
                    try {
                        cookie = new Cookie("mgrName", URLEncoder.encode(mgr.getMgrName(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    cookie.setPath(session.getServletContext().getContextPath());
                    cookie.setMaxAge(60 * 60 * 24 * 7);//保存7天
                    response.addCookie(cookie);
                } else {
                    Cookie cookie = null;
                    try {
                        cookie = new Cookie("mgrName", URLEncoder.encode(mgr.getMgrName(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    cookie.setPath(session.getServletContext().getContextPath());
                    cookie.setMaxAge(-1);//删除
                    response.addCookie(cookie);
                }
                return "index";
            }
        }
        return "redirect:/login.jsp";
    }
}
