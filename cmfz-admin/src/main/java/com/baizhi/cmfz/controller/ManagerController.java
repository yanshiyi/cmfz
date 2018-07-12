package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

    @RequestMapping("/login")
    public String login(String enCode, HttpSession session, Manager manager, Boolean rememberMe , HttpServletResponse response){
        String vcode = (String) session.getAttribute("vcode");
        if(vcode.equalsIgnoreCase(enCode)){
            Subject subject= SecurityUtils.getSubject();
            try{
                subject.login(new UsernamePasswordToken(manager.getMgrName(),manager.getMgrPwd(),rememberMe));
                if (rememberMe!=null&&rememberMe) {
                    Cookie cookie = null;
                    try {
                        cookie = new Cookie("mgrName", URLEncoder.encode(manager.getMgrName(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    cookie.setPath(session.getServletContext().getContextPath());
                    cookie.setMaxAge(60 * 60 * 24 * 7);//保存7天
                    response.addCookie(cookie);
                    session.setAttribute("manager",manager);
                } else {
                    Cookie cookie = null;
                    try {
                        cookie = new Cookie("mgrName", URLEncoder.encode(manager.getMgrName(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    cookie.setPath(session.getServletContext().getContextPath());
                    cookie.setMaxAge(-1);//删除
                    response.addCookie(cookie);
                    session.setAttribute("manager",manager);
                }
                return "redirect:/main/main.jsp";
            }catch (UnknownAccountException e){
                e.printStackTrace();
                return "redirect:/login.jsp";
            }catch(IncorrectCredentialsException ice){
                ice.printStackTrace();
                return "redirect:/login.jsp";
            }catch(AuthenticationException ae){
                ae.printStackTrace();
                return "redirect:/login.jsp";
            }
        }
        return "redirect:/login.jsp";
    }
}
